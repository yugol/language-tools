package impiegato.engine.tests;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import impiegato.Impiegato_1;
import impiegato.engine.TestItem;
import impiegato.util.DataFileReader;

public abstract class TestData {

    private static final String KEY_SEPARATOR   = "=";
    private static final String VALUE_SEPARATOR = "/";
    private static final Random RANDOMIZER      = new Random();

    private final TestSpec       testSpec;
    private final List<TestItem> items = new ArrayList<>();
    private double[]             relevances;

    public TestData(final TestSpec testSpec) {
        this.testSpec = testSpec;
    }

    protected abstract TestItem processRecord(String record, List<TestItem> items);

    public void loadItems() throws IOException {
        new DataFileReader(testSpec.getItemsFile()) {

            @Override
            protected void processRecord(final String record) {
                final TestItem item = TestData.this.processRecord(record, items);
                if (item != null) {
                    items.add(item);
                }
            }
        }.process();
        loadResults();
        updateRelevances();
    }

    private Map<String, String> loadResultsData() throws IOException {
        final Map<String, String> results = new HashMap<>();

        final File resultsFile = testSpec.getResultsFile();
        if (resultsFile.exists()) {
            new DataFileReader(resultsFile) {

                @Override
                protected void processRecord(final String record) {
                    final String[] result = record.split(KEY_SEPARATOR);
                    results.put(result[0], result[1]);
                }
            }.process();
        }
        return results;
    }

    private void loadResults() throws IOException {
        final Map<String, String> results = loadResultsData();
        for (final TestItem item : items) {
            final String value = results.get(item.getKey());
            if (value != null) {
                final String[] result = value.split(VALUE_SEPARATOR);
                item.setCorrectAnswerCount(Integer.parseInt(result[0]));
                item.setPresentationCount(Integer.parseInt(result[1]));
            }
        }
    }

    public void saveResults() throws IOException {
        final Map<String, String> results = new HashMap<>();
        for (final TestItem item : items) {
            final String value = item.getCorrectAnswerCount() + VALUE_SEPARATOR + item.getPresentationCount();
            results.put(item.getKey(), value);
        }
        final File resultsFile = testSpec.getResultsFile();
        if (Impiegato_1.DEBUG) {
            System.out.println("Writing: " + resultsFile.getCanonicalPath());
        }
        try (PrintWriter writer = new PrintWriter(resultsFile)) {
            for (final String key : results.keySet()) {
                final String value = results.get(key);
                writer.print(key);
                writer.print(KEY_SEPARATOR);
                writer.println(value);
            }
        }
    }

    public void updateRelevances() {
        relevances = new double[items.size()];
        double sumRelevances = 0;
        for (final TestItem item : items) {
            sumRelevances += item.getRelevance();
        }
        double relevance = 0;
        for (int i = 0; i < items.size(); ++i) {
            relevance += items.get(i).getRelevance() / sumRelevances;
            relevances[i] = relevance;
        }
    }

    public TestItem sampleItem() {
        final double hit = RANDOMIZER.nextDouble();
        for (int i = 0; i < relevances.length; ++i) {
            if (hit <= relevances[i]) {
                return items.get(i);
            }
        }
        return items.get(RANDOMIZER.nextInt(items.size()));
    }
}

package impiegato.engine;

import impiegato.Impiegato;
import impiegato.engine.tests.espressioni.EspressioniTestData;
import impiegato.engine.tests.nomi.NomiTestData;
import impiegato.engine.tests.verbi.VerbiTestData;
import impiegato.engine.tests.vocabolario.VocabolarioTestData;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Tempo;
import java.io.File;
import java.io.IOException;

public class TestSpec implements Comparable<TestSpec> {

    private final File itemsFile;
    private final TestCategory category;
    private final String name;
    private Modo modo;
    private Tempo tempo;

    public TestSpec(File file) {
        itemsFile = file;
        String[] chunks = file.getName().split("\\.");
        category = TestCategory.valueOf(chunks[chunks.length - 2].toUpperCase());
        name = chunks.length > 2 ? chunks[chunks.length - 3] : "";
        if (category == TestCategory.VERBI) {
            chunks = name.split("-");
            modo = Modo.valueOf(chunks[0].toUpperCase());
            tempo = Tempo.valueOf(chunks[1].toUpperCase());
        }
    }

    public File getItemsFile() {
        return itemsFile;
    }

    @Override
    public String toString() {
        return category + " " + name;
    }

    public File getResultsFile() {
        String fileName = itemsFile.getName();
        fileName = fileName.substring(0, fileName.lastIndexOf('.') + 1) + "results";
        File resultsFile = itemsFile.getParentFile().getParentFile();
        resultsFile = new File(resultsFile, Impiegato.RESULTS_FOLDER_NAME);
        resultsFile.mkdirs();
        resultsFile = new File(resultsFile, fileName);
        return resultsFile;
    }

    @Override
    public int compareTo(TestSpec o) {
        int cmp = new Integer(category.ordinal()).compareTo(o.category.ordinal());
        if (cmp == 0) {
            cmp = name.compareToIgnoreCase(o.name);
        }
        return cmp;
    }

    public TestData getTestData() throws IOException {
        TestData testData = null;
        switch (category) {
            case VOCABOLARIO:
                testData = new VocabolarioTestData(this);
                break;
            case ESPRESSIONI:
                testData = new EspressioniTestData(this);
                break;
            case NOMI:
                testData = new NomiTestData(this);
                break;
            case VERBI:
                testData = new VerbiTestData(this, modo, tempo);
                break;
        }
        if (testData != null) {
            testData.loadItems();
        }
        return testData;
    }
}

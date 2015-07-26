package impiegato;

import impiegato.engine.TestData;
import impiegato.engine.TestItem;
import impiegato.engine.TestSpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * http://translation.sensagent.com/
 *
 * http://grammatica-italiana.dossier.net/
 *
 *
 * ToDo
 *
 * - "calculate" verb forms
 *
 * - test numerals (cardinal + ordinal)
 *
 */
public class Impiegato {

    public static final boolean DEBUG = false;

    public static final String ITEMS_FOLDER_NAME = "items";
    public static final String RESULTS_FOLDER_NAME = "results";

    private static final int DEFAULT_TEST_SET_ITEM = 1;
    private static final int DEFAULT_TEST_ITEM_COUNT = 10;

    public static void main(String... args) throws IOException {
        Impiegato impiegato = new Impiegato();
        try {
            while (true) {
                impiegato.clearConsole();
                impiegato.drawMenu();
                String option = impiegato.readConsole("Please insert test set number (anything else will exit) [" + DEFAULT_TEST_SET_ITEM + "]: ", String.valueOf(DEFAULT_TEST_SET_ITEM));
                impiegato.initializeTest(Integer.parseInt(option) - 1);
                while (true) {
                    int itemCount = DEFAULT_TEST_ITEM_COUNT;
                    option = impiegato.readConsole("How many items per test (0 to return to main menu)? [" + itemCount + "]: ", String.valueOf(itemCount));
                    try {
                        itemCount = Integer.parseInt(option);
                        if (itemCount > 0) {
                            impiegato.runTest(itemCount);
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
            }
        } catch (RuntimeException re) {
            if (DEBUG) {
                re.printStackTrace(System.err);
            }
        }
        System.out.println("Done " + Impiegato.class.getSimpleName() + ".");
    }

    private final List<TestSpec> testSets = new ArrayList<TestSpec>();
    private final BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
    private TestData testData;

    public Impiegato() throws IOException {
        File itemsFolder = new File(ITEMS_FOLDER_NAME);
        for (File file : itemsFolder.listFiles()) {
            if (file.isFile()) {
                String name = file.getName();
                if (name.endsWith(".items")) {
                    testSets.add(new TestSpec(file));
                }
            }
        }
        Collections.sort(testSets);
    }

    private void initializeTest(int testSetIndex) throws IOException {
        TestSpec testSpec = testSets.get(testSetIndex);
        testData = testSpec.getTestData();
    }

    private void clearConsole() {
        for (int i = 0; i < 2; ++i) {
            System.out.println();
        }
    }

    private void drawMenu() {
        System.out.println("AVAILABLE TESTS: \n");
        for (int i = 0; i < testSets.size(); ++i) {
            System.out.format("    %2d. %s\n", i + 1, testSets.get(i));
        }
        System.out.println();
    }

    private String readConsole(String cursor, String defaultAnswer) throws IOException {
        System.out.print(cursor);
        System.out.flush();
        String answer = sin.readLine();
        if (defaultAnswer != null && answer.isEmpty()) {
            answer = defaultAnswer;
        }
        return answer;
    }

    private void runTest(int itemCount) throws IOException {
        clearConsole();
        float correctCount = 0;
        long tStart = System.currentTimeMillis();
        for (int i = 0; i < itemCount; ++i) {
            TestItem item = testData.sampleItem();
            String answer = readConsole(item.getChallenge(), null);
            item.incPresentationCount();
            if (item.getScore(answer) > 0) {
                item.incCorrectAnswerCount();
                ++correctCount;
                System.out.println("ok\n");
            } else {
                System.out.println("ko -> " + item.getCorrectAnswer() + "\n");
            }
        }
        long delta = (System.currentTimeMillis() - tStart) / 1000;
        testData.saveResults();
        testData.updateRelevances();
        System.out.format("Score: %4.2f in %d minute(s) and %d second(s)\n\n", 10 * correctCount / itemCount, delta / 60, delta % 60);
    }
}

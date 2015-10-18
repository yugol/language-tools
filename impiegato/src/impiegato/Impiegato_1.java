package impiegato;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import impiegato.engine.TestCategory;
import impiegato.engine.TestItem;
import impiegato.engine.tests.TestData;
import impiegato.engine.tests.TestSpec;
import impiegato.util.ConsoleWrapper;

public class Impiegato_1 {

    public static final boolean        DEBUG                   = false;
    public static final ConsoleWrapper CONSOLE                 = new ConsoleWrapper();

    private static final String        ITEMS_FOLDER_NAME       = "items";

    private static final int           DEFAULT_TEST_SET_ITEM   = 1;
    private static final int           DEFAULT_TEST_ITEM_COUNT = 10;

    public static void main(final String... args) throws IOException {
        final Impiegato_1 impiegato = new Impiegato_1();
        try {
            while (true) {
                CONSOLE.clear();
                impiegato.drawMenu();
                String option = CONSOLE.readln("Please insert test set number (anything else will exit) [" + DEFAULT_TEST_SET_ITEM + "]: ", String.valueOf(DEFAULT_TEST_SET_ITEM));
                impiegato.initializeTest(Integer.parseInt(option) - 1);
                while (true) {
                    int itemCount = DEFAULT_TEST_ITEM_COUNT;
                    option = CONSOLE.readln("How many items per test (0 to return to main menu)? [" + itemCount + "]: ", String.valueOf(itemCount));
                    try {
                        itemCount = Integer.parseInt(option);
                        if (itemCount > 0) {
                            impiegato.runTest(itemCount);
                        } else {
                            break;
                        }
                    } catch (final NumberFormatException e) {
                        break;
                    }
                }
            }
        } catch (final RuntimeException re) {
            if (DEBUG) {
                re.printStackTrace(System.err);
            }
        }
        CONSOLE.println("Done " + Impiegato_1.class.getSimpleName() + ".");
    }

    private final List<TestSpec> testSets = new ArrayList<>();
    private TestData             testData;

    public Impiegato_1() throws IOException {
        testSets.add(new TestSpec(TestCategory.NUMERALI));
        final File itemsFolder = new File(ITEMS_FOLDER_NAME);
        for (final File file : itemsFolder.listFiles()) {
            if (file.isFile()) {
                final String name = file.getName();
                if (name.endsWith(".items")) {
                    testSets.add(new TestSpec(file));
                }
            }
        }
        Collections.sort(testSets);
    }

    private void initializeTest(final int testSetIndex) throws IOException {
        final TestSpec testSpec = testSets.get(testSetIndex);
        testData = testSpec.getTestData();
    }

    private void drawMenu() {
        CONSOLE.println("AVAILABLE TESTS: \n");
        for (int i = 0; i < testSets.size(); ++i) {
            CONSOLE.format("    %2d. %s\n", i + 1, testSets.get(i));
        }
        CONSOLE.println();
    }

    private void runTest(final int itemCount) throws IOException {
        CONSOLE.clear();
        float correctCount = 0;
        final long tStart = System.currentTimeMillis();
        for (int i = 0; i < itemCount; ++i) {
            final TestItem item = testData.sampleItem();
            final String challenge = String.valueOf(i + 1) + ". " + item.getChallenge();
            final String answer = CONSOLE.readln(challenge, null);
            item.incPresentationCount();
            if (item.getScore(answer) > 0) {
                item.incCorrectAnswerCount();
                ++correctCount;
                CONSOLE.println("ok\n");
            } else {
                CONSOLE.println("ko -> " + item.getCorrectAnswer() + "\n");
            }
        }
        final long delta = (System.currentTimeMillis() - tStart) / 1000;
        testData.saveResults();
        testData.updateRelevances();
        CONSOLE.format("Score: %4.2f in %d minute(s) and %d second(s)\n\n", 10 * correctCount / itemCount, delta / 60, delta % 60);
    }
}

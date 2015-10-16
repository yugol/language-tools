package impiegato;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import impiegato.engine.TestItem;
import impiegato.engine.TestSet;
import impiegato.engine.TestStore;
import impiegato.engine.tests.nomi.NomeItem;
import impiegato.engine.tests.verbi.VerboItem;
import impiegato.grammar.Arto;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.grammar.parti_del_discorso.Nome;
import impiegato.grammar.parti_del_discorso.Verbo;
import impiegato.util.ConsoleWrapper;
import impiegato.util.Constants;

public class Impiegato {

    private static boolean DEBUG = true;

    private static Random         RAND                    = new Random();
    private static ConsoleWrapper CONSOLE                 = new ConsoleWrapper();
    private static String         DEFAULT_TEST_SET_ITEM   = "1a";
    private static int            DEFAULT_TEST_ITEM_COUNT = 10;

    public static void main(final String... args) throws IOException {
        Impiegato impiegato = new Impiegato();
        impiegato.loadTestStore();
        impiegato.runTestSession();
        CONSOLE.println();
        CONSOLE.println("Bye!");
    }

    private final TestStore testStore = new TestStore();
    private String          setOption;
    private int             itemCount;

    private void loadTestStore() throws IOException {
        File itemsFolder = new File(Constants.ITEMS_FOLDER_NAME);
        for (File file : itemsFolder.listFiles()) {
            if (file.isFile()) {
                testStore.load(file);
            }
        }
    }

    private void drawMenu() {
        CONSOLE.println("1. VERBI");
        CONSOLE.println("  a) ALL");
        CONSOLE.println("  b) Indicativo presente");
        CONSOLE.println("  c) Indicativo passato prossimo");
        CONSOLE.println("2. NOMI");
        CONSOLE.println("  a) ALL");
    }

    private void runTestSession() throws IOException {
        while (true) {
            drawMenu();
            setOption = CONSOLE.readln("Please specify test set ('q' to exit) [" + DEFAULT_TEST_SET_ITEM + "]: ", String.valueOf(DEFAULT_TEST_SET_ITEM)).trim().toLowerCase();
            if ("q".equals(setOption)) {
                break;
            }
            while (true) {
                itemCount = DEFAULT_TEST_ITEM_COUNT;
                String countOption = CONSOLE.readln("How many items in set (0 to return to main menu)? [" + itemCount + "]: ", String.valueOf(itemCount)).trim();
                try {
                    itemCount = Integer.parseInt(countOption);
                    if (0 == itemCount) {
                        break;
                    }
                } catch (NumberFormatException e) {
                }
                if (!runTestSet()) {
                    break;
                }
                if (DEBUG) {
                    break;
                }
            }
            if (DEBUG) {
                break;
            }
        }
    }

    private boolean runTestSet() throws IOException {
        TestSet testSet = generateTestSet();
        if (testSet == null) {
            return false;
        }
        CONSOLE.clear();
        float correctCount = 0;
        long tStart = System.currentTimeMillis();
        for (int i = 0; i < itemCount; ++i) {
            TestItem item = testSet.get(i);
            String challenge = String.valueOf(i + 1) + ". " + item.getChallenge();
            String answer = CONSOLE.readln(challenge, null);
            item.incPresentationCount();
            if (item.getScore(answer) > 0) {
                item.incCorrectAnswerCount();
                ++correctCount;
                CONSOLE.println("ok\n");
            } else {
                CONSOLE.println("ko -> " + item.getCorrectAnswer() + "\n");
            }
        }
        long delta = (System.currentTimeMillis() - tStart) / 1000;
        CONSOLE.format("Score: %4.2f in %d minute(s) and %d second(s)\n\n", 10 * correctCount / itemCount, delta / 60, delta % 60);
        return true;
    }

    private TestSet generateTestSet() {
        TestSet testSet = new TestSet();
        if (setOption.startsWith("1")) {
            for (int i = 0; i < itemCount; ++i) {
                Verbo verbo = getRandomVerbo();
                Modo modo = getRandomModo();
                Tempo tempo = getRandomTempo();
                Persona persona = getRandomPersona();
                Numero numero = getRandomNumero();
                VerboItem item = new VerboItem(verbo, modo, tempo, persona, numero);
                testSet.add(item);
            }
        } else if (setOption.startsWith("2")) {
            for (int i = 0; i < itemCount; ++i) {
                Nome nome = getRandomNome();
                Numero numero = getRandomNumero();
                Arto arto = getRandomArto();
                NomeItem item = new NomeItem(nome, numero, arto);
                testSet.add(item);
            }
        }
        if (testSet.size() == 0) {
            testSet = null;
        }
        return testSet;
    }

    private Nome getRandomNome() {
        Nome nome = testStore.getRandomNome();
        return nome;
    }

    private Verbo getRandomVerbo() {
        Verbo verbo = testStore.getRandomVerbo();
        return verbo;
    }

    private Arto getRandomArto() {
        Arto value = null;
        Arto[] values = Arto.values();
        value = values[RAND.nextInt(values.length)];
        return value;
    }

    private Numero getRandomNumero() {
        Numero value = null;
        Numero[] values = Numero.values();
        value = values[RAND.nextInt(values.length)];
        return value;
    }

    private Persona getRandomPersona() {
        Persona value = null;
        Persona[] values = Persona.values();
        value = values[RAND.nextInt(values.length)];
        return value;
    }

    private Tempo getRandomTempo() {
        Tempo value = null;
        if (setOption.endsWith("a")) {
            Tempo[] values = { Tempo.PRESENTE, Tempo.PASSATO_PROSSIMO };
            value = values[RAND.nextInt(values.length)];
        } else if (setOption.endsWith("b")) {
            value = Tempo.PRESENTE;
        } else if (setOption.endsWith("c")) {
            value = Tempo.PASSATO_PROSSIMO;
        }
        return value;
    }

    private Modo getRandomModo() {
        Modo value = null;
        if (setOption.endsWith("a")) {
            Modo[] values = { Modo.INDICATIVO };
            value = values[RAND.nextInt(values.length)];
        } else if (setOption.endsWith("b")) {
            value = Modo.INDICATIVO;
        } else if (setOption.endsWith("c")) {
            value = Modo.INDICATIVO;
        }
        return value;
    }
}

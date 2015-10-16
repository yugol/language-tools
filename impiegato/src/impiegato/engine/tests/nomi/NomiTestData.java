package impiegato.engine.tests.nomi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import impiegato.engine.TestItem;
import impiegato.engine.TestStore;
import impiegato.engine.tests.TestData;
import impiegato.engine.tests.TestSpec;
import impiegato.grammar.Arto;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.parti_del_discorso.Nome;

public class NomiTestData extends TestData {

    private final Map<String, Nome> nomi = new HashMap<String, Nome>();

    public NomiTestData(final TestSpec testSpec) {
        super(testSpec);
    }

    @Override
    protected TestItem processRecord(final String record, final List<TestItem> items) {
        final Nome nome = TestStore.processNomeRecord(record, nomi);
        for (final Numero numero : Numero.values()) {
            for (final Arto articolazione : Arto.values()) {
                final NomeItem item = new NomeItem(nome, numero, articolazione);
                items.add(item);
            }
        }
        return null;
    }
}

package impiegato.engine.tests.verbi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import impiegato.engine.TestItem;
import impiegato.engine.TestStore;
import impiegato.engine.tests.TestData;
import impiegato.engine.tests.TestSpec;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.grammar.parti_del_discorso.Verbo;

public class VerbiTestData extends TestData {

    protected Modo                   modo;
    protected Tempo                  tempo;
    private final Map<String, Verbo> verbi = new HashMap<>();

    public VerbiTestData(final TestSpec testSpec, final Modo modo, final Tempo tempo) {
        super(testSpec);
        this.modo = modo;
        this.tempo = tempo;
    }

    @Override
    protected TestItem processRecord(final String record, final List<TestItem> items) {
        final Verbo verbo = TestStore.processVerboRecord(record, verbi, modo, tempo);
        for (final Persona persona : Persona.values()) {
            for (final Numero numero : Numero.values()) {
                final VerboItem item = new VerboItem(verbo, modo, tempo, persona, numero);
                items.add(item);
            }
        }
        return null;
    }
}
package impiegato.engine.tests.verbi;

import impiegato.engine.TestData;
import impiegato.engine.TestItem;
import impiegato.engine.TestSpec;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.grammar.parti_del_discorso.Verbo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerbiTestData extends TestData {

    private Modo modo;
    private Tempo tempo;
    private final Map<String, Verbo> verbi = new HashMap<String, Verbo>();

    public VerbiTestData(TestSpec testSpec, Modo modo, Tempo tempo) {
        super(testSpec);
        this.modo = modo;
        this.tempo = tempo;
    }

    @Override
    protected TestItem processRecord(String record, List<TestItem> items) {
        String[] forms = record.split(CELL_SEPARATOR);
        String lemma = forms[0].trim();
        Verbo verbo = verbi.get(lemma);
        if (verbo == null) {
            verbo = new Verbo(lemma);
            verbi.put(lemma, verbo);
        }
        verbo.setModo(modo);
        verbo.setTempo(tempo);
        verbo.setForm(modo, tempo, Persona.PRIMA, Numero.SINGOLARE, forms[1].trim());
        verbo.setForm(modo, tempo, Persona.PRIMA, Numero.SINGOLARE, forms[1].trim());
        verbo.setForm(modo, tempo, Persona.SECONDA, Numero.SINGOLARE, forms[2].trim());
        verbo.setForm(modo, tempo, Persona.TERZA, Numero.SINGOLARE, forms[3].trim());
        verbo.setForm(modo, tempo, Persona.PRIMA, Numero.PLURALE, forms[4].trim());
        verbo.setForm(modo, tempo, Persona.SECONDA, Numero.PLURALE, forms[5].trim());
        verbo.setForm(modo, tempo, Persona.TERZA, Numero.PLURALE, forms[6].trim());

        for (Persona persona : Persona.values()) {
            for (Numero numero : Numero.values()) {
                VerboItem item = new VerboItem(verbo, modo, tempo, persona, numero);
                items.add(item);
            }
        }

        return null;
    }
}

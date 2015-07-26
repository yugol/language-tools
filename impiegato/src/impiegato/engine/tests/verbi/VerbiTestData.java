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
        verbo.setForm(forms[1].trim(), modo, tempo, Persona.PRIMA, Numero.SINGOLARE);
        verbo.setForm(forms[1].trim(), modo, tempo, Persona.PRIMA, Numero.SINGOLARE);
        verbo.setForm(forms[2].trim(), modo, tempo, Persona.SECONDA, Numero.SINGOLARE);
        verbo.setForm(forms[3].trim(), modo, tempo, Persona.TERZA, Numero.SINGOLARE);
        verbo.setForm(forms[4].trim(), modo, tempo, Persona.PRIMA, Numero.PLURALE);
        verbo.setForm(forms[5].trim(), modo, tempo, Persona.SECONDA, Numero.PLURALE);
        verbo.setForm(forms[6].trim(), modo, tempo, Persona.TERZA, Numero.PLURALE);

        for (Persona persona : Persona.values()) {
            for (Numero numero : Numero.values()) {
                VerboItem item = new VerboItem(verbo, modo, tempo, persona, numero);
                items.add(item);
            }
        }

        return null;
    }
}

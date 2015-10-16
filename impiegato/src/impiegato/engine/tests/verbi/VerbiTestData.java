package impiegato.engine.tests.verbi;

import impiegato.engine.TestSpec;
import impiegato.engine.tests.TestData;
import impiegato.engine.tests.TestItem;
import impiegato.grammar.Ausiliare;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.grammar.parti_del_discorso.Verbo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerbiTestData extends TestData {

    private static final String INCOATIVO_MARKER = "(isc)";
    private static final String AUSILIARE_MARKER = "(essere)";
    private static final String PP_MARKER = "(pp.";
    private static final String END_MARKER = ")";

    protected Modo modo;
    protected Tempo tempo;
    private final Map<String, Verbo> verbi = new HashMap<>();

    public VerbiTestData(TestSpec testSpec, Modo modo, Tempo tempo) {
        super(testSpec);
        this.modo = modo;
        this.tempo = tempo;
    }

    @Override
    protected TestItem processRecord(String record, List<TestItem> items) {
        String[] forms = record.split(CELL_SEPARATOR);
        String lemma = forms[0].trim();
        boolean incoativo = lemma.contains(INCOATIVO_MARKER);
        Ausiliare ausiliare = lemma.contains(AUSILIARE_MARKER) ? Ausiliare.ESSERE : Ausiliare.AVERE;
        String participioPassato = null;
        int ppStartIndex = lemma.indexOf(PP_MARKER);
        if (ppStartIndex >= 0) {
            int ppEndIndex = lemma.indexOf(END_MARKER, ppStartIndex);
            participioPassato = lemma.substring(ppStartIndex + PP_MARKER.length(), ppEndIndex);
        }
        if (lemma.contains(" ")) {
            lemma = lemma.split(" ")[0];
        }
        Verbo verbo = verbi.get(lemma);
        if (verbo == null) {
            verbo = new Verbo(lemma);
            verbo.setIncoativo(incoativo);
            verbo.setForm(participioPassato, Modo.PARTICIPIO, Tempo.PASSATO);
            verbo.setAusiliare(ausiliare);
            verbi.put(lemma, verbo);
        }
        if (forms.length > 1) {
            verbo.setForm(forms[1].trim(), modo, tempo, Persona.PRIMA, Numero.SINGOLARE);
            if (forms.length > 2) {
                verbo.setForm(forms[2].trim(), modo, tempo, Persona.SECONDA, Numero.SINGOLARE);
                if (forms.length > 3) {
                    verbo.setForm(forms[3].trim(), modo, tempo, Persona.TERZA, Numero.SINGOLARE);
                    if (forms.length > 4) {
                        verbo.setForm(forms[4].trim(), modo, tempo, Persona.PRIMA, Numero.PLURALE);
                        if (forms.length > 5) {
                            verbo.setForm(forms[5].trim(), modo, tempo, Persona.SECONDA, Numero.PLURALE);
                            if (forms.length > 6) {
                                verbo.setForm(forms[6].trim(), modo, tempo, Persona.TERZA, Numero.PLURALE);
                            }
                        }
                    }
                }
            }
        }
        for (Persona persona : Persona.values()) {
            for (Numero numero : Numero.values()) {
                VerboItem item = new VerboItem(verbo, modo, tempo, persona, numero);
                items.add(item);
            }
        }
        return null;
    }
}

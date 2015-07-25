package impiegato.engine.tests.nomi;

import impiegato.engine.TestData;
import impiegato.engine.TestItem;
import impiegato.engine.TestSpec;
import impiegato.grammar.Arto;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.parti_del_discorso.Nome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NomiTestData extends TestData {

    private final Map<String, Nome> nomi = new HashMap<String, Nome>();

    public NomiTestData(TestSpec testSpec) {
        super(testSpec);
    }

    @Override
    protected TestItem processRecord(String record, List<TestItem> items) {
        String[] forms = record.split(CELL_SEPARATOR);
        String lemma = forms[0].trim();
        Genere genere = null;
        String plurale = null;
        if (forms.length == 2) {
            String second = forms[1].trim();
            genere = Genere.fromString(second);
            if (genere == null) {
                plurale = second;
            }
        } else if (forms.length == 3) {
            genere = Genere.fromString(forms[1].trim());
            plurale = forms[2].trim();
        }
        Nome nome = new Nome(lemma, genere, plurale);
        nomi.put(lemma, nome);

        for (Numero numero : Numero.values()) {
            for (Arto articolazione : Arto.values()) {
                NomeItem item = new NomeItem(nome, numero, articolazione);
                items.add(item);
            }
        }

        return null;
    }
}

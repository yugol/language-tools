package impiegato.engine;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import impiegato.grammar.Ausiliare;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.grammar.parti_del_discorso.Nome;
import impiegato.grammar.parti_del_discorso.Verbo;
import impiegato.util.Constants;
import impiegato.util.DataFileReader;

public class TestStore {

    private static Random RAND = new Random();

    private final Map<String, Verbo> verbi = new HashMap<>();
    private final Map<String, Nome>  nomi  = new HashMap<>();

    public void load(final File file) throws IOException {
        String[] chunks = file.getName().split("\\.");
        if ("items".equalsIgnoreCase(chunks[chunks.length - 1])) {
            final TestCategory category = TestCategory.valueOf(chunks[chunks.length - 2].toUpperCase());
            final String name = chunks.length > 2 ? chunks[chunks.length - 3] : "";
            switch (category) {
            case VERBI:
                chunks = name.split("-");
                final Modo modo = Modo.valueOf(chunks[0].toUpperCase());
                final Tempo tempo = Tempo.valueOf(chunks[1].toUpperCase());
                new DataFileReader(file) {

                    @Override
                    protected void processRecord(final String record) {
                        processVerboRecord(record, verbi, modo, tempo);
                    }
                }.process();
                break;
            case NOMI:
                new DataFileReader(file) {

                    @Override
                    protected void processRecord(final String record) {
                        processNomeRecord(record, nomi);
                    }
                }.process();
                break;
            default:
                break;
            }
        }
    }

    public static Verbo processVerboRecord(final String record, final Map<String, Verbo> verbi, final Modo modo, final Tempo tempo) {
        final String[] forms = record.split(Constants.CELL_SEPARATOR);
        String lemma = forms[0].trim();
        final boolean incoativo = lemma.contains(Constants.INCOATIVO_MARKER);
        final Ausiliare ausiliare = lemma.contains(Constants.AUSILIARE_MARKER) ? Ausiliare.ESSERE : Ausiliare.AVERE;
        String participioPassato = null;
        final int ppStartIndex = lemma.indexOf(Constants.PP_MARKER);
        if (ppStartIndex >= 0) {
            final int ppEndIndex = lemma.indexOf(Constants.END_MARKER, ppStartIndex);
            participioPassato = lemma.substring(ppStartIndex + Constants.PP_MARKER.length(), ppEndIndex);
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
        return verbo;
    }

    public static Nome processNomeRecord(final String record, final Map<String, Nome> nomi) {
        final String[] forms = record.split(Constants.CELL_SEPARATOR);
        final String lemma = forms[0].trim();
        Genere genere = null;
        String plurale = null;
        if (forms.length == 2) {
            final String second = forms[1].trim();
            genere = Genere.fromString(second);
            if (genere == null) {
                plurale = second;
            }
        } else if (forms.length == 3) {
            genere = Genere.fromString(forms[1].trim());
            plurale = forms[2].trim();
        }
        final Nome nome = new Nome(lemma, genere, plurale);
        nomi.put(lemma, nome);
        return nome;
    }

    public Verbo getRandomVerbo() {
        Verbo verbo = null;
        final Iterator<Verbo> it = verbi.values().iterator();
        for (int i = 0; i < RAND.nextInt(verbi.size()); ++i) {
            verbo = it.next();
        }
        return verbo;
    }

    public Nome getRandomNome() {
        Nome nome = null;
        final Iterator<Nome> it = nomi.values().iterator();
        for (int i = 0; i < RAND.nextInt(nomi.size()); ++i) {
            nome = it.next();
        }
        return nome;
    }
}

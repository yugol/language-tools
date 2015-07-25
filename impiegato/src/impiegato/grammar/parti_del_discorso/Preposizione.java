package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.determinazioni.Conseguente;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;

public class Preposizione extends ParteDelDiscorso {

    public static final String DI = "di";
    public static final String A = "a";
    public static final String DA = "da";
    public static final String IN = "in";
    public static final String SU = "su";
    public static final String CON = "con";
    public static final String PER = "per";
    public static final String FRA_TRA = "fra|tra";
    public static final String ENTRO = "entro";
    public static final String FA = "fa";

    public static final String[] SAMPLES = { DI, A, DA, IN, SU, CON, PER, FRA_TRA };

    public static String getRadix(String lemma) {
        if (DI.equals(lemma)) {
            return "de";
        }
        if (A.equals(lemma)) {
            return "a";
        }
        if (DA.equals(lemma)) {
            return "da";
        }
        if (IN.equals(lemma)) {
            return "ne";
        }
        if (SU.equals(lemma)) {
            return "su";
        }
        return null;
    }

    public static Preposizione get(String form) {
        form = form.trim().toLowerCase();
        if ("d'".equals(form)) {
            return new Preposizione(DI, null, null, Conseguente.VOCALE);
        } else if ("fra".equals(form) || "tra".equals(form)) {
            return new Preposizione(FRA_TRA);

        } else if ("del".equals(form)) {
            return new Preposizione(DI, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("dello".equals(form)) {
            return new Preposizione(DI, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
        } else if ("dell'".equals(form)) {
            return new Preposizione(DI, null, Numero.SINGOLARE, Conseguente.VOCALE);
        } else if ("della".equals(form)) {
            return new Preposizione(DI, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("dei".equals(form)) {
            return new Preposizione(DI, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
        } else if ("degli".equals(form)) {
            return new Preposizione(DI, Genere.MASCHILE, Numero.PLURALE, null);
        } else if ("delle".equals(form)) {
            return new Preposizione(DI, Genere.FEMMINILE, Numero.PLURALE, null);

        } else if ("al".equals(form)) {
            return new Preposizione(A, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("allo".equals(form)) {
            return new Preposizione(A, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
        } else if ("all'".equals(form)) {
            return new Preposizione(A, null, Numero.SINGOLARE, Conseguente.VOCALE);
        } else if ("alla".equals(form)) {
            return new Preposizione(A, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("ai".equals(form)) {
            return new Preposizione(A, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
        } else if ("agli".equals(form)) {
            return new Preposizione(A, Genere.MASCHILE, Numero.PLURALE, null);
        } else if ("alle".equals(form)) {
            return new Preposizione(A, Genere.FEMMINILE, Numero.PLURALE, null);

        } else if ("dal".equals(form)) {
            return new Preposizione(DA, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("dallo".equals(form)) {
            return new Preposizione(DA, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
        } else if ("dall'".equals(form)) {
            return new Preposizione(DA, null, Numero.SINGOLARE, Conseguente.VOCALE);
        } else if ("dalla".equals(form)) {
            return new Preposizione(DA, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("dai".equals(form)) {
            return new Preposizione(DA, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
        } else if ("dagli".equals(form)) {
            return new Preposizione(DA, Genere.MASCHILE, Numero.PLURALE, null);
        } else if ("dalle".equals(form)) {
            return new Preposizione(DA, Genere.FEMMINILE, Numero.PLURALE, null);

        } else if ("nel".equals(form)) {
            return new Preposizione(IN, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("nello".equals(form)) {
            return new Preposizione(IN, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
        } else if ("nell'".equals(form)) {
            return new Preposizione(IN, null, Numero.SINGOLARE, Conseguente.VOCALE);
        } else if ("nella".equals(form)) {
            return new Preposizione(IN, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("nei".equals(form)) {
            return new Preposizione(IN, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
        } else if ("negli".equals(form)) {
            return new Preposizione(IN, Genere.MASCHILE, Numero.PLURALE, null);
        } else if ("nelle".equals(form)) {
            return new Preposizione(IN, Genere.FEMMINILE, Numero.PLURALE, null);

        } else if ("sul".equals(form)) {
            return new Preposizione(SU, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("sullo".equals(form)) {
            return new Preposizione(SU, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
        } else if ("sull'".equals(form)) {
            return new Preposizione(SU, null, Numero.SINGOLARE, Conseguente.VOCALE);
        } else if ("sulla".equals(form)) {
            return new Preposizione(SU, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
        } else if ("sui".equals(form)) {
            return new Preposizione(SU, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
        } else if ("sugli".equals(form)) {
            return new Preposizione(SU, Genere.MASCHILE, Numero.PLURALE, null);
        } else if ("sulle".equals(form)) {
            return new Preposizione(SU, Genere.FEMMINILE, Numero.PLURALE, null);

        }
        return new Preposizione(form);
    }

    public static Preposizione get(String lemma, Preposizione one) {
        Preposizione another = new Preposizione(lemma);
        another.setGenere(one.getGenere());
        another.setNumero(one.getNumero());
        another.setConseguente(one.getConseguente());
        return another;
    }

    private Genere genere;
    private Numero numero;
    private Conseguente conseguente;

    protected Preposizione(String lemma) {
        super(lemma);
    }

    public Preposizione(String lemma, Genere genere, Numero numero, Conseguente conseguente) {
        this(lemma);
        this.genere = genere;
        this.numero = numero;
        this.conseguente = conseguente;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public Conseguente getConseguente() {
        return conseguente;
    }

    public void setConseguente(Conseguente conseguente) {
        this.conseguente = conseguente;
    }

    @Override
    public String getForm() {
        String lemma = getLemma();

        if (numero == null) {
            if (conseguente == Conseguente.VOCALE) {
                if (DI.equals(lemma)) {
                    return "d'";
                }
            }
        } else {
            String radix = getRadix(lemma);
            if (radix != null) {
                if (numero == Numero.SINGOLARE) {
                    if (conseguente == Conseguente.VOCALE) {
                        return radix + "ll'";
                    }
                    if (genere == Genere.FEMMINILE) {
                        return radix + "lla";
                    }
                    if (conseguente == Conseguente.S__Z_X_Y_PS_PN_GN) {
                        return radix + "llo";
                    }
                    return radix + "l";
                }
                if (numero == Numero.PLURALE) {
                    if (genere == Genere.FEMMINILE) {
                        return radix + "lle";
                    }
                    if (conseguente == Conseguente.CONSONANTE) {
                        return radix + "i";
                    }
                    return radix + "gli";
                }
            }
        }

        if (FRA_TRA.equals(lemma)) {
            return "tra";
        }

        return lemma;
    }
}

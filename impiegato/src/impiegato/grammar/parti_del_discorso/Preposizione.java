package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.Conseguente;
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

    public static final String[] SAMPLES = {DI, A, DA, IN, SU, CON, PER, FRA_TRA};

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
        if (null != form) {
            switch (form) {
                case "d'":
                    return new Preposizione(DI, null, null, Conseguente.VOCALE);
                case "fra":
                case "tra":
                    return new Preposizione(FRA_TRA);
                case "del":
                    return new Preposizione(DI, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "dello":
                    return new Preposizione(DI, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
                case "dell'":
                    return new Preposizione(DI, null, Numero.SINGOLARE, Conseguente.VOCALE);
                case "della":
                    return new Preposizione(DI, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "dei":
                    return new Preposizione(DI, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
                case "degli":
                    return new Preposizione(DI, Genere.MASCHILE, Numero.PLURALE, null);
                case "delle":
                    return new Preposizione(DI, Genere.FEMMINILE, Numero.PLURALE, null);
                case "al":
                    return new Preposizione(A, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "allo":
                    return new Preposizione(A, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
                case "all'":
                    return new Preposizione(A, null, Numero.SINGOLARE, Conseguente.VOCALE);
                case "alla":
                    return new Preposizione(A, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "ai":
                    return new Preposizione(A, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
                case "agli":
                    return new Preposizione(A, Genere.MASCHILE, Numero.PLURALE, null);
                case "alle":
                    return new Preposizione(A, Genere.FEMMINILE, Numero.PLURALE, null);
                case "dal":
                    return new Preposizione(DA, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "dallo":
                    return new Preposizione(DA, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
                case "dall'":
                    return new Preposizione(DA, null, Numero.SINGOLARE, Conseguente.VOCALE);
                case "dalla":
                    return new Preposizione(DA, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "dai":
                    return new Preposizione(DA, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
                case "dagli":
                    return new Preposizione(DA, Genere.MASCHILE, Numero.PLURALE, null);
                case "dalle":
                    return new Preposizione(DA, Genere.FEMMINILE, Numero.PLURALE, null);
                case "nel":
                    return new Preposizione(IN, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "nello":
                    return new Preposizione(IN, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
                case "nell'":
                    return new Preposizione(IN, null, Numero.SINGOLARE, Conseguente.VOCALE);
                case "nella":
                    return new Preposizione(IN, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "nei":
                    return new Preposizione(IN, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
                case "negli":
                    return new Preposizione(IN, Genere.MASCHILE, Numero.PLURALE, null);
                case "nelle":
                    return new Preposizione(IN, Genere.FEMMINILE, Numero.PLURALE, null);
                case "sul":
                    return new Preposizione(SU, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "sullo":
                    return new Preposizione(SU, Genere.MASCHILE, Numero.SINGOLARE, Conseguente.S__Z_X_Y_PS_PN_GN);
                case "sull'":
                    return new Preposizione(SU, null, Numero.SINGOLARE, Conseguente.VOCALE);
                case "sulla":
                    return new Preposizione(SU, Genere.FEMMINILE, Numero.SINGOLARE, Conseguente.CONSONANTE);
                case "sui":
                    return new Preposizione(SU, Genere.MASCHILE, Numero.PLURALE, Conseguente.CONSONANTE);
                case "sugli":
                    return new Preposizione(SU, Genere.MASCHILE, Numero.PLURALE, null);
                case "sulle":
                    return new Preposizione(SU, Genere.FEMMINILE, Numero.PLURALE, null);
            }
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
    public String getForm(Object... selector) {
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

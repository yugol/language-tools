package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;
import impiegato.util.StringUtil;

public class Nome extends ParteDelDiscorso {

    private static Genere identifyGenere(String lemma, Genere genere) {
        if (genere == null) {
            char last = lemma.charAt(lemma.length() - 1);
            if (last == 'à' || lemma.endsWith("a`")) {
                return Genere.FEMMINILE;
            }
            if (StringUtil.isVowel(last)) {
                switch (last) {
                    case 'o':
                        return Genere.MASCHILE;
                    case 'a':
                        return Genere.FEMMINILE;
                    case 'e':
                        if (lemma.endsWith("ore")) {
                            return Genere.MASCHILE;
                        }
                        if (lemma.endsWith("trice") || lemma.endsWith("ione")) {
                            return Genere.FEMMINILE;
                        }
                }
            } else {
                return Genere.MASCHILE;
            }
        }
        if (genere == null) {
            throw new IllegalArgumentException("No " + Genere.class.getSimpleName() + " for '" + lemma + "'");
        }
        return genere;
    }

    private static String identifyPlurale(String lemma, Genere genere, String plurale) {
        if (plurale == null) {
            char last = lemma.charAt(lemma.length() - 1);
            if (last == 'à' || lemma.endsWith("a`")) {
                return lemma;
            }
            if (!StringUtil.isVowel(last)) {
                return lemma;
            }
            switch (genere) {
                case MASCHILE:
                    if (lemma.endsWith("io")) {
                        return lemma.substring(0, lemma.length() - 2) + "i";
                    }
                    if (lemma.endsWith("co")) {
                        return lemma.substring(0, lemma.length() - 2) + "chi";
                    }
                    if (lemma.endsWith("go")) {
                        return lemma.substring(0, lemma.length() - 2) + "ghi";
                    }
                    if (lemma.endsWith("o")) {
                        return lemma.substring(0, lemma.length() - 1) + "i";
                    }
                case FEMMINILE:
                    if (lemma.endsWith("cia")) {
                        if (StringUtil.isVowel(lemma.charAt(lemma.length() - 4))) {
                            return lemma.substring(0, lemma.length() - 3) + "cie";
                        }
                        return lemma.substring(0, lemma.length() - 3) + "ce";
                    }
                    if (lemma.endsWith("gia")) {
                        if (StringUtil.isVowel(lemma.charAt(lemma.length() - 4))) {
                            return lemma.substring(0, lemma.length() - 3) + "gie";
                        }
                        return lemma.substring(0, lemma.length() - 3) + "ge";
                    }
                    if (lemma.endsWith("ca")) {
                        return lemma.substring(0, lemma.length() - 2) + "che";
                    }
                    if (lemma.endsWith("ga")) {
                        return lemma.substring(0, lemma.length() - 2) + "ghe";
                    }
                    if (lemma.endsWith("a")) {
                        return lemma.substring(0, lemma.length() - 1) + "e";
                    }
                default:
                    break;
            }
            if (lemma.endsWith("e")) {
                return lemma.substring(0, lemma.length() - 1) + "i";
            }
        }
        return plurale;
    }

    private final Genere genere;
    private final String plurale;
    private Numero numero;

    public Nome(String lemma) {
        this(lemma, null, null);
    }

    public Nome(String lemma, Genere genere) {
        this(lemma, genere, null);
    }

    public Nome(String lemma, String plurale) {
        this(lemma, null, plurale);
    }

    public Nome(String lemma, Genere genere, String plurale) {
        super(lemma);
        this.genere = identifyGenere(lemma, genere);
        this.plurale = identifyPlurale(lemma, this.genere, plurale);
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public String getForm() {
        if (numero == Numero.PLURALE) {
            return plurale;
        }
        return getLemma();
    }

}

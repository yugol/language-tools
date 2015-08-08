package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.Conseguente;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;

public class ArticoloIndeterminativo extends Articolo {

    public static ArticoloIndeterminativo get(Genere genere, Numero numero, String form) {
        Conseguente conseguente = Conseguente.classifyForm(form);
        return new ArticoloIndeterminativo(genere, numero, conseguente);
    }

    public ArticoloIndeterminativo(Genere genere, Numero numero, Conseguente conseguente) {
        super(genere, numero, conseguente);
    }

    @Override
    public String getForm(Object... selector) {
        switch (getGenere()) {
            case MASCHILE:
                switch (getNumero()) {
                    case SINGOLARE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                            case VOCALE:
                                return "un";
                            case S__Z_X_Y_PS_PN_GN:
                                return "uno";
                        }
                    case PLURALE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                                return "dei";
                            case S__Z_X_Y_PS_PN_GN:
                            case VOCALE:
                                return "degli";
                        }
                }
            case FEMMINILE:
                switch (getNumero()) {
                    case SINGOLARE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                            case S__Z_X_Y_PS_PN_GN:
                                return "una";
                            case VOCALE:
                                return "un'";
                        }
                    case PLURALE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                            case S__Z_X_Y_PS_PN_GN:
                            case VOCALE:
                                return "delle";
                        }
                }
            default:
                break;
        }
        return getLemma();
    }

}

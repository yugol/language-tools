package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.determinazioni.Conseguente;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;

public class ArticoloDeterminativo extends Articolo {

    public static ArticoloDeterminativo get(Genere genere, Numero numero, String form) {
        Conseguente conseguente = Conseguente.classifyForm(form);
        return new ArticoloDeterminativo(genere, numero, conseguente);
    }

    protected ArticoloDeterminativo(Genere genere, Numero numero, Conseguente conseguente) {
        super(genere, numero, conseguente);
    }

    @Override
    public String getForm() {
        switch (getGenere()) {
            case MASCHILE:
                switch (getNumero()) {
                    case SINGOLARE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                                return "il";
                            case S__Z_X_Y_PS_PN_GN:
                                return "lo";
                            case VOCALE:
                                return "l'";
                        }
                    case PLURALE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                                return "i";
                            case S__Z_X_Y_PS_PN_GN:
                            case VOCALE:
                                return "gli";
                        }
                }
            case FEMMINILE:
                switch (getNumero()) {
                    case SINGOLARE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                            case S__Z_X_Y_PS_PN_GN:
                                return "la";
                            case VOCALE:
                                return "l'";
                        }
                    case PLURALE:
                        switch (getConseguente()) {
                            case CONSONANTE:
                            case S__Z_X_Y_PS_PN_GN:
                            case VOCALE:
                                return "le";
                        }
                }
            default:
                break;
        }
        return getLemma();
    }

}

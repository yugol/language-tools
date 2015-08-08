package impiegato.grammar;

import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.parti_del_discorso.Articolo;
import impiegato.grammar.parti_del_discorso.ArticoloDeterminativo;
import impiegato.grammar.parti_del_discorso.ArticoloIndeterminativo;

public enum Arto {

    DETERMINATIVO,
    INDETERMINATIVO;

    public Articolo getArticolo(Genere genere, Numero numero, String form) {
        switch (this) {
            case DETERMINATIVO:
                return ArticoloDeterminativo.get(genere, numero, form);
            case INDETERMINATIVO:
                return ArticoloIndeterminativo.get(genere, numero, form);
        }
        return null;
    }
}

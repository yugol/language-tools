package impiegato.grammar;

import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;

public final class FormSelector {

    public Modo modo;
    public Tempo tempo;
    public Persona persona;
    public Numero numero;
    public Genere genere;

    public FormSelector(Object... selector) {
        if (selector != null && selector.length > 0) {
            if (selector[0] instanceof FormSelector) {
                merge((FormSelector) selector[0]);
            } else {
                merge(selector);
            }
        }
    }

    public FormSelector merge(FormSelector other) {
        if (modo == null) {
            modo = other.modo;
        }
        if (tempo == null) {
            tempo = other.tempo;
        }
        if (persona == null) {
            persona = other.persona;
        }
        if (numero == null) {
            numero = other.numero;
        }
        if (genere == null) {
            genere = other.genere;
        }
        return this;
    }

    public FormSelector merge(Object... selector) {
        for (Object obj : selector) {
            if (obj instanceof Modo) {
                modo = (Modo) obj;
            } else if (obj instanceof Tempo) {
                tempo = (Tempo) obj;
            } else if (obj instanceof Persona) {
                persona = (Persona) obj;
            } else if (obj instanceof Numero) {
                numero = (Numero) obj;
            } else if (obj instanceof Genere) {
                genere = (Genere) obj;
            }
        }
        return this;
    }
}

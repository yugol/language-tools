package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import java.util.EnumMap;
import java.util.Map;

public class Verbo extends ParteDelDiscorso {

    private static class FormSelector {

        public Modo modo;
        public Tempo tempo;
        public Persona persona;
        public Numero numero;

        public FormSelector(Object... spec) {
            if (spec != null) {
                for (Object obj : spec) {
                    if (obj instanceof Modo) {
                        modo = (Modo) obj;
                    } else if (obj instanceof Tempo) {
                        tempo = (Tempo) obj;
                    } else if (obj instanceof Persona) {
                        persona = (Persona) obj;
                    } else if (obj instanceof Numero) {
                        numero = (Numero) obj;
                    }
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
            return this;
        }

    }

    private final FormSelector defaultSelector = new FormSelector();

    private final Map<Modo, Map<Tempo, Map<Persona, Map<Numero, String>>>> forms = new EnumMap<Modo, Map<Tempo, Map<Persona, Map<Numero, String>>>>(Modo.class);

    public Verbo(String lemma) {
        super(lemma);
    }

    @Override
    public String getForm(Object... selector) {
        FormSelector fSel = new FormSelector(selector).merge(defaultSelector);
        return forms.get(fSel.modo).get(fSel.tempo).get(fSel.persona).get(fSel.numero);
    }

    public Modo getModo() {
        return defaultSelector.modo;
    }

    public void setModo(Modo modo) {
        defaultSelector.modo = modo;
    }

    public Tempo getTempo() {
        return defaultSelector.tempo;
    }

    public void setTempo(Tempo tempo) {
        defaultSelector.tempo = tempo;
    }

    public Persona getPersona() {
        return defaultSelector.persona;
    }

    public void setPersona(Persona persona) {
        defaultSelector.persona = persona;
    }

    public Numero getNumero() {
        return defaultSelector.numero;
    }

    public void setNumero(Numero numero) {
        defaultSelector.numero = numero;
    }

    public void setForm(String form, Object... selector) {
        FormSelector fSel = new FormSelector(selector).merge(defaultSelector);
        Map<Tempo, Map<Persona, Map<Numero, String>>> tempi = forms.get(fSel.modo);
        if (tempi == null) {
            tempi = new EnumMap<Tempo, Map<Persona, Map<Numero, String>>>(Tempo.class);
            forms.put(fSel.modo, tempi);
        }
        Map<Persona, Map<Numero, String>> persone = tempi.get(fSel.tempo);
        if (persone == null) {
            persone = new EnumMap<Persona, Map<Numero, String>>(Persona.class);
            tempi.put(fSel.tempo, persone);
        }
        Map<Numero, String> numeri = persone.get(fSel.persona);
        if (numeri == null) {
            numeri = new EnumMap<Numero, String>(Numero.class);
            persone.put(fSel.persona, numeri);
        }
        numeri.put(fSel.numero, form);
    }
}

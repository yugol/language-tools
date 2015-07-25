package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;

import java.util.HashMap;
import java.util.Map;

public class Verbo extends ParteDelDiscorso {

    private Modo modo;
    private Tempo tempo;
    private Persona persona;
    private Numero numero;

    private final Map<Modo, Map<Tempo, Map<Persona, Map<Numero, String>>>> forms = new HashMap<Modo, Map<Tempo, Map<Persona, Map<Numero, String>>>>();

    public Verbo(String lemma) {
        super(lemma);
    }

    @Override
    public String getForm() {
        return forms.get(modo).get(tempo).get(persona).get(numero);
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public void setForm(String form) {
        setForm(null, null, null, null, form);
    }

    public void setForm(Modo aModo, Tempo aTempo, Persona aPersona, Numero aNumero, String form) {
        if (aModo == null) {
            aModo = modo;
        }
        if (aTempo == null) {
            aTempo = tempo;
        }
        if (aPersona == null) {
            aPersona = persona;
        }
        if (aNumero == null) {
            aNumero = numero;
        }
        Map<Tempo, Map<Persona, Map<Numero, String>>> tempi = forms.get(aModo);
        if (tempi == null) {
            tempi = new HashMap<Tempo, Map<Persona, Map<Numero, String>>>();
            forms.put(aModo, tempi);
        }
        Map<Persona, Map<Numero, String>> persone = tempi.get(aTempo);
        if (persone == null) {
            persone = new HashMap<Persona, Map<Numero, String>>();
            tempi.put(aTempo, persone);
        }
        Map<Numero, String> numeri = persone.get(aPersona);
        if (numeri == null) {
            numeri = new HashMap<Numero, String>();
            persone.put(aPersona, numeri);
        }
        numeri.put(aNumero, form);
    }
}

package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.FormSelector;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;

public class PronomeRiflessivo extends Pronome {

	private static String calculateForm(Persona persona, Numero numero) {
		switch (persona) {
		case PRIMA:
			switch (numero) {
			case SINGOLARE:
				return "mi";
			case PLURALE:
				return "ci";
			}
		case SECONDA:
			switch (numero) {
			case SINGOLARE:
				return "ti";
			case PLURALE:
				return "vi";
			}
		case TERZA:
			return "si";
		}
		return null;
	}

	private static Persona calculatePersona(String form) {
		switch (form) {
		case "mi":
		case "ci":
			return Persona.PRIMA;
		case "ti":
		case "vi":
			return Persona.SECONDA;
		case "si":
			return Persona.TERZA;
		}
		return null;
	}

	private static Numero calculateNumero(String form) {
		switch (form) {
		case "mi":
		case "ti":
			return Numero.SINGOLARE;
		case "ci":
		case "vi":
			return Numero.PLURALE;
		}
		return null;
	}

	private Persona persona;
	private Numero numero;

	public PronomeRiflessivo(String form) {
		super("");
		persona = calculatePersona(form);
		numero = calculateNumero(form);
	}

	public PronomeRiflessivo(Persona persona, Numero numero) {
		super("");
		this.persona = persona;
		this.numero = numero;
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

	@Override
	public String getForm(Object... selector) {
		FormSelector fSel = new FormSelector(selector).merge(persona, numero);
		return calculateForm(fSel.persona, fSel.numero);
	}
}

package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.util.StringUtil;

public class PronomePersonale extends Pronome {

	public static PronomePersonale get(Persona persona, Numero numero, Genere genere) {
		switch (persona) {
		case PRIMA:
			switch (numero) {
			case SINGOLARE:
				return new PronomePersonale("io", persona, numero, genere);
			case PLURALE:
				return new PronomePersonale("noi", persona, numero, genere);
			}
		case SECONDA:
			switch (numero) {
			case SINGOLARE:
				return new PronomePersonale("tu", persona, numero, genere);
			case PLURALE:
				return new PronomePersonale("voi", persona, numero, genere);
			}
		case TERZA:
			switch (numero) {
			case SINGOLARE:
				switch (genere) {
				case MASCHILE:
					return new PronomePersonale("lui", persona, numero, genere);
				case FEMMINILE:
					return new PronomePersonale("lei", persona, numero, genere);
				case LEI:
					return new PronomePersonale("Lei", persona, numero, genere);
				}
			case PLURALE:
				return new PronomePersonale("loro", persona, numero, genere);
			}
		}
		return null;
	}

	private final Persona persona;
	private final Numero numero;
	private final Genere genere;

	public PronomePersonale(String lemma, Persona persona, Numero numero, Genere genere) {
		super(lemma);
		this.persona = persona;
		this.numero = numero;
		this.genere = genere;
	}

	public Persona getPersona() {
		return persona;
	}

	public Numero getNumero() {
		return numero;
	}

	public Genere getGenere() {
		return genere;
	}

	@Override
	public String getForm(Object... selector) {
		return getLemma();
	}

	public String getCapitalizedForm() {
		return StringUtil.capitalizeFirst(getForm((Object) null));
	}

}

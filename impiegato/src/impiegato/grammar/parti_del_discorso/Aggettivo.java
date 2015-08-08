package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.FormSelector;

public class Aggettivo extends ParteDelDiscorso {

	public Aggettivo(String lemma) {
		super(lemma);
	}

	@Override
	public String getForm(Object... selector) {
		FormSelector fSel = new FormSelector(selector);
		String form = getLemma().substring(0, getLemma().length() - 1);
		switch (fSel.genere) {
		case FEMMINILE:
			switch (fSel.numero) {
			case PLURALE:
				return form + "e";
			case SINGOLARE:
				return form + "a";
			}
		case MASCHILE:
			switch (fSel.numero) {
			case PLURALE:
				return form + "i";
			case SINGOLARE:
				return form + "o";
			}
		default:
		}
		return null;
	}
}

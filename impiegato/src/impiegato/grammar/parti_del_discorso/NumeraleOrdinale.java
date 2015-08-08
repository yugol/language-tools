package impiegato.grammar.parti_del_discorso;

public class NumeraleOrdinale extends Numerale {

	static String getGeneralForm(String lemma) {
		switch (lemma) {
		case "1":
			return "primo";
		case "2":
			return "secondo";
		case "3":
			return "terzo";
		case "4":
			return "quarto";
		case "5":
			return "quinto";
		case "6":
			return "sesto";
		case "7":
			return "settimo";
		case "8":
			return "ottavo";
		case "9":
			return "nono";
		case "10":
			return "decimo";
		}
		String cardinalForm = NumeraleCardinale.getGeneralForm(lemma);
		if (!cardinalForm.endsWith("sei")) {
			cardinalForm = cardinalForm.substring(0, cardinalForm.length() - 1);
		}
		if (cardinalForm.endsWith("mil")) {
			cardinalForm = cardinalForm + "l";
		}
		return cardinalForm + "esimo";
	}

	public NumeraleOrdinale(String lemma) {
		super(lemma);
	}

	public NumeraleOrdinale(int integer) {
		this(String.valueOf(integer));
	}

	@Override
	public String getForm(Object... selector) {
		String form = getGeneralForm(getLemma());
		return form;
	}

}

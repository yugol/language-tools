package impiegato.engine.tests.numerali;

import impiegato.engine.tests.TestItem;
import impiegato.grammar.parti_del_discorso.Numerale;
import impiegato.grammar.parti_del_discorso.NumeraleOrdinale;

public class NumeraleItem extends TestItem {

	private final Numerale numerale;

	public NumeraleItem(Numerale numerale) {
		this.numerale = numerale;
	}

	@Override
	public String getChallenge() {
		StringBuilder challenge = new StringBuilder(numerale.getLemma());
		if (numerale instanceof NumeraleOrdinale) {
			challenge.append("'");
		}
		challenge.append(": ");
		return challenge.toString();
	}

	@Override
	public String getCorrectAnswer() {
		return numerale.getForm();
	}

	@Override
	public String getKey() {
		return null;
	}
}

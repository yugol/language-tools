package impiegato.engine.tests.numerali;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import impiegato.engine.TestSpec;
import impiegato.engine.tests.TestData;
import impiegato.engine.tests.TestItem;
import impiegato.grammar.parti_del_discorso.Numerale;
import impiegato.grammar.parti_del_discorso.NumeraleCardinale;
import impiegato.grammar.parti_del_discorso.NumeraleOrdinale;

public class NumeraliTestData extends TestData {

	private final Random rand = new Random();

	public NumeraliTestData(TestSpec testSpec) {
		super(testSpec);
	}

	@Override
	protected TestItem processRecord(String record, List<TestItem> items) {
		return null;
	}

	@Override
	public void loadItems() throws IOException {
	}

	@Override
	public void saveResults() throws IOException {
	}

	@Override
	public void updateRelevances() {
	}

	@Override
	public TestItem sampleItem() {
		int digitCount = rand.nextInt(3) + 1;
		int max = (int) Math.pow(10, digitCount);
		int lemma = rand.nextInt(max);
		Numerale numerale;
		if (rand.nextBoolean() && rand.nextBoolean()) {
			numerale = new NumeraleOrdinale(lemma);
		} else {
			numerale = new NumeraleCardinale(lemma);
		}
		return new NumeraleItem(numerale);
	}
}

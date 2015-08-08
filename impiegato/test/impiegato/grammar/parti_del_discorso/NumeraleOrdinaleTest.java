package impiegato.grammar.parti_del_discorso;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class NumeraleOrdinaleTest {

	@Test
	public void testGetGeneralForm() {
		assertEquals("zeresimo", NumeraleOrdinale.getGeneralForm("0"));
		assertEquals("primo", NumeraleOrdinale.getGeneralForm("1"));
		assertEquals("secondo", NumeraleOrdinale.getGeneralForm("2"));
		assertEquals("terzo", NumeraleOrdinale.getGeneralForm("3"));
		assertEquals("quarto", NumeraleOrdinale.getGeneralForm("4"));
		assertEquals("quinto", NumeraleOrdinale.getGeneralForm("5"));
		assertEquals("sesto", NumeraleOrdinale.getGeneralForm("6"));
		assertEquals("settimo", NumeraleOrdinale.getGeneralForm("7"));
		assertEquals("ottavo", NumeraleOrdinale.getGeneralForm("8"));
		assertEquals("nono", NumeraleOrdinale.getGeneralForm("9"));
		assertEquals("decimo", NumeraleOrdinale.getGeneralForm("10"));
		assertEquals("undicesimo", NumeraleOrdinale.getGeneralForm("11"));
		assertEquals("dodicesimo", NumeraleOrdinale.getGeneralForm("12"));
		assertEquals("tredicesimo", NumeraleOrdinale.getGeneralForm("13"));
		assertEquals("quattordicesimo", NumeraleOrdinale.getGeneralForm("14"));
		assertEquals("quindicesimo", NumeraleOrdinale.getGeneralForm("15"));
		assertEquals("sedicesimo", NumeraleOrdinale.getGeneralForm("16"));
		assertEquals("diciassettesimo", NumeraleOrdinale.getGeneralForm("17"));
		assertEquals("diciottesimo", NumeraleOrdinale.getGeneralForm("18"));
		assertEquals("diciannovesimo", NumeraleOrdinale.getGeneralForm("19"));
		assertEquals("ventesimo", NumeraleOrdinale.getGeneralForm("20"));
		assertEquals("ventunesimo", NumeraleOrdinale.getGeneralForm("21"));
		assertEquals("ventiduesimo", NumeraleOrdinale.getGeneralForm("22"));
		assertEquals("ventitreesimo", NumeraleOrdinale.getGeneralForm("23"));
		assertEquals("ventiquattresimo", NumeraleOrdinale.getGeneralForm("24"));
		assertEquals("venticinquesimo", NumeraleOrdinale.getGeneralForm("25"));
		assertEquals("ventiseiesimo", NumeraleOrdinale.getGeneralForm("26"));
		assertEquals("ventisettesimo", NumeraleOrdinale.getGeneralForm("27"));
		assertEquals("ventottesimo", NumeraleOrdinale.getGeneralForm("28"));
		assertEquals("ventinovesimo", NumeraleOrdinale.getGeneralForm("29"));
		assertEquals("trentesimo", NumeraleOrdinale.getGeneralForm("30"));
		assertEquals("quarantesimo", NumeraleOrdinale.getGeneralForm("40"));
		assertEquals("cinquantesimo", NumeraleOrdinale.getGeneralForm("50"));
		assertEquals("sessantesimo", NumeraleOrdinale.getGeneralForm("60"));
		assertEquals("settantesimo", NumeraleOrdinale.getGeneralForm("70"));
		assertEquals("ottantesimo", NumeraleOrdinale.getGeneralForm("80"));
		assertEquals("novantesimo", NumeraleOrdinale.getGeneralForm("90"));
		assertEquals("centesimo", NumeraleOrdinale.getGeneralForm("100"));
		assertEquals("centounesimo", NumeraleOrdinale.getGeneralForm("101"));
		assertEquals("centoduesimo", NumeraleOrdinale.getGeneralForm("102"));
		assertEquals("duecentesimo", NumeraleOrdinale.getGeneralForm("200"));
		assertEquals("trecentesimo", NumeraleOrdinale.getGeneralForm("300"));
		assertEquals("quattrocentesimo", NumeraleOrdinale.getGeneralForm("400"));
		assertEquals("quattrocentocinquantaseiesimo", NumeraleOrdinale.getGeneralForm("456"));
		assertEquals("cinquecentesimo", NumeraleOrdinale.getGeneralForm("500"));
		assertEquals("seicentesimo", NumeraleOrdinale.getGeneralForm("600"));
		assertEquals("settecentesimo", NumeraleOrdinale.getGeneralForm("700"));
		assertEquals("ottocentesimo", NumeraleOrdinale.getGeneralForm("800"));
		assertEquals("novecentesimo", NumeraleOrdinale.getGeneralForm("900"));
		assertEquals("millesimo", NumeraleOrdinale.getGeneralForm("1000"));
		assertEquals("duemillesimo", NumeraleOrdinale.getGeneralForm("2000"));
		assertEquals("milionesimo", NumeraleOrdinale.getGeneralForm("1000000"));
	}

	@Test
	public void testGetGeneralForm_randomness() {
		Random rand = new Random();
		for (int i = 1; i <= 10; ++i) {
			int max = (int) Math.pow(10, i);
			if (i >= 10) {
				max = Integer.MAX_VALUE;
			}
			Numerale num = new NumeraleOrdinale(rand.nextInt(max));
			System.out.println(num.getLemma() + " -> " + num.getForm());
		}
	}

}

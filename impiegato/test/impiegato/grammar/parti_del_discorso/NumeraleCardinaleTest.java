package impiegato.grammar.parti_del_discorso;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class NumeraleCardinaleTest {

	@Test
	public void testGetGeneralForm() {
		assertEquals("quindici", NumeraleCardinale.getGeneralForm("15"));
		assertEquals("ventidue", NumeraleCardinale.getGeneralForm("22"));
		assertEquals("cinquantotto", NumeraleCardinale.getGeneralForm("58"));
		assertEquals("settantatre'", NumeraleCardinale.getGeneralForm("73"));
		assertEquals("trentasei", NumeraleCardinale.getGeneralForm("36"));
		assertEquals("novantaquattro", NumeraleCardinale.getGeneralForm("94"));
		assertEquals("quaranta", NumeraleCardinale.getGeneralForm("40"));
		assertEquals("sessantasette", NumeraleCardinale.getGeneralForm("67"));
		assertEquals("ottantuno", NumeraleCardinale.getGeneralForm("81"));
		assertEquals("cinquantasei", NumeraleCardinale.getGeneralForm("56"));
		assertEquals("trentaquattro", NumeraleCardinale.getGeneralForm("34"));
		assertEquals("ventisette", NumeraleCardinale.getGeneralForm("27"));

		assertEquals("cento", NumeraleCardinale.getGeneralForm("100"));
		assertEquals("duecento", NumeraleCardinale.getGeneralForm("200"));
		assertEquals("duecentoquarantasei", NumeraleCardinale.getGeneralForm("246"));
		assertEquals("trecento", NumeraleCardinale.getGeneralForm("300"));
		assertEquals("trecentocinquantasette", NumeraleCardinale.getGeneralForm("357"));
		assertEquals("quattrocentoottantatre'", NumeraleCardinale.getGeneralForm("483"));
		assertEquals("cinquecentoquattro", NumeraleCardinale.getGeneralForm("504"));
		assertEquals("seicentonovantuno", NumeraleCardinale.getGeneralForm("691"));
		assertEquals("settecentosessantadue", NumeraleCardinale.getGeneralForm("762"));
		assertEquals("quattrocentododici", NumeraleCardinale.getGeneralForm("412"));
		assertEquals("novecentosettantotto", NumeraleCardinale.getGeneralForm("978"));
		assertEquals("seicentosette", NumeraleCardinale.getGeneralForm("607"));
		assertEquals("ottocentocinquantasei", NumeraleCardinale.getGeneralForm("856"));

		assertEquals("mille", NumeraleCardinale.getGeneralForm("1000"));
		assertEquals("millequattrocentosettantatre'", NumeraleCardinale.getGeneralForm("1473"));
		assertEquals("millenovecentonovanta", NumeraleCardinale.getGeneralForm("1990"));
		assertEquals("duemila", NumeraleCardinale.getGeneralForm("2000"));
		assertEquals("tremilacinquecentotrentanove", NumeraleCardinale.getGeneralForm("3539"));
		assertEquals("quattromilasettecentoventicinque", NumeraleCardinale.getGeneralForm("4725"));
		assertEquals("seimilaquattrocentocinquantotto", NumeraleCardinale.getGeneralForm("6458"));
		assertEquals("settemilaottocentosessantaquattro", NumeraleCardinale.getGeneralForm("7864"));
		assertEquals("ottomilaquattrocentoundici", NumeraleCardinale.getGeneralForm("8411"));
		assertEquals("novemilasettecentocinquantotto", NumeraleCardinale.getGeneralForm("9758"));

		assertEquals("diecimilacinquecento", NumeraleCardinale.getGeneralForm("10500"));
		assertEquals("cinquecentocinquemila", NumeraleCardinale.getGeneralForm("505000"));
		assertEquals("milione", NumeraleCardinale.getGeneralForm("1000000"));
		assertEquals("quattromilionitrecentomila", NumeraleCardinale.getGeneralForm("4300000"));

	}

	@Test
	public void testGetGeneralForm_randomness() {
		Random rand = new Random();
		for (int i = 1; i <= 10; ++i) {
			int max = (int) Math.pow(10, i);
			if (i >= 10) {
				max = Integer.MAX_VALUE;
			}
			Numerale num = new NumeraleCardinale(rand.nextInt(max));
			System.out.println(num.getLemma() + " -> " + num.getForm());
		}
	}

}

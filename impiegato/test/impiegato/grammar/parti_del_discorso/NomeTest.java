package impiegato.grammar.parti_del_discorso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import impiegato.grammar.determinazioni.Genere;

public class NomeTest {

	// @Test
	public void testIdentifyGenere() {
		fail("Not yet implemented");
	}

	@Test
	public void testIdentifyPlurale() {
		assertEquals("alberghi", Nome.identifyPlurale("albergo", null, null));
		assertEquals("amici", Nome.identifyPlurale("amico", null, "amici"));
		assertEquals("ananas", Nome.identifyPlurale("ananas", null, null));
		assertEquals("armadi", Nome.identifyPlurale("armadio", null, null));
		assertEquals("amiche", Nome.identifyPlurale("amica", null, null));
		assertEquals("arance", Nome.identifyPlurale("arancia", null, null));
		assertEquals("attivita`", Nome.identifyPlurale("attivita`", null, null));
		assertEquals("banche", Nome.identifyPlurale("banca", null, null));
		assertEquals("bugie", Nome.identifyPlurale("bugia", null, null));
		assertEquals("calzoni", Nome.identifyPlurale("calzone", null, null));
		assertEquals("camere", Nome.identifyPlurale("camera", null, null));
		assertEquals("cappuccini", Nome.identifyPlurale("cappuccino", null, null));
		assertEquals("ciliegie", Nome.identifyPlurale("ciliegia", null, null));
		assertEquals("citta`", Nome.identifyPlurale("citta`", null, null));
		assertEquals("conti", Nome.identifyPlurale("conto", null, null));
		assertEquals("coperte", Nome.identifyPlurale("coperta", null, null));
		assertEquals("docce", Nome.identifyPlurale("doccia", null, null));
		assertEquals("formaggi", Nome.identifyPlurale("formaggio", null, null));
		assertEquals("giardini", Nome.identifyPlurale("giardino", null, null));
		assertEquals("grechi", Nome.identifyPlurale("greco", null, null));
		assertEquals("idee", Nome.identifyPlurale("idea", null, null));
		assertEquals("impiegate", Nome.identifyPlurale("impiegata", null, null));
		assertEquals("interfacce", Nome.identifyPlurale("interfaccia", null, null));
		assertEquals("lavatrici", Nome.identifyPlurale("lavatrice", null, null));
		assertEquals("librerie", Nome.identifyPlurale("libreria", null, null));
		assertEquals("mance", Nome.identifyPlurale("mancia", null, null));
		assertEquals("mille", Nome.identifyPlurale("milla", null, null));
		assertEquals("possibilita`", Nome.identifyPlurale("possibilita`", null, null));
		assertEquals("qualita`", Nome.identifyPlurale("qualita`", null, null));
		assertEquals("specchi", Nome.identifyPlurale("specchio", null, null));
		assertEquals("spiagge", Nome.identifyPlurale("spiaggia", null, null));
		assertEquals("studi", Nome.identifyPlurale("studio", null, null));
		assertEquals("succhi", Nome.identifyPlurale("succo", null, null));
		assertEquals("televisioni", Nome.identifyPlurale("televisione", null, null));
		assertEquals("lampade", Nome.identifyPlurale("lampada", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));
		assertEquals("", Nome.identifyPlurale("", null, null));

		assertEquals("artisti", Nome.identifyPlurale("artista", Genere.MASCHILE, null));
		assertEquals("colleghi", Nome.identifyPlurale("collega", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.MASCHILE, null));

		assertEquals("auto", Nome.identifyPlurale("auto", Genere.FEMMINILE, null));
		assertEquals("canzoni", Nome.identifyPlurale("canzone", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
		assertEquals("", Nome.identifyPlurale("", Genere.FEMMINILE, null));
	}

}

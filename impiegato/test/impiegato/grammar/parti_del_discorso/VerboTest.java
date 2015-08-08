package impiegato.grammar.parti_del_discorso;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import impiegato.grammar.Ausiliare;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;

public class VerboTest {

	@Test
	public void testIndicativoPresente() {
		Verbo verbo = new Verbo("cantare");
		assertEquals("canto", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("canti", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("canta", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("cantiamo", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA));
		assertEquals("cantate", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA));
		assertEquals("cantano", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA));

		verbo = new Verbo("correre");
		assertEquals("corro", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("corri", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("corre", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("corriamo", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA));
		assertEquals("correte", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA));
		assertEquals("corrono", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA));

		verbo = new Verbo("scoprire");
		assertEquals("scopro", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("scopri", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("scopre", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("scopriamo", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA));
		assertEquals("scoprite", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA));
		assertEquals("scoprono", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA));

		verbo = new Verbo("capire");
		verbo.setIncoativo(true);
		assertEquals("capisco", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("capisci", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("capisce", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("capiamo", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA));
		assertEquals("capite", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA));
		assertEquals("capiscono", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA));

		verbo = new Verbo("cercare");
		assertEquals("cerco", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("cerchi", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("cerca", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("cerchiamo", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA));
		assertEquals("cercate", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA));
		assertEquals("cercano", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA));

		verbo = new Verbo("pagare");
		assertEquals("pago", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("paghi", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("paga", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("paghiamo", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA));
		assertEquals("pagate", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA));
		assertEquals("pagano", verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA));
	}

	@Test
	public void testParticipioPassato() {
		Verbo verbo = new Verbo("parlare");
		assertEquals("parlato", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO));

		verbo = new Verbo("credere");
		assertEquals("creduto", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO));

		verbo = new Verbo("partire");
		assertEquals("partito", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO));

		verbo = new Verbo("piacere");
		verbo.setForm("piaciuto", Modo.PARTICIPIO, Tempo.PASSATO);
		assertEquals("piaciuto", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO));

		verbo = new Verbo("svegliare");
		assertEquals("svegliato", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO));
		assertEquals("svegliato", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO, Numero.SINGOLARE, Genere.MASCHILE));
		assertEquals("svegliata", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO, Numero.SINGOLARE, Genere.FEMMINILE));
		assertEquals("svegliati", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO, Numero.PLURALE, Genere.MASCHILE));
		assertEquals("svegliate", verbo.getForm(Modo.PARTICIPIO, Tempo.PASSATO, Numero.PLURALE, Genere.FEMMINILE));
	}

	@Test
	public void testIndicativoPassatoProssimo() {
		Verbo verbo = new Verbo("sbagliare");
		assertEquals("ho sbagliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("hai sbagliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("ha sbagliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("abbiamo sbagliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.PRIMA));
		assertEquals("avete sbagliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.SECONDA));
		assertEquals("hanno sbagliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.TERZA));

		verbo = new Verbo("andare");
		verbo.setAusiliare(Ausiliare.ESSERE);
		assertEquals("sono andato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("sei andato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("e` andato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("siamo andati", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.PRIMA));
		assertEquals("siete andati", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.SECONDA));
		assertEquals("sono andati", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.TERZA));

		assertEquals("sono andata", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.PRIMA, Genere.FEMMINILE));
		assertEquals("sei andata", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.SECONDA, Genere.FEMMINILE));
		assertEquals("e` andata", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.TERZA, Genere.FEMMINILE));
		assertEquals("siamo andate", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.PRIMA, Genere.FEMMINILE));
		assertEquals("siete andate", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.SECONDA, Genere.FEMMINILE));
		assertEquals("sono andate", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.TERZA, Genere.FEMMINILE));

		verbo = new Verbo("svegliarsi");
		assertEquals("mi sono svegliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.PRIMA));
		assertEquals("ti sei svegliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.SECONDA));
		assertEquals("si e` svegliato", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.TERZA));
		assertEquals("ci siamo svegliati", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.PRIMA));
		assertEquals("vi siete svegliati", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.SECONDA));
		assertEquals("si sono svegliati", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.TERZA));

		assertEquals("mi sono svegliata", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.PRIMA, Genere.FEMMINILE));
		assertEquals("ti sei svegliata", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.SECONDA, Genere.FEMMINILE));
		assertEquals("si e` svegliata", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.SINGOLARE, Persona.TERZA, Genere.FEMMINILE));
		assertEquals("ci siamo svegliate", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.PRIMA, Genere.FEMMINILE));
		assertEquals("vi siete svegliate", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.SECONDA, Genere.FEMMINILE));
		assertEquals("si sono svegliate", verbo.getForm(Modo.INDICATIVO, Tempo.PASSATO_PROSSIMO, Numero.PLURALE, Persona.TERZA, Genere.FEMMINILE));
	}
}

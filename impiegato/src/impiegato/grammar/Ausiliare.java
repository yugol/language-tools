package impiegato.grammar;

import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.grammar.parti_del_discorso.Verbo;

public enum Ausiliare {

	AVERE("avere"), ESSERE("essere");

	public final Verbo verbo;

	private Ausiliare(String lemma) {
		verbo = new Verbo(lemma);
		switch (lemma) {
		case "avere":
			verbo.setForm("ho", Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA);
			verbo.setForm("hai", Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA);
			verbo.setForm("ha", Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA);
			verbo.setForm("abbiamo", Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA);
			verbo.setForm("avete", Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA);
			verbo.setForm("hanno", Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA);
			break;
		case "essere":
			verbo.setForm("sono", Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.PRIMA);
			verbo.setForm("sei", Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.SECONDA);
			verbo.setForm("e`", Modo.INDICATIVO, Tempo.PRESENTE, Numero.SINGOLARE, Persona.TERZA);
			verbo.setForm("siamo", Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.PRIMA);
			verbo.setForm("siete", Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.SECONDA);
			verbo.setForm("sono", Modo.INDICATIVO, Tempo.PRESENTE, Numero.PLURALE, Persona.TERZA);
			break;
		default:
			break;
		}
	}

}

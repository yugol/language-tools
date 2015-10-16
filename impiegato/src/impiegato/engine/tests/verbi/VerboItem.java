package impiegato.engine.tests.verbi;

import impiegato.engine.TestItem;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.grammar.parti_del_discorso.PronomePersonale;
import impiegato.grammar.parti_del_discorso.Verbo;

public class VerboItem extends TestItem {

	private final Verbo parent;
	private final Modo modo;
	private final Tempo tempo;
	private final Persona persona;
	private final Numero numero;

	public VerboItem(Verbo parent, Modo modo, Tempo tempo, Persona persona, Numero numero) {
		this.parent = parent;
		this.modo = modo;
		this.tempo = tempo;
		this.persona = persona;
		this.numero = numero;
	}

	@Override
	public String getChallenge() {
		StringBuilder challenge = new StringBuilder();
		challenge.append("(").append(modo.toString().toLowerCase()).append(".").append(tempo.toString().toLowerCase()).append(") ");
		challenge.append(PronomePersonale.get(persona, numero, Genere.values()[RANDOMIZER.nextInt(Genere.values().length)]).getCapitalizedForm());
		challenge.append(" [").append(parent.getLemma()).append("]: ");
		return challenge.toString();
	}

	@Override
	public String getCorrectAnswer() {
		parent.setModo(modo);
		parent.setTempo(tempo);
		parent.setPersona(persona);
		parent.setNumero(numero);
		return parent.getForm((Object) null);
	}

	@Override
	public String getKey() {
		StringBuilder key = new StringBuilder(parent.getLemma());
		key.append(".").append(modo).append(".").append(tempo).append(".").append(persona).append(".").append(numero);
		return key.toString();
	}
}

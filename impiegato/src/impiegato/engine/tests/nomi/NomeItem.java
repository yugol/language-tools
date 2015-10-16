package impiegato.engine.tests.nomi;

import impiegato.engine.TestItem;
import impiegato.grammar.Arto;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.parti_del_discorso.Nome;

public class NomeItem extends TestItem {

	private final Nome parent;
	private final Numero numero;
	private final Arto arto;

	public NomeItem(Nome parent, Numero numero, Arto arto) {
		this.parent = parent;
		this.numero = numero;
		this.arto = arto;
	}

	@Override
	public String getChallenge() {
		StringBuilder challenge = new StringBuilder();
		String cardinality = numero == Numero.SINGOLARE ? "1" : "n";
		if (arto == Arto.INDETERMINATIVO) {
			challenge.append(cardinality).append(" ");
		}
		challenge.append("[").append(parent.getLemma()).append("]");
		if (arto == Arto.DETERMINATIVO) {
			challenge.append(" ").append(cardinality);
		}
		challenge.append(": ");
		return challenge.toString();
	}

	@Override
	public String getCorrectAnswer() {
		parent.setNumero(numero);
		String nomeForm = parent.getForm();
		String articoloForm = arto.getArticolo(parent.getGenere(), numero, nomeForm).getForm();
		if (articoloForm.endsWith("'")) {
			return articoloForm + nomeForm;
		}
		return articoloForm + " " + nomeForm;
	}

	@Override
	public String getKey() {
		StringBuilder key = new StringBuilder(parent.getLemma());
		key.append(".").append(arto).append(".").append(numero);
		return key.toString();
	}

}

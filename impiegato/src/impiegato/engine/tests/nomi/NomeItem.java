package impiegato.engine.tests.nomi;

import impiegato.engine.TestItem;
import impiegato.grammar.Arto;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.parti_del_discorso.Nome;
import impiegato.util.StringUtil;

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
        challenge.append(StringUtil.capitalizeFirst(arto.toString())).append(" ");
        challenge.append(numero.toString().toLowerCase()).append(" [");
        challenge.append(parent.getLemma()).append("]: ");
        return challenge.toString();
    }

    @Override
    public String getCorrectAnswer() {
        parent.setNumero(numero);
        String nomeForm = parent.getForm(null);
        String articoloForm = arto.getArticolo(parent.getGenere(), numero, nomeForm).getForm(null);
        if (articoloForm.endsWith("'")) {
            return articoloForm + nomeForm;
        }
        return articoloForm + " " + nomeForm;
    }

    @Override
    public String getKey() {
        StringBuilder key = new StringBuilder(NomeItem.class.getSimpleName());
        key.append(".").append(arto);
        key.append(".").append(numero);
        key.append(".").append(parent.getLemma());
        return key.toString();
    }

}

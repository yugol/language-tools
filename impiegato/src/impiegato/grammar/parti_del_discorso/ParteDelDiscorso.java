package impiegato.grammar.parti_del_discorso;

public abstract class ParteDelDiscorso {

    private final String lemma;

    protected ParteDelDiscorso(String lemma) {
        this.lemma = lemma;
    }

    public String getLemma() {
        return lemma;
    }

    public abstract String getForm(Object... selector);

}

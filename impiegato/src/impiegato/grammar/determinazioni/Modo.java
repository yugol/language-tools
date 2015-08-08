package impiegato.grammar.determinazioni;

public enum Modo {

    INDICATIVO(true),
    CONGIUNTIVO(true),
    CONDIZIONALE(true),
    INPERATIVO(true),

    INFINITO(false),
    PARTICIPIO(false),
    GERUNDIO(false);

    public final boolean finito;

    private Modo(boolean finito) {
        this.finito = finito;
    }

}

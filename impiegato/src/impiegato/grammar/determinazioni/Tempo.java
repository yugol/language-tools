package impiegato.grammar.determinazioni;

public enum Tempo {

    PRESENTE(0),

    IMPERFETTO(-1),
    PASSATO_PROSSIMO(-1),
    PASSATO_REMOTO(-1),
    TRAPASSATO_PROSSIMO(-1),
    TRAPASSATO_REMOTO(-1),

    FUTURO_SEMPLICE(1),
    FUTURO_ANTERIORE(1);

    public final int tempo;

    private Tempo(int tempo) {
        this.tempo = tempo;
    }

}

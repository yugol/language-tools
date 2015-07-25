package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.determinazioni.Conseguente;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Numero;

public abstract class Articolo extends ParteDelDiscorso {

    private Genere genere;
    private Numero numero;
    private Conseguente conseguente;

    public Articolo(Genere genere, Numero numero, Conseguente conseguente) {
        super(null);
        this.genere = genere;
        this.numero = numero;
        this.conseguente = conseguente;
    }

    public Genere getGenere() {
        return genere;
    }

    public Numero getNumero() {
        return numero;
    }

    public Conseguente getConseguente() {
        return conseguente;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public void setConseguente(Conseguente conseguente) {
        this.conseguente = conseguente;
    }

}

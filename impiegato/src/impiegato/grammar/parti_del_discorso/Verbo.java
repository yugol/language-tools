package impiegato.grammar.parti_del_discorso;

import impiegato.grammar.Ausiliare;
import impiegato.grammar.Coniugazione;
import impiegato.grammar.FormSelector;
import impiegato.grammar.determinazioni.Genere;
import impiegato.grammar.determinazioni.Modo;
import impiegato.grammar.determinazioni.Numero;
import impiegato.grammar.determinazioni.Persona;
import impiegato.grammar.determinazioni.Tempo;
import impiegato.util.StringUtil;
import java.util.EnumMap;
import java.util.Map;

public class Verbo extends ParteDelDiscorso {

    private final FormSelector defaultSelector = new FormSelector();
    private final Map<Modo, Map<Tempo, Map<Persona, Map<Numero, String>>>> forms = new EnumMap<>(Modo.class);
    private final boolean riflessivo;
    private boolean incoativo;
    private Ausiliare ausiliare;
    private String participioPassato;

    public Verbo(String lemma) {
        super(lemma.endsWith("si") ? lemma.substring(0, lemma.length() - 2) + "e" : lemma);
        riflessivo = lemma.endsWith("si");
        ausiliare = riflessivo ? Ausiliare.ESSERE : Ausiliare.AVERE;
    }

    public Ausiliare getAusiliare() {
        return ausiliare;
    }

    @Override
    public String getForm(Object... selector) {
        String form = null;
        FormSelector fSel = new FormSelector(selector).merge(defaultSelector);
        try {
            form = forms.get(fSel.modo).get(fSel.tempo).get(fSel.persona).get(fSel.numero);
        } catch (NullPointerException e) {
        }
        if (StringUtil.isNullOrBlank(form)) {
            form = calculateForm(fSel);
        }
        return form;
    }

    public Modo getModo() {
        return defaultSelector.modo;
    }

    public Numero getNumero() {
        return defaultSelector.numero;
    }

    public Persona getPersona() {
        return defaultSelector.persona;
    }

    public Tempo getTempo() {
        return defaultSelector.tempo;
    }

    public boolean isIncoativo() {
        return incoativo;
    }

    public boolean isRiflessivo() {
        return riflessivo;
    }

    public void setAusiliare(Ausiliare ausiliare) {
        this.ausiliare = ausiliare;
    }

    public void setForm(String form, Object... selector) {
        FormSelector fSel = new FormSelector(selector).merge(defaultSelector);
        if (fSel.modo == Modo.PARTICIPIO && fSel.tempo == Tempo.PASSATO) {
            participioPassato = form;
        } else {
            Map<Tempo, Map<Persona, Map<Numero, String>>> tempi = forms.get(fSel.modo);
            if (tempi == null) {
                tempi = new EnumMap<>(Tempo.class);
                forms.put(fSel.modo, tempi);
            }
            Map<Persona, Map<Numero, String>> persone = tempi.get(fSel.tempo);
            if (persone == null) {
                persone = new EnumMap<>(Persona.class);
                tempi.put(fSel.tempo, persone);
            }
            Map<Numero, String> numeri = persone.get(fSel.persona);
            if (numeri == null) {
                numeri = new EnumMap<>(Numero.class);
                persone.put(fSel.persona, numeri);
            }
            numeri.put(fSel.numero, form);
        }
    }

    public void setIncoativo(boolean incoativo) {
        this.incoativo = incoativo && getLemma().endsWith("ire");
    }

    public void setModo(Modo modo) {
        defaultSelector.modo = modo;
    }

    public void setNumero(Numero numero) {
        defaultSelector.numero = numero;
    }

    public void setPersona(Persona persona) {
        defaultSelector.persona = persona;
    }

    public void setTempo(Tempo tempo) {
        defaultSelector.tempo = tempo;
    }

    private String calculateForm(FormSelector fSel) {
        String root = getRoot();
        Coniugazione group = Coniugazione.fromLemma(getLemma());
        if (fSel.modo == Modo.INDICATIVO) {
            if (fSel.tempo == Tempo.PRESENTE) {
                return calculateIndicativoPresenteForm(fSel, root, group);
            } else if (fSel.tempo == Tempo.PASSATO_PROSSIMO) {
                return calculateIndicativoPassatoProssimoForm(fSel, root, group);
            }
        } else if (fSel.modo == Modo.PARTICIPIO) {
            if (fSel.tempo == Tempo.PASSATO) {
                return calculateParticipioPassatoForm(fSel, root, group);
            }
        }
        return null;
    }

    private String calculateIndicativoPassatoProssimoForm(FormSelector fSel, String root, Coniugazione group) {
        StringBuilder form = new StringBuilder(ausiliare.verbo.getForm(Modo.INDICATIVO, Tempo.PRESENTE, fSel.numero, fSel.persona));
        form.append(" ");
        if (ausiliare == Ausiliare.AVERE) {
            form.append(getForm(Modo.PARTICIPIO, Tempo.PASSATO));
        }
        if (ausiliare == Ausiliare.ESSERE) {
            if (fSel.genere == null) {
                fSel.genere = Genere.MASCHILE;
            }
            form.append(getForm(Modo.PARTICIPIO, Tempo.PASSATO, fSel.numero, fSel.genere));
            if (isRiflessivo()) {
                form.insert(0, " ");
                PronomeRiflessivo pr = new PronomeRiflessivo(fSel.persona, fSel.numero);
                form.insert(0, pr.getForm());
            }
        }
        return form.toString();
    }

    private String calculateIndicativoPresenteForm(FormSelector fSel, String root, Coniugazione group) {
        switch (group) {
            case PRIMA:
                switch (fSel.numero) {
                    case SINGOLARE:
                        switch (fSel.persona) {
                            case PRIMA:
                                return root + "o";
                            case SECONDA:
                                if (root.endsWith("c") || root.endsWith("g")) {
                                    root += "h";
                                }
                                return root + "i";
                            case TERZA:
                                return root + "a";
                        }
                    case PLURALE:
                        switch (fSel.persona) {
                            case PRIMA:
                                if (root.endsWith("c") || root.endsWith("g")) {
                                    root += "h";
                                }
                                return root + "iamo";
                            case SECONDA:
                                return root + "ate";
                            case TERZA:
                                return root + "ano";
                        }
                }
            case SECONDA:
                switch (fSel.numero) {
                    case SINGOLARE:
                        switch (fSel.persona) {
                            case PRIMA:
                                return root + "o";
                            case SECONDA:
                                return root + "i";
                            case TERZA:
                                return root + "e";
                        }
                    case PLURALE:
                        switch (fSel.persona) {
                            case PRIMA:
                                return root + "iamo";
                            case SECONDA:
                                return root + "ete";
                            case TERZA:
                                return root + "ono";
                        }
                }
            case TERZA:
                switch (fSel.numero) {
                    case SINGOLARE:
                        switch (fSel.persona) {
                            case PRIMA:
                                return root + (incoativo ? "isco" : "o");
                            case SECONDA:
                                return root + (incoativo ? "isci" : "i");
                            case TERZA:
                                return root + (incoativo ? "isce" : "e");
                        }
                    case PLURALE:
                        switch (fSel.persona) {
                            case PRIMA:
                                return root + "iamo";
                            case SECONDA:
                                return root + "ite";
                            case TERZA:
                                return root + (incoativo ? "iscono" : "ono");
                        }
                }
        }
        return null;
    }

    private String calculateParticipioPassatoForm(FormSelector fSel, String root, Coniugazione group) {
        if (StringUtil.isNullOrBlank(participioPassato)) {
            switch (group) {
                case PRIMA:
                    participioPassato = root + "ato";
                    break;
                case SECONDA:
                    participioPassato = root + "uto";
                    break;
                case TERZA:
                    participioPassato = root + "ito";
                    break;
            }
        }
        String form = participioPassato;
        if (fSel.genere != null && fSel.numero != null) {
            Aggettivo aggettivo = new Aggettivo(participioPassato);
            form = aggettivo.getForm(fSel);
        }
        return form;
    }

    private String getRoot() {
        return getLemma().substring(0, getLemma().length() - 3);
    }
}

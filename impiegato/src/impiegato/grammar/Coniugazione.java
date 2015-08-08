package impiegato.grammar;

import impiegato.util.StringUtil;

public enum Coniugazione {

	PRIMA("are"), SECONDA("ere"), TERZA("ire");

	public final String termination;

	private Coniugazione(String termination) {
		this.termination = termination;
	}

	public static Coniugazione fromLemma(String lemma) {
		if (!StringUtil.isNullOrBlank(lemma)) {
			String termination = lemma.substring(lemma.length() - 3);
			for (Coniugazione cg : values()) {
				if (termination.equals(cg.termination)) {
					return cg;
				}
			}
		}
		return null;
	}
}

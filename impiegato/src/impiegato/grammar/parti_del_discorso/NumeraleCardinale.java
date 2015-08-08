package impiegato.grammar.parti_del_discorso;

import java.util.ArrayList;
import java.util.List;

import impiegato.util.StringUtil;

// fix millions
public class NumeraleCardinale extends Numerale {

	static String getGeneralForm(String lemma) {
		if (lemma.length() == 1) {
			return getOneDigitForm(lemma);
		}
		if (lemma.length() == 2) {
			return getTwoDigitForm(lemma);
		}
		if (lemma.length() == 3) {
			return getThreeDigitForm(lemma);
		}
		List<String> groups = new ArrayList<>();
		while (!lemma.isEmpty()) {
			if (lemma.length() > 3) {
				groups.add(getGeneralForm(lemma.substring(lemma.length() - 3)));
				lemma = lemma.substring(0, lemma.length() - 3);
			} else {
				groups.add(getGeneralForm(lemma));
				lemma = "";
			}
		}
		StringBuilder form = new StringBuilder(groups.get(0));
		String group = groups.get(1);
		if (group.isEmpty()) {
		} else if (group.equals("uno")) {
			form.insert(0, "mille");
		} else {
			form.insert(0, "mila");
			form.insert(0, group);
		}
		if (groups.size() > 2) {
			group = groups.get(2);
			if (group.equals("uno")) {
				form.insert(0, "milione");
			} else {
				form.insert(0, "milioni");
				form.insert(0, group);
			}
			if (groups.size() > 3) {
				group = groups.get(3);
				if (group.equals("uno")) {
					form.insert(0, "miliardo");
				} else {
					form.insert(0, "miliardi");
					form.insert(0, group);
				}
			}
		}
		return form.toString();
	}

	static String getOneDigitForm(String lemma) {
		switch (lemma) {
		case "0":
			return "zero";
		case "1":
			return "uno";
		case "2":
			return "due";
		case "3":
			return "tre";
		case "4":
			return "quattro";
		case "5":
			return "cinque";
		case "6":
			return "sei";
		case "7":
			return "sette";
		case "8":
			return "otto";
		case "9":
			return "nove";
		}
		return null;
	}

	static String getTwoDigitForm(String lemma) {
		if (lemma.startsWith("0")) {
			return getOneDigitForm(lemma.substring(1));
		}
		switch (lemma) {
		case "10":
			return "dieci";
		case "11":
			return "undici";
		case "12":
			return "dodici";
		case "13":
			return "tredici";
		case "14":
			return "quattordici";
		case "15":
			return "quindici";
		case "16":
			return "sedici";
		case "17":
			return "diciassette";
		case "18":
			return "diciotto";
		case "19":
			return "diciannove";
		case "20":
			return "venti";
		case "30":
			return "trenta";
		case "40":
			return "quaranta";
		case "50":
			return "cinquanta";
		case "60":
			return "sessanta";
		case "70":
			return "settanta";
		case "80":
			return "ottanta";
		case "90":
			return "novanta";
		}
		String prefix = getTwoDigitForm(lemma.charAt(0) + "0");
		String suffix = getOneDigitForm(String.valueOf(lemma.charAt(1)));
		if (StringUtil.isVowel(suffix.charAt(0))) {
			prefix = prefix.substring(0, prefix.length() - 1);
		}
		String form = prefix + suffix;
		if (form.endsWith("tre")) {
			form = form + "'";
		}
		return form;
	}

	static String getThreeDigitForm(String lemma) {
		if ("000".equals(lemma)) {
			return "";
		}
		if (lemma.startsWith("0")) {
			return getTwoDigitForm(lemma.substring(1));
		}
		String prefix = getOneDigitForm(lemma.substring(0, 1));
		prefix = prefix.equals("uno") ? "cento" : prefix + "cento";
		String suffix = lemma.substring(1);
		if ("00".equals(suffix)) {
			suffix = "";
		} else {
			suffix = getTwoDigitForm(lemma.substring(1));
		}
		return prefix + suffix;
	}

	public NumeraleCardinale(String lemma) {
		super(lemma);
	}

	public NumeraleCardinale(int integer) {
		this(String.valueOf(integer));
	}

	@Override
	public String getForm(Object... selector) {
		String form = getGeneralForm(getLemma());
		form = form.replace("mille", "mille_");
		form = form.replace("milla", "mila_");
		form = form.replace("milione", "milione_");
		form = form.replace("milioni", "milioni_");
		form = form.replace("miliardo", "miliardo_");
		form = form.replace("miliardi", "miliardi_");
		return form;
	}

}

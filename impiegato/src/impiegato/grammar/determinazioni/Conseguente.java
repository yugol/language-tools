package impiegato.grammar.determinazioni;

import impiegato.util.StringUtil;

public enum Conseguente {

    CONSONANTE,
    S__Z_X_Y_PS_PN_GN,
    VOCALE;

    public static Conseguente classifyForm(String form) {
        form = form.trim().toLowerCase();
        char first = form.charAt(0);
        if (StringUtil.isVowel(first)) {
            return Conseguente.VOCALE;
        }
        if (first == 's' && form.length() >= 2) {
            char second = Character.toLowerCase(form.charAt(1));
            if (!StringUtil.isVowel(second)) {
                return Conseguente.S__Z_X_Y_PS_PN_GN;
            }
        }
        if (first == 'z' || first == 'x' || first == 'y') {
            return Conseguente.S__Z_X_Y_PS_PN_GN;
        }
        if (first == 'p' && form.length() >= 2) {
            char second = Character.toLowerCase(form.charAt(1));
            if (second == 's' || second == 'n') {
                return Conseguente.S__Z_X_Y_PS_PN_GN;
            }
        }
        if (first == 'g' && form.length() >= 2) {
            char second = Character.toLowerCase(form.charAt(1));
            if (second == 'n') {
                return Conseguente.S__Z_X_Y_PS_PN_GN;
            }
        }
        return Conseguente.CONSONANTE;
    }
}

package impiegato.grammar.determinazioni;

public enum Genere {

    MASCHILE,
    FEMMINILE,
    LEI;

    public static Genere fromString(String str) {
        if ("m".equalsIgnoreCase(str)) {
            return MASCHILE;
        }
        if ("f".equalsIgnoreCase(str)) {
            return FEMMINILE;
        }
        return null;
    }
}

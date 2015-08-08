package impiegato.util;

public class StringUtil {

    public static boolean isNullOrBlank(String str) {
        if (str == null) {
            return true;
        }
        str = str.trim();
        return str.isEmpty();
    }

    public static boolean isVowel(char first) {
        return first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' || first == 'à';
    }

    public static String capitalizeFirst(String str) {
        if (StringUtil.isNullOrBlank(str)) {
            return str;
        }
        str = str.toLowerCase();
        if (str.length() > 1) {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return String.valueOf(Character.toUpperCase(str.charAt(0)));
    }

}

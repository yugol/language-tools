package impiegato.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleWrapper {

    private final BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

    public void println(final String string) {
        System.out.println(string);
    }

    public void clear() {
        for (int i = 0; i < 2; ++i) {
            System.out.println();
        }
    }

    public String readln(final String cursor, final String defaultAnswer) throws IOException {
        // System.out.println(cursor);
        // String extra = "";
        System.out.print(cursor);
        if (System.console() != null) {
            int backCount = 0;
            for (int i = 0; i < cursor.length(); ++i) {
                if (cursor.charAt(i) > 127) {
                    ++backCount;
                    // extra += cursor.charAt(i);
                }
            }
            backCount >>= 1;
            for (int i = 0; i < backCount; ++i) {
                System.out.print("\b");
            }
            for (int i = 0; i < backCount; ++i) {
                System.out.print(" ");
            }
            for (int i = 0; i < backCount; ++i) {
                System.out.print("\b");
            }
            // System.out.print("_" + extra + "_" + backCount);
        }
        System.out.flush();
        String answer = cin.readLine();
        if (defaultAnswer != null && answer.isEmpty()) {
            answer = defaultAnswer;
        }
        return answer;
    }

    public void println() {
        System.out.println();
    }

    public void format(final String pattern, final Object... params) {
        System.out.format(pattern, params);
    }

}

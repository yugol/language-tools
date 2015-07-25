package impiegato.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class VocabolarioNormalizer {

    public static void main(String... args) throws IOException {
        final Set<String> keys = new HashSet<String>();
        new DataFileReader("items/vocabolario.items") {

            @Override
            protected void processRecord(String record) {
                String[] parts = record.split("=");
                String key = parts[0];
                String value = parts[1];
                if (!keys.add(key)) {
                    System.err.println(key);
                    System.exit(1);
                }
                if (record.indexOf("(a)=") >= 0) {
                    key = "a " + key.substring(0, key.length() - 4);
                }
                System.out.println(key + "=" + value);
            }
        }.process();
        System.out.println("Done.");
    }
}

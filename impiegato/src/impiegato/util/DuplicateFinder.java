package impiegato.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DuplicateFinder {

	public static void main(String... args) throws IOException {
		String[] resources = new String[] {
		        "items/nomi.items",
		        "items/vocabolario.items",
		        "items/espressioni.vocabolario.items",
		};

		for (String resource : resources) {
			System.out.println("Checking: " + resource);
			final Set<String> keys = new HashSet<String>();
			new DataFileReader(resource) {

				@Override
				protected void processRecord(String record) {
					String[] parts = record.split("=");
					parts = parts[0].split(",");
					String key = parts[0];
					// String value = parts[1];
					if (!keys.add(key)) {
						System.err.println(key);
						System.exit(1);
					}
					// System.out.println(key + "=" + value);
				}
			}.process();
		}

		System.out.println("Done checking for duplicates.");
	}
}

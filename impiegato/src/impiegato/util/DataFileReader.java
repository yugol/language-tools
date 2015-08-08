package impiegato.util;

import impiegato.Impiegato;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class DataFileReader {

    private final static String COMMENT = "#";

    private final File dataFile;

    public DataFileReader(String fileName) {
        this(new File(fileName));
    }

    public DataFileReader(File file) {
        dataFile = file;
    }

    public boolean process() throws IOException {
        if (dataFile.exists()) {
            if (Impiegato.DEBUG) {
                System.out.println("Reading: " + dataFile.getCanonicalPath());
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String line = null;
                while (null != (line = reader.readLine())) {
                    if (!StringUtil.isNullOrBlank(line)) {
                        if (!line.startsWith(COMMENT)) {
                            processRecord(line);
                        }
                    }
                }
                return true;
            }
        } else {
            System.err.println("Cannot find: " + dataFile.getCanonicalPath());
        }
        return false;
    }

    protected abstract void processRecord(String record);

}

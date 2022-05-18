package helpers;

import java.io.BufferedReader;
import java.io.IOException;

public class ReaderWorker {
    public static String read(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (String line = null; (line = reader.readLine()) != null;) {
            sb.append(line);
        }

        return sb.toString();
    }
}

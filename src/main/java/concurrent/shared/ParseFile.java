package concurrent.shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;

public final class ParseFile {
    private final File file;

    public ParseFile(File file) {
        this.file = file;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        return content(data -> true);
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        return content(data -> data < 0x80);
    }

    private synchronized String content(Predicate<Integer> predicate) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            int rsl;
            while ((rsl = in.read()) > 0) {
                if (predicate.test(rsl)) {
                    sb.append(rsl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

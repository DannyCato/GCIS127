package unit10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * A class tha mimics the behavior of files in Python.
 * 
 * @author GCCIS Faculty
 */
public class FileLineReader implements Iterable<String> {
    /**
     * The path to the file to read.
     */
    private final String path;

    /**
     * Creates a new FileLineReader that will read from the specified file.
     * 
     * @param path The path to the file.
     */
    private FileLineReader(String path) {
        this.path = path;
    }

    /**
     * Static method that can be imported to create file readers, e.g.:
     * 
     * import static FileLineReader.open;
     * 
     * for(String line : open("path/to/file.txt")) {
     *   ...
     * }
     * 
     * @param path The path to the file to open.
     * 
     * @return An iterable that can be used to iterate through the lines in the
     * file.
     */
    public static Iterable<String> open(String path) {
        return new FileLineReader(path);
    }

    @Override
    public Iterator<String> iterator() {
        try {
            return new FileIterator(path);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file: " + path);
        }
    }

    /**
     * An iterator that iterates through lines in a text file.
     */
    private static class FileIterator implements Iterator<String> {
        /**
         * The file reader used to read the file.
         */
        private final FileReader fReader;

        /**
         * The buffered reader that reads one line at a time.
         */
        private final BufferedReader reader;

        /**
         * The next line in the file.
         */
        private String next;

        /**
         * Creates a new file iterator to iterate through the lines in the
         * specified file.
         * 
         * @param path The path to the file.
         * @throws IOException If the file cannot be accessed.
         */
        private FileIterator(String path) throws IOException {
            this.fReader = new FileReader(path);
            this.reader = new BufferedReader(fReader);
            this.next = reader.readLine();
        }


        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String next() {
            String line = this.next;

            try {
                this.next = reader.readLine();
            } catch (IOException e) {
                this.next = null;
            }

            return line;
        }
    }
}

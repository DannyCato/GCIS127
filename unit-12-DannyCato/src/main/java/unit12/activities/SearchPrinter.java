package unit12.activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SearchPrinter {
    @SuppressWarnings("all")
    public static void main(String[] args) throws IOException {
        URL google = new URL("https://www.google.com");
        URLConnection connection = google.openConnection();
        connection.connect();

        InputStream in = connection.getInputStream();
        Scanner sc = new Scanner(in);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}

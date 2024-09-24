package unit12.activities;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
    public static void main(String[] args) throws IOException {
        try {
            Socket sock = new Socket("www.google.com",80);
            sock.close();
        } catch (UnknownHostException uhe) {}

        try {
            Socket sock = new Socket("www.npr.com",443);
            sock.close();
        } catch (UnknownHostException uhe) {}

        try {
            Socket sock = new Socket("swec-123.rit.edu",33705);
            sock.close();
        } catch (UnknownHostException uhe) {}
    }
}

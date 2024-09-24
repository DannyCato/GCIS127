package unit13.practicum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Duplexer {
    private Socket socket;
    private BufferedReader netIn;
    private PrintWriter netOut;

    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;
        InputStream is = socket.getInputStream();
        netIn = new BufferedReader(new InputStreamReader(is));
        netOut = new PrintWriter(socket.getOutputStream());
    }

    public void send(String msg) {
        netOut.println(msg);
        netOut.flush();
    }

    public String read() throws IOException {
        return netIn.readLine();
    }

    public void close() throws IOException {
        socket.close();
        netIn.close();
        netOut.close();
    }

}

package unit12.duplexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Duplexer {
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    
    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.printWriter = new PrintWriter(socket.getOutputStream());
    }

    public void send(String message) {
        printWriter.println(message);
        printWriter.flush();
    }

    public String read() throws IOException {
        return bufferedReader.readLine();
    }

    public void close() throws IOException {
        socket.close();
        printWriter.close();
        bufferedReader.close();
    }
}

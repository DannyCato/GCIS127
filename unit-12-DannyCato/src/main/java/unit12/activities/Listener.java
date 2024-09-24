package unit12.activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {
    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(22);
        Socket client = serv.accept();
        System.out.println("Connected");
        client.close();
        serv.close();
    }
}

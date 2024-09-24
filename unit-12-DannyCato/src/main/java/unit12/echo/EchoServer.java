package unit12.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(54321);
        Socket client = server.accept();
        BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String red = read.readLine();
        System.out.println(red);

        PrintWriter pw = new PrintWriter(client.getOutputStream());
        pw.println(red.toUpperCase());
        pw.flush();

        server.close();
    }
    
}

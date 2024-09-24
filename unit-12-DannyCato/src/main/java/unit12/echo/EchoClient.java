package unit12.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("localhost", 54321);
        PrintWriter pw = new PrintWriter(sock.getOutputStream());
        pw.println("What's good gang");
        pw.flush();

        BufferedReader read = null;
        while (read == null) {
            read = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        }
        System.out.println(read.readLine());

        sock.close();
    }
    
}

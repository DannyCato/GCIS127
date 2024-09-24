package unit12.activities;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Name {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("129.21.101.89",54321);
        OutputStream out = sock.getOutputStream();
        PrintWriter printer = new PrintWriter(out);
        printer.println("what");
        printer.flush();
        sock.close();
    }
    
}

package unit13.practicum;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SumClient {
    private Duplexer duplexer;
    private Scanner userIn;

    public SumClient(int port) throws IOException {
        Socket socket = new Socket("localhost", port);
        duplexer = new Duplexer(socket);
        userIn = new Scanner(System.in);
        task();
    }

    public void task() throws IOException {
        String number = "";
        while (!number.equals("0")) {
            System.out.print("Enter a number: ");
            number = userIn.nextLine();
            duplexer.send(number);

            String sum = duplexer.read();
            System.out.println("Sum = " + sum);
        }
        duplexer.close();
        userIn.close();
    }

    public static void main(String[] args) throws IOException {
        new SumClient(9999);
    }

}

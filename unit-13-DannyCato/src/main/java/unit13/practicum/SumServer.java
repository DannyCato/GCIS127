package unit13.practicum;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Runnable;

public class SumServer implements Runnable { 
    private static int sum = 0;
    private ServerSocket serv;
    private Duplexer duplexer;

    public SumServer(ServerSocket server) throws IOException {
        this.serv = server;
        serv.setReuseAddress(true);

        System.out.println("\tWaiting for next connection");
        Socket connected = serv.accept();
        System.out.println("\tConnected!");
        this.duplexer = new Duplexer(connected);
        Thread t = new Thread(this);
        t.start();

        new SumServer(server);        
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(9999);
        SumServer server = new SumServer(serv);
        server.getClass();
    }

    @Override
    public void run() {
        print("Run started");

        while (true) {
            print("waiting for number");
            String ans = "";
            try {
                ans = duplexer.read();
            } catch (IOException e) {}

            print("recieved " + ans);

            print("Adding + " + ans + " to " + sum);
            synchronized (serv) {
                sum += Integer.parseInt(ans);
            }

            print("sending number back");
            duplexer.send("" + sum);
            print("sent");

            if (ans.equals("0")) {
                print("recieved 0");
                print("breaking connection");
                try {
                    duplexer.close();
                } catch (IOException e) {}
                break;
            }

            print("**STARTING OVER**");
        }
    }

    private void print(Object o)  {
        System.out.println(o);
    }
}

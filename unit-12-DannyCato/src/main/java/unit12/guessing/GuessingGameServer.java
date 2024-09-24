package unit12.guessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import unit12.duplexer.Duplexer;

public class GuessingGameServer extends Duplexer implements Runnable {
    private GuessingGameImpl game;

    public GuessingGameServer(Socket socket) throws IOException {
        super(socket);
        this.game = new GuessingGameImpl();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        Socket client = server.accept();
        GuessingGameServer serv = new GuessingGameServer(client);
        serv.run();

        client.close();
        server.close();
    }

    //@Override
    public void run() {
        String request = "";
        while (!request.equals("QUIT")) {
            try {
                request = read();
            } catch (IOException e) {}
            System.out.println("RECV: " + request);

            String[] tokens = request.split(" ");

            String response = "";
            switch (response) {
                case "QUIT":
                    game.quit();
                    response = "GAME_OVER";
                    break;
                case "RESTART":
                    game.restart();
                    response = "RESTARTED";
                    break;
                case "GUESS":
                    GuessResult res = game.guess(Integer.parseInt(tokens[1]));
                    response = res.toString();
                    break;
                default:
                    response = "ERROR: Unknown Command - " + request;
                    break;
            }
            System.out.println("SEND: " + response);
            send(response);
        }
    }
    
}

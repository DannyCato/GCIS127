package unit12.guessing;

import java.io.IOException;
import java.net.Socket;

import unit12.duplexer.Duplexer;

public class GuessingGameProxy extends Duplexer implements GuessingGame{


    public GuessingGameProxy(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void restart() {
        send("RESTART");
        String response = "";
        try {
            response = read();
        } catch (IOException ioe) {}
        if (!response.equals("RESTARTED")) {
            System.out.println("Server did not restart!");
        }
    }

    @Override
    public GuessResult guess(int number) {
        send("GUESS " + number);
        String response = "";
        try {
            response = read();
        } catch (IOException ioe) {}
        return GuessResult.valueOf(response);
    }

    @Override
    public void quit() {
        send("QUIT");
        try {
            read();
            close();
        } catch (IOException ioe) {}
    }
    
}

package unit12.guessing;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class NetworkGuessinGame {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 15000);
        GuessingGame game = new GuessingGameProxy(socket);
        GamePlayer player = new GamePlayer(game);
        player.playTheGame();
        
        socket.close();
    }
}

package unit12.tinychat;

import java.io.IOException;
import java.net.Socket;

public class TinyChatProxy extends Duplexer implements TinyChat {

    public TinyChatProxy(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void quit() {
        send("quit");
        try {
            read();
            close();
        } catch (IOException ioe) {}
    }

    @Override
    public void connect(String name) {
        send(name);
        
        String answer = "";
        try {
            answer = read();
        } catch (IOException ioe) {}
        if (answer.equals("Connected"));
    }

    @Override
    public void sendMessage(String name, String message) {
        send(name + " : " + message);
    }
    
}

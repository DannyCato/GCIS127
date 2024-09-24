package unit12.tinychat;

import java.io.IOException;
import java.net.Socket;

public class TinyChatServer extends Duplexer /* implements Runnable */ {

    public TinyChatServer(Socket socket) throws IOException {
        super(socket);
        //TODO Auto-generated constructor stub
    }
    
}

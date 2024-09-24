package unit12.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(54321);

        DatagramPacket recieved = new DatagramPacket(new byte[1024], 1024);
        server.receive(recieved);

        String str = new String(recieved.getData(), 0, recieved.getLength());
        System.out.println(str);

        str = str.toUpperCase();
        DatagramPacket outgoing = new DatagramPacket(str.getBytes(), str.length(), recieved.getAddress(), recieved.getPort());
        server.send(outgoing);

        server.close();
    }
}

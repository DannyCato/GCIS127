package unit12.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();

        String str = "and that's on gang!";
        DatagramPacket outgoing = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 54321);
        client.send(outgoing);

        DatagramPacket recieved = new DatagramPacket(new byte[1024], 1024);
        client.receive(recieved);

        String strin = new String(recieved.getData(), 0, recieved.getLength());
        System.out.println(strin);


        client.close();
    }
}

package unit12.intersection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Client-side of the server. Uses UDP
 * 
 * @author Danny Catorcini
 */
public class SIClient {
    /**
     * Socket of this object
     */
    private DatagramSocket socket;

    /**
     * Name of the server to be sent to
     */
    private String SERVER_NAME;

    /**
     * Port of the server to be sent to
     */
    private int PORT;

    /**
     * Set of all elements to be checked
     */
    private Set<String> set;

    /**
     * Set of all overlapping elements
     */
    private Set<String> intersection;

    /**
     * Constructor of the object
     * 
     * @param serverName takes in a String of name of the server for the client to send to
     * @param port takes in an int of the port for the client to send to
     * @param set Set to be tested
     * 
     * @throws IOException
     */
    public SIClient(String serverName, int port, Set<String> set) throws IOException {
        Random rand = new Random();
        int dPort = 0;
        while (dPort == 0 || port == dPort) {
            dPort = rand.nextInt(10000, 65535);
        }
        this.socket = new DatagramSocket(dPort, InetAddress.getByName(serverName));
        this.SERVER_NAME = serverName;
        this.PORT = port;
        this.set = set;
        this.intersection = new HashSet<>();
    }

    /**
     * Main method.
     * Contains client-side half for sending and then recieving a message
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SIClient client = new SIClient("localhost", 54321, Sets.A4());
        client.mainLoop();
        client.close();
    }

    /**
     * Main method.
     * Loop of everything that happens in main. Follows assignment guide
     * 
     * @throws IOException
     */
    public void mainLoop() throws IOException {
        String sent = (String) set.toArray()[0];
        set.remove(sent);
        send(sent);
        while (!(set.isEmpty())) {
            // wait
            String recieved = recieve();

            // listen
            if (recieved.equals("NO")) {
                recieved = recieve();
            } else {
                intersection.add(sent);
            }

            // check an end state
            if (recieved.equals("END")) {
                break;
            }

            // recieve and respond
            if (set.contains(recieved)) {
                set.remove(recieved);
                intersection.add(recieved);
            } else {
                send("NO");
            }

            try {
            sent = (String) set.toArray()[0];
            set.remove(sent);
            send(sent);
            }
            catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        send("END");
        System.out.println(Arrays.toString(intersection.toArray()));
    }

    /**
     * Sends a message to the specified server
     * 
     * @param message String to be sent
     * 
     * @throws IOException
     */
    public void send(String message) throws IOException {
        // System.out.println("Client: " + message); // debug message to better understand flow
        socket.send(new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName(SERVER_NAME), PORT));
    }

    /**
     * Halts thread until message is recieved
     * 
     * @return String recieved
     * 
     * @throws IOException
     */    
    public String recieve() throws IOException {
        DatagramPacket rec = new DatagramPacket(new byte[1024], 1024);
        socket.receive(rec);
        String a = new String(rec.getData(), 0, rec.getLength());
        // System.out.println("From server: " + a); // debug message to better understand flow
        return a;
    }

    /**
     * Closes the socket so the port can be reused
     */
    public void close() {
        socket.close();
    }

    /**
     * @return Set to be checked
     */
    public Set<String> getSet() {
        return set;
    }

    /**
     * @return Set of overlapping elements
     */
    public Set<String> getIntersection() {
        return intersection;
    }
    
}

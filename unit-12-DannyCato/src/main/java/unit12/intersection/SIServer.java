package unit12.intersection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Server-side of the server. Uses UDP. Only able to read from one port
 * 
 * @author Danny Catorcini
 */
public class SIServer {
    /**
     * Socket of the object
     */
    private DatagramSocket socket;

    /**
     * Packet that contains all recieved information
     */
    private DatagramPacket packetIn;

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
     * @param port takes in an int of the port for the server to read from
     * @param set Set to be tested
     * 
     * @throws IOException
     */
    public SIServer(int port, Set<String> set) throws IOException {
        this.socket = new DatagramSocket(port);
        this.packetIn = new DatagramPacket(new byte[1024], 1024);
        this.set = set;
        this.intersection = new HashSet<>();
    }

    /**
     * Main method.
     * Contains sever-side half for recieving and then sending a message
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SIServer server = new SIServer(54321, Sets.B4());
        System.out.println(Arrays.toString(Sets.B4().toArray()));
        server.mainLoop();
        server.close();
    }

    /**
     * Main method.
     * Loop of everything that happens in main. Follows assignment guide
     * 
     * @throws IOException
     */
    public void mainLoop() throws IOException {
        String sent = "";
        while (!(set.isEmpty())) {
            set.remove(sent);
            // wait
            String recieved = recieve();

            // listen
            if (recieved.equals("NO")) {
                recieved = recieve();
            } else {
                if (sent != "") {
                    intersection.add(sent);
                }
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
                intersection.remove(recieved);
            }
            try {
            sent = (String) set.toArray()[0];
            send(sent);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        send("END");
        System.out.println(Arrays.toString(intersection.toArray()));
    }

    /**
     * Sends a message to the sender
     * 
     * @param message String to be sent
     * 
     * @throws IOException
     */
    public void send(String message) throws IOException {
        System.out.println("Server: " + message); // debug message to better understand flow
        socket.send(new DatagramPacket(message.getBytes(), message.length(), packetIn.getAddress(), packetIn.getPort()));
    }

    /**
     * Halts thread until message is recieved
     * 
     * @return String recieved
     * 
     * @throws IOException
     */
    public String recieve() throws IOException {
        socket.receive(packetIn);
        String a = new String(packetIn.getData(), 0, packetIn.getLength());
        System.out.println("From client: " + a); // debug message to better understand flow
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
     * @return Set of overlapping indicies
     */
    public Set<String> getIntersection() {
        return intersection;
    }

    
}

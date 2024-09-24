package unit08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import unit08.mcf.Node;
import unit08.mcf.NodeQueue;

public class NodeQueueTest {
    
    @Test
    public void constructorTest() {
        Node last = new Node("123");
        Node node = new Node("aa", new Node("bruh", last));

        NodeQueue<String> queue = new NodeQueue<String>(node);

        assertEquals("3, aa -> bruh -> 123 -> null", queue.toString());
    }

    @Test
    public void enqueueTest() {
        Node last = new Node("123");
        Node node = new Node("aa", new Node("bruh", last));
        NodeQueue<String> queue = new NodeQueue<String>(node);
        
        queue.enqueue("what the freak");

        assertEquals("4, aa -> bruh -> 123 -> what the freak -> null", queue.toString());
    }

    @Test
    public void dequeueTest() {
        Node last = new Node("123");
        Node node = new Node("aa", new Node("bruh", last));
        NodeQueue<String> queue = new NodeQueue<String>(node);
        
        String val = queue.dequeue();

        assertEquals("3, bruh -> 123 -> null", queue.toString());
        assertEquals("aa", val);
    }
}

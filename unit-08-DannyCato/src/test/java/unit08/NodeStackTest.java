package unit08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit08.mcf.Node;
import unit08.mcf.NodeStack;

public class NodeStackTest {
    @Test
    public void constructorTest() {
        Node last = new Node("123");
        Node node = new Node("aa", new Node("bruh", last));

        NodeStack stack = new NodeStack(node);

        assertEquals("3, aa -> bruh -> 123 -> null", stack.toString());
    }

    @Test
    public void pushTest() {
        Node node = new Node("aa", new Node("bruh", null));

        NodeStack stack = new NodeStack(node);
        stack.push("123");

        assertEquals("3, aa -> bruh -> 123 -> null", stack.toString());
    }

    @Test
    public void popTest() {
        Node last = new Node("123");
        Node node = new Node("aa", new Node("bruh", last));

        NodeStack stack = new NodeStack(node);
        String popped = stack.pop();

        assertEquals("2, aa -> bruh -> null", stack.toString());
        assertEquals("123", popped);
    }

    @Test
    public void topTest() {
        Node last = new Node("123");
        Node node = new Node("aa", new Node("bruh", last));

        NodeStack stack = new NodeStack(node);
        String topped = stack.top();

        assertEquals("123", topped);
    }
}

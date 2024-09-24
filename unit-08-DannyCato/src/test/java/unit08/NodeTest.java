package unit08;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import unit08.mcf.Node;

public class NodeTest {
    @Test
    public void constructorTest() {
        Node node = new Node("aa");

        assertEquals(node.getValue(), "aa");
        assertNull(node.getNext());
    }

    @Test
    public void nextTest() {
        Node node = new Node("aa", new Node("bb"));

        assertNotNull(node.getNext());
    }
}

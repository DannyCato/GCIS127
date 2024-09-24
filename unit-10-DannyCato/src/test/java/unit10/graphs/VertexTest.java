package unit10.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class VertexTest {
    @Test
    public void create() {
        // setup
        String expected = "abc";

        // invoke
        Vertex<String> vertex = new Vertex<>(expected);

        // analyze
        assertEquals(expected, vertex.getValue());
        Set<Vertex<String>> neighbors = vertex.getNeighbors();
        assertNotNull(neighbors);
        assertEquals(0, neighbors.size());
    }

    @Test
    public void connect() {
        // setup
        Vertex<String> vertexA = new Vertex<String>("a");
        Vertex<String> vertexB = new Vertex<String>("b");

        // invoke
        vertexA.connect(vertexB);

        // analyze
        assertTrue(vertexA.connected(vertexB));
        Set<Vertex<String>> neighbors = vertexA.getNeighbors();
        assertEquals(1, neighbors.size());
        assertTrue(neighbors.contains(vertexB));
    }
}

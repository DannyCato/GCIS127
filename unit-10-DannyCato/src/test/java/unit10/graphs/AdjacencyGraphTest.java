package unit10.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AdjacencyGraphTest {
    @Test
    public void create() {
        // setup
        String value = "abc";

        // invoke
        Graph<String> graph = new AdjacencyGraph<>();

        // analyze
        assertEquals(0, graph.size());
        assertFalse(graph.contains(value));
    }

    @Test
    public void addValue() {
        // setup
        String value = "abc";
        Graph<String> graph = new AdjacencyGraph<>();

        // invoke
        graph.add(value);

        // analyze
        assertEquals(1, graph.size());
        assertTrue(graph.contains(value));
    }

    @Test
    public void testConnectedFalse() {
        // setup
        String a = "a";
        String b = "b";
        Graph<String> graph = new AdjacencyGraph<>();
        graph.add(a);
        graph.add(b);

        // invoke - none

        // analyze
        assertEquals(2, graph.size());
        assertTrue(graph.contains(a));
        assertTrue(graph.contains(b));
        assertFalse(graph.connected(a, b));
        assertFalse(graph.connected(b, a));
    }

    @Test
    public void testConnectDirected() {
        // setup
        String a = "a";
        String b = "b";
        Graph<String> graph = new AdjacencyGraph<>();
        graph.add(a);
        graph.add(b);

        // invoke
        graph.connectDirected(a, b);

        // analyze
        assertEquals(2, graph.size());
        assertTrue(graph.contains(a));
        assertTrue(graph.contains(b));
        assertTrue(graph.connected(a, b));
        assertFalse(graph.connected(b, a));
    }

    @Test
    public void testConnectUndirected() {
        // setup
        String a = "a";
        String b = "b";
        Graph<String> graph = new AdjacencyGraph<>();
        graph.add(a);
        graph.add(b);

        // invoke
        graph.connectUndirected(a, b);

        // analyze
        assertEquals(2, graph.size());
        assertTrue(graph.contains(a));
        assertTrue(graph.contains(b));
        assertTrue(graph.connected(a, b));
        assertTrue(graph.connected(b, a));
    }
}

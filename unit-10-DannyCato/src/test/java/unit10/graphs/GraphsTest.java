package unit10.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GraphsTest {
    @Test
    public void verifyGraph() {
        // setup - none

        // invoke
        Graph<String> graph = Graphs.makeGraph();

        // analyze
        assertEquals(11, graph.size());
        assertTrue(graph.connected("A", "B"));
        assertTrue(graph.connected("A", "C"));

        assertTrue(graph.connected("B", "A"));
        assertFalse(graph.connected("B", "D"));
        assertTrue(graph.connected("B", "E"));

        assertFalse(graph.connected("C", "A"));
        assertTrue(graph.connected("C", "D"));
        assertTrue(graph.connected("C", "E"));
        assertTrue(graph.connected("C", "H"));

        assertTrue(graph.connected("D", "B"));
        assertTrue(graph.connected("D", "C"));
        assertTrue(graph.connected("D", "F"));

        assertTrue(graph.connected("E", "B"));
        assertTrue(graph.connected("E", "C"));
        assertTrue(graph.connected("E", "F"));

        assertTrue(graph.connected("F", "D"));
        assertFalse(graph.connected("F", "E"));
        assertTrue(graph.connected("F", "G"));

        assertTrue(graph.connected("I", "K"));
        assertFalse(graph.connected("I", "J"));

        assertTrue(graph.connected("J", "I"));
        assertTrue(graph.connected("J", "K"));

        assertTrue(graph.connected("K", "I"));
        assertTrue(graph.connected("K", "J"));
    }
}

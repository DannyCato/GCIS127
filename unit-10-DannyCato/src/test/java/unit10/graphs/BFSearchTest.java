package unit10.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BFSearchTest {
    @Test
    public void bfPathUndirectedPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        List<String> path = graph.bfSearch("A", "G");

        // analyze
        assertEquals(5, path.size());
        assertEquals("A", path.get(0));
        assertEquals("G", path.get(4));
    }

    @Test
    public void bfPathNoPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();
        List<String> expected = null;

        // invoke
        List<String> actual = graph.bfSearch("A", "K");

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void bfPathDirectedPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();
        List<String> expected = new LinkedList<>();
        expected.add("A");
        expected.add("C");
        expected.add("H");

        // invoke
        List<String> path = graph.bfSearch("A", "H");

        // analyze
        assertEquals(expected, path);
    }

    @Test
    public void bfPathDirectedNoPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();
        List<String> expected = null;

        // invoke
        List<String> actual = graph.bfSearch("H", "A");

        // analyze
        assertEquals(expected, actual);
    }

}

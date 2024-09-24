package unit11.practicum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import unit11.graphs.*;

public class Mothers {
    public static List<String> findMothers(AdjacencyGraph<String> graph, Map<String, Vertex<String>> vertices) {
        ArrayList<String> output = new ArrayList<>();
        for(Vertex<String> i : vertices.values()) {
            Set<Vertex<String>> visited = new HashSet<>();
            visited.add(i);
            if(followPath(i, visited, vertices.size())) {
                output.add(i.getValue());
            }
        }
        return (List<String>) output;
    }

    private static boolean followPath(Vertex<String> current, Set<Vertex<String>> visited, int max) {
        for (Vertex<String> neu : current.getNeighbors()) {
            if (visited.size() == max) {
                return true;
            }
            visited.add(neu);
            if (followPath(neu, visited, max)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AdjacencyGraph<String> graph1 = new AdjacencyGraph<>();
        graph1.add("a");
        graph1.add("b");
        graph1.add("c");
        graph1.add("d");
        graph1.add("e");

        graph1.connectDirected("a", "b");
        graph1.connectDirected("b", "e");
        graph1.connectDirected("b", "c");
        graph1.connectDirected("c", "d");
        graph1.connectDirected("e", "a");

        System.out.println(findMothers(graph1, graph1.getVertices()));


        AdjacencyGraph<String> graph2 = new AdjacencyGraph<>();
        graph2.add("t");
        graph2.add("u");
        graph2.add("v");
        graph2.add("w");
        graph2.add("x");
        graph2.add("y");
        graph2.add("z");

        graph2.connectDirected("t", "v");
        graph2.connectDirected("w", "t");
        graph2.connectDirected("x", "t");
        graph2.connectDirected("y", "x");
        graph2.connectDirected("y", "w");
        graph2.connectDirected("x", "u");
        graph2.connectDirected("z", "u");
        graph2.connectDirected("z", "y");

        System.out.println(findMothers(graph2, graph2.getVertices()));

    }
}

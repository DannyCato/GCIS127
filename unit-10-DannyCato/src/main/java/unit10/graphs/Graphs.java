package unit10.graphs;

public class Graphs {
    public static AdjacencyGraph<String> makeGraph() {
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        String[] what = {"A","B","C","D","E","F","G","H","I","J","K"};
        
        for (String i : what) {
            graph.add(i);
        }

        graph.connectUndirected("A", "B");
        graph.connectUndirected("B", "E");
        graph.connectUndirected("E", "C");
        graph.connectUndirected("C", "D");
        graph.connectUndirected("D", "F");
        graph.connectUndirected("F", "G");
        graph.connectDirected("A", "C");
        graph.connectDirected("C", "H");
        graph.connectDirected("D", "B");
        graph.connectDirected("E", "F");

        graph.connectUndirected("J", "K");
        graph.connectUndirected("I", "K");
        graph.connectDirected("J", "I");

        return graph;
    }
}

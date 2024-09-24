package unit10.graphs;

public class Main {
    public static void main(String[] args) {
        String[] filenames = {"a_13_5.txt", "a_22_3.txt", "a_26_4.txt", "a_6_1.txt", "a_7_3.txt", "bipartite.txt",
                              "k2.txt", "k2_2.txt", "k3.txt", "k3_3.txt", "k4.txt", "k5.txt", "non_bipartite.txt",
                              "v2.txt"};
        for (String filename : filenames) {
            System.out.println(filename + " connected components: " + GraphReader.readGraph("data/bfs/" + filename).countConnectedComponents());
        }
        // System.out.println("k3_3.txt" + " connected components: " + GraphReader.readGraph("data/bfs/k3_3.txt").countConnectedComponents());
    }
}

package unit10.graphs;

import static unit10.FileLineReader.open;
import java.util.HashSet;
import java.util.Set;

public class GraphReader {
    public static void main(String[] args) {
        Graph<String> graph = readGraph("data/bfs/a_6_1.txt");
        System.out.println(graph.toString());
    }

    public static Graph<String> readGraph(String filename) {
        AdjacencyGraph<String> returnGraph = new AdjacencyGraph<>();

        for (String line : open(filename)) {
            if (line.toCharArray()[0] == '#') {
                continue;
            }
            
            String[] letters = line.split(" ");
            String currentLetter = letters[0];

            Set<String> addedLettersSet = new HashSet<>();

            for (String letter : letters) {
                if (currentLetter.equals(letter)) {
                    if (returnGraph.getVertexFromValue(letter) == null) {
                        returnGraph.add(letter);
                        addedLettersSet.add(letter);
                    }
                }
                else if (addedLettersSet.contains(letter)) {
                    continue;
                } else {
                    if (returnGraph.getVertexFromValue(letter) == null) {
                        returnGraph.add(letter);
                    }
                    if (!(returnGraph.connected(currentLetter, letter))) {
                        returnGraph.connectUndirected(currentLetter, letter);
                    }
                    addedLettersSet.add(letter);
                }
            }
        }

        return returnGraph;
    }
}

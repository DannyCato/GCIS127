package unit10.graphs;

import static unit10.FileLineReader.open;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FrogHopping {
    private AdjacencyGraph<Hole> graph;
    private char[][] arrayBoard;
    private final int ROWS, COLS;
    private Map<Integer, Hole> map;

    public FrogHopping(String filename) throws IOException{
        // Initialize all of the fields
        // Construct the array and add all vertices to the graph
        map = new HashMap<>();
        graph = new AdjacencyGraph<>();


        ArrayList<String> file = new ArrayList<>();
        for (String line : open(filename)) {
            file.add(line);
        }
        String firstLine = file.get(0);
        String[] first = firstLine.split(" ");
        ROWS = Integer.parseInt(first[0]);
        COLS = Integer.parseInt(first[1]);

        arrayBoard = new char[ROWS][COLS];        
        file.remove(0);

        int row = 0, col = 0;
        for (String line : file) {
            for (String piece : line.split(" ")) {
                arrayBoard[row][col] = piece.toCharArray()[0];
                col++;
            }
            col = 0;
            row++;
        }

        row = 0; 
        col = 0;
        for (char[] a : arrayBoard) {
            for (char b : a) {
                if (b == 'H') {
                    Hole hole = new Hole(row, col);
                    int[] arr = {row,col};
                    map.put(hashCode(arr), hole);
                    graph.add(hole);
                }
                col++;
            }
            col = 0;
            row++;
        }

        // Connect vertices
        connectVertices();      
             
    }
    private void connectVertices(){
        // in a line, stacked, or offset by 45
        // in first and last line it can only be horizontal

        boolean edgeLine = true;
        int row = 0, col = 0;
        for(char[] a : arrayBoard) {
            if (row == arrayBoard.length - 1) {
                edgeLine = true;
            }
            for (char b : a) {
                if (b == 'P') {
                    if (!edgeLine) {
                        // check diagonal and vertical
                        // vertical -
                        if (arrayBoard[row - 1][col] == 'H' && arrayBoard[row + 1][col] == 'H') {
                            int[] arr1 = {row - 1, col};
                            int[] arr2 = {row + 1, col};
                            graph.connectUndirected(map.get(findCorrectHashFromMap(hashCode(arr1))), map.get(findCorrectHashFromMap(hashCode(arr2))));
                        }

                        // diagonal 1 \
                        if (col - 1 >= 0 && col + 1 != arrayBoard.length) {
                            if (arrayBoard[row-1][col-1] == 'H' && arrayBoard[row+1][col+1] == 'H') {
                                int[] arr1 = {row - 1, col - 1};
                                int[] arr2 = {row + 1, col + 1};
                                graph.connectUndirected(map.get(findCorrectHashFromMap(hashCode(arr1))), map.get(findCorrectHashFromMap(hashCode(arr2))));
                            }
                        // diagonal 2 /
                            if (arrayBoard[row+1][col-1] == 'H' && arrayBoard[row-1][col+1] == 'H') {
                                int[] arr1 = {row + 1, col - 1};
                                int[] arr2 = {row - 1, col + 1};
                                graph.connectUndirected(map.get(findCorrectHashFromMap(hashCode(arr1))), map.get(findCorrectHashFromMap(hashCode(arr2))));
                            }
                        }
                    }
                    // check horizontal 
                    // horizontal |
                    if (colIndexConfirmer(row, col)) {
                        int[] arr1 = {row, col - 1};
                        int[] arr2 = {row, col + 1};
                        graph.connectUndirected(map.get(findCorrectHashFromMap(hashCode(arr1))), map.get(findCorrectHashFromMap(hashCode(arr2))));
                    }
                }
                col++;
            }
            edgeLine = false;
            col = 0;
            row++;
        }

    }

    private Integer findCorrectHashFromMap(int hashCode) {
        for (Integer i : map.keySet()) {
            if (i.equals(Integer.valueOf(hashCode))) {
                return i;
            }
        }
        return null;
    }

    private boolean colIndexConfirmer(int row, int col) {
        if (col - 1 >= 0 && col + 1 != arrayBoard.length) {
            if (arrayBoard[row][col-1] == 'H' && arrayBoard[row][col+1] == 'H') {
                return true;
            }
        }
        return false;
    }

    public int hashCode(int[] arr) {
        int hash = 0;
        arr[1] = arr[1] * 100;
        for (int i : arr) {
            hash += Objects.hash(i);
        }
        return hash;
    }
    
    @Override
    public String toString() {
        String output = "";
        for (Hole i : map.values()) {
            output += i.toString() + ": [";

            boolean first = true;
            for (Vertex<Hole> neighbor : graph.getVertcies().get(i).getNeighbors()) {
                if (!first) {
                    output += ", ";
                }
                first = false;
                output += neighbor.getValue().toString();
            }
            output += "]\n";
        }
        return output;

    }
    
    // The frog can't jump to a hole which was visited before
    public List<Hole> dfPathV0(Hole start, Hole end) {
        return graph.dfSearch(start, end);
    }
    // The frog can't jump over the same peg more than once
    public List<Hole> dfPathV1(Hole start, Hole end) {
        return null;
    }
    public static void main(String[] args) throws IOException {
        FrogHopping frog = new FrogHopping("data/dfs/frog_3.txt");
        System.out.println(frog);
        // for (int i : frog.map.keySet()) {
        //     System.out.println(i);
        // }
        Hole start = new Hole(2, 1);
        Hole end = new Hole(0, 5);
        System.out.println(frog.dfPathV0(start, end)); //[(2,1), (0,3), (2,5), (2,3), (0,5)]
        System.out.println(frog.dfPathV1(start, end)); //[(2,1), (0,3), (2,5), (2,3), (0,3), (0,5)]
        System.out.println("The frog game graph representation:");
        
    }
}

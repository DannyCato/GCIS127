package unit10.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Hole{
    private final int row, col;
    public Hole(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public static void main(String[] args) {
        Map<Hole, Integer> map = new HashMap<>();
        map.put(new Hole(0, 0), 0);
        map.put(new Hole(0, 3), 0);
        map.put(new Hole(5, 2), 5);
        System.out.println(map.containsKey(new Hole(5, 2))); //true
        System.out.println(map.get(new Hole(5, 2))); //5   


        AdjacencyGraph<Hole> graph = new AdjacencyGraph<>();
        Hole a = new Hole(0, 1);
        graph.add(a);
        Hole b = new Hole(0, 3);
        graph.add(b);
        Hole c = new Hole(0, 5);
        graph.add(c);
        Hole d = new Hole(2, 1);
        graph.add(d);
        Hole e = new Hole(2, 3);
        graph.add(e);
        Hole f = new Hole(2, 5);
        graph.add(f);

        graph.connectUndirected(a, d);
        graph.connectUndirected(a, e);
        graph.connectUndirected(b, d);
        graph.connectUndirected(b, e);
        graph.connectUndirected(b, c);
        graph.connectUndirected(b, f);
        graph.connectUndirected(c, e);
        graph.connectUndirected(e, f);

        List<Hole> bf = graph.bfSearch(d, c);
        System.out.println(bf.toString());
        List<Hole> df = graph.dfSearch(d, c);
        System.out.println(df.toString());
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Hole) {
            Hole other = (Hole) o;
            return row == other.row && col == other.col;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
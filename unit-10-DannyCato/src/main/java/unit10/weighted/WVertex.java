package unit10.weighted;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WVertex<E> {
    private E value;
    private final Map<WVertex<E>, Edge<E>> neighbors;    

    public WVertex(E value) {
        this.value = value;
        neighbors = new HashMap<>();
    }

    public E getValue() {
        return value;
    }

    public void connect(WVertex<E> neighbor, double weight) {
        Edge<E> edge = new Edge<>(this, neighbor, weight);
        neighbors.put(neighbor, edge);
    }   

    public Set<Edge<E>> edges() {
        Set<Edge<E>> edges = new TreeSet<>();
        for(WVertex<E> neighbor : neighbors.keySet()) {
            edges.add(neighbors.get(neighbor));
        }
        return edges;
    }

    public Edge<E> edge(WVertex<E> neighbor) {
        return neighbors.get(neighbor);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

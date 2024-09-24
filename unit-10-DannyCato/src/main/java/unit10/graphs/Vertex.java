package unit10.graphs;

import java.util.HashSet;
import java.util.Set;

public class Vertex<E> {
    private E value;
    private Set<Vertex<E>> neighbors;

    public Vertex(E value) {
        this.value = value;
        this.neighbors = new HashSet<Vertex<E>>();
    }

    public E getValue() {
        return value;
    }

    public void connect(Vertex<E> neighbor) {
        neighbors.add(neighbor);
    }

    public boolean connected(Vertex<E> other) {
         return neighbors.contains(other);
    }

    public Set<Vertex<E>> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        String ret = value.toString()+ ": {";
        boolean first = true;
        for (Vertex<E> N : neighbors) {
            if (!first) {
                ret += ", ";
            }
            N.getValue().toString();
        }
        return ret + "}";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(Object obj) {
        if ((E)obj instanceof E) {
            E object = (E) obj;
            return value.equals(object);
            
        }
        return false;
    }
}
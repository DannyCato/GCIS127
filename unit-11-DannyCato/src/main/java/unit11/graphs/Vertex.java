package unit11.graphs;

import java.util.Set;
import java.util.HashSet;

/**
 * Represents a vertex in an unweighted adjacency-list implementation of the 
 * graph data structure.
 * 
 * @author GCCIS Faculty
 */
public class Vertex<E> {
    /**
     * The value stored by this vertext.
     */
    private E value;

    /**
     * The set of neighbors to which this vertex is connected.
     */
    private Set<Vertex<E>> neighbors;

    /**
     * Creates a new vertex with the specified value and an empty set of 
     * neighbors.
     * 
     * @param value The value stored in the new vertex.
     */
    public Vertex(E value) {
        this.value = value;
        neighbors = new HashSet<>();
    }

    public E getValue() {
        return value;
    }

    /**
     Connects this vertex to its neighbor by adding it to the set of neighbors.

     * @param neighbor The neighbor to which this vertex should be connected.
     */
    public void connect(Vertex<E> neighbor) {
        neighbors.add(neighbor);
    }

    /**
     * Returns true if the specified vertex is a member of the neighbors set.
     * 
     * @param vertex The vertex being checked for membership.
     * 
     * @return True if the vertex is a neighbor, and false otherwise.
     */
    public boolean connected(Vertex<E> vertex) {
        return neighbors.contains(vertex);
    }

    /**
     * Returns the set of neighbors. This should be used with caution as the
     * set is mutable. Any changes will be permanent.
     * 
     * @return The mutable set of neighbors.
     */
    public Set<Vertex<E>> getNeighbors() {
        return neighbors;
    }
    
}

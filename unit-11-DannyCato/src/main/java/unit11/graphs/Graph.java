package unit11.graphs;

import java.util.List;

/**
 * Defines the essential operations of a graph data structure.
 * 
 * @author GCCIS Faculty
 */
public interface Graph<E> {
    /**
     * Adds a value to the graph (if it is not already present).
     * 
     * @param value The value to be added to the graph.
     */
    void add(E value);

    /**
     * Returns true if the specified value is present in the graph.
     * 
     * @param value The value.
     * 
     * @return True if the value is present in the graph, and false otherwise.
     */
    boolean contains(E value);

    /**
     * Returns the number of values being stored in the graph.
     * 
     * @return The number of values in the graph.
     */
    int size();

    /**
     * Creates a directed connection between two values in the graph. Such a
     * connection is one-way and may only be traversed from the source vertex
     * to the destination vertex.
     * 
     * @param a The source vertex.
     * @param b The destination vertex.
     */
    void connectDirected(E a, E b);

    /**
     * Creates an undirected connection between the source and destination 
     * vertices. Such a connection is two-way and may be traversed in either
     * direction.
     * 
     * @param a The source vertex.
     * @param b The destination vertex.
     */
    void connectUndirected(E a, E b);

    /**
     * Returns true if there is a connection from the source vertext to the 
     * destination vertex. The connection may be directed.
     * 
     * @param a The source vertex.
     * @param b The destination vertex.
     * 
     * @return True if there is a connection from vertex a to vertex b, and
     * false otherwise.
     */
    boolean connected(E a, E b);

    /**
     * Uses a breadth-first search to determine whether or not a path exists
     * between the start and end vertices.
     * 
     * @param start The start vertex.
     * @param end The end vertex.
     * 
     * @return True if at least one path exists between the start and end 
     * vertices, and false otherwise.
     */
    default boolean bfSearch(E start, E end) {
        throw new UnsupportedOperationException("BFS Not Implemented!");
    }

    /**
     * Uses a breadth-first search to find the path from the start vertex to
     * the end vertex, if it exists.
     * 
     * @param start The start  vertex.
     * @param end The end vertex.
     * 
     * @return A list containing the values along the path from the start 
     * vertex to the end vertex, if it exists. If no path exists, the list will
     * be null.
     */
    default List<E> bfPath(E start, E end) {
        throw new UnsupportedOperationException("BFP Not Implemented!");
    }

    /**
     * Uses a depth-first search to determine whether or not a path exists
     * between the start and end vertices.
     * 
     * @param start The start vertex.
     * @param end The end vertex.
     * 
     * @return True if at least one path exists between the start and end 
     * vertices, and false otherwise.
     */
    default boolean dfSearch(E start, E end) {
        throw new UnsupportedOperationException("DFS Not Implemented!");
    }

    /**
     * Uses a depth-first search to find the path from the start vertex to
     * the end vertex, if it exists.
     * 
     * @param start The start  vertex.
     * @param end The end vertex.
     * 
     * @return A list containing the values along the path from the start 
     * vertex to the end vertex, if it exists. If no path exists, the list will
     * be null.
     */
    default List<E> dfPath(E start, E end) {
        throw new UnsupportedOperationException("DFP Not Implemented!");
    }
}
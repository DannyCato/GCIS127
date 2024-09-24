package unit10.weighted;

public interface WGraph<E> {
    void add(E value);
    boolean contains(E value);
    int size();
    void connect(E a, E b, double weight);
    boolean connected(E a, E b);
    double weight(E a, E b);
    
    default WPath<E> dijkstrasPath(E start, E end) {
        throw new UnsupportedOperationException();
    }
}

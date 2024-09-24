package unit08.mcf;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    int size();
}

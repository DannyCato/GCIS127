package unit09.practicum;
import java.lang.Iterable;
import java.util.Iterator;

public interface Tuple<E> extends Iterable<E> {
    public E get(int index);
    public int size();
    default public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}

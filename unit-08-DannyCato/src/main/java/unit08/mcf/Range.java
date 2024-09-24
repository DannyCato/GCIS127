package unit08.mcf;
import java.lang.Iterable;
import java.util.Iterator;


public interface Range extends Iterable<Integer>
/*
 * Range implementation for Java. Hardcoded to be an Iterable<Integer>
 */
{
    int size();
    Integer get(int n);
    default Iterator<Integer> iterator() {
        throw new UnsupportedOperationException();
    }
}

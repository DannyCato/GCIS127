package unit09.practicum;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayTuple<E> implements Tuple<E> {
    private Object[] elements;

    public ArrayTuple(Object[] elements) {
        this.elements = elements;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (index < size()) {
            return (E) elements[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public String toString() {
        String ret = Arrays.toString(elements);
        return ret;
    }
    
    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator<E>(elements, size());
    }
}

package unit09.practicum;

import java.util.Iterator;

/**
 * An iterator over an array.
 * 
 * @author GCCIS Faculty
 */
public class ArrayIterator<E> implements Iterator<E> {
    /**
     * The object array over which this iterator iterates.
     */
    private Object[] elements;

    /**
     * the current index in the array of elements.
     */
    private int index;


    /**
     * The size (which may be less than or equal to the length of the array).
     */
    private int size;
    
    public ArrayIterator(Object[] elements, int stopIndex) {
        this.elements = elements;
        this.size = stopIndex;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E next() {
        E element = (E)elements[index];
        index++;
        return element;
    }
}

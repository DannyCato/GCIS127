package unit08.mcf;
import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] elements; // Object type to stop it from throwing errors
    private int front = Integer.MAX_VALUE;
    private int back = Integer.MAX_VALUE;
    private int size;
    
    public ArrayQueue(E[] full) {
        this.elements = full;
        int count = 0;
        for (E thing : full) {
            if (thing != null && front == Integer.MAX_VALUE) { // set value to front
                front = count;
            } else if (thing != null && front != Integer.MAX_VALUE) { // set value to back
                back = count;
            }
            count++;

            if (thing == null && front != Integer.MAX_VALUE && back != Integer.MAX_VALUE) {
                break;
            }
        }
        size = back - front + 1;
    }

    public void enqueue(E value) {
        if (size + 1 >= elements.length) {
            Object[] arr = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                arr[i] = elements[(i + front) % elements.length];
            }
            arr[size()] = value;
            elements = arr;
            size++;
            front = 0;
            back = size() - 1;
        } else {
            back = (back + 1) % elements.length;
            elements[back] = value;
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        E value = (E) elements[front];
        // @ts-ignore
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return value;
    }

    @Override
    public String toString() {
        return "" + size + ", " + Arrays.toString(elements);
    }

    public int size() {
        return size;
    }
}

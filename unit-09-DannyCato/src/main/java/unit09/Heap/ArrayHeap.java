package unit09.Heap;

import java.util.Arrays;
import java.util.Random;

public class ArrayHeap implements Heap{
    private int[] array;
    private int size;

    public ArrayHeap() {
        array = new int[3];
        size = 0;
    }

    public static void main(String[] args) {
        ArrayHeap arr = new ArrayHeap();
        System.out.println(arr.getSize());

        for (int i = 0; i < 10; i++) {
            arr.add(new Random().nextInt(50));
        }
        System.out.println(arr);
        arr.remove();
        arr.remove();
        System.out.println(arr);
    }

    @Override
    public void add(int value) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, size + 2);
        }
        array[size] = value;
        siftUp();
        size++;
    }

    private void siftUp() {
        int child = size;
        int parent = (child - 1) / 2;
        while (array[parent] > array[child]) {
            swap(child, parent);
            siftUp();
        }  
    }

    private void swap(int old, int neu) {
        if (array[old] != array[neu]) {
            int temp = array[old];
            array[old] = array[neu];
            array[neu] = temp; 
        }
    }

    @Override
    public int remove() {
        int temp = array[0];
        swap(0, size - 1);
        array[size - 1] = 0;
        size--;
        siftDown();
        return temp;
    }

    private void siftDown() {
        int parent = 0;

        boolean one = false;
        boolean two = false;
        while (parent < size) {
            try {
                try {    
                    siftDownComparer(parent, 1);
                    one = true;

                    try {
                        siftDownComparer(parent, 2);
                        two = true;
                    } 
                    catch(Exception IndexOutOfBoundsException) {
                        
                    }
                }
                catch (Exception IndexOutOfBoundsException) {

                }

                int smaller = largerNumber(parent, one, two);
                if (smaller < array[parent]) {
                    swap(parent, smaller);
                }
                parent = smaller;
            }
            catch (Exception UnsupportedOperationException) {
                break;
            }
        }
    }

    private int siftDownComparer(int parentIndex, int indexMover) {
        return (array[parentIndex * 2 + indexMover]);
    }

    private int largerNumber(int parent, boolean one, boolean two) {
        if (one && two) {
            if (!(array[parent + 1] == 0 || array[parent + 2] == 0)) {
                return ((Math.min(array[parent + 1], array[parent + 2]) == array[parent + 1])) ? parent + 1 : parent + 2 ;
            }
        } else if (one) {
            if (array[parent + 1] == 0) {
                throw new UnsupportedOperationException();
            }
            return parent + 1;
        } else if (two) {
            return parent + 2;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "" + size + ", " + Arrays.toString(array);
    }

    public int[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }  
}

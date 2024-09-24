package unit10.practicum;

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] array;
    private int size;

    public ArrayHeap() {
        array = new int[5];
        size = 0;
    }

    @Override
    public void add(int value) {
        // add pt 1
        if(size == array.length) {
            array = Arrays.copyOf(array, size*2);
        }
        array[size] = value;
        
        // sifting up
        int child = size;
        int parent = (child - 1) / 2;
        while(array[parent] > array[child]) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }

        // for loop version
        // for(int c=size, p=(c-1)/2; array[p] > array[c]; c=p, p=(c-1)/2) {
        //     swap(p, c);
        // }

        size++; // don't forget!
    }

    @Override
    public int remove() {
        // most of part 1
        int temp = array[0];
        size--;
        swap(0, size);
        array[size] = 0;

        // sifting down
        int parent = 0;
        while(parent < size) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int dest = parent;
            if(left < size) {
                dest = left;
            }
            if(right < size && array[right] < array[left]) {
                dest = right;
            }
            if(array[dest] < array[parent]) {
                swap(dest, parent);
                parent = dest;
            } else {
                break;
            }
        }

        // last bit of part 1
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) + ", " + size;
    }

    private void swap(int a, int b) {
        if(a != b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    public static void main(String[] args) {
        Heap heap = new ArrayHeap();

        System.out.println(heap);

        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);

        System.out.println(heap);

        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
    }
    
}

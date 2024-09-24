package unit10.practicum;

public class HeapPQ implements Queue<Integer>{
    private ArrayHeap heap = new ArrayHeap();

    public HeapPQ(int[] list) {
        for (int i : list) {
            enqueue(i);
        }
    }

    @Override
    public void enqueue(Integer value) {
        heap.add(value);
    }

    @Override
    public Integer dequeue() {
        return heap.remove();
    }

    @Override
    public int size() {
        return heap.size();
    }

    public ArrayHeap getHeap() {
        return heap;
    }
    
}

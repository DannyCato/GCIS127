package unit10.practicum;

import java.util.Collection;
import java.util.LinkedList;

public class ListPQ implements Queue<Integer>{
    private LinkedList<Integer> list = new LinkedList<>();
    private int size;

    public ListPQ(Collection<Integer> col) {
        this.size = 0;
        for (int i : col) {
            this.list.add(i);
            size++;
        }
    }

    @Override
    public void enqueue(Integer value) {
        this.list.add(value);
    }

    @Override
    public Integer dequeue() {
        int lowest = Integer.MAX_VALUE;
        int lowestIndex = 0;

        int count = 0;
        for (int i : list) {
            if (i < lowest) {
                lowest = i;
                lowestIndex = count;
            }
            count++;
        }
        list.remove(lowestIndex);
        size--;
        return lowest;
    }

    @Override
    public int size() {
        return size;
    }

    public LinkedList<Integer> getList() {
        return list;
    }
    
}

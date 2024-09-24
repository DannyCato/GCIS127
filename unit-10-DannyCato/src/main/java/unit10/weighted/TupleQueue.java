package unit10.weighted;

import java.util.LinkedList;
import java.util.List;

public class TupleQueue<E> {
    private final List<PathTuple<E>> queue;

    public TupleQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(PathTuple<E> element) {
        queue.add(element);
    }

    public PathTuple<E> dequeue() {
        int index = 0;
        PathTuple<E> closest = queue.get(index);

        for(int i=0; i<queue.size(); i++) {
            PathTuple<E> candidate = queue.get(i);
            if(candidate.getDistance() < closest.getDistance()) {
                closest = candidate;
                index = i;
            }
        }

        queue.remove(index);

        return closest;
    }

    public int size() {
        return queue.size();
    }    
}

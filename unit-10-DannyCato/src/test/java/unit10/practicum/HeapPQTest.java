package unit10.practicum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class HeapPQTest {
    @Test
    public void heapTest() {
        int[] what = new int[10];
        for (int i = 0; i < 10; i++) {
            what[i] = new Random().nextInt(15);
        }
        HeapPQ heap = new HeapPQ(what);

        Set<Integer> set = new HashSet<>();

        for (int i : what) {
            set.add(i);
        }

        while (!set.isEmpty()) {
            assertTrue(set.remove(heap.dequeue()));
        }
    }
}

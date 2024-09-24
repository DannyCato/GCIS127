package unit08;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import unit08.mcf.ArrayQueue;

public class ArrayQueueTest {

    @Test
    public void constructorTest() {
        String[] strs = {null, "aa", "bb", "cc", "dd", "ee", null, null, "one", "two"};
        ArrayQueue<String> arrQ = new ArrayQueue<String>(strs);

        assertEquals("5, " + Arrays.toString(strs), arrQ.toString());
    }

    @Test
    public void enqueueTest1() {
        String[] strs = {null, "aa", "bb", "cc", "dd", "ee", null, null, "one", "two"};
        ArrayQueue<String> arrQ = new ArrayQueue<String>(strs);
        arrQ.enqueue("ff");

        assertEquals("6, [null, aa, bb, cc, dd, ee, ff, null, one, two]", arrQ.toString());
    }

    @Test
    public void enqueueTest2() {
        String[] strs = {null, "aa", "bb", "cc", "dd", "ee"};
        ArrayQueue<String> arrQ = new ArrayQueue<String>(strs);
        arrQ.enqueue("ff");

        assertEquals("6, [aa, bb, cc, dd, ee, ff, null, null, null, null, null, null]", arrQ.toString());
    }

    @Test
    public void dequeueTest() {
        String[] strs = {null, "aa", "bb", "cc", "dd", "ee", null, null, "one", "two"};
        ArrayQueue<String> arrQ = new ArrayQueue<String>(strs);
        String ans = arrQ.dequeue();

        assertEquals("4, [null, null, bb, cc, dd, ee, null, null, one, two]", arrQ.toString());
        assertEquals("aa", ans);
    }
}

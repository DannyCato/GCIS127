package unit09;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import unit09.practicum.ArrayTuple;

public class ArrayTupleTest {

    @Test
    public void arrayTupleTest() {
        Integer[] asdf = {0,1,2,3,4,5};
        ArrayTuple<Integer> wow = new ArrayTuple<Integer>((Object[]) asdf);

        int count = 0;
        for (int i : wow) {
            assertEquals(asdf[count], i);
            count++;
        }

        assertEquals("[0, 1, 2, 3, 4, 5]", wow.toString());
    }
}

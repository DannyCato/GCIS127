package unit08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import unit08.mcf.ArrayStack;

public class ArrayStackTest {
    @Test
    public void constructorTest() {
        ArrayStack as = new ArrayStack("a");

        assertEquals("[a, null, null]", as.toString());
    }

    @Test
    public void pushTest() {
        ArrayStack as = new ArrayStack("a");
        as.push("b");

        assertEquals("[a, b, null]", as.toString());
    }

    @Test
    public void popTest() {
        ArrayStack as = new ArrayStack("a");
        as.push("b");
        as.push("c");

        as.pop();

        assertEquals("[a, b, null]", as.toString());
    }

    @Test
    public void topTest() {
        ArrayStack as = new ArrayStack("a");
        as.push("b");
        as.push("c");

        assertEquals("c", as.top());
    }
}

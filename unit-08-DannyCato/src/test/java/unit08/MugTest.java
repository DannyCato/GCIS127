package unit08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MugTest {
    @Test
    public void buildMugTest(){
        Mug mug = new Mug(100, "red", Material.GLASS, "huh");

        assertEquals(mug.getSize(), 100);
        assertEquals(mug.getColor(), "red");
        assertEquals(mug.getMaterial(), Material.GLASS);
        assertEquals(mug.getPhrase(), "huh");
    }

    @Test
    public void fillTest() {
        Mug mug = new Mug(100, "red", Material.GLASS, "huh");

        mug.fill(100);

        assertEquals(mug.getFillLevel(), 100);
    }

    @Test
    public void drainTest() {
        Mug mug = new Mug(100, "red", Material.GLASS, "huh");

        mug.fill(100);
        mug.drain(50);

        assertEquals(mug.getFillLevel(), 50);
    }    
}

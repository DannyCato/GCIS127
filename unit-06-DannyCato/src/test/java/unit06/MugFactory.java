package unit06;
import java.util.*;

public class MugFactory {
    public static final String HATE = "Ifucking hate it";
    public static final String WRONG = "What the fuck is wrong with this";
    public static final String CONFUSED = "I'm so confused";
    

    public static void main(String[] args) {
        Mug mug1 = new Mug(100,"green",50, HATE, Material.CERAMIC);
        /*
        mug1.size = 100;
        mug1.color = "green";
        mug1.fillLevel = 50;
        mug1.phrase = "Ifucking hate it";
        mug1.material = "ceramic";
        */

        
        Mug mug2 = new Mug(100,"red",50, WRONG, Material.STAINLESS_STEEL);
        /* 
        mug2.size = 100;
        mug2.color = "blue";
        mug2.fillLevel = 50;
        mug2.phrase = "What the fuck is wrong with this";
        mug2.material = "ceramic";
        */

        
        Mug mug3 = new Mug(100,"red",50, CONFUSED, Material.PORCELAIN);
        /* 
        mug3.size = 100;
        mug3.color = "red";
        mug3.fillLevel = 50;
        mug3.phrase = "I'm so confused";
        mug3.material = "ceramic";
        */

        printMug(mug1);
        printMug(mug2);
        printMug(mug3);

        
        mug1.fill(100000);
        printMug(mug1);
        mug1.drain(1000);
        printMug(mug1);

        Material[] values = Material.values();
        System.out.println(Arrays.toString(values));
    }
    
    public static void printMug(Mug mug) {
        System.out.println(mug.getSize());
        System.out.println(mug.getColor());
        System.out.println(mug.getFillLevel());
        System.out.println(mug.getPhrase());
        System.out.println(mug.getMaterial());
        System.out.println(mug.getMaterial().getPrice());
        System.out.println();
    }
    
}

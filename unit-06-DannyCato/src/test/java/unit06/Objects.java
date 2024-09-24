package unit06;
import java.util.*;

public class Objects {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(funWithObjects("I hate you")));
        System.out.println(Arrays.toString(funWithObjects(new Mug(100,"red",50, MugFactory.CONFUSED, Material.PORCELAIN))));
        System.out.println(Arrays.toString(funWithObjects(15)));
        
    }

    public static Object[] funWithObjects(Object object) {
        Object[] arr = new Object[5];

        arr[0] = object.toString();
        arr[1] = 1;
        arr[2] = false;
        arr[3] = new Mug(100,"red",50,MugFactory.HATE,Material.CERAMIC);
        arr[4] = "what";

        return arr;
    }
}

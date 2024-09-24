package unit07.products;
import unit07.toys.ActionFigure;
import java.util.*;

public class FactoryActionFigure extends Factory {
    static Random rand = new Random();

    public FactoryActionFigure() {
        super(new ActionFigure(rand.nextInt(5, 15) + 0.99, pickHair(), pickEyecolor(), new String[] {"Best toy", "I'm cool", "Action!"}, rand.nextBoolean()), "Action Figure Factory");
    }

    public Product make() {
        return super.getProduct();
    }

    public static String pickHair() {
        String[] sounds = {"Brown", "Blonde", "Black", "Dyed"};
        return sounds[rand.nextInt(sounds.length)];
    }

    public static String pickEyecolor() {
        String[] sounds = {"Brown", "Blue", "Green", "Hazel"};
        return sounds[rand.nextInt(sounds.length)];
    }
}

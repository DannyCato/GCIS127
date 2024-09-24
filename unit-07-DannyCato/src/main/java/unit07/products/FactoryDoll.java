package unit07.products;
import unit07.toys.Doll;
import java.util.*;

public class FactoryDoll extends Factory {
    static Random rand = new Random();

    public FactoryDoll() {
        super(new Doll(rand.nextInt(5, 30) + 0.99, pickHair(), pickEyecolor(), new String[] {"I love it", "Wow!", "How Cool!"}), "Doll Factory");
    }

    public Product make() {
        return super.getProduct();
    }

    public static String pickHair() {
        String[] sounds = {"Red", "Brunette", "Blonde", "Black", "Dyed"};
        return sounds[rand.nextInt(sounds.length)];
    }

    public static String pickEyecolor() {
        String[] sounds = {"Brown", "Blue", "Green", "Hazel"};
        return sounds[rand.nextInt(sounds.length)];
    }
}

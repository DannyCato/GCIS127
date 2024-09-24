package unit07.products;
import unit07.toys.Robot;
import java.util.*;

public class FactoryRobot extends Factory {
    static Random rand = new Random();

    public FactoryRobot() {
        super(new Robot(rand.nextInt(30, 100) + 0.99, 100, pickSound()), "Robot Factory");
    }

    public Product make() {
        return super.getProduct();
    }

    public static String pickSound() {
        String[] sounds = {"Beep", "Boop", "Beep Boop", "BWOWOW", "SHOOWP"};
        return sounds[rand.nextInt(sounds.length)];
        
    }
}

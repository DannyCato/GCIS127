package unit08.Practicum;
import java.util.Random;

public class Manio extends Fighter {
    public Manio() {
        super("Manio", 100);
    }

    public int dealDamage() {
        return new Random().nextInt(25,51);
    }

    public int takeDamage(int damage) {
        if (new Random().nextInt(100) > 75) {
            return 0;
        }
        setHealth(Math.max(getHealth() - damage, 0));
        return getHealth();
    }
}

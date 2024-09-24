package unit08.Practicum;
import java.util.Random;

public class Lonk extends Fighter {
    public Lonk() {
        super("Lonk", 100);
    }

    public int dealDamage() {
        return 45;
    }

    public int takeDamage(int damage) {
        if (new Random().nextInt(100) > 50) {
            damage /= 2;
        }
        setHealth(Math.max(getHealth() - damage, 0));
        return getHealth();
    }
}

package unit07.gvt;
import java.util.Random;

public class Cleric extends Goat{
    public Cleric(String name) {
        super(name, 125, 125);
    }

    public Attack attack() {
        Random rand = new Random(); 
        int[] attack = {rand.nextInt(15,26)};
        return new Attack("Bell, Book, and Candle", attack, DamageTypes.HOLY);
    }

    public void takeDamage(Attack attack) {
        DamageTypes type = attack.getDamageType();
        double damageModifier = 1.0;
        int countDamage = 0;
        for (int i : attack.getHits()) {
            countDamage += i;
        }

        if (type == DamageTypes.HOLY) {
            heal((int) (countDamage * 0.25));
        }

        int totalDamage = (int) (countDamage * damageModifier);
        int currentHP = this.getCurrentHP();
        this.setCurrentHP((currentHP - totalDamage < 0) ? 0 : currentHP - totalDamage);
    }

    @Override
    public String toString() {
        return "A cleric named " + this.getName() + " with " + this.getCurrentHP() + "/" + this.getMaximumHP() + " hit points!";
    }
}

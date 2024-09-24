package unit07.gvt;
import java.util.*;

public class Thief extends Goat{
    public Thief(String name) {
        super(name, 125, 125);
    }

    public Attack attack() {
        Random rand = new Random(); 
        int hits = rand.nextInt(1,4);
        int[] attack = new int[hits];
        for (int i = 0; i < hits; i++) {
            attack[i] = rand.nextInt(10,21);

            if (rand.nextInt(0,100) < 26) {
                attack[i] *= 2;
            }
        }
        return new Attack("Stabbity-Stab", attack, DamageTypes.PHYSICAL);
    }

    public void takeDamage(Attack attack) {
        DamageTypes type = attack.getDamageType();
        double damageModifier = 1.0;
        if (type == DamageTypes.POISON) {
            damageModifier = 0.75;
        }

        int countDamage = 0;
        for (int i : attack.getHits()) {
            countDamage += i;
        }

        int totalDamage = (int) (countDamage * damageModifier);
        int currentHP = this.getCurrentHP();
        this.setCurrentHP((currentHP - totalDamage < 0) ? 0 : currentHP - totalDamage);
    }

    @Override
    public String toString() {
        return "A thief named " + this.getName() + " with " + this.getCurrentHP() + "/" + this.getMaximumHP() + " hit points!";
    }
}

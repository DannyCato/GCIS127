package unit07.gvt;

public class Trollzord extends Troll {
    public Trollzord() {
        super("Trollzord", 38, 38, 5);
    }

    public Attack attack() {
        int[] attack = {25};
        return new Attack("Flame War", attack, DamageTypes.MAGICAL);
    }

    public void takeDamage(Attack attack) {
        DamageTypes type = attack.getDamageType();
        double damageModifier = 1.0;
        if (type == DamageTypes.HOLY) {
            damageModifier = 1.25;
        }

        int countDamage = 0;
        for (int i : attack.getHits()) {
            countDamage += i;
        }

        int totalDamage = (int) (countDamage * damageModifier);
        int currentHP = this.getCurrentHP();
        this.setCurrentHP((currentHP - totalDamage < 0) ? 0 : currentHP - totalDamage);
    }
}

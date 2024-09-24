package unit07.gvt;

public class Fighter extends Goat {

    public Fighter(String name) {
        super(name, 150, 150);
    }

    public Attack attack() {
        int[] attack = {25};
        return new Attack("Cleave", attack, DamageTypes.PHYSICAL);
    }

    public void takeDamage(Attack attack) {
        DamageTypes type = attack.getDamageType();
        double damageModifier = 1.0;
        if (type == DamageTypes.PHYSICAL) {
            damageModifier = 0.75;
        } else if (type == DamageTypes.MAGICAL) {
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

    @Override
    public String toString() {
        return "A fighter named " + this.getName() + " with " + this.getCurrentHP() + "/" + this.getMaximumHP() + " hit points!";
    }
}

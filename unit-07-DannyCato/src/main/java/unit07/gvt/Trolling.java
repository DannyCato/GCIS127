package unit07.gvt;

public class Trolling extends Troll{
    public Trolling() {
        super("Trolling", 38, 38, 3);
    }

    public Attack attack() {
        int[] attack = {25};
        return new Attack("U Mad", attack, DamageTypes.PHYSICAL);
    }

    public void takeDamage(Attack attack) {
        DamageTypes type = attack.getDamageType();
        double damageModifier = 1.0;
        if (type == DamageTypes.MAGICAL) {
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

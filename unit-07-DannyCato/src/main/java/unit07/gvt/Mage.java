package unit07.gvt;

public class Mage extends Goat{

    public Mage(String name) {
        super(name, 100, 100);
    }

    public Attack attack() {
        int[] attack = {9,9,9,9};
        return new Attack("Magic Missiles", attack, DamageTypes.MAGICAL);
    }

    public void takeDamage(Attack attack) {
        DamageTypes type = attack.getDamageType();
        double damageModifier = 1.0;
        if (type == DamageTypes.MAGICAL) {
            damageModifier = 0.75;
        } else if (type == DamageTypes.PHYSICAL) {
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
        return "A mage named " + this.getName() + " with " + this.getCurrentHP() + "/" + this.getMaximumHP() + " hit points!";
    }

    // public static void main(String[] args) {
    //     Mage greg = new Mage("greg", 125, 125);
    //     Mage joe = new Mage("joe", 100, 100);

    //     System.out.println(greg.toString());
    //     System.out.println(joe.toString());

    //     // greg attacks joe
    //     Attack attack = greg.Attack();
    //     joe.takeDamage(attack);
    //     System.out.println("Joe's health is: " + joe.currentHP);

    //     // greg knocks out joe
    //     System.out.println("Joe gets healed");
    //     joe.heal(10000);
    //     System.out.println("Joe's health is: " + joe.currentHP);
    //     while (joe.isConscious()) {
    //         joe.takeDamage(attack);
    //         System.out.println("Joe's health is: " + joe.currentHP);
    //     }
    //     System.out.println("Joe is conscious: " + joe.isConscious());
    // }
}

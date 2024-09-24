package unit08.Practicum;

public class FighterArena {
    public static void fightArean(Fighter f1, Fighter f2) {
        while (f1.isConscious() && f2.isConscious()) {
            int dam1 = f2.dealDamage();
            int dam2 = f1.dealDamage();

            f1.takeDamage(dam1);
            f2.takeDamage(dam2);

            System.out.println(f1.toString() + " took " + dam1 + " damage");
            System.out.println(f2.toString() + " took " + dam2 + " damage");

        }

        if (f1.isConscious() && !f2.isConscious()) {
            System.out.println(f1.toString() + " wins!");
        } else if (f2.isConscious() && !f1.isConscious()) {
            System.out.println(f2.toString() + " wins!");
        } else {
            System.out.println("Tie!");
        }
    }
}

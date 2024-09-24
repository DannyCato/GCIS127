package unit07.gvt;

public class GoatArena {
    public static void battle(Goat goat1, Goat goat2) {
        print(goat1.toString() + " VS " + goat2.toString());
        Attack g1_attack = goat1.attack();
        Attack g2_attack = goat2.attack(); 

        int round = 0;
        while (goat1.isConscious() && goat2.isConscious()) {
            round++;
            print("ROUND " + round);
            int g1_roundStartHP = goat1.getCurrentHP();
            int g2_roundStartHP = goat2.getCurrentHP();
            print(goat1.getName() + " starts the round at " + g1_roundStartHP + " HP");
            print(goat2.getName() + " starts the round at " + g2_roundStartHP + " HP");

            damage(g2_attack, goat1, goat1.getCurrentHP()); // goat 1 take damage
            damage(g1_attack, goat2, goat2.getCurrentHP()); // goat 2 take damage

            print(goat1.getName() + " is now at " + goat1.getCurrentHP() + " HP");
            print(goat2.getName() + " is now at " + goat2.getCurrentHP() + " HP");
        }

        if (!(goat1.isConscious() || goat2.isConscious())) {
            print("TIE!");
        } else if (goat1.isConscious() && !goat2.isConscious()) {
            print(goat1.getName() + " is victorious!");
        } else if (!goat1.isConscious() && goat2.isConscious()) {
            print(goat2.getName() + " is victorious!");
        }
    }

    public static void damage(Attack attack, Goat goat, int startingHealth) {
        goat.takeDamage(attack);
            print(goat.getName() + " got hit with " + attack.getName() 
            + " for " + (startingHealth - goat.getCurrentHP()) + " HP!");
    }

    public static void main(String[] args) {
        battle(new Mage("gregamy"), new Fighter("geraldine"));
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}

package unit07.gvt;

public abstract class Goat {
    private String name;
    private int maximumHP;
    private int currentHP;

    public Goat() {
        this.name = "Hairy Potter";
        this.maximumHP = 100;
        this.currentHP = 100;
    }

    public Goat(String name, int maximumHP, int currentHP) {
        this.name = name;
        this.maximumHP = maximumHP;
        this.currentHP = currentHP;
    }

    public void heal(int amount) {
        currentHP = (currentHP + amount > maximumHP) ? maximumHP : currentHP + amount;
    }

    public boolean isConscious() {
        if (currentHP > 0) {
            return true;
        }
        return false;
    }

    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);

    @Override
    public String toString() {
        return "A goat named " + this.name + " with " + currentHP + "/" + maximumHP + " hit points!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaximumHP() {
        return maximumHP;
    }

    public void setMaximumHP(int maximumHP) {
        this.maximumHP = maximumHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}

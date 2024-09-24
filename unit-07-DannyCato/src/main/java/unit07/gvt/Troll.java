package unit07.gvt;

public abstract class Troll {
    private String name;
    private int maximumHP;
    private int currentHP;
    private int regenRate;

    public Troll(String name, int maximumHP, int currentHP, int regenRate) {
        this.name = name;
        this.maximumHP = maximumHP;
        this.currentHP = currentHP;
        this.regenRate = regenRate;
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

    public void regen() {
        currentHP = Math.min((int) currentHP + (currentHP * (regenRate / 100)), maximumHP);
    }

    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);

    @Override
    public String toString() {
        return "A "+ this.name + " with " + currentHP + "/" + maximumHP + " hit points!";
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

    public int getRegenRate() {
        return regenRate;
    }

    public void setRegenRate(int regenRate) {
        this.regenRate = regenRate;
    }
}

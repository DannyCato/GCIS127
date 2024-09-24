package unit08.Practicum;

public abstract class Fighter {
    private String name; 
    private int health;

    public Fighter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract int dealDamage();

    public abstract int takeDamage(int damage);

    public boolean isConscious() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }
}

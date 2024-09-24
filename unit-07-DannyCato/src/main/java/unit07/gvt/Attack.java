package unit07.gvt;

public class Attack {
    private String name;
    private int[] hits;
    private DamageTypes damage;

    public Attack(String name, int[] hits, DamageTypes damage) {
        this.name = name;
        this.hits = hits;
        this.damage = damage;
    }

    public String getName() {
        return this.name;
    }

    public int[] getHits() {
        return this.hits;
    }

    public DamageTypes getDamageType() {
        return this.damage;
    }
}

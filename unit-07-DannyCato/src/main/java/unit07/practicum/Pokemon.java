package unit07.practicum;

public class Pokemon {
    private String name;
    private Types type;
    private int level;

    public Pokemon(String name, Types type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon(String name, Types type) {
        this.name = name;
        this.type = type;
        this.level = 1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types getType() {
        return this.type;
    }

    public int getLevel() {
        return this.level;
    }

    public void incrementLevel() {
        if (this.level < 100) {
            this.level++;
        }
    }    

    @Override
    public String toString() {
        return "Pokemon{name=" + this.name + ", type=" + this.type.name() + ", level=" + this.level + "}";
    }

    public boolean equals(Pokemon poke) {
        if (poke.getLevel() == this.level && poke.getType() == this.type) {
            return true;
        }
        return false;
    }
}

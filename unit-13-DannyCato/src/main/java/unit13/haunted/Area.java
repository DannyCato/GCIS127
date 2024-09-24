package unit13.haunted;

public class Area {
    private String name;
    private AreaType type;
    private String evilPresence;

    public Area(String name, AreaType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AreaType getType() {
        return type;
    }

    public boolean isHaunted() {
        return evilPresence != null;
    }

    public void haunt(String evilPresence) {
        this.evilPresence = evilPresence;
    }

    @Override
    public String toString() {
        if (isHaunted()) {
            return name + " [" + type + "/" + evilPresence + "]";
        }
        return name + " [" + type + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Area) {
            Area a = (Area) o;
            if (a.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + name.hashCode();
        return hash;
    }
} 

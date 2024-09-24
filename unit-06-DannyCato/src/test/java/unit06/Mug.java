package unit06;

public class Mug {
    private int size;
    private String color;
    private double fillLevel;
    private String phrase;
    private Material material;

    public Mug(int size, String color, double fillLevel, String phrase, Material material) {
        this.size = size;
        this.color = color;
        this.fillLevel = fillLevel;
        this.phrase = phrase;
        this.material = material;
    }

    public void fill(int ounces) {
        this.fillLevel = Math.min(this.size, this.fillLevel + ounces);
    }

    public void drain(int ounces) {
        this.fillLevel = Math.max(0, this.fillLevel - ounces);
    }


    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }


    public void setFillLevel(double fillLevel) {
        this.fillLevel = fillLevel;
    }

    public double getFillLevel() {
        return this.fillLevel;
    }

    
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }


    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return this.material;
    }

    @Override
    public String toString() {
        return "A " + getColor() + " " + getMaterial() + "mug, that is " + getSize() + " fl oz and $" + getMaterial().getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Mug) {
            Mug other = (Mug)obj;
            return this.size == other.size && this.color == other.color && 
            this.fillLevel == other.fillLevel && this.phrase == other.phrase
            && this.material == other.material;
        }
        return false;
    }
}

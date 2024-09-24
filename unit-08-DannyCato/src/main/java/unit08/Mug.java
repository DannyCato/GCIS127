package unit08;

/**
 * A simple class representing a Mug.
 */
public class Mug {
    /**
     * The capacity of the mug (in fluid ounces).
     */
    private final double size;

    /**
     * The mug's current fill level - should not exceed the capacity or drop
     * below 0.
     */
    private double fillLevel;

    /**
     * The color of the mug.
     */
    private final String color;

    /**
     * The material from which the mug is made.
     */
    private final Material material;

    /**
     * A phrase written on the face of the mug.
     */
    private String phrase;

    /**
     * Constructs a new mug with the specified values.
     * 
     * @param size The size of the new mug (in fluid ounces).
     * @param color The color of the mug.
     * @param material The material from which the mug is made.
     * @param phrase The phrase on the face of the mug.
     */
    public Mug(double size, String color, Material material, String phrase) {
        this.size = size;
        this.fillLevel = 0.0d;
        this.color = color;
        this.material = material;
        this.phrase = phrase;
    }

    public double getSize() {
        return size;
    }

    public double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(double fillLevel) {
        this.fillLevel = fillLevel;
    }

    public String getColor() {
        return color;
    }

    public Material getMaterial() {
        return material;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    /**
     * Adds up to the specified amount of liquid to the mug and ensures that 
     * the capacity is not exceeded.
     * 
     * @param ounces The amount of liquid to add to the mug's current fill 
     * level.
     */
    public void fill(double ounces) {
        fillLevel += ounces;
        if(fillLevel > size) {
            fillLevel = size;
        }
    }

    /**
     * Drains up to the specified amount of liquid from the mug's current fill
     * level and ensures that the fill level does not drop below 0.
     * 
     * @param ounces The amount of liquid to add to the mug's current fill 
     * level.
     * @return The amount of liquid that was drained (may be less than the
     * requested amount).
     */
    public double drain(double ounces) {
        double actual;
        if(ounces > fillLevel) {
            actual = fillLevel;
            fillLevel = 0;
        } else {
            actual = ounces;
            fillLevel -= ounces;
        }
        return actual;
    }
    
    @Override
    public String toString() {
        return "A " + size + "oz " + color + " " + material 
            + " mug that says '" + phrase + "'";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Mug) {
            Mug other = (Mug)obj;
            return this.size == other.size && this.material == other.material;
        } else {
            return false;
        }
    }
}

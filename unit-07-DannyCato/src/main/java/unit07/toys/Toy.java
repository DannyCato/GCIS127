package unit07.toys;

public abstract class Toy extends unit07.products.Product{

    public Toy(String name, Double MSRP) {
        super(name, MSRP);
    }

    public Toy() {
        super("generic", 0);
    }

    public abstract void play();

    @Override
    public String toString() {
        return "a toy, " + getName() + "/" + getProductCode() + " at price " + getMSRP();
    }
    
}

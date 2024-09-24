package unit07.products;
import java.util.Random;

public class Product {
    private final int productCode;
    private String name;
    private double MSRP;

    public Product(String name, double MSRP) {
        this.productCode = newProdCode();
        this.name = name;
        this.MSRP = MSRP;
    }

    public int newProdCode() {
        Random rand = new Random();
        return rand.nextInt(1000000, 10000000);
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMSRP() {
        return MSRP;
    }

    public void setMSRP(double mSRP) {
        MSRP = mSRP;
    }

    @Override
    public String toString() {
        return "a product, " + getName() + "/" + getProductCode() + " at price " + getMSRP();
    }
}

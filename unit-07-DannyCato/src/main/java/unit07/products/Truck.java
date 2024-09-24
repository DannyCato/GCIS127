package unit07.products;

public interface Truck {
    int capacity = 3;

    void load(Product product);

    Product unload();

}

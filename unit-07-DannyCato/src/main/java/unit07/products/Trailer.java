package unit07.products;

public class Trailer implements Truck {
    private Product[] currentLoad;

    public Trailer() {
        this.currentLoad = new Product[0];
    }

    public void load(Product product) {
        if (hasSpace()) {
            add(product);
        }
    }

    public boolean hasSpace() {
        return (capacity > currentLoad.length) ? true : false;
    }

    public boolean isEmpty() {
        return (currentLoad.length == 0) ? true : false;
    }

    public Product unload() {
        if (!isEmpty()) {
            return remove(currentLoad);
        }
        return null;
    }

    public void add(Product product) {
        Product[] intermeidate = new Product[currentLoad.length + 1];
        int count = 0;
        for (Product i : currentLoad) {
            intermeidate[count] = i;
            count++;
        }
        intermeidate[intermeidate.length - 1] = product;
        currentLoad = intermeidate;
    }

    public Product remove(Product[] products) {
        Product[] intermediate = new Product[products.length - 1];
        for (int i = 0; i < products.length - 1; i++) {
            intermediate[i] = products[i];
        }
        Product last = products[products.length - 1];
        currentLoad = intermediate;
        return last;
    }
}

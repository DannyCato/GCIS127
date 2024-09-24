package unit07.products;

public abstract class Factory {
    private Product product;
    private String name;

    public Factory(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    public abstract Product make();

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

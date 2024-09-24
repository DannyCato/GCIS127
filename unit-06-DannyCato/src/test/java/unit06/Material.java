package unit06;

public enum Material {
    CERAMIC(10),
    STAINLESS_STEEL(30),
    GLASS(24),
    BAMBOO(13),
    PORCELAIN(15),
    PLASTIC(5);
    
    private int price;

    private Material(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name() + " (" +getPrice() + ") ";
    }
}

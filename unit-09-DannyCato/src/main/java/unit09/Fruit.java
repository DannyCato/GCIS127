package unit09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Fruit implements Comparable<Fruit>{
    private String name;
    private int price;

    public static void main(String[] args) {
        ArrayList<Fruit> arr = new ArrayList<>();
        arr.add(new Fruit("lemon", 10));
        arr.add(new Fruit("lime", 111));
        arr.add(new Fruit("lemon", 100));

        System.out.println(Arrays.toString(arr.toArray()));
        Collections.sort(arr);
        System.out.println(Arrays.toString(arr.toArray()));
    }

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Fruit f1) {
        if (!this.name.equals(f1.getName())) {
            // compare Strings
            return name.compareTo(f1.getName());
        } else {
            // compare price
            return price - f1.getPrice();
        }

    }

    @Override
    public String toString() {
        return name + " $" + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

package unit09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {
    public int compare(Fruit fruit, Fruit otherFruit){
        if (fruit.getPrice() != otherFruit.getPrice()) {
            // compare price
            return fruit.getPrice() - otherFruit.getPrice();
        } else {
            // compare Strings
            return fruit.getName().compareTo(otherFruit.getName());
        }
    }

    public static void main(String[] args) {
        Fruit f1 = new Fruit("limon", 10);
        Fruit f2 = new Fruit("lemon", 1000);
        Fruit f3 = new Fruit("lemon", 10);

        ArrayList<Fruit> fruity = new ArrayList<>();
        fruity.add(f1);
        fruity.add(f2);
        fruity.add(f3);

        System.out.println(Arrays.toString(fruity.toArray()));
        Collections.sort(fruity, new FruitComparator());
        System.out.println(Arrays.toString(fruity.toArray()));
    }
}

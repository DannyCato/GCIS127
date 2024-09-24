package unit09.Sushi;

import java.util.Random;

public class Sushi {
    private int number;
    private int weight;
    private int price;

    public Sushi(int number) {
        this.number = number;
        this.weight = new Random().nextInt(20,100);
        this.price = new Random().nextInt(10,41);
    }

    public String toString() {
        return "number=" + number + ", weight=" + weight + " grams, $" + price;
    }

    public int getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

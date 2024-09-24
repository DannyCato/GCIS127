package unit09;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Pokemon implements Comparable<Pokemon>{
    private int number;
    private String name;

    public Pokemon(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + number + ": " + name;
    }

    @Override
    public int compareTo(Pokemon poke) {
        return this.number - poke.number;
    }

    public static void main(String[] args) {
        ArrayList<Pokemon> pokes = new ArrayList<Pokemon>();
        pokes.add(new Pokemon(3, "zooweemama"));
        pokes.add(new Pokemon(2, "wowza"));
        pokes.add(new Pokemon(1, "grag"));

        System.out.println(Arrays.toString(pokes.toArray()));
        
        Collections.sort(pokes);    
        System.out.println(Arrays.toString(pokes.toArray()));

    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package unit07.products;
import java.util.*;

public class Complex {
    public Factory[] factories;
    public String name;

    public Complex(String name) {
        this.name = name;
        factories = new Factory[0];
    }

    public void fillTrailer(Trailer trailer) {
        while (trailer.hasSpace()) {
            Random rand = new Random();
            Factory randomFactory = factories[rand.nextInt(factories.length)];
            trailer.add(randomFactory.getProduct());
        }
    }

    public void add(Factory factory) {
        Factory[] intermeidate = new Factory[factories.length + 1];
        int count = 0;
        for (Factory i : factories) {
            intermeidate[count] = i;
            count++;
        }
        intermeidate[intermeidate.length - 1] = factory;
        factories = intermeidate;
    }

    public Factory remove(Factory[] factories) {
        Factory[] intermeidate = new Factory[factories.length - 1];
        int count = 0;
        for (Factory prod : factories) {
            intermeidate[count] = prod;
            count++;
        }
        Factory last = factories[factories.length - 1];
        this.factories = intermeidate;
        return last;
    }
}
package unit09.Sushi;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Sushi, Integer> bag = new HashMap<>();
    private int cost;
    
    public Order(Set<Integer> order) {
        for (int i : order) {
            bag.put(new Sushi(i), i);
        }

        for (Sushi i : bag.keySet()) {
            cost += i.getPrice();
        }
    }

    public Map<Sushi, Integer> getBag() {
        return bag;
    }

    public int getCost() {
        return cost;
    }
}

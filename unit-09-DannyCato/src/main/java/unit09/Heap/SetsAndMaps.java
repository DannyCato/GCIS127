package unit09.Heap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SetsAndMaps {
    public static void main(String[] args) {
        SetsAndMaps bruh = new SetsAndMaps();
        
        Set<String> strings = new TreeSet<>();
        bruh.addAndPrint(strings);

        bruh.addAndPrint(new TreeSet<String>());
        bruh.addAndPrint(new HashSet<String>());

        Set<String> grag = new TreeSet<>(new AlphabeticComparator());
        bruh.addAndPrint(grag);


        Map<String, Integer> one = new TreeMap<>();
        Map<String, Integer> two = new HashMap<>();
        Map<String, Integer> three = new TreeMap<>(new AlphabeticComparator());

        bruh.putAndPrint(one);
        bruh.putAndPrint(two);
        bruh.putAndPrint(three);
    }    

    public void addAndPrint(Set<String> set) {
        set.add("6");
        set.add("1513");
        set.add("ASDFA");
        set.add("wowza!");
        set.add("I'm so excited");
        for (String i : set) {
            System.out.println(i);
        }
    }

    public void putAndPrint(Map<String, Integer> map) {
        map.put("5",5);
        map.put("4",4);
        map.put("3",3);
        map.put("2!",2);
        map.put("1",1);

        for (String i : map.keySet()) {
            System.out.println(i);
        }
    }
}

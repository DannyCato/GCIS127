package unit09.Heap;

import java.util.Comparator;

public class AlphabeticComparator implements Comparator<String> {
    public int compare(String one, String two) {
        one = one.toLowerCase();
        two = two.toLowerCase();
        return one.compareTo(two);
    }
}

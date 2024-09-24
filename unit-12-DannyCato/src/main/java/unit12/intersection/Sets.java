package unit12.intersection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    private static final int MAX = 10000;

    // Example 1
    public static Set<String> A1() {
        Set<String> A = new HashSet<>();
        A.add("a");
        A.add("b");
        return A;
    }

    public static Set<String> B1() {
        Set<String> B = new HashSet<>();
        B.add("b");
        B.add("c");
        return B;
    }

    // Example 2
    public static Set<String> A2() {
        Set<String> A = new HashSet<>();
        A.add("a");
        return A;
    }

    public static Set<String> B2() {
        Set<String> B = new HashSet<>();
        B.add("b");
        B.add("c");
        B.add("d");
        return B;
    }

    // Example 3
    public static Set<String> A3() {
        Set<String> A = new HashSet<>();
        A.add("a");
        A.add("b");
        A.add("c");
        return A;
    }

    public static Set<String> B3() {
        Set<String> B = new HashSet<>();
        B.add("a");
        B.add("b");
        B.add("c");
        return B;
    }

    // Example 4
    public static Set<String> A4() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 20; i += 2) {
            set.add(String.valueOf(i));
        }
        return set;
    }

    public static Set<String> B4() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 20; i += 4) {
            set.add(String.valueOf(i));
        }
        return set;
    }

    // Intersection of A4 and B4
    public static Set<String> AB4() {
        Set<String> A4 = A4();
        Set<String> B4 = B4();
        Set<String> AB4 = new HashSet<>();
        for (String elt : A4) {
            if (B4.contains(elt))
                AB4.add(elt);
        }
        return new TreeSet<>(AB4);
    }

    // Example 4
    public static Set<String> A5() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < MAX; i += 3) {
            set.add(String.valueOf(i));
        }
        return set;
    }

    public static Set<String> B5() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < MAX; i += 2) {
            set.add(String.valueOf(i));
        }
        return set;
    }

    // Intersection of A5 and B5
    public static Set<String> AB5() {
        Set<String> A5 = A5();
        Set<String> B5 = B5();
        Set<String> AB5 = new HashSet<>();
        for (String elt : A5) {
            if (B5.contains(elt))
                AB5.add(elt);
        }
        return new TreeSet<>(AB5);
    }

    public static void main(String[] args) {
        Set<String> A4 = A4();
        Set<String> B4 = B4();
        Set<String> AB4 = AB4();
        System.out.println("A4 = " + A4 + ", size = " + A4.size());
        System.out.println("B4 = " + B4 + ", size = " + B4.size());
        System.out.println("AB4 = " + AB4 + ", size = " + AB4.size());

        Set<String> A5 = A5();
        Set<String> B5 = B5();
        Set<String> AB5 = AB5();
        System.out.println("A5 = " + A5 + ", size = " + A5.size());
        System.out.println("B5 = " + B5 + ", size = " + B5.size());
        System.out.println("AB5 = " + AB5 + ", size = " + AB5.size());
    }
}

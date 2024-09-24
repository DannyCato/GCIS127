package unit06;
import java.util.*;

public class Activities {
    public static void main(String[] args) {
        /* 
        int val = 10;
        String str = "Huh";
        long great = 1234567890;
        double yessir = 1.2445256343456;
        
        System.out.println(val);
        System.out.println(str);
        System.out.println(great);
        System.out.println(yessir);
        */

        evenlyDivisible(13);
        evenlyDivisible(5);
        evenlyDivisible(13051);
        evenlyDivisible(1135);

        System.out.println(countWhile(3));
        System.out.println(countFor(3));

        int[] arr = squares(5);
        String output = Arrays.toString(arr);
        System.out.println(output);
    }

    public static void evenlyDivisible(int n) {
        if (n % 2 == 0) {
            System.out.println(n + " is even");
        } else if (n % 3 == 0) {
            System.out.println(n + " is divisible by 3");
        } else if (n % 5 == 0) {
            System.out.println(n + " is divisible by 5");
        } else {
            System.out.println(n + " is odd and not divisible by 3 or 5");
        }
        
    }

    public static int countWhile(int n) {
        int temp_counter = 0, sum = 0;
        while (temp_counter != n + 1) {
            sum += temp_counter;
            temp_counter++;
        }
        return sum;
    }

    public static int countFor(int n) {
        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            sum += i;
        }
        return sum;
    }

    public static int[] squares(int n) {
        int[] arr = new int[n];
        for (int i = 0; i<arr.length; i++) {
            arr[i] = i*i;
        }
        return arr;
    }
    
}

package unit06;
import java.util.*;

public class Primes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int number = scan.nextInt();
            if (number < 1) {
                break;
            }
            boolean prime = isPrime(number);
            if (prime) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is a not prime number");
            }
        }
        scan.close();
    }

    public static boolean isPrime(int n) {
        /*
         * Finds midpoint and checks if every number before that 
         * can be evenly divided into it using modulus
         */
        double midpoint = n / 2.0;
        for(double i = 2.0; i <= midpoint; i += 1.0) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    
}

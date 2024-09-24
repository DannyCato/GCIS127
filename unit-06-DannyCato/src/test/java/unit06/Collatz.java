package unit06;

import java.util.Scanner;

public class Collatz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int number = scan.nextInt();
            if (number < 1) {
                break;
            }
            System.out.println(sequence(number));
        }
        scan.close();
    }

    public static String sequence(int n) {
        String answer = "";
        if (n < 1) {
            return answer;
        }
        while (n > 1) {
            answer += n + " ";
            if (n % 2 == 0) {
                n = n/2;
            } else {
                n = 3 * n + 1;
            }
        }
        return answer + "1";
    }
}

package unit09.Sushi;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        Random rand = new Random();

        Set<Integer> items = new HashSet<>();
        while (items.size() < 25) {
            items.add(rand.nextInt(100));
        }

        System.out.println("Welcome to Shinji Ikari's Sushi Shop");
        System.out.print("Here is the current selection: ");
        printArr(items);

        Scanner scan = new Scanner(System.in);
        System.out.print("The cashier takes your order: ");
        String in = scan.nextLine();
        scan.close();

        System.out.println("The cashier prepares your order.");
        String[] toSet = in.split(" ");
        Set<Integer> toOrder = new HashSet<>();
        for (String i : toSet) {
            Integer num = Integer.parseInt(i);
            items.remove(num);
            toOrder.add(num);
        }
        Order currentOrder = new Order(toOrder);

        System.out.print("Here is the remaining selection: ");
        printArr(items);
        System.out.println("That will be $" + currentOrder.getCost());
        System.out.println("Here is your order, please come again");

        System.out.println("Back at your apartment, you take out your sushi and eat it ...");
        
        for (Sushi sushi : currentOrder.getBag().keySet()) {
            System.out.println("Eating Sushi{" + sushi.toString() + "} ... yum!");
        }

        
    }

    private static void printArr(Set<Integer> arr) {
        String ans = "";
        boolean first = true;
        for (int i : arr) {
            if (!first) {
                ans += ", ";
            }
            first = false;
            ans += i;
        }
        System.out.println(ans);
    }
}

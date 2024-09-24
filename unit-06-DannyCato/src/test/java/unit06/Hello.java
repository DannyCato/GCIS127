package unit06;
import java.util.*;

public class Hello {
    public static void main(String[] args) {
        helloYou();
    }
    
    public static void helloYou() {
        Scanner great = new Scanner(System.in);
        System.out.print("What's your name: ");
        String name = great.nextLine();
        System.out.println();
        System.out.println("Hello, " + name + "!");
        great.close();
    }
}
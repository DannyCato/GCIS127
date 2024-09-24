package unit06.Roulette;
import java.util.*;

public class RouletteGame {
    public static String[] valid = new String[39];

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(buildBoard()));
        Random numberMan = new Random();
        valid = ValidSet(valid);

        // Printing Quick Guide
        System.out.println(
            "Rules: \n" +
                "\tNo 00\n" +
                "\tPlace as many Bets as you like\n" +
            "\nPayout:\n" +
            "\tColor: 2x bet\n" +
            "\tNumber: 36x bet" +
            "\n\n"
        );

        // Collect Bets
            /*
            * Array of Bets
            * ArrayList <==
            */
        Bet[] bets = new Bet[0];

        Scanner better = new Scanner(System.in);

        // Enter bets
        System.out.print("Enter your bets ($ #/R/B, $ #/R/B, ...): ");
        String toParse = better.nextLine();
        String[] splitArray = toParse.split(", "); // Split Bets by Comma
        String[][] furtherSplit = new String[splitArray.length][2]; // Create array to store every bet by {amount, location}

        for (int i = 0; i < furtherSplit.length; i++) { // Split string into {amount, location}
            furtherSplit[i] = splitArray[i].split(" ");
        }
        for (String[] i : furtherSplit) { // Puts all the information into classes and checks if its correct
            int amount = Integer.parseInt(i[0]);
            String location = i[1];
            if (amount > 0) {
                if (isValid(location)) {
                    bets = Append(bets, new Bet(amount, location));
                }
            }
        }
        // Code for Testing to see if it works out correctly
        // boolean start = true;
        // String printedBets = "";
        // for (Bet i: bets) {
        //     if (!start) {
        //         printedBets += ", ";
        //     }
        //     start = false;
        //     printedBets += i.toString() + "";
        // }
        // System.out.println(printedBets);

        // Spin Wheel
        System.out.println("The wheel spins ...");
        int picked = numberMan.nextInt(0,37);
        String color = pickColor(picked);
        System.out.println("It lands on " + picked + " " + color);

        // Evaluate Winnings
        
        int winnings = 0;
        for (Bet bet : bets) {
            try {
                int num = Integer.parseInt(bet.getLocation());
                if (num == picked) {
                    winnings = winnings + bet.getAmount() * 36;
                }
            } catch (Exception e) {
                if ("" + color.toCharArray()[0] == bet.getLocation()) {
                    winnings = winnings + bet.getAmount() * 2;
                }
            }
        }
        System.out.print("You won $" + winnings);



        /* 
            All useless code because i made this wrong :)
        int count = 0;
        boolean breaker = false;
        String printedBets = "";
        while (true) {
            
            count++;
            // Bet Amount
            boolean cont = true;
            int amount = 0;
            while (cont) {
                System.out.print("How much for bet #" + count + "?: ");
                String checker = better.nextLine(); // Using an empty String to stop loop
                //System.out.print(checker);
                // Break loop if bet == ""
                cont = false;
                if (checker == "") {
                    System.out.println("Betting Ended");
                    breaker = true;
                    break;
                }
                try {
                    amount = Integer.parseInt(checker);
                    if (amount < 1) {
                        throw new ArithmeticException("Negative Number");
                    }
                }
                catch (Exception e) {
                    System.out.println("Number typed was not valid");
                    cont = true;
                }
            }
            if (breaker) {
                break;
            }
             
            //System.out.println();

            // Bet Location
            boolean go = true;
            String location = "";
            while (go) {
                go = false;
                System.out.print("What location or color?: ");
                String checker = better.nextLine(); // Using an empty String to stop loop
                //System.out.print(checker);
                if (isValid(checker)) {
                    location = checker;
                    go = false;
                } else {
                  System.out.println("Selection was not valid");
                  go = true;
                }
            }

            // Create Bet
            Bet bet = new Bet(amount, location);

            // Add to list of Bets (Wish we could use arrayLists)
            bets = Append(bets, bet);

            // Print out all bets
            boolean start = true;
            printedBets = "";
            for (Bet i: bets) {
                if (!start) {
                    printedBets += ", ";
                }
                start = false;
                printedBets += i.toString() + "";
            }
            System.out.println("\nPress enter when done with betting.");
            System.out.println("Current bets: " + printedBets + "\n\n");
        }
        */
        better.close();        

        
        

        // Output Bets
        
        

        // Spin Roulette Wheel

        // Pay Out
    }

    public static String[] buildBoard() {
        String[] board = new String[37];
        for (int i = 0; i != 37; i++) {
            if (i != 0) {
                if (i % 2 == 0) {
                    board[i] = i + "B";
                } else {
                    board[i] = i + "R";
                }
            } else {
                board[i] = i + "";
            }
        }
        return board;
    }

    public static String[] ValidSet(String[] set) {
        int i;
        for (i = 0; i != 37; i++) {
            set[i] = "" + i;
        }
        set[i] = "R";
        set[i + 1] = "B"; 
        
        return set;
    }

    public static boolean isValid(String test) {
        test = test.toUpperCase();
        for (String i : valid) {
            if (i.equals(test)) {
                return true;
            }
        }
        return false;
    }

    public static String pickColor(int i) {
        if (i == 0) {
            return "";
        } else {
            if (i % 2 == 0) {
                return "RED";
            } else {
                return "BLACK";
            }
        }
    }

    public static Bet[] Append(Bet[] arr, Bet item) {
        //Appends to the end of the list
        Bet[] returned = new Bet[arr.length + 1];
        
        for (int i = 0; i < arr.length; i++) {
            returned[i] = arr[i];
        }

        returned[arr.length] = item;
        return returned;
    }


}

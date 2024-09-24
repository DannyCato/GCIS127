package unit11.ggg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Makes the Greedy Greedy Goats game function
 * 
 * @author Danny Catorcini
 */
public class GreedyGreedyGoats {
    /**
     * main function
     * 
     * @param args I don't honestly know what these do
     * but i think i can figure it out soon
     * 
     */
    public static void main(String[] args) {
        Trough trough = new Trough(250);
        ArrayList<Thread> threads = new ArrayList<>();

        TurnipDropper dropper = new TurnipDropper(trough);
        Thread drop = new Thread(dropper);
        drop.start();
        threads.add(drop);

        Goat[] goats = new Goat[4];
        Goat cyan = new Goat(Color.CYAN, trough);
        goats[0] = cyan;
        Goat yellow = new Goat(Color.YELLOW, trough);
        goats[1] = yellow;
        Goat green = new Goat(Color.GREEN, trough);
        goats[2] = green;
        Goat orange = new Goat(Color.ORANGE, trough);
        goats[3] = orange;

        for (Goat g : goats) {
            Thread t = new Thread(g);
            t.start();
            threads.add(t);
        }

        while (true) {
            try {
                Thread.sleep(500);
                boolean check = true;
                for (Thread t : threads) {
                    if (t.isAlive()) {
                        check = false;
                    }
                }
                if (check) {
                    break;
                }
            }
            catch (InterruptedException ie) {}
        }

        print("The game is over! A total of " + trough.getTurnipsSoFar() + " turnips were dropped into the trough!");
        List<Goat> list = new ArrayList<>(Arrays.asList(goats));
        Collections.sort(list);
        int count = 0;
        for (Goat g : list) {
            print(g.toString() + " ate " + g.getTurnipsEaten() + " turnips!");
            count += g.getTurnipsEaten();
        }
        print("Together, the goats ate " + count + " turnips!");
        
        
    }

    /**
     * Helper function to limit writing extra unnecessary code
     * 
     * @param object compatible with any parameter that is not an array or list
     * 
     */
    private static void print(Object o) {
        System.out.println(o);
    }
}

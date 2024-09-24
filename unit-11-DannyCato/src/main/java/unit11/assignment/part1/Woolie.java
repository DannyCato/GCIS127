package unit11.assignment.part1;

import java.util.Random;

/**
 * Represents one Woolie that wants to cross a bridge.
 * 
 * @author Danny Catorcini
 */
public class Woolie extends Thread{
    /**
     * Name of the Woolie
     */
    private String name;

    /**
     * How long it takes to cross a bridge
     */
    private int timeToCross;

    /**
     * Town the Woolie Starts in
     */
    private String startingTown;

    /**
     * Town the Woolie ends in
     */
    private String endTown;

    /**
     * Creates a new Woolie with a name, time it takes to cross, starting town, and the bridge it will cross
     * 
     * @param name The String stored in the name
     * @param timeToCross The number of seconds to cross the bridge
     * @param startingTown The String stored as the Starting Town. Can only be "Courtwald" or "Glassdell"
     * @param startingTown The String stored as the End Town. Can only be "Courtwald" or "Glassdell" 
     * and must be the opposite of what startingTown is
     */
    public Woolie(String name, int timeToCross, String startingTown, String endTown) {
        this.name = name;
        this.timeToCross = timeToCross;
        this.startingTown = startingTown;
        this.endTown = endTown;
    }

    /**
     * Ran when a thread of Woolie is started
     * Prints the current state that the Woolie is 
     * in. All threads can run at the same time
     */
    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge at " + startingTown);
        System.out.println(name + " is starting to cross");
        sleepHelper(1000);
        for (int i = 1; i < timeToCross; i++) {
            sleepHelper(1000);
            System.out.println("\t" + name + ": " + (timeToCross - i) + " seconds");
        }
        System.out.println(name + " arrives at " + endTown);
        
    }

    /**
     * Helper class to avoid having a bunch of try-catch blocks adding to visual complexity
     */
    private void sleepHelper(int millis) {
        try {
                sleep(millis);
            } catch (InterruptedException e) {}
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        String[] names = {"Al", "Bert", "Char", "Def"};

        for (int i = 0; i < 4; i++) {
            String start, end;
            if (new Random().nextBoolean()) {
                start = "Courtwald";
                end = "Glassdell";
            } else {
                start = "Glassdell";
                end = "Courtwald";
            }

            Woolie t = new Woolie(names[i], new Random().nextInt(3,10), start, end);
            t.start();
        }
    }
}

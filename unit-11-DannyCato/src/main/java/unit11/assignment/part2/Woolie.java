package unit11.assignment.part2;

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
     * Town the Woolie will end up in after crossing the bridge
     */
    private String endTown;

    /**
     * Bridge object that the Woolie will cross
     */
    private Bridge bridge;

    /**
     * Creates a new Woolie with a name, time it takes to cross, starting town, and the bridge it will cross
     * 
     * @param name The String stored in the name
     * @param timeToCross The number of seconds to cross the bridge
     * @param startingTown The String stored as the Starting Town. Can only be "Courtwald" or "Glassdell"
     * @param bridge A bridge object
     */
    public Woolie(String name, int timeToCross, String startingTown, Bridge bridge) {
        this.name = name;
        this.timeToCross = timeToCross;
        this.startingTown = startingTown;
        if (startingTown.equals("Courtwald")) {
            this.endTown = "Glassdell";
        } else {
            this.endTown = "Courtwald";
        }
        this.bridge = bridge;
    }

    /**
     * Ran when a thread of Woolie is started
     * Prints the current state that the Woolie is 
     * in. Synchronizes on the shared Bridge object 
     * and if not halted will continue to print every
     * second that it prints. 
     */
    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge at " + startingTown);
        synchronized(bridge) {
            bridge.enterBridge(this);
            System.out.println(name + " is starting to cross");
            for (int i = 0; i < timeToCross; i++) {
                sleepHelper();
                System.out.println("\t" + name + ": " + (timeToCross - i) + " seconds");
            }
            sleepHelper();
            System.out.println(name + " arrives at " + endTown);
            bridge.leaveBridge(this);
        }   
    }

    /**
     * Helper class to avoid having a bunch of try-catch blocks adding to visual complexity
     */
    private void sleepHelper() {
        try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        String[] names = {"Al", "Bert", "Char", "Def"};
        Bridge bridge = new Bridge();
        for (int i = 0; i < 4; i++) {
            String start;
            if (new Random().nextBoolean()) {
                start = "Courtwald";
            } else {
                start = "Glassdell";
            }

            Woolie t = new Woolie(names[i], new Random().nextInt(3,10), start, bridge);
            t.start();
        }
    }
}

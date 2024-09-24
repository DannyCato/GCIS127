package unit11.ggg;

/**
 * Represents a goat that is eating from a trough
 * 
 * @author Danny Catorcini
 * 
 */
public class Goat implements Runnable, Comparable<Goat>{

    /**
     * Color of the Goat
     * 
     */
    private Color color;

    /**
     * Trough the goat will eat from
     * 
     */
    private Trough trough;

    /**
     * number of turnips eaten
     * 
     */
    private int turnipsEaten;

    /**
     * Constructor for Goat
     * 
     * @param color Color Enum
     * @param trough Trough obejct that the goat will eat from
     * 
     */
    public Goat(Color color, Trough trough) {
        this.color = color;
        this.trough = trough;
        turnipsEaten = 0;
    }

    /**
     * Loops continuously until the trough is at its limit. While
     * looping it will wait for turnips to become available and
     * attempt to eat them
     * 
     */
    @Override
    public void run() {
        while (!(trough.atLimit())) {
            synchronized(trough) {
                waitForTurnips();
                while (keepEating()) {
                    tryToEat();
                }
            }
        }
    }

    /**
     * Returns a String representation of the Goat
     * 
     * @return a String representation of the Goat
     * 
     */
    @Override
    public String toString() {
        return "The " + color.toString() + " goat";
    }

    /**
     * Returns a boolean of if the trough is empty
     * 
     * @return if the trough is empty
     * 
     */
    protected boolean keepEating() {
        return !trough.isEmpty();
    }

    /**
     * Wait cycle for a Goat. If the trough is not 
     * empty and has not dispensed all its turnips 
     * it will make the goats wait until they are 
     * dropped. When it waits it outputs a string
     * 
     */
    protected void waitForTurnips() {
        if (!(trough.atLimit()) && trough.isEmpty()) { // wait
            try {
                print(this.toString() + " is waiting for more turnips");
                trough.wait();
            } catch (InterruptedException ie) {}
        }
    }

    /**
     * Tells the Goat to eat. If it can eat it increments
     * and outputs a string
     * 
     */
    protected void tryToEat() {
        if(trough.eat()) {
            turnipsEaten++;
            print(toString() + " has eaten a turnip");
        }
    }

    /**
     * Returns the field of the number of turnips eaten
     * 
     * @return the number of turnips eaten
     * 
     */
    public int getTurnipsEaten() {
        return turnipsEaten;
    }

    /**
     * Helper function to limit writing extra unnecessary code
     * 
     * @param object compatible with any parameter that is not an array or list
     * 
     */
    private void print(Object object) {
        System.out.println(object);
    }

    /**
     * Returns an int based comparing the number of Turnips 
     * eaten. Implementation of compareTo to make 
     * Collections.sort work in the future
     * 
     * @param goat the goat to be compared against
     * 
     * @return the compared int
     * 
     */
    @Override
    public int compareTo(Goat goat) {
        return goat.turnipsEaten - this.turnipsEaten;
    }
    
}

package unit11.ggg;

/**
 * A class representing a food trough used to feed goats. There is a limit on
 * the maximum number of turnips that may be dropped into the trough before it
 * needs to be inspected and cleaned. 
 * 
 * This class is not threadsafe. DO NOT modify the class.
 */
public class Trough {
    /**
     * The maximum limit of turnips that may be dropped into the trough before
     * it must be inspected, cleaned, and maintained.
     */
    private final int turnipLimit;

    /**
     * The number of turnips that have been dropped into the trough since its
     * last inspection.
     */
    private int turnipsSoFar;

    /**
     * The number of turnips currently in the trough that have yet to be eaten.
     */
    private int currentTurnips;

    /**
     * Creates a new trough with the specified limit.
     * 
     * @param turnipLimit The maximum number of turnips that may be dropped 
     * into the trough before it must be cleaned and maintained.
     */
    public Trough(int turnipLimit) {
        this.turnipLimit = turnipLimit;
        this.turnipsSoFar = 0;
        this.currentTurnips = 0;
    }

    /**
     * Returns the total number of turnips that have been dropped into the
     * trough since its last cleaning and inspection.
     * 
     * @return The turnips that have been dropped into the trough so far.
     */
    public int getTurnipsSoFar() {
        return this.turnipsSoFar;
    }

    /**
     * Returns true if the number of turnips that have been dropped into the
     * trough since its last cleaning and inspection has reached the maximum
     * limit. No additional turnips should be dropped into the trough if the
     * limit has been reached!
     * 
     * @return True if the number of turnips dropped so far has reached the
     * maximum limit, and false otherwise. 
     */
    public boolean atLimit() {
        return this.turnipsSoFar >= this.turnipLimit;
    }

    /**
     * Returns true if the trough is empty, i.e. all of the turnips dropped 
     * into the trough have been eaten.
     * 
     * @return True if the trough is empty, false if there is at least one
     * turnip in the trough.
     */
    public boolean isEmpty() {
        return this.currentTurnips <= 0;
    }

    /**
     * Drops a turnip into the trough iff the maximum limit has not been 
     * reached. If the limit has been reached, the turnip will be rejected.
     */
    public void drop() {
        if(!atLimit()) {
            this.currentTurnips += 1;
            this.turnipsSoFar += 1;
        } 
    }

    /**
     * Allows a goat to stick its head into the trough to try to eat one of the
     * turnips contained therein. The trough may be empty, in which case the
     * goat will not eat a turnip.
     * 
     * @return True if the goat successfully ate a turnip. If the trough is
     * empty, the goat will leave hungry (and the method will return false).
     * 
     */
    public boolean eat() {
        if(currentTurnips > 0) {
            currentTurnips--;
            return true;
        } else {
            return false;
        }
    }
}

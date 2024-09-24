package unit11.ggg;

import java.util.Random;

/**
 * Represents a turnip dropper that is dropping turnips into a trough
 * 
 * @author Danny Catorcini
 * 
 */
public class TurnipDropper implements Runnable {

    /**
     * Trough the droppers will drop into
     * 
     */
    private Trough trough;

    /**
     * Constructor for TurnipDropper
     * 
     * @param trough Trough obejct that the goat will eat from
     * 
     */
    public TurnipDropper(Trough trough) {
        this.trough = trough;
    }
    
    /**
     * Loops continuously until the trough is at its limit. While
     * looping it will occasionally drop turnips into the trough.
     * It waits 1-250 milliseconds before it loops over. Outputs a 
     * string at the end of the cycle
     * 
     */
    @Override
    public void run() {
        while (keepDropping()) {
            synchronized(trough) {
                if(keepDropping()) {
                    dropTurnips();
                }
            }
            try {
                Thread.sleep(new Random().nextInt(1,250));
            } catch (InterruptedException ie) {}
        }
        print("the turnip dropper has run out of turnips");
    }

    /**
     * Checks to see if the trough is at its limit.
     * 
     * @return true if trough is at not its limit
     * 
     */
    protected boolean keepDropping() {
            return !trough.atLimit();
    }

    /**
     * First checks if it can drop more turnips, if it cannot then the loop ends.
     * Else it randomly chooses 1-3 turnips to drop, then outputs how many turnips
     * it ended up dropping
     * 
     */
    protected void dropTurnips() {
        if (trough.atLimit()) {
            print("the turnip dropper has run out of turnips");
        } else {
            int actualDropNum = 0;
            int dropNum = new Random().nextInt(1,4);
            for (int i = 0; i < dropNum; i++) {
                synchronized (trough) {
                    if (trough.atLimit()) {
                        break;
                    }
                    trough.drop();
                    trough.notifyAll();
                    actualDropNum++;
                }
            }
            print("the dropper drops " + actualDropNum + " turnips into the trough");
        }
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
}

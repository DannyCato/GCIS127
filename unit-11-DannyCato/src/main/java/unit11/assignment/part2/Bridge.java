package unit11.assignment.part2;

/**
 * The bridge that Woolies will cross
 * 
 * @author Danny Catorcini
 */
public class Bridge {
    /**
     * The Woolie currently on the bridge
     */
    private Woolie onBridge;

    /**
     * All Woolie Threads will call this to cross the bridge one at a time.
     * If no other Woolie is on the bridge, the Woolie will be set to on bridge 
     * and begin to cross. Otherwise, it will be halted and wait until the Woolie 
     * finishes crossing
     * 
     * @param wool the Woolie calling the method
     */
    public void enterBridge(Woolie wool) {
        if (onBridge == null) {
            this.onBridge = wool;
        } else {
            try {
                this.wait();
            } catch (InterruptedException ie) {

            }
        }
    }

    /**
     * Once a Woolie thread has crossed the bridge it call this 
     * method. It removes it from being on the current bridge and
     * notifies one of the other Woolies that it is time to cross
     * 
     * @param wool the Woolie calling the method. Used to make sure the correct Woolie is calling it
     */
    public void leaveBridge(Woolie wool) {
        if (onBridge == wool) {
            this.onBridge = null;
            this.notify();
        }
    }
}

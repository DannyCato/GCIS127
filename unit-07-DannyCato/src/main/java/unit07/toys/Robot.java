package unit07.toys;

public class Robot extends Toy{
    private int charge;
    private String sound;

    public Robot(Double MSRP, int charge, String sound) {
        super("Robot", MSRP);
        this.charge = charge;
        this.sound = sound;
    }

    public void charge(int power) {
        charge = Math.min(charge + power, 100);
    }

    public void play() {
        if (charge > 0) {
            System.out.println(this.sound);
            charge = Math.max(charge-20, 0);
        }
    }

    @Override
    public String toString() {
        return "a robot, " + this.getName() + "/" + this.getProductCode() + " at price " + this.getMSRP()
        + ". The robot is at " + charge + "% and plays a " + sound + " sound";
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
    
}
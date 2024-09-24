package unit07.toys;

import java.util.Random;

public class ActionFigure extends Doll {
    private boolean KungFuGrip;

    public ActionFigure(double MSRP, String hair, String eyecolor, String[] sayings, boolean KungFuGrip) {
        super("Action Figure", MSRP, hair, eyecolor, sayings);

    }

    public String hasKungFuGrip() {
        return (KungFuGrip) ? "with sword" : "without sword";
    }

    public void play() {
        if (this.getPlays() > 10) {
            int rand = new Random().nextInt(0, this.getSayings().length);
            System.out.println(this.getSayings()[rand] + hasKungFuGrip());
        } else {
            System.out.println("Toy is broken");
        }
    }

    @Override
    public String toString() {
        return "an Action Figure, " + this.getName() + "/" + this.getProductCode() + " at price " + this.getMSRP()
        + ". The Action Figure " + hasKungFuGrip()+ " has " + this.getHair() + " color hair, " + this.getEyecolor() + " eyes, and has " + this.getSayings().length + "sayings";
    }

    public boolean isKungFuGrip() {
        return KungFuGrip;
    }

    public void setKungFuGrip(boolean kungFuGrip) {
        KungFuGrip = kungFuGrip;
    }
}

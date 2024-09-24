package unit07.toys;

import java.util.Random;

public class Doll extends Toy{
    private String hair;
    private String eyecolor;
    private String[] sayings;
    private int plays;

    public Doll(double MSRP, String hair, String eyecolor, String[] sayings) {
        super("Doll", MSRP);
        this.hair = hair;
        this.eyecolor = eyecolor;
        this.sayings = sayings;
    }

    protected Doll(String ActionFigure, double MSRP, String hair, String eyecolor, String[] sayings) {
        super(ActionFigure, MSRP);
        this.hair = hair;
        this.eyecolor = eyecolor;
        this.sayings = sayings;
    }

    public void play() {
        if (plays > 10) {
            int rand = new Random().nextInt(0, sayings.length);
            System.out.println(sayings[rand]);;
        } else {
            System.out.println("Toy is broken");
        }
    }

    @Override
    public String toString() {
        return "a Doll, " + this.getName() + "/" + this.getProductCode() + " at price " + this.getMSRP()
        + ". The Doll has " + this.hair + " color hair, " + eyecolor + " eyes, and has " + sayings.length + " sayings";
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String[] getSayings() {
        return sayings;
    }

    public void setSayings(String[] sayings) {
        this.sayings = sayings;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }
    
}
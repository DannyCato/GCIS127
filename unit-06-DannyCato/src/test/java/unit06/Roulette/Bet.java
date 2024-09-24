package unit06.Roulette;

public class Bet {
    private int amount;
    private String location;

    public Bet(int amount, String location) {
        this.amount = amount;
        this.location = location;
    }

    public int getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getAmount() + " " + getLocation();
    }
}

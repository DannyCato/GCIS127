package unit07.parser;

public class Constant implements Expression{
    public double constant;

    public Constant(double constant) {
        this.constant = constant;
    }

    public double evaluate() {
        return constant;
    }

    // public static void main(String[] args) {
    //     Constant con = new Constant(5);
    //     System.out.println(con.evaluate());
    // }
}
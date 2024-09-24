package unit07.parser;

public class Increment implements Expression {
    public final Expression init;

    public Increment(Expression init) {
        this.init = init;
    }

    public double evaluate() {
        return init.evaluate() + 1;
    }

    // public static void main(String[] args) {
    //     System.out.println(new Increment(new Constant(5)).evaluate());
    // }
}
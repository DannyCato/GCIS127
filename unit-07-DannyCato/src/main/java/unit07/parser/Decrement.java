package unit07.parser;

public class Decrement implements Expression {
    public final Expression init;

    public Decrement(Expression init) {
        this.init = init;
    }

    public double evaluate() {
        return init.evaluate() - 1;
    }
}
package unit07.parser;

public class Subtraction implements Expression {
    public final Expression init1;
    public final Expression init2;

    public Subtraction(Expression init1, Expression init2) {
        this.init1 = init1;
        this.init2 = init2;
    }

    public double evaluate() {
        return init1.evaluate() - init2.evaluate();
    }
}

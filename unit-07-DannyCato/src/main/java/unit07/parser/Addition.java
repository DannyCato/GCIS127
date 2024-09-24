package unit07.parser;

public class Addition implements Expression {
    public final Expression init1;
    public final Expression init2;

    public Addition(Expression init1, Expression init2) {
        this.init1 = init1;
        this.init2 = init2;
    }

    public double evaluate() {
        return init1.evaluate() + init2.evaluate();
    }

    // public static void main(String[] args) {
    //     System.out.println(new Addition(new Increment(new Constant(5)), new Constant(5)).evaluate());
    // }
}

package unit08.mcf;
import java.util.Arrays;

public class ArrayStack implements Stack {
    private String[] stack = new String[3];
    private int top;
    
    public ArrayStack(String n) {
        this.stack[0] = n;
        top = 1;
    }

    public void push(String value) {
        stack[top] = value;
        top++;
    }

    public String pop() {
        String n = stack[top - 1];
        stack[top - 1] = null;
        top--;
        return n;
    }

    public String top() {
        return stack[top - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

    public int size() {
        return top;
    }
}

package unit08.mcf;

public class FibonacciRange implements Range
/*
 * Offers a Range that loops through the fibonacci sequence
 */
{
    private int depth;

    public FibonacciRange(int depth) {
        this.depth = depth;
    }

    @Override
    /*
     * Returns the maximum depth of the instance
     */
    public int size() {
        return depth;
    }

    @Override
    public Integer get(int n) 
    /*
     * Returns an integer at the designated index based on the fibonacci sequence
     * Throws IndexOutOfBoundsException if out of range
     */
    {
        if (n < depth) {
            return fibonacci(n);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int fibonacci(int n)
    /*
     * Starter for the algorithm so that I can keep compatability and make it easier to call
     */
    {
        return fibonacci(n, 0, 1);
    }

    private int fibonacci(int n, int a, int b)  
    /*
     * Easy algorithm to hopefully find the fibonacci sequence quickly
     * Translated into java, but based on https://stackoverflow.com/a/13826877
     */
    {
        if (n > 0) {
            return fibonacci(n-1, b, b+a);
        }
        return a;
    }

    @Override
    public RangeIterator iterator() 
    /*
     * returns RangeIterator of object to make compatible with for-each loops
     */
    {
        return new RangeIterator(this);
    }

    public static void main(String[] args) {
        // 1
        System.out.println("first 45 numbers of fibonacci sequence");
        for (int i : new FibonacciRange(45)) {
            System.out.println(i);
        }
        System.out.println();
    }
}

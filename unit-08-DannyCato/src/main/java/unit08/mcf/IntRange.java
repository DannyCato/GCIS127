package unit08.mcf;

public class IntRange implements Range
/*
 * Implements a range function that works similarly to python's Range function
 * Construct with (Stop), (Start,Stop), (Start,Stop,Step)
 */
{
    private int start;
    private int stop;
    private int step;

    public IntRange(int stop) 
    /* 
     * Needs (int stop) 
     * Starts at 0 and steps by one
     */
    {
        this.start = 0;
        this.stop = stop;
        this.step = 1;
    }

    public IntRange(int start, int stop) 
    /* 
     * Needs (int start, int stop) 
     * Steps by 1
     */
    {
        this.start = start;
        this.stop = stop;
        this.step = 1;
    }

    public IntRange(int start, int stop, int step) 
    /* Needs (int start, int stop, int step) */
    {
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    @Override
    public int size() 
    /*
     * Returns the number of numbers that will by given by this instance
     */
    {
        int guess = (stop - start) / step;
        if (guess % step == 0) {
            return guess;
        }
        return guess + 1;
    }

    @Override
    public Integer get(int n) 
    /*
     * Returns an integer at the designated in the sequence
     * Throws IndexOutOfBoundsException if out of range
     */
    {
        if (n < this.size() && n >= 0) {
            return (n * step) + start;
        } else {
            throw new IndexOutOfBoundsException();
        }
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
        System.out.println("Test 1\n0, 15, 3: {0,3,6,9,12,15}");
        for (int i : new IntRange(0, 15, 3)) {
            System.out.println(i);
        }
        System.out.println();
        
        // 2
        System.out.println("Test 2\n0, 14, 3: {0,3,6,9,12}");
        for (int i : new IntRange(0, 14, 3)) {
            System.out.println(i);
        }
        System.out.println();

        // 3
        System.out.println("Test 3\n5: {0,1,2,3,4}");
        for (int i : new IntRange(5)) {
            System.out.println(i);
        }
        System.out.println();
        
        // 2
        System.out.println("Test 4\n3, 14, 5: {3,8,13}");
        for (int i : new IntRange(3, 14, 5)) {
            System.out.println(i);
        }
        System.out.println();
    }

}

package unit08.mcf;

import java.util.Iterator;

public class RangeIterator implements Iterator<Integer>
/*
 * It implements an iterator for the Range interface
 */
{
    private Range range;
    private int cursor;
    

    public RangeIterator(Range range) {
        this.range = range;
        this.cursor = 0;
    }
    
    @Override
    public boolean hasNext() 
    /*
     * Checks to see if the iterator has another object to check
     */
    {
        try {
            return (range.size() > cursor);
        } 
        catch(Exception IndexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public Integer next() 
    /*
     * returns the next int in the iteration
     */
    {
        int next = range.get(cursor);
        cursor++;
        return next;
    }
}

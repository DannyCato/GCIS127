package unit12.practicum;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timer implements Runnable{
    private String name;
    private List<Integer> list;
    private int numberOfValues;

    public Timer(String name, List<Integer> list, int numberOfValues) {
        this.name = name;
        this.list = list;
        this.numberOfValues = numberOfValues;
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfValues; i++) {
            list.add(0);
        }
        long elasped = System.nanoTime() - start;
        System.out.println("Filled " + name + " with " + String.format("%,d", numberOfValues) + " in " + elasped + " nanoseconds");
    }

    public static void main(String[] args) {
        Thread arrayList = new Thread(new Timer("ArrayList", new ArrayList<Integer>(), 1000));
        arrayList.start();
        try {
            arrayList.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread vector = new Thread(new Timer("Vector", new Vector<Integer>(), 1000));
        vector.start();
        try {
            vector.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Vector is made thread-safe from the start so accessing values 
     * when in a threaded context can be faster when compared to the
     * standard non-thread-safe JCF
     */
}

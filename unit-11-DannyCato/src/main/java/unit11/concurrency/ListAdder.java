package unit11.concurrency;

import java.util.ArrayList;
import java.util.Random;

public class ListAdder implements Runnable{
    private ArrayList<Integer> sharedList;
    private int num;

    public ListAdder(ArrayList<Integer> sharedList, int num) {
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized(sharedList) {
                sharedList.add(new Random().nextInt(num)); // critical, uses shared resource
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> bruh = new ArrayList<>();

        Thread[] listAdders = new Thread[100];
        for (int i = 0; i < 100; i++) {
            ListAdder listAdder = new ListAdder(bruh, 15);
            Thread t = new Thread(listAdder);
            listAdders[i] = t;
            t.start();
        }

        for (Thread t : listAdders) {
            try {
                t.join();
            } 
            catch (InterruptedException e) {

            }
        }
        System.out.println(bruh.size());

    }
}

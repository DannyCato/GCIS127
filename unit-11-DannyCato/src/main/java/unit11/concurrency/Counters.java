package unit11.concurrency;

import java.util.Scanner;

public class Counters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Num of threads: ");
        int j = scan.nextInt();
        scan.close();
        System.out.println("");


        Thread[] threads = new Thread[j];

        for (int i = 0; i < j; i++) {
            RunnableCounter obj = new RunnableCounter("" + (i + 1));
            Thread run = new Thread(obj);
            threads[i] = run;
            run.start();            
        }

        for (Thread t : threads) {
            try {
                    t.join();
            }
            catch (InterruptedException e) {
                
            }
        }
    }
}

package unit11.concurrency;

import java.util.LinkedList;

public class Consumer extends Thread{
    private LinkedList<String> queue;
    private int id;
    
    public Consumer(LinkedList<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(queue) {
                while (!queue.isEmpty()) {
                    String current = queue.removeFirst();
                    System.out.println(current + "\t" + id);
                }
                System.out.println(id + " waiting for work");
                try {
                    queue.wait();
                }
                catch (InterruptedException ie) {}
            }
        }
        
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("man");
        list.add("what");
        list.add("massive brug");

        Consumer t = new Consumer(list, 1);
        t.run();
    }
}

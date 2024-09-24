package unit11.concurrency;

public class CounterThread extends Thread {
    private String name;

    public CounterThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        CounterThread counter = new CounterThread("greaf");
        int count = 0;
        counter.start();
        while (counter.isAlive()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                
            }
            count++;
        }
        for (int i = 65; i < 91; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println(count);
    }
}

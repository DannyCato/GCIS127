package unit11.concurrency;

public class RunnableCounter implements Runnable{
    private String name;

    public RunnableCounter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        RunnableCounter man = new RunnableCounter("gragamy");
        Thread thread = new Thread(man);
        thread.start();
    }
}

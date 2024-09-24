package unit11.concurrency;

public class Countdown implements Runnable{
    @Override
    public void run() {
        int time = 10;
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            while (time > -10) {
                String val = "";
                if (time > 0) {
                    val = "+";
                } else if (time < 0) {
                    val = "-";
                } else {
                    System.out.println("liftoff");
                    continue;
                }
                System.out.println("T" + val + Integer.parseInt("" + Math.abs(time)));
                time--;
            }
        }
        
    }
}

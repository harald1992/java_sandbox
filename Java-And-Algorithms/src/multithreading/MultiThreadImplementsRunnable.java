package multithreading;

import static java.lang.Thread.sleep;

public class MultiThreadImplementsRunnable implements Runnable{

    private final int threadNumber;

    public MultiThreadImplementsRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        // count until 5
        for (int i = 0; i < 5; i++) {
            System.out.println(threadNumber + ": count = " + i);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }}
}

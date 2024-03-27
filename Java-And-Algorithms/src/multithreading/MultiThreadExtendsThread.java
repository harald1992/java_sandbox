package multithreading;

public class MultiThreadExtendsThread extends Thread{

    private final int threadNumber;

    public MultiThreadExtendsThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        // count until 5
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadNumber " + threadNumber + "count = " + i);
            if (threadNumber == 3) throw new RuntimeException();    // this does not kill all other threads.

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

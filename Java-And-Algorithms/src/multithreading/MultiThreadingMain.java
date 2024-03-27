package multithreading;

public class MultiThreadingMain {

    public static void multiThreadingStart() {

        // extend thread, if you extend Thread you cannot implement other methods.
        // for (int i = 0; i < 5; i++) {
        //     MultiThreadExtendsThread myThing = new MultiThreadExtendsThread(i);
        //     myThing.start();    // start so it does it multithreaded (don't use run)
        // }

        // implements runnable, that way you can implement other interfaces in that class, but you have to create a thread to start it.
        for (int i = 0; i < 5; i++) {
            MultiThreadImplementsRunnable myThing2 = new MultiThreadImplementsRunnable(i);
            Thread myThread = new Thread(myThing2);
            myThread.start();
            try {
                myThread.join(); // wait for the thread to complete, this will make the for loop basically sync again.
            } catch (InterruptedException ignored) {}
            System.out.println("Finished");
        }
    }

}

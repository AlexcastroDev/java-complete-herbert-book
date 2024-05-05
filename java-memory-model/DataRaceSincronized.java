public class DataRaceSincronized {
    boolean ready = false;
    int answer = 0;

    public synchronized void thread1() {
        while (!ready) {
            // Busy-waiting
        }
        assert answer == 42 : "Assertion failed - answer is not 42";
        System.out.println("Thread 1: Answer read as " + answer);
    }

    public synchronized void thread2() {
        answer = 42;
        ready = true;
        System.out.println("Thread 2: Set answer to 42 and ready to true");
    }

    public static void main(String[] args) {
        DataRaceSincronized race = new DataRaceSincronized();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                race.thread1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                race.thread2();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Threads interrupted");
        }
    }
}
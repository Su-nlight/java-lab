public class SynchronizedErrorHandlingExample {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        // Create multiple threads
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkerThread(counter);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Main thread interrupted.");
            }
        }

        System.out.println("Final Counter: " + counter.getCounter());
    }
}

class SharedCounter {
    private int counter = 0;

    // Synchronized method to safely increment the counter
    public synchronized void increment() throws Exception {
        // Simulate an exception scenario
        if (counter == 5) {
            throw new Exception("Counter reached an invalid value: " + counter);
        }
        counter++;
        System.out.println(Thread.currentThread().getName() + " - Counter: " + counter);
    }

    public int getCounter() {
        return counter;
    }
}

class WorkerThread extends Thread {
    private final SharedCounter sharedCounter;

    public WorkerThread(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        try {
            sharedCounter.increment();
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName() + " - Error: " + e.getMessage());
        }
    }
}



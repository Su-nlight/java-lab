//implement error handling techniques using multithreading
public class MultithreadingExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task(10));
        Thread t2 = new Thread(new Task(0));  // Will cause exception
        Thread t3 = new Thread(new Task(5));

        t1.start();
        t2.start();
        t3.start();
    }
}

class Task implements Runnable {
    private int value;

    public Task(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " started.");
            
            // Simulated risky operation (could throw ArithmeticException)
            int result = 100 / value;

            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception in thread " + Thread.currentThread().getName() + ": " + e.getMessage());
        } finally {
            System.out.println("Thread " + Thread.currentThrea
            d().getName() + " completed.");
        }
    }
}


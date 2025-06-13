import java.util.Scanner;

public class ErrorHandlingDemo {

    // Method that can throw an exception
    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking input from user
            System.out.print("Enter numerator: ");
            int num = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int den = scanner.nextInt();

            // May throw ArithmeticException
            int result = divide(num, den);
            System.out.println("Result: " + result);

            // Array operation to show another exception
            int[] arr = new int[3];
            System.out.println("Accessing 5th element: " + arr[4]); // Will throw exception

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        } catch (Exception e) {
            System.out.println("Some other error occurred: " + e.getMessage());
        } finally {
            System.out.println("This block is always executed (finally block).");
            scanner.close();
        }
    }
}

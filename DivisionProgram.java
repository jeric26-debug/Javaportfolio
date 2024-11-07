import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt for the first number
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            // Prompt for the second number
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            // Perform the division
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}
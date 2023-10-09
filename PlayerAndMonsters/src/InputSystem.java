import java.util.InputMismatchException;
import java.util.Scanner;

public class InputSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static int select(String message, int min, int max) {
        int val = -1;
        do {
            try {
                System.out.println(message);
                val = scanner.nextInt();
            } catch (InputMismatchException e) {
                val = -1;
                scanner.next(); // Consume invalid input to prevent an infinite loop
            }
        } while (val < min || val > max);
        return val;
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();

        if (PasswordChecker.isStrongPassword(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak. Recommendations to make it stronger:");
            PasswordChecker.printPasswordRequirements(password);
        }

        int crackTime = PasswordChecker.estimateCrackTime(password);
        System.out.println("Estimated time to crack password: " + PasswordChecker.formatTime(crackTime));
    }
}

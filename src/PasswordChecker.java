import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();

        PasswordRequirements passwordValidator = new PasswordValidator();
        PasswordStrengthEstimator passwordStrengthEstimator = new ConcretePasswordStrengthEstimator();

        if (passwordValidator.isStrongPassword(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak. Recommendations to make it stronger:");
            passwordValidator.printPasswordRequirements(password);
        }

        int crackTime = passwordStrengthEstimator.estimateCrackTime(password);
        System.out.println("Estimated time to crack password: " + passwordStrengthEstimator.formatTime(crackTime));
    }
}

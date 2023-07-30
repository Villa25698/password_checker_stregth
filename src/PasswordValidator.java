import java.util.regex.Pattern;

public class PasswordValidator implements PasswordRequirements {
    private static final int MIN_LENGTH = 14;

    @Override
    public boolean isStrongPassword(String password) {
        if (password.length() < MIN_LENGTH) {
            System.out.println("Warning: Password is too short. It should be at least 14 characters long.");
            return false;
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            System.out.println("Warning: APassword should contain at least one uppercase letter.");
            return false;
        }

        if (!Pattern.compile("\\d").matcher(password).find()) {
            System.out.println("Warning: Password should contain at least one digit.");
            return false;
        }

        if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
            System.out.println("Warning: Password should contain at least one symbol.");
            return false;
        }

        return true;
    }

    @Override
    public void printPasswordRequirements(String password) {
        if (password.length() < MIN_LENGTH) {
            System.out.println("- Password should be at least 14 characters long.");
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            System.out.println("- Password should contain at least one uppercase letter.");
        }

        if (!Pattern.compile("\\d").matcher(password).find()) {
            System.out.println("- Password should contain at least one digit.");
        }

        if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
            System.out.println("- Password should contain at least one symbol.");
        }
    }
}

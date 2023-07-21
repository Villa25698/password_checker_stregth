import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();

        if (isStrongPassword(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak. Recommendations to make it stronger:");
            PasswordChecker.printPasswordRequirements(password);
        }

        int crackTime = estimateCrackTime(password);
        System.out.println("Estimated time to crack password: " + formatTime(crackTime));
    }

    public static boolean isStrongPassword(String password) {
        // sjekk lengden
        if (password.length() < 8) {
            System.out.println("Warning: Password is too short. It should be at least 8 characters long.");
            return false;
        }

        // sjekk om den har store bokstaver
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Warning: Password should contain at least one uppercase letter.");
            return false;
        }

        // sjekk om den har tall
        if (!password.matches(".*\\d.*")) {
            System.out.println("Warning: Password should contain at least one digit.");
            return false;
        }

        // sjekk om den har symboler
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("Warning: Password should contain at least one symbol.");
            return false;
        }

        return true;
    }

    public static int estimateCrackTime(String password) {
        int charsetSize = 95; // Utskrivbare ASCII-tegn fra ' ' (32) til '~' (126)
        int passwordLength = password.length();
        double combinations = Math.pow(charsetSize, passwordLength);
        // Forutsetninger for sprekkehastighet: 10^9 (en milliard) kombinasjoner per sekund kilde: https://www.scientificamerican.com/article/the-mathematics-of-hacking-passwords/
        double secondsToCrack = combinations / 1e9;

        return (int) secondsToCrack;
    }

    public static String formatTime(int seconds) {
        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int years = days / 365;

        if (years >= 1) {
            return years + " years";
        } else if (days >= 1) {
            return days + " days";
        } else if (hours >= 1) {
            return hours + " hours";
        } else if (minutes >= 1) {
            return minutes + " minutes";
        } else {
            return seconds + " seconds";
        }
    }

    public static void printPasswordRequirements(String password) {
        if (password.length() < 8) {
            System.out.println("- Password should be at least 8 characters long.");
        }

        if (!password.matches(".*[A-Z].*")) {
            System.out.println("- Password should contain at least one uppercase letter.");
        }

        if (!password.matches(".*\\d.*")) {
            System.out.println("- Password should contain at least one digit.");
        }

        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("- Password should contain at least one symbol.");
        }
    }
}

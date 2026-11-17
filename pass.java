
import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {

    public static Object[] checkPasswordStrength(String password) {

        int strength = 0;
        String remarks;

        // Criteria
        if (password.length() >= 8) {
            strength++;
        }

        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            strength++;
        }

        if (Pattern.compile("[a-z]").matcher(password).find()) {
            strength++;
        }

        if (Pattern.compile("[0-9]").matcher(password).find()) {
            strength++;
        }

        if (Pattern.compile("[!@#$%^&*(),.?\":{}|<>]")
                .matcher(password).find()) {
            strength++;
        }

        // Rating
        if (strength <= 2) {
            remarks = "Weak";
        } else if (strength == 3) {
            remarks = "Moderate";
        } else if (strength == 4) {
            remarks = "Strong";
        } else {
            remarks = "Very Strong";
        }

        return new Object[]{strength, remarks};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Object[] result = checkPasswordStrength(password);

        int score = (int) result[0];
        String rating = (String) result[1];

        System.out.println("\nPassword Strength Score: " + score + " / 5");
        System.out.println("Password Strength: " + rating);

        scanner.close();
    }
}

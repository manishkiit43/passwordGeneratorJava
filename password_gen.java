package my_project;

import java.util.Scanner;
import java.security.SecureRandom;

public class password_gen {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_-+=<>?/{}~|";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        System.out.println("Should the password include numbers? (yes/no): ");
        String numbers = scanner.next().equalsIgnoreCase("yes") ? NUMBERS : "";
        System.out.println("Should the password include lowercase letters? (yes/no): ");
        String lowercase = scanner.next().equalsIgnoreCase("yes") ? LOWERCASE : "";
        System.out.println("Should the password include uppercase letters? (yes/no): ");
        String uppercase = scanner.next().equalsIgnoreCase("yes") ? UPPERCASE : "";
        System.out.println("Should the password include special characters? (yes/no): ");
        String specialChars = scanner.next().equalsIgnoreCase("yes") ? SPECIAL_CHARS : "";
        String password = generatePassword(length, numbers + lowercase + uppercase + specialChars);
        System.out.println("Your new password is: " + password);
        scanner.close();
    }

    private static String generatePassword(int length, String characters) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(RANDOM.nextInt(characters.length())));
        }
        return password.toString();
    }
}
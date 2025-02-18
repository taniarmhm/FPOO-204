import javax.swing.*;
import java.security.SecureRandom;

public class Main {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

    public static void main(String[] args) {
        int length = getPasswordLength();
        boolean includeUppercase = getYesNoOption("¿Incluir mayúsculas?");
        boolean includeSpecials = getYesNoOption("¿Incluir caracteres especiales?");

        String password = generatePassword(length, includeUppercase, includeSpecials);
        String strength = checkPasswordStrength(password);

        JOptionPane.showMessageDialog(null, "Contraseña generada: " + password + "\nFortaleza: " + strength);
    }

    private static int getPasswordLength() {
        String input = JOptionPane.showInputDialog("Introduce la longitud de la contraseña (mínimo 8):", "8");
        try {
            int length = Integer.parseInt(input);
            return Math.max(length, 8);
        } catch (NumberFormatException e) {
            return 8;
        }
    }

    private static boolean getYesNoOption(String message) {
        int option = JOptionPane.showConfirmDialog(null, message, "Selecciona una opción", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeSpecials) {
        String characters = LOWERCASE + NUMBERS;
        if (includeUppercase) characters += UPPERCASE;
        if (includeSpecials) characters += SPECIALS;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }

    private static String checkPasswordStrength(String password) {
        int score = 0;
        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()\\-_=+\\[\\]{}|;:,.<>?/].*")) score++;

        switch (score) {
            case 4: return "Fuerte";
            case 3: return "Media";
            default: return "Débil";
        }
    }
}

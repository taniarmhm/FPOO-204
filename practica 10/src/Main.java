import javax.swing.*;
import java.security.SecureRandom;

public class Main {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*()-_=+[]{}|;:'",.<>?/";

    public static void main(String[] args) {
        int length = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud del password (mínimo 8, por defecto 8):"));
        if (length < 8) length = 8;

        int includeUppercase = JOptionPane.showConfirmDialog(null, "¿Incluir mayúsculas?", "Opciones", JOptionPane.YES_NO_OPTION);
        int includeSpecials = JOptionPane.showConfirmDialog(null, "¿Incluir caracteres especiales?", "Opciones", JOptionPane.YES_NO_OPTION);

        String password = generatePassword(length, includeUppercase == JOptionPane.YES_OPTION, includeSpecials == JOptionPane.YES_OPTION);
        String strength = checkStrength(password);

        JOptionPane.showMessageDialog(null, "Password generado: " + password + "\nFortaleza: " + strength);
    }

    public static String generatePassword(int length, boolean useUpper, boolean useSpecials) {
        String charPool = LOWERCASE + NUMBERS;
        if (useUpper) charPool += UPPERCASE;
        if (useSpecials) charPool += SPECIALS;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(charPool.charAt(random.nextInt(charPool.length())));
        }
        return password.toString();
    }

    public static String checkStrength(String password) {
        int score = 0;
        if (password.length() >= 12) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()\-_=+\[\]{}|;:'\",.<>?/].*")) score++;

        switch (score) {
            case 4: return "Muy Fuerte";
            case 3: return "Fuerte";
            case 2: return "Moderada";
            default: return "Débil";
        }
    }
}

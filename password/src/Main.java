import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int longitud = obtenerLongitud();
        boolean incluirMayusculas = incluirMayusculas();
        boolean incluirCaracteresEspeciales = incluirCaracteresEspeciales();

        String contraseña = generarContraseña(longitud, incluirMayusculas, incluirCaracteresEspeciales);
        JOptionPane.showMessageDialog(null, "Contraseña Generada: " + contraseña);

        comprobarFortalezaContraseña(contraseña);
    }

    private static int obtenerLongitud() {
        int longitud;
        do {
            String input = JOptionPane.showInputDialog("Ingrese la longitud de la contraseña (mínimo 1):");
            if (input != null && !input.isEmpty()) {
                longitud = Integer.parseInt(input);
            } else {
                longitud = 8;
            }
        } while (longitud < 1);
        return longitud;
    }

    private static boolean incluirMayusculas() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Incluir letras mayúsculas?");
        return respuesta == JOptionPane.YES_OPTION;
    }

    private static boolean incluirCaracteresEspeciales() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Incluir caracteres especiales?");
        return respuesta == JOptionPane.YES_OPTION;
    }

    private static String generarContraseña(int longitud, boolean incluirMayusculas, boolean incluirCaracteresEspeciales) {
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresEspeciales = "!@#$%^&*()-_=+[]{}|;:',<.>/?";
        String digitos = "0123456789";

        String caracteres = minusculas + digitos;
        if (incluirMayusculas) {
            caracteres += mayusculas;
        }
        if (incluirCaracteresEspeciales) {
            caracteres += caracteresEspeciales;
        }

        Random random = new Random();
        StringBuilder contraseña = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            contraseña.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return contraseña.toString();
    }

    private static void comprobarFortalezaContraseña(String contraseña) {
        String mensaje = "Fortaleza de la contraseña: ";
        if (contraseña.length() >= 12 && contraseña.matches(".*[A-Z].*") && contraseña.matches(".*[!@#$%^&*()].*")) {
            mensaje += "Fuerte";
        } else if (contraseña.length() >= 8) {
            mensaje += "Media";
        } else {
            mensaje += "Débil";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

import java.util.Scanner;
public class ejercisio1 {
    public static void main(String[] args) {
        String contrasenaGuardada = "MiContraseña123";
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la contraseña: ");
        String contrasenaUsuario = sc.nextLine();
        if (contrasenaGuardada.equalsIgnoreCase(contrasenaUsuario)) {
            System.out.println("Contraseña correcta.");
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }
}

import java.util.Scanner;
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una cadena de caracteres: ");
        String cadena = sc.nextLine();
        String cadenaInvertida = new StringBuilder(cadena).reverse().toString();

        if (cadena.equalsIgnoreCase(cadenaInvertida)) {
            System.out.println("La cadena es un palíndromo.");
        } else {
            System.out.println("La cadena no es un palíndromo.");
        }
    }

}


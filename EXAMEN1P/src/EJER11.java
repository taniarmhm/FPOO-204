import java.util.Scanner;

public class EJER11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la primera palabra: ");
        String palabra1 = scanner.nextLine();

        System.out.print("Ingrese la segunda palabra: ");
        String palabra2 = scanner.nextLine();

        scanner.close();

        int longitud1 = palabra1.length();
        int longitud2 = palabra2.length();

        if (longitud1 > longitud2) {
            System.out.println("La palabra más larga es: " + palabra1 + " por " + (longitud1 - longitud2) + " letras.");
        } else if (longitud2 > longitud1) {
            System.out.println("La palabra más larga es: " + palabra2 + " por " + (longitud2 - longitud1) + " letras.");
        } else {
            System.out.println("Ambas palabras tienen la misma longitud.");
        }
    }
}


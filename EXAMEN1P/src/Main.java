import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ingrese un numero: ");
        int numero = scanner.nextInt();
        scanner.close();

        System.out.println("serie de Collatz: ");
        while (numero != 1) {
            System.out.print(numero + " ");
            if (numero % 2 == 0) {
                numero /= 2;
            } else {
                numero = 3 * numero + 1;
            }
        }
        System.out.println(1);
    }
}



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero positivo: ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i += 2) {
            System.out.print(i + (i < num - 1 ? ", " : ""));
        }
        sc.close();
    }
}
import java.util.Scanner;

public class ejerciccio
1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero positivo: ");
        int num = sc.nextInt();

        for (int i = num; i >= 0; i--) {
            System.out.print(i + (i > 0 ? ", " : ""));
        }
        sc.close();
    }
}
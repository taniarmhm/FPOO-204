import java.util.Scanner;
public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.print("Introdusca el primer número: ");
            double numero1 = sc.nextDouble();

            System.out.print("Introdusca el segundo número: ");
            double numero2 = sc.nextDouble();

            System.out.print("Introdusca un operador (+, -, *, /): ");
            char operador = sc.next().charAt(0);

            switch (operador) {
                case '+':
                    System.out.println("Resultado: " + (numero1 + numero2));
                    break;
                case '-':
                    System.out.println("Resultado: " + (numero1 - numero2));
                    break;
                case '*':
                    System.out.println("Resultado: " + (numero1 * numero2));
                    break;

                default:
                    System.out.println("Operador no válido");
                    break;
            }
        }
    }
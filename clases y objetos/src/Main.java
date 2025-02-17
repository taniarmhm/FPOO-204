import javax.swing.JOptionPane;

class Cuenta {
    private String numeroCuenta;
    private String titular;
    private int edad;
    private double saldo;

    public Cuenta(String numeroCuenta, String titular, int edad, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.edad = edad;
        this.saldo = saldo;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void ingresarEfectivo(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            JOptionPane.showMessageDialog(null, "Ingreso exitoso. Saldo actual: " + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "Cantidad inválida.");
        }
    }

    public void retirarEfectivo(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            JOptionPane.showMessageDialog(null, "Retiro exitoso. Saldo actual: " + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "Fondos insuficientes o cantidad inválida.");
        }
    }

    public void depositarACuenta(Cuenta otraCuenta, double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            otraCuenta.saldo += cantidad;
            JOptionPane.showMessageDialog(null, "Depósito exitoso. Tu saldo actual: " + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "Fondos insuficientes o cantidad inválida.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
        String titular = JOptionPane.showInputDialog("Ingrese el nombre del titular:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del titular:"));
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));

        Cuenta cuenta = new Cuenta(numeroCuenta, titular, edad, saldo);

        String numeroCuentaDestino = JOptionPane.showInputDialog("Ingrese el número de cuenta destino:");
        String titularDestino = JOptionPane.showInputDialog("Ingrese el nombre del titular destino:");
        int edadDestino = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del titular destino:"));
        double saldoDestino = 0.0; // Inicialmente en cero

        Cuenta cuentaDestino = new Cuenta(numeroCuentaDestino, titularDestino, edadDestino, saldoDestino);

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seleccione una opción:\n1. Consultar saldo\n2. Ingresar efectivo\n3. Retirar efectivo\n4. Depositar a otra cuenta\n5. Salir"));

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Saldo actual: " + cuenta.consultarSaldo());
                    break;
                case 2:
                    double ingreso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar:"));
                    cuenta.ingresarEfectivo(ingreso);
                    break;
                case 3:
                    double retiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar:"));
                    cuenta.retirarEfectivo(retiro);
                    break;
                case 4:
                    double deposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar en otra cuenta:"));
                    cuenta.depositarACuenta(cuentaDestino, deposito);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 5);
    }
}


public class Spartan {
    //atributos del Spartan
    public String nombre;
    int salud;
    int escudo;
    String armaPrincipal;

    //metodos del spartan
    public void mostrarInfo(){
        System.out.println("información del Spartan");
        System.out.println("Nombre:  " + nombre);
        System.out.println("Salud: " + salud);
        System.out.println("Escudo:  " + escudo);
        System.out.println("Arma principal  " + armaPrincipal);
        System.out.println("----------informacion del Spartan---------------  " );
    }
public void atacar(String enemigo){
        System.out.println(nombre + "ataca" + enemigo + "con" + armaPrincipal);
}

public  void recargarArma (int municiones) {
    int restante= 10;
    int total= restante + municiones;
    System.out.println("El arma" + armaPrincipal + "tiene" + total + "balas" );


}
public void  correr (boolean status){
        if (status){
            System.out.println("El spartan esta  " + nombre + "esta corriendo");
        } else {
            System.out.println("El spartan esta  " + nombre + "se detuvo");
        }

}
}

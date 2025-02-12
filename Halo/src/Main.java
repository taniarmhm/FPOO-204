
public class Main {
 public static void main (String[] args ) {

     //craemos Objeto = instanciar objeto
     Spartan  jefeMaestro = new Spartan();
     Spartan  Rich = new Spartan();

     //asignamos los atributos del objeto
     jefeMaestro.nombre= "John";
     jefeMaestro.salud= 100;
     jefeMaestro.escudo=90;
     jefeMaestro.armaPrincipal= "Rifle de asalto";


     //usar sus metodos
     jefeMaestro.mostrarInfo();
     jefeMaestro.atacar ("Elite");
     jefeMaestro.recargarArma(65 );
     jefeMaestro.correr(true);
// segundo objeto rich
    Rich.nombre= "Emile";
    Rich.salud= 0;
    Rich.escudo=0;
    Rich.armaPrincipal= "Rifle de asalto";


    Rich.mostrarInfo();
    Rich.atacar ("Grunt");
    Rich.recargarArma(10 );
    Rich.correr(false);
 }






}//llave de clase

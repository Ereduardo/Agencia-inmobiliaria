import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Inquilino {

    private static Vector usuarios = new Vector(10,5);
    private String nombre;
    private String cedula;
    private int edad;
    private String sexo;
    private int identificador = 1;

    Random random = new Random(); //Para el metodo setIdentificador

    Inquilino(){ // Metodo constructor
        System.out.println("Ingrese el nombre del inquilino: ");
        String aNombre = Main.escanear();
        System.out.println("Ingrese la cedula: ");
        String aCedula = Main.escanear();
        System.out.println("Ingrese la edad: ");
        int aEdad = Main.escanearInt();
        System.out.println("Ingrese el sexo del inquilino: ");
        String aSexo = Main.escanear();
        Inquilino.rellenarInquilino(this, aNombre, aCedula, aEdad, aSexo);
    }

    public static void rellenarInquilino(Inquilino cliente,String nombre, String cedula, int edad, String sexo){
        //Inquilino cliente = new Inquilino();
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setEdad(edad);
        cliente.setSexo(sexo);
        cliente.setIdentificador();
        usuarios.addElement(cliente);
        
        System.out.println("El cliente tiene como nombre: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).nombre);
        System.out.println("El cliente tiene como cedula: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).cedula);
        System.out.println("El cliente se define como: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).sexo);
        System.out.println("El cliente tiene la edad de "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).edad+" años");
        System.out.println("El cliente tiene como identificador: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).identificador);
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdentificador() {
        int min = 111111;
        int max = 999999;
        
        identificador = random.nextInt(max + min); //EL identificador es un codigo entre 111111 y 999999
       
    }

    public String getCedula() {
        return cedula;
    }
    
    public int getEdad() {
        return edad;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getSexo() {
        return sexo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void modificarInquilino(){
//
    }
    public void eliminarInquilino(){
//
    }

}

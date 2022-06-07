import java.util.Random;
import java.util.Vector;



public class Inquilino {

    private static Vector usuarios = new Vector(10,5);
    private String nombre;
    private String cedula;
    private int edad;
    private String sexo;
    private int iD = 1;

    Random random = new Random(); //Para el metodo setIdentificador

    Inquilino(){ // Metodo constructor
        System.out.println("Ingrese el nombre del inquilino: ");
        this.setNombre(Main.escanear());
        System.out.println("Ingrese la cedula: ");
        this.setCedula(Main.escanear());
        System.out.println("Ingrese la edad: ");
        this.setEdad(Main.escanearInt());      
        System.out.println("Ingrese el sexo del inquilino: ");
        this.setSexo(Main.escanear());
        this.iD = Main.nuevo_ID();
        registrarInquilino(this);
    }

    public static void registrarInquilino(Inquilino cliente){
        usuarios.addElement(cliente);
        System.out.println("El cliente tiene como nombre: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).nombre);
        System.out.println("El cliente tiene como cedula: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).cedula);
        System.out.println("El cliente se define como: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).sexo);
        System.out.println("El cliente tiene la edad de "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).edad+" años");
        System.out.println("El cliente tiene como identificador: "+((Inquilino)usuarios.elementAt(usuarios.size()-1)).iD);
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


    public String getCedula() {
        return cedula;
    }
    
    public int getEdad() {
        return edad;
    }

    public int getIdentificador() {
        return iD;
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

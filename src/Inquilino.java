import java.util.Random;

public class Inquilino {

    private String nombre;
    private int cedula;
    private int edad;
    private String sexo;
    private int identificador = 1;

    Random random = new Random(); //Para el metodo setIdentificador

    public void setCedula(int cedula) {
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

    public int getCedula() {
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

    public void registrarInquilino(){
//
    }

    public void modificarInquilino(){
//
    }
    public void eliminarInquilino(){
//
    }

}

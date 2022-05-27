import java.util.Vector;
import java.util.Scanner;

public abstract class Inmueble {
    protected String direccion;
    protected String descripcionInmueble;
    protected int codigoPostal;
    protected int idMueble;
    protected double precioAlquiler;

    private static Vector inmuebles = new Vector(10,5);
    
    Inmueble(){

        
    }
    
    public void registrarInmueble(){
//
    }

    public void modificarInmueble(){
//
    }

    public void eliminarInmueble(){
//
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDescripcionInmueble() {
        return descripcionInmueble;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
    
    public int getIdMueble() {
    return idMueble;        
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

}

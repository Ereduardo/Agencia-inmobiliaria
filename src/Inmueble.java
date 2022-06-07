import java.util.Vector;

public class Inmueble {
    protected String direccion;
    protected String descripcionInmueble;
    protected int codigoPostal;
    protected double precioAlquiler;
    public static Vector inmuebles = new Vector(10,5);
    public static Inmueble inmueble_obj = new Inmueble();

    public static void registrarInmueble(){
    System.out.println("Ingrese la dirección del inmueble: ");
    inmueble_obj.setDireccion(Main.escanear());
    if(confirmInmuebleRepetido(inmueble_obj.direccion)){
        System.out.println("Esta dirección ya está registrada.");
        System.out.println("Volviendo al menú principal...");
        Main.salto_espacio();
        return;
    }
    System.out.println("Ingrese una breve descripción del inmueble: ");
    inmueble_obj.setDescripcionInmueble(Main.escanear());
    System.out.println("Ingrese el codigo postal del inmueble: ");
    inmueble_obj.setCodigoPostal(Main.escanearInt());
    System.out.println("Ingrese el precio para alquilar el inmueble (Ingrese solo la cifra en numeros): ");
    inmueble_obj.setPrecioAlquiler(Main.escanearDouble());

    inmuebles.addElement(inmueble_obj);

    System.out.println("Datos del inmueble registrado: ");
    System.out.println("Dirección: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).direccion);
    System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).descripcionInmueble);
    System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).codigoPostal);
    System.out.println("Precio de alquiler: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).precioAlquiler);
    System.out.println("Inmueble registrado.");
        Main.salto_espacio();
    
    }
    
    public static void modificarInmueble() {
    if(inmuebles.size()==0){
            System.out.println("No has registrado ningún inmueble aún. ");
            System.out.println("Regresando al menú principal...");
            Main.salto_espacio();
    }   else{
        
        System.out.println("Ingrese la dirección del inmueble a modificar: ");
        String direccion_hallar = Main.escanear();
         // 
        for(int i=0; i<inmuebles.size(); i++){
            Boolean validar = Main.comparar_String(direccion_hallar, ((Inmueble)inmuebles.elementAt(i)).direccion);
                if(validar){
                System.out.println("Está a punto de modificar todos los datos del inmueble");
                System.out.println("Ingrese la nueva dirección: ");
                ((Inmueble)inmuebles.elementAt(i)).direccion = Main.escanear();
                System.out.println("Ingrese la nueva descripción: ");
                ((Inmueble)inmuebles.elementAt(i)).descripcionInmueble = Main.escanear();
                System.out.println("Ingrese el nuevo codigo postal: ");
                ((Inmueble)inmuebles.elementAt(i)).codigoPostal = Main.escanearInt();
                System.out.println("Ingrese el nuevo precio de Alquiler: ");
                ((Inmueble)inmuebles.elementAt(i)).precioAlquiler = Main.escanearDouble();

                System.out.println("Los nuevos datos que acabas de ingresar son: ");
                System.out.println("Dirección: "+ ((Inmueble)inmuebles.elementAt(i)).direccion);
                System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(i)).descripcionInmueble);
                System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(i)).codigoPostal);
                System.out.println("Precio de alquiler: "+((Inmueble)inmuebles.elementAt(i)).precioAlquiler);
                System.out.println("Inmueble modificado.");
                    Main.salto_espacio();
                    return;
            }
            
        }
        System.out.println("No se ha encontrado ningún inmueble con esa dirección.");
        System.out.println("Regresando al menú principal...");
        Main.salto_espacio();
    }
        
    }

    public static void mostrarInmueble(){
        System.out.println("Ingrese el ID del inmueble a mostrar: ");
        String direccion_hallar = Main.escanear();
            for(int i=0; i<inmuebles.size(); i++){
                Boolean validar = Main.comparar_String(direccion_hallar, ((Inmueble)inmuebles.elementAt(i)).direccion);
                if(validar){
                    System.out.println("Datos del inmueble con la respectiva ID: ");
                    System.out.println("Dirección: "+((Inmueble)inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("Presione Enter para continuar.");
                    Main.salto_espacio();
                }
            }
    }

    public static void eliminarInmueble(){
        if(inmuebles.size()==0){
            System.out.println("No has registrado ningún inmueble aún. ");
            return;
        }

        System.out.println("Ingrese la dirección del inmueble a eliminar: ");
        String direccion_hallar = Main.escanear();

        for(int i=0; i<inmuebles.size(); i++){
            Boolean validar = Main.comparar_String(direccion_hallar, ((Inmueble)inmuebles.elementAt(i)).direccion);
            if(validar){
                System.out.println("Estos son los datos del inmueble a eliminar: ");
                System.out.println("Dirección: "+((Inmueble)inmuebles.elementAt(i)).direccion);
                System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(i)).descripcionInmueble);
                System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(i)).codigoPostal);
                System.out.println("Precio de Alquiler: "+((Inmueble)inmuebles.elementAt(i)).precioAlquiler);
                System.out.println("¿Confirma la eliminación?");
                System.out.println("Escriba 1 para confirmar, 2 o más para negar.");
                if(Main.escanearInt()==1){
                confirmEliminarInmueble(i);
                }
            }
            else{
                System.out.println("No se ha encontrado ningún inmueble con esa dirección.");
                return;
            }
        }
        

    }

    public static void confirmEliminarInmueble(int i){
        System.out.println("Borrando...");
        inmuebles.removeElementAt(i);
        System.out.println("Inmueble borrado.");
    }

    public static Boolean confirmInmuebleRepetido(String calle){
        for(int i=0; i<inmuebles.size(); i++){
        Boolean validar = Main.comparar_String(calle, ((Inmueble)inmuebles.elementAt(i)).direccion);
        if(validar){return validar;}
        }
        return false;
        
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
    

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }
    public void setDireccion(String direccion) {
        inmueble_obj.direccion = direccion;
    }
    public void setDescripcionInmueble(String descripcionInmueble) {
    inmueble_obj.descripcionInmueble = descripcionInmueble;
    }
    public void setCodigoPostal(int codigoPostal) {
        inmueble_obj.codigoPostal = codigoPostal;
    }
    
    public void setPrecioAlquiler(double precioAlquiler) {
        inmueble_obj.precioAlquiler = precioAlquiler;
    }
    

}

import java.util.Vector;

public class Inmueble {
    protected String direccion;
    protected String descripcionInmueble;
    protected int codigoPostal;
    protected double precioAlquiler;
    protected int iD_inmueble = Main.nuevo_ID();
    public static Vector inmuebles = new Vector(10,5);
    
    Inmueble(){
        registrarInmueble();
        //Setter de los atributos
        // Guardar cada inmueble en un objeto cada uno
        // Getter para verlos
    }

    public static void registrarInmueble(){
        Inmueble inmueble_obj = new Inmueble();
        System.out.println("Ingrese la dirección del inmueble: ");
        inmueble_obj.setDireccion(Main.escanear());
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
        System.out.println("ID: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).iD_inmueble);
        System.out.println("Inmueble registrado.");
        Main.salto_espacio();
    
    }
    
    public static void modificarInmueble() {
        
    if(inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún. ");
            System.out.println("Regresando al menú principal...");
            Main.salto_espacio();
    }   else{
        
        System.out.println("Ingrese el número ID del inmueble a modificar: ");
        int id_hallar = Main.escanearInt();
            for(int i=0;i<inmuebles.size();i++){
                if(id_hallar == ((Inmueble)inmuebles.elementAt(i)).iD_inmueble){
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: "+((Inmueble)inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).iD_inmueble);
                    System.out.println("¿Desea modificarlo?");
                    System.out.println("Presione 1 para confirmar.");
                    System.out.println("Presione 2 o más para regresar.");
                    if(Main.escanearInt()==1){confirmModificarInmueble(id_hallar);}else{
                        Main.back_to_main();
                    }
                }
            }
        
     
        }
        
    }

    public static void confirmModificarInmueble(int i){
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
                    Main.back_to_main();
                    
    }

    public static void mostrarInmueble(){
        
        if(inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún. ");
            System.out.println("Regresando al menú principal...");
            Main.salto_espacio();
    }   else{

        System.out.println("Ingrese el número ID del inmueble a mostrar: ");
        int id_hallar = Main.escanearInt();
            for(int i=0;i<inmuebles.size();i++){
                if(id_hallar == ((Inmueble)inmuebles.elementAt(i)).iD_inmueble){
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: "+((Inmueble)inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).iD_inmueble);
                    Main.salto_espacio();
                }
            }
        }
    }

    public static void eliminarInmueble(){
        if(inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún. ");
            Main.salto_espacio();
            return;
        }
        
        System.out.println("Ingrese el número ID del inmueble a eliminar: ");
        int id_hallar = Main.escanearInt();
            for(int i=0;i<inmuebles.size();i++){
                if(id_hallar == ((Inmueble)inmuebles.elementAt(i)).iD_inmueble){
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: "+((Inmueble)inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: "+((Inmueble)inmuebles.elementAt(inmuebles.size()-1)).iD_inmueble);
                    System.out.println("¿Desea eliminarlo?");
                    System.out.println("Presione 1 para confirmar.");
                    System.out.println("Presione 2 o más para regresar.");
                    if(Main.escanearInt()==1){confirmEliminarInmueble(id_hallar);}else{
                        Main.back_to_main();
                    }
                }
            }
        

    }

    public static void confirmEliminarInmueble(int i){
        System.out.println("Borrando...");
        inmuebles.removeElementAt(i);
        System.out.println("Inmueble eliminado.");
        Main.salto_espacio();
    }


    public static void mostrarTodosLosinmuebles() {
        if(inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún.");
            Main.salto_espacio();
        }
            for(int i=0; i<inmuebles.size(); i++){
                    System.out.println("Inmueble número ["+(i+1)+"]");
                    System.out.println("Dirección: "+((Inmueble)inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)inmuebles.elementAt(i)).precioAlquiler);
                    Main.salto_espacio();
            }

    }

   /*  public static int verificar_espacio(int i) {
        if(i<0 || i>inmuebles.size()) {
           System.out.println("Ese número de inmueble no está registrado."); 
            while(i<0 || i>inmuebles.size()){
                System.out.println("Ingrese un número valido.");
                i = Main.escanearInt();
            }

        }
        return i;
    } */

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
        this.direccion = direccion;
    }
    public void setDescripcionInmueble(String descripcionInmueble) {
    this.descripcionInmueble = descripcionInmueble;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
    

}

public class Inmueble {
    protected String direccion;
    protected String descripcionInmueble;
    protected int codigoPostal;
    protected double precioAlquiler;
    protected int iD_inmueble = Main.nuevo_ID();
    protected int id_cliente;
    
    Inmueble(){
        registrarInmueble(this);
        
    }

    
    
    public static void registrarInmueble(Inmueble inmueble_obj){
        System.out.println("Ingrese la dirección del inmueble: ");
        inmueble_obj.setDireccion(Main.escanear());
        System.out.println("Ingrese una breve descripción del inmueble: ");
        inmueble_obj.setDescripcionInmueble(Main.escanear());
        System.out.println("Ingrese el codigo postal del inmueble: ");
        inmueble_obj.setCodigoPostal(Main.escanearInt());
        System.out.println("Ingrese el precio para alquilar el inmueble (Ingrese solo la cifra en numeros): ");
        inmueble_obj.setPrecioAlquiler(Main.escanearDouble());
        Main.inmuebles.addElement(inmueble_obj);
        mostrarDatos(inmueble_obj);
    
    }
    
    
   
    public static void mostrarDatos(Inmueble inmueble_obj){
        System.out.println("Datos del inmueble registrado: ");
        System.out.println("Dirección: "+inmueble_obj.getDireccion());
        System.out.println("Descripción: "+inmueble_obj.getDescripcionInmueble());
        System.out.println("Codigo postal: "+inmueble_obj.getCodigoPostal());
        System.out.println("Precio de alquiler: "+inmueble_obj.getPrecioAlquiler());
        System.out.println("ID: "+inmueble_obj.getiD_inmueble());
        System.out.println("Inmueble registrado.");
        Main.salto_espacio();
    }

    public static void modificarInmueble() {
    if(Main.inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún. ");
            System.out.println("Regresando al menú principal...");
            Main.salto_espacio();
    }   else{
        
        System.out.println("Ingrese el número ID del inmueble a modificar: ");
        int id_hallar = Main.escanearInt();
            for(int i=0;i<Main.inmuebles.size();i++){
                if(id_hallar == ((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble){
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: "+((Inmueble)Main.inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)Main.inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)Main.inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)Main.inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: "+((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble);
                    System.out.println("¿Desea modificarlo?");
                    System.out.println("Presione 1 para confirmar.");
                    System.out.println("Presione 2 o más para regresar.");
                    if(Main.escanearInt()==1){confirmModificarInmueble(i);}else{ // NO ES ID HALLAR 
                        Main.back_to_main();
                    }
                }
            }
        
     
        }
        
    }

    
   
    public static void confirmModificarInmueble(int i){
                    System.out.println("Está a punto de modificar todos los datos del inmueble");
                    System.out.println("Ingrese la nueva dirección: ");
                    ((Inmueble)Main.inmuebles.elementAt(i)).direccion = Main.escanear();
                    System.out.println("Ingrese la nueva descripción: ");
                    ((Inmueble)Main.inmuebles.elementAt(i)).descripcionInmueble = Main.escanear();
                    System.out.println("Ingrese el nuevo codigo postal: ");
                    ((Inmueble)Main.inmuebles.elementAt(i)).codigoPostal = Main.escanearInt();
                    System.out.println("Ingrese el nuevo precio de Alquiler: ");
                    ((Inmueble)Main.inmuebles.elementAt(i)).precioAlquiler = Main.escanearDouble();

                    System.out.println("Los nuevos datos que acabas de ingresar son: ");
                    System.out.println("Dirección: "+ ((Inmueble)Main.inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)Main.inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)Main.inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)Main.inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("Inmueble modificado.");
                    Main.salto_espacio();
                    Main.back_to_main();
                    
    }

    public static void mostrarInmueble(){
        
        if(Main.inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún. ");
            System.out.println("Regresando al menú principal...");
            Main.salto_espacio();
    }   else{

        System.out.println("Ingrese el número ID del inmueble a mostrar: ");
        int id_hallar = Main.escanearInt();
            for(int i=0;i<Main.inmuebles.size();i++){
                if(id_hallar == ((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble){
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: "+((Inmueble)Main.inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)Main.inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)Main.inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)Main.inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: "+((Inmueble)Main.inmuebles.elementAt(Main.inmuebles.size()-1)).iD_inmueble);
                    Main.salto_espacio();
                }
            }
        }
        
    }

    public static void eliminarInmueble(){
        if(Main.inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún. ");
            Main.salto_espacio();
            return;
        }
        
        System.out.println("Ingrese el número ID del inmueble a eliminar: ");
        int id_hallar = Main.escanearInt();
            for(int i=0;i<Main.inmuebles.size();i++){
                if(id_hallar == ((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble){
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: "+((Inmueble)Main.inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)Main.inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)Main.inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)Main.inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: "+((Inmueble)Main.inmuebles.elementAt(Main.inmuebles.size()-1)).iD_inmueble);
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
        Main.inmuebles.removeElementAt(i);
        System.out.println("Inmueble eliminado.");
        Main.salto_espacio();
    }


    public static void mostrarTodosLosinmuebles() {
        if(Main.inmuebles.isEmpty()){
            System.out.println("No has registrado ningún inmueble aún.");
            Main.salto_espacio();
        }
            for(int i=0; i<Main.inmuebles.size(); i++){
                    System.out.println("Inmueble número ["+(i+1)+"]");
                    System.out.println("Dirección: "+((Inmueble)Main.inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: "+((Inmueble)Main.inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: "+((Inmueble)Main.inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: "+((Inmueble)Main.inmuebles.elementAt(i)).precioAlquiler);
                    Main.salto_espacio();
            }
            
    }

    
    
    public static void verificar_inmueble(int id){
        for(int i=0;i<Main.inmuebles.size();i++){
            if(id == ((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble){
                System.out.println("Inmueble hallado, el de dirección: ");
                System.out.println(((Inmueble)Main.inmuebles.elementAt(i)).direccion);
                Main.salto_espacio();
                return;
            }
        }
        System.out.println("Inmueble no hallado, regresando al menú.");
        Main.salto_espacio();
        Main.back_to_main();
    }

    public static int buscar_pos_id_inmueble(int id){
        for(int i = 0;i<Main.inmuebles.size();i++){
            if(id == ((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble){
                return i;
            }
        }
        return id;
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
    
   
    public int getiD_inmueble() {
        return iD_inmueble;
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

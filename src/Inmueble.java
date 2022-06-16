/********
 * La clase inmueble, una propiedad la cual puede ser alquilada por un cliente registrado en la agencia 
 * 
 * 
 * ************************************************
 *  * Palabra de honor:
 * - No he discutido ni mostrado el código de mi programa con alguien que no sea mi compañero
 * Profesor o con el monitor asignado a este curso
 *
 * - No he utilizado código obtenido de otro u otros estudiantes,
 * O cualquier otra fuente no autorizada, ya sea modificado o sin modificar.
 *
 * - Si cualquier código o documentación utilizada en mi programa
 * Fue obtenido de otra fuente, tal como Internet, un libro de texto o curso
 * Notas, debe ser claramente señalado con una cita apropiada en
 * Los comentarios de mi programa.
 *
 * Eduardo José Jimenez - 0222010055
 * Jesús David Navarro - 0222010036
 *
 *
 **************************************************
 * 
 */

public class Inmueble {
    protected int id_cliente = 0;
    protected String direccion;
    protected String descripcionInmueble;
    protected int codigoPostal;
    protected double precioAlquiler;
    protected int iD_inmueble = Main.nuevo_ID();

    /**
     * Metodo constructor de la clase inmueble
     */
    Inmueble() {
        registrarInmueble(this);

    }


    
    /** 
     * Registra el inmueble en el respectivo vector de inmuebles inicializado en el Main
     * @param inmueble_obj Objeto del inmueble a registrar
     */
    public static void registrarInmueble(Inmueble inmueble_obj) {
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


    
    /** 
     * Muestra los datos del inmueble recién registrado en el vector 
     * @param inmueble_obj Objeto del inmueble
     */
    public static void mostrarDatos(Inmueble inmueble_obj) {
        System.out.println("Datos del inmueble registrado: ");
        System.out.println("Dirección: " + inmueble_obj.getDireccion());
        System.out.println("Descripción: " + inmueble_obj.getDescripcionInmueble());
        System.out.println("Codigo postal: " + inmueble_obj.getCodigoPostal());
        System.out.println("Precio de alquiler: " + inmueble_obj.getPrecioAlquiler());
        System.out.println("ID: " + inmueble_obj.getiD_inmueble());
        System.out.println("Inmueble registrado.");
        Main.salto_espacio();
    }
    /*******
     * Metodo para modificar los datos del inmueble con el ID del inmueble
     */
    public static void modificarInmueble() {
        if (Main.inmuebles.isEmpty()) {
            System.out.println("No has registrado ningún inmueble aún. ");
            System.out.println("Regresando al menú principal...");
            Main.salto_espacio();
        } else {

            System.out.println("Ingrese el número ID del inmueble a modificar: ");
            int id_hallar = Main.escanearInt();
            for (int i = 0; i < Main.inmuebles.size(); i++) {
                if (id_hallar == ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble) {
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: " + ((Inmueble) Main.inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: " + ((Inmueble) Main.inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: " + ((Inmueble) Main.inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: " + ((Inmueble) Main.inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: " + ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble);
                    System.out.println("¿Desea modificarlo?");
                    System.out.println("Presione 1 para confirmar.");
                    System.out.println("Presione 2 o más para regresar.");
                    if (Main.escanearInt() == 1) {
                        confirmModificarInmueble(i);
                    } else { // NO ES ID HALLAR
                        Main.back_to_main();
                    }
                }
            }


        }

    }


    
    /** 
     * Metodo para confirmar la modificación de datos del inmueble 
     * @param i posición del inmueble en el vector 
     */
    public static void confirmModificarInmueble(int i) {
        System.out.println("Está a punto de modificar todos los datos del inmueble");
        System.out.println("Ingrese la nueva dirección: ");
        ((Inmueble) Main.inmuebles.elementAt(i)).direccion = Main.escanear();
        System.out.println("Ingrese la nueva descripción: ");
        ((Inmueble) Main.inmuebles.elementAt(i)).descripcionInmueble = Main.escanear();
        System.out.println("Ingrese el nuevo codigo postal: ");
        ((Inmueble) Main.inmuebles.elementAt(i)).codigoPostal = Main.escanearInt();
        System.out.println("Ingrese el nuevo precio de Alquiler: ");
        ((Inmueble) Main.inmuebles.elementAt(i)).precioAlquiler = Main.escanearDouble();

        System.out.println("Los nuevos datos que acabas de ingresar son: ");
        System.out.println("Dirección: " + ((Inmueble) Main.inmuebles.elementAt(i)).direccion);
        System.out.println("Descripción: " + ((Inmueble) Main.inmuebles.elementAt(i)).descripcionInmueble);
        System.out.println("Codigo postal: " + ((Inmueble) Main.inmuebles.elementAt(i)).codigoPostal);
        System.out.println("Precio de alquiler: " + ((Inmueble) Main.inmuebles.elementAt(i)).precioAlquiler);
        System.out.println("Inmueble modificado.");
        Main.salto_espacio();
        Main.back_to_main();

    }
    /********
     * Metodo para mostrar los datos del inmueble con el ID del inmueble
     */
    public static void mostrarInmueble() {

        if (Main.inmuebles.isEmpty()) {
            System.out.println("No has registrado ningún inmueble aún. ");
            System.out.println("Regresando al menú principal...");
            Main.salto_espacio();
        } else {

            System.out.println("Ingrese el número ID del inmueble a mostrar: ");
            int id_hallar = Main.escanearInt();
            for (int i = 0; i < Main.inmuebles.size(); i++) {
                if (id_hallar == ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble) {
                    System.out.println("Datos del inmueble con el respectivo numero: ");
                    System.out.println("Dirección: " + ((Inmueble) Main.inmuebles.elementAt(i)).direccion);
                    System.out.println("Descripción: " + ((Inmueble) Main.inmuebles.elementAt(i)).descripcionInmueble);
                    System.out.println("Codigo postal: " + ((Inmueble) Main.inmuebles.elementAt(i)).codigoPostal);
                    System.out.println("Precio de alquiler: " + ((Inmueble) Main.inmuebles.elementAt(i)).precioAlquiler);
                    System.out.println("ID: " + ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble);
                    if (((Inmueble) Main.inmuebles.elementAt(i)).id_cliente != 0) {
                        int pos_inqui = Inquilino.buscar_pos_id_inquilino(((Inmueble) Main.inmuebles.elementAt(i)).id_cliente);
                        System.out.println("Nombre del alquilador: " + ((Inquilino) Main.usuarios.elementAt(i)).getNombre());
                    } else {
                        System.out.println("Inmueble sin actual alquilador.");
                    }
                    Main.salto_espacio();
                }
            }
        }

    }
    /********
     * Metodo para eliminar inmuebles del vector con el ID del inmueble
     */
    public static void eliminarInmueble() {
        if (Main.inmuebles.isEmpty()) {
            System.out.println("No has registrado ningún inmueble aún. ");
            Main.salto_espacio();
            return;
        }

        System.out.println("Ingrese el número ID del inmueble a eliminar: ");
        int id_hallar = Main.escanearInt();
        for (int i = 0; i < Main.inmuebles.size(); i++) {
            if (id_hallar == ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble) {
                System.out.println("Datos del inmueble con el respectivo numero: ");
                System.out.println("Dirección: " + ((Inmueble) Main.inmuebles.elementAt(i)).direccion);
                System.out.println("Descripción: " + ((Inmueble) Main.inmuebles.elementAt(i)).descripcionInmueble);
                System.out.println("Codigo postal: " + ((Inmueble) Main.inmuebles.elementAt(i)).codigoPostal);
                System.out.println("Precio de alquiler: " + ((Inmueble) Main.inmuebles.elementAt(i)).precioAlquiler);
                System.out.println("ID: " + ((Inmueble) Main.inmuebles.elementAt(Main.inmuebles.size() - 1)).iD_inmueble);
                System.out.println("¿Desea eliminarlo?");
                System.out.println("Presione 1 para confirmar.");
                System.out.println("Presione 2 o más para regresar.");
                if (Main.escanearInt() == 1) {
                    confirmEliminarInmueble(id_hallar);
                } else {
                    Main.back_to_main();
                }
            }
        }


    }


    
    /** 
     * Metodo para confirmar la eliminación del inmueble en el vector de Inmuebles
     * @param i posición del inmueble en el vector
     */
    public static void confirmEliminarInmueble(int i) {
        System.out.println("Borrando...");
        Main.inmuebles.removeElementAt(i);
        System.out.println("Inmueble eliminado.");
        Main.salto_espacio();
    }

    /**
     * Metodo para mostrar todos los inmuebles registrados en el vector sin imprimir el ID
     */
    public static void mostrarTodosLosinmuebles() {
        if (Main.inmuebles.isEmpty()) {
            System.out.println("No has registrado ningún inmueble aún.");
            Main.salto_espacio();
        }
        for (int i = 0; i < Main.inmuebles.size(); i++) {
            System.out.println("Inmueble número [" + (i + 1) + "]");
            System.out.println("Dirección: " + ((Inmueble) Main.inmuebles.elementAt(i)).direccion);
            System.out.println("Descripción: " + ((Inmueble) Main.inmuebles.elementAt(i)).descripcionInmueble);
            System.out.println("Codigo postal: " + ((Inmueble) Main.inmuebles.elementAt(i)).codigoPostal);
            System.out.println("Precio de alquiler: " + ((Inmueble) Main.inmuebles.elementAt(i)).precioAlquiler);
            if (((Inmueble) Main.inmuebles.elementAt(i)).id_cliente != 0) {
                int pos_inqui = Inquilino.buscar_pos_id_inquilino(((Inmueble) Main.inmuebles.elementAt(i)).id_cliente);
                System.out.println("Nombre del alquilador: " + ((Inquilino) Main.usuarios.elementAt(i)).getNombre());
            } else {
                System.out.println("Inmueble sin actual alquilador.");
            }
            Main.salto_espacio();
        }

    }


    
    /** 
     * Metodo para verificar si el inmueble se encuentra en el vector de Inmuebles, de ser false, retorna al Main
     * @param id ID del inmueble
     */
    public static void verificar_inmueble(int id) {
        for (int i = 0; i < Main.inmuebles.size(); i++) {
            if (id == ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble) {
                System.out.println("Inmueble hallado, el de dirección: ");
                System.out.println(((Inmueble) Main.inmuebles.elementAt(i)).direccion);
                Main.salto_espacio();
                return;
            }
        }
        System.out.println("Inmueble no hallado, regresando al menú.");
        Main.salto_espacio();
        Main.back_to_main();
    }

    
    /** 
     * Metodo para buscar la posición del ID del inmueble en el vector de inmuebles
     * @param id ID del inmueble
     * @return int posición del inmueble en el vector
     */
    public static int buscar_pos_id_inmueble(int id) {
        for (int i = 0; i < Main.inmuebles.size(); i++) {
            if (id == ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble) {
                return i;
            }
        }
        return id;
    }


    
    /** 
     * Metodo get para la dirección del inmueble
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }


    
    /** 
     * Metodo get para la descripcion del inmueble
     * @return String descripcion del inmueble
     */
    public String getDescripcionInmueble() {
        return descripcionInmueble;
    }


    
    /** 
     * Metodo get para el codigo postal del inmueble
     * @return int codigo postal del inmueble
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }


    
    /** 
     * Metodo get para el ID del inmueble
     * @return int ID del inmueble
     */
    public int getiD_inmueble() {
        return iD_inmueble;
    }


    
    /** 
     * Metodo get para el precio del alquiler del inmueble
     * @return double
     */
    public double getPrecioAlquiler() {
        return precioAlquiler;
    }


    
    /** 
     * Metodo set para la direccion del inmueble
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    
    /** 
     * Metodo set para la descripcion del inmueble
     * @param descripcionInmueble
     */
    public void setDescripcionInmueble(String descripcionInmueble) {
        this.descripcionInmueble = descripcionInmueble;
    }


    
    /** 
     * Metodo set para el codigo postal del inmueble
     * @param codigoPostal
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    
    /** 
     * Metodo set para el precio del Alquiler del inmueble
     * @param precioAlquiler
     */
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }


}

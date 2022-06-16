/**********
 * El Alquiler guarda una lista de datos de los clientes que alquilan inmuebles
 * en el respectivo vector de Alquileres inicializado en el Main
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

public class Alquiler {
    private int inquilino_id;
    private int inmueble_id;
    private String nombre_inquilino;
    private String direccion_inmueble;

    /***********
     * Constructor para el objeto Alquiler, utilizado para guardar con facilidad los atributos de la clase Alquiler.
     * 
     */
    Alquiler() {
        System.out.println("Ingrese el ID del inmueble: ");
        int id_inmueble = Main.escanearInt();
        verificarAlquilerRepetido(id_inmueble);
        Inmueble.verificar_inmueble(id_inmueble);
        System.out.println("Ingrese el ID del cliente: ");
        int id_cliente = Main.escanearInt();
        Inquilino.verificar_inquilino(id_cliente);
        pagarAlquiler(id_cliente, id_inmueble);
        int pos_inquilino = Inquilino.buscar_pos_id_inquilino(id_cliente);
        int pos_inmueble = Inmueble.buscar_pos_id_inmueble(id_inmueble);
        this.setNombre_inquilino(((Inquilino) Main.usuarios.elementAt(pos_inquilino)).getNombre());
        this.setInquilino_id(id_cliente);
        this.setInmueble_id(id_inmueble);
        this.setDireccion_inmueble(((Inmueble) Main.inmuebles.elementAt(pos_inmueble)).getDireccion());
        Main.alquileres.addElement(this);
        System.out.println("Contrato de alquiler completado correctamente.");
        Main.salto_espacio();
        Main.back_to_main();


    }

    
    /** 
     * Verifica si el inmueble ya está en un alquiler, es deicir, repetido, en caso de que sea true, retorna al Main.
     * @param id_inmueble id del inmueble
     */
    public static void verificarAlquilerRepetido(int id_inmueble) {
        for (int i = 0; i < Main.alquileres.size(); i++) {
            if (id_inmueble == ((Alquiler) Main.alquileres.elementAt(i)).getInmueble_id()) {
                System.out.println("Este inmueble ya se encuentra alquilado, no se puede volver a alquilar.");
                Main.salto_espacio();
                Main.back_to_main();
            }
        }

    }

    
    /** 
     * Cobra el precio del alquiler a la cuenta bancaria del cliente, y genera un movimiento (Gasto) a registrar.
     * Le da un nuevo dueño de inmueble al cliente que confirme pago de alquiler.
     * @param id_cliente ID del cliente
     * @param id_inmueble ID del inmueble
     */
    public static void pagarAlquiler(int id_cliente, int id_inmueble) {
        System.out.println("En caso de que el cliente no tenga una cuenta abierta con la cual pagar alquiler");
        System.out.println("el sistema lo retornará automaticamente al menú.");
        Main.salto_espacio();
        int pos_cuenta = Cuenta.verificarCuenta(id_cliente);
        int pos_inmueble = Inmueble.buscar_pos_id_inmueble(id_inmueble);
        Double precio_alquiler = ((Inmueble) Main.inmuebles.elementAt(pos_inmueble)).precioAlquiler;
        int pos_inquilino = Inquilino.buscar_pos_id_inquilino(id_cliente);
        System.out.println("El precio de alquiler del inmueble con dirección " + ((Inmueble) Main.inmuebles.elementAt(pos_inmueble)).direccion);
        System.out.println("es de: " + precio_alquiler + "$");
        System.out.println("¿Está seguro de pagar? Se cobrará de la cuenta del cliente.");
        System.out.println("Presione 1 para confirmar, 2 o + para regresar al menú.");
        if (Main.escanearInt() != 1) {
            Main.back_to_main();
        }
        if (((Cuenta) Main.cuentas.elementAt(pos_cuenta)).getCuenta() < precio_alquiler) {
            System.out.println("No tiene dinero suficiente en cuenta para pagar el alquiler.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        ((Inmueble) Main.inmuebles.elementAt(pos_inmueble)).id_cliente = id_cliente;
        ((Cuenta) Main.cuentas.elementAt(pos_cuenta)).setCuenta(((Cuenta) Main.cuentas.elementAt(pos_cuenta)).getCuenta() - precio_alquiler);
        Movimiento.identificarGasto(pos_inmueble, pos_inquilino, precio_alquiler.floatValue());

    }
    /*********
     * Mostrar el alquiler de un inmueble, si es que está alquilado, de no estarlo, retorna al Main.
     */
    public static void mostrarAlquiler_inmueble() {
        System.out.println("Ingrese el ID del inmueble para verificar su alquiler.");
        int id_inmueble = Main.escanearInt();
        verificarAlquiler_inmueble(id_inmueble);
        for (int i = 0; i < Main.alquileres.size(); i++) {
            if (id_inmueble == ((Alquiler) Main.alquileres.elementAt(i)).inmueble_id) {
                System.out.println("Inmueble alquilado, mostrando información del alquiler: ");
                System.out.println("Nombre del cliente alquilador: " + ((Alquiler) Main.alquileres.elementAt(i)).nombre_inquilino);
                System.out.println("Se guarda el ID del cliente por confidencialidad.");
                System.out.println("ID del inmueble alquilado: " + ((Alquiler) Main.alquileres.elementAt(i)).inmueble_id);
                System.out.println("Direccion del inmueble alquilado: " + ((Alquiler) Main.alquileres.elementAt(i)).direccion_inmueble);
                Main.salto_espacio();
            }
        }

    }
    /********
     * Mostrar todos los alquileres que tiene un inquilino, de no tener ninguno, retorna al Main.
     */
    public static void mostrarAlquileres_inquilino() {
        System.out.println("Ingrese el ID del cliente a ver sus alquileres.");
        int id_inquilino = Main.escanearInt();
        verificarAlquiler_inquilino(id_inquilino);
        for (int i = 0; i < Main.alquileres.size(); i++) {
            if (id_inquilino == ((Alquiler) Main.alquileres.elementAt(i)).inquilino_id) {
                System.out.println("Nombre del cliente: " + ((Alquiler) Main.alquileres.elementAt(i)).nombre_inquilino);
                System.out.println("ID del cliente: " + ((Alquiler) Main.alquileres.elementAt(i)).inquilino_id);
                System.out.println("ID del inmueble alquilado: " + ((Alquiler) Main.alquileres.elementAt(i)).inmueble_id);
                System.out.println("Dirección del inmueble alquilado: " + ((Alquiler) Main.alquileres.elementAt(i)).direccion_inmueble);
                System.out.println("______________________________________");
                Main.salto_espacio();
            }
        }


    }

    
    /** 
     * Verifica si el inmueble se encuentra en el vector de alquileres, de ser False, retorna al main, de ser True, retorno vacío.
     * @param id_inmueble ID del inmueble
     */
    public static void verificarAlquiler_inmueble(int id_inmueble) {
        for (int i = 0; i < Main.alquileres.size(); i++) {
            if (id_inmueble == ((Alquiler) Main.alquileres.elementAt(i)).inmueble_id) {
                return;
            }
        }
        System.out.println("No se ha encontrado este inmueble en la lista de alquileres.");
        Main.salto_espacio();
        Main.back_to_main();
    }

    
    /** 
     * Verifica si el inquilino se encuentra en el vector de alquileres, de ser False, retorna al Main, de ser True, retorna al vacío
     * @param id_inquilino ID del inquilino
     */
    public static void verificarAlquiler_inquilino(int id_inquilino) {
        for (int i = 0; i < Main.alquileres.size(); i++) {
            if (id_inquilino == ((Alquiler) Main.alquileres.elementAt(i)).inquilino_id) {
                return;
            }
        }
        System.out.println("No se ha encontrado a este cliente en la lista de alquileres.");
        Main.salto_espacio();
        Main.back_to_main();
    }

    /********
     * Elimina un elemento del vector alquileres, dando el ID del inquilino y el inmueble a desalquilar
     */
    public static void desalquilar() {
        System.out.println("Ingrese el ID del alquilador.");
        int id_alquilador = Main.escanearInt();
        verificarAlquiler_inquilino(id_alquilador);
        System.out.println("Ingrese el ID del inmueble a desalquilar");
        int id_inmueble = Main.escanearInt();
        verificarAlquiler_inmueble(id_inmueble);
        for (int i = 0; i < Main.alquileres.size(); i++) {
            if (((Alquiler) Main.alquileres.elementAt(i)).inquilino_id == id_alquilador && ((Alquiler) Main.alquileres.elementAt(i)).inmueble_id == id_inmueble) {
                System.out.println("Se ha encontrado su respectivo alquiler cliente.");
                System.out.println("Actual dueño de alquiler. " + ((Alquiler) Main.alquileres.elementAt(i)).nombre_inquilino);
                System.out.println("Dirección del inmueble: " + ((Alquiler) Main.alquileres.elementAt(i)).direccion_inmueble);
                System.out.println("¿Desea eliminar este alquiler?");
                if (Main.escanearInt() != 1) {
                    eliminarAlquiler(i, id_inmueble);
                }

            }
        }
        System.out.println("No se ha encontrado un alquiler de ese inmueble siendo este cliente el actual dueño, por favor, verificar si los ID son correctos.");
        Main.salto_espacio();
    }

    
    /** 
     * Elimina el elemento del vector Alquiler
     * @param pos_alquiler posición en el vector Alquiler
     * @param id_inmueble ID del inmueble
     */
    public static void eliminarAlquiler(int pos_alquiler, int id_inmueble) {

        int pos_inmueble = Inmueble.buscar_pos_id_inmueble(id_inmueble);
        ((Inmueble) Main.inmuebles.elementAt(pos_inmueble)).id_cliente = 0;
        Main.alquileres.removeElementAt(pos_alquiler);
        System.out.println("Alquiler eliminado correctamente...");
        Main.salto_espacio();
        Main.back_to_main();

    }

    
    /** 
     * Metodo Get para el ID del inquilino
     * @return ID del inquilino
     */
    public int getInquilino_id() {
        return inquilino_id;
    }

    
    /** 
     * Metodo Get para el ID del inmueble
     * @return ID del inmueble
     */
    public int getInmueble_id() {
        return inmueble_id;
    }


    
    /** 
     * Metodo Set para el ID del inmueble 
     * @param inmueble_id ID del inmueble
     */
    public void setInmueble_id(int inmueble_id) {
        this.inmueble_id = inmueble_id;
    }

    
    /** 
     * Metodo Set para el ID del inquilino
     * @param inquilino_id
     */
    public void setInquilino_id(int inquilino_id) {
        this.inquilino_id = inquilino_id;
    }

    
    /** 
     * Metodo Set para el nombre del inquilino
     * @param nombre_inquilino nombre del inquilino
     */
    public void setNombre_inquilino(String nombre_inquilino) {
        this.nombre_inquilino = nombre_inquilino;
    }

    
    /** 
     * Metodo Get para el nombre_inquilino
     * @return String del nombre del inquilino
     */
    public String getNombre_inquilino() {
        return nombre_inquilino;
    }

    
    /** 
     * Metodo Get para la dirección del inmueble
     * @return String de la dirección del inmueble
     */
    public String getDireccion_inmueble() {
        return direccion_inmueble;
    }

    
    /** 
     * Metodo Set para la direccion del inmueble
     * @param direccion_inmueble direccion del inmueble
     */
    public void setDireccion_inmueble(String direccion_inmueble) {
        this.direccion_inmueble = direccion_inmueble;
    }

}

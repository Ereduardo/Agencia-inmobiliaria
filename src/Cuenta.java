/********
 * La clase cuenta hace referencia a la cuenta bancaria
 * la cual puede abrir y consignar cada cliente registrado en la agencia con su ID
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

public class Cuenta {
    private double cuenta;
    private int id_cliente;
    private String nombre_cliente;
    /*******
     * Metodo constructor de Cuenta 
     * la cual ayuda a rellenar el vector Cuentas con el objeto creado a partir
     */
    Cuenta() {
        if (Main.usuarios.isEmpty()) {
            System.out.println("No hay clientes registrados, volviendo al menú.");
            Main.salto_espacio();
            Main.back_to_main();
        }
        System.out.println("Escriba el ID del cliente de la cuenta a abrir: ");
        int id = Main.escanearInt();
        Inquilino.verificar_inquilino(id);
        int pos_id = Inquilino.buscar_pos_id_inquilino(id);
        verificarCuentaRepetida(id);
        this.setNombre_cliente(((Inquilino) Main.usuarios.elementAt(pos_id)).getNombre());
        this.setId_cliente(((Inquilino) Main.usuarios.elementAt(pos_id)).getIdentificador());
        System.out.println("¿Cuanto va a consignar en su cuenta para empezar?");
        Double importe = Main.escanearDouble();
        this.setCuenta(importe);
        Main.cuentas.addElement(this);
        System.out.println("Su cuenta ha comenzado con: " + ((Cuenta) Main.cuentas.elementAt(pos_id)).getCuenta() + " $");
        Main.salto_espacio();
        Movimiento.identificarGanancia(pos_id, importe);

    }
/*************
 * Metodo para consignar dinero a la cuenta bancaria de un cliente con su ID
 * 
 */
    public static void consignarCuenta() {
        System.out.println("¿Cual es el ID del cliente dueño de la cuenta?");
        int id = Main.escanearInt();
        int pos_id = verificarCuenta(id);
        System.out.println("¿Cuanto va a consignar a la cuenta?");
        Double importe = Main.escanearDouble();
        ((Cuenta) Main.cuentas.elementAt(pos_id)).setCuenta((((Cuenta) Main.cuentas.elementAt(pos_id)).getCuenta() + importe));
        Main.salto_espacio();
        System.out.println("La cuenta actualmente tiene: " + ((Cuenta) Main.cuentas.elementAt(pos_id)).getCuenta());
        Movimiento.identificarGanancia(pos_id, importe);
        Main.salto_espacio();
        Main.back_to_main();

    }

    
    /** 
     * Verifica si una cuenta ya existe en el vector, retornando al Main de ser True.
     * @param id ID del cliente
     */
    public static void verificarCuentaRepetida(int id) {
        for (int i = 0; i < Main.cuentas.size(); i++) {
            if (id == ((Cuenta) Main.cuentas.elementAt(i)).id_cliente) {
                System.out.println("Cuenta hallada, no hace falta volverla a abrir.");
                System.out.println("Nombre del dueño: ");
                System.out.println(((Cuenta) Main.cuentas.elementAt(i)).nombre_cliente);
                System.out.println("Saldo actual: ");
                System.out.println(((Cuenta) Main.cuentas.elementAt(i)).getCuenta());
                System.out.println("\nRegresando al menú...");
                Main.salto_espacio();
                Main.back_to_main();
            }
        }
    }

    
    /** 
     * Verifica si una cuenta del cliente existe, retornando su posición en el vector cuentas
     * @param id ID del cliente
     * @return int posición en el vector
     */
    public static int verificarCuenta(int id) {
        for (int i = 0; i < Main.cuentas.size(); i++) {
            if (id == ((Cuenta) Main.cuentas.elementAt(i)).id_cliente) {
                System.out.println("Cuenta hallada, nombre del dueño: ");
                System.out.println(((Cuenta) Main.cuentas.elementAt(i)).nombre_cliente);
                Main.salto_espacio();
                return i; // Retorna la posicion
            }
        }
        System.out.println("Cuenta no encontrada, regresando al menú.");
        Main.salto_espacio();
        Main.back_to_main();
        return 0;
    }
    /*******
     * Metodo para mostrar el saldo de la cuenta bancaria con el ID del cliente
     */
    public static void mostrarSaldoCuenta() {
        System.out.println("Ingresar el ID del dueño de la cuenta.");
        int pos_id_cliente = verificarCuenta(Main.escanearInt());
        System.out.println("El saldo del cliente: " + ((Cuenta) Main.cuentas.elementAt(pos_id_cliente)).nombre_cliente);
        System.out.println("Contiene la suma de: " + ((Cuenta) Main.cuentas.elementAt(pos_id_cliente)).cuenta + " $");
        Main.salto_espacio();
        Main.back_to_main();
    }


    
    /** 
     * Metodo Set para la cuenta del cliente
     * @param cuenta
     */
    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }


    
    /** 
     * Metodo Set para el ID del cliente
     * @param id_cliente
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    
    /** 
     * Metodo Set para el nombre del cliente
     * @param nombre_cliente
     */
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    
    /** 
     * Metodo Get para la cuenta del cliente
     * @return double
     */
    public double getCuenta() {
        return cuenta;
    }

    
    /** 
     * Metodo Get para el nombre del cliente
     * @return String
     */
    public String getNombre_cliente() {
        return nombre_cliente;
    }


}

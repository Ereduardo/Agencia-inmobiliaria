

/********
 * Clase movimiento, para guardar los gastos o ganancias de los inquilinos en su respectivo vector
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
 */

public class Movimiento {
    private boolean tipoMovimiento;// 1 = ingreso or 0 = gasto
    private int id_inmueble;
    private int id_inquilino;
    private float importe;  //Cantidad de dinero
    private String nombre_inquilino;


    
    /** 
     * Metodo para identificar un movimiento y guardarlo como gasto en el vector con un Booleano
     * @param pos_inm Posición del inmueble en el vector
     * @param pos_inqui Posición del inquilino en el vector
     * @param importe Cantidad gastada 
     */
    public static void identificarGasto(int pos_inm, int pos_inqui, float importe) {
        Movimiento gasto = new Movimiento();
        gasto.setTipoMovimiento(false);
        gasto.setId_inmueble(((Inmueble) Main.inmuebles.elementAt(pos_inm)).iD_inmueble);
        gasto.setId_inquilino(((Inquilino) Main.usuarios.elementAt(pos_inqui)).getIdentificador());
        gasto.setNombre_inquilino(((Inquilino) Main.usuarios.elementAt(pos_inqui)).getNombre());
        importe *= -1;
        gasto.setImporte(importe);
        Main.movimientos.addElement(gasto);
    }

    /*
     * Metodo para buscar  movimientos en el vector con el ID del cliente
     */
    public static void buscarMovimiento() {
        System.out.println("Inserte el ID del respectivo cliente: ");
        int id = Main.escanearInt();
        verificarMovimientos(id);
        for (int i = 0; i < Main.movimientos.size(); i++) {
            if (id == ((Movimiento) Main.movimientos.elementAt(i)).getId_inquilino()) {
                System.out.println("___________________________________");
                System.out.println("Nombre del cliente: " + ((Movimiento) Main.movimientos.elementAt(i)).getNombre_inquilino());
                System.out.println("ID del cliente: " + ((Movimiento) Main.movimientos.elementAt(i)).getId_inquilino());
                if (((Movimiento) Main.movimientos.elementAt(i)).tipoMovimiento) {
                    System.out.println("Una ganancia de: " + ((Movimiento) Main.movimientos.elementAt(i)).getImporte());
                } else {
                    System.out.println("Un gasto de: " + ((Movimiento) Main.movimientos.elementAt(i)).getImporte());
                }

            }
        }
    }

    
    /**    
     * Metodo para guardar en el vector de Movimientos y registrarlo como Ganancia
     * @param pos_inqui Posición de inquilino en el vector
     * @param importe Cantidad de dinero movido
     */
    public static void identificarGanancia(int pos_inqui, Double importe) {
        Movimiento ganancia = new Movimiento();
        ganancia.setTipoMovimiento(true);
        ganancia.setId_inmueble(0);//No necesitamos del inmueble en las ganancias
        ganancia.setId_inquilino(((Inquilino) Main.usuarios.elementAt(pos_inqui)).getIdentificador());
        ganancia.setNombre_inquilino(((Inquilino) Main.usuarios.elementAt(pos_inqui)).getNombre());
        ganancia.setImporte(importe.floatValue());
        Main.movimientos.addElement(ganancia);

    }
    /**
     * Metodo para buscar solo ganancias en el vector de Movimientos
     * @param ID ID del cliente
     */
    public static void buscarGanancias() {
        System.out.println("Inserte el ID del respectivo cliente: ");
        int id = Main.escanearInt();
        verificarMovimientos(id);
        for (int i = 0; i < Main.movimientos.size(); i++) { //Mientras llega al final del vector
            if (((Movimiento) Main.movimientos.elementAt(i)).tipoMovimiento) { //Mientras sea positivo el importe
                if (id == ((Movimiento) Main.movimientos.elementAt(i)).getId_inquilino()) { //Mientras el importe sea del cliente
                    System.out.println("Nombre del cliente: " + ((Movimiento) Main.movimientos.elementAt(i)).getNombre_inquilino());
                    System.out.println("Identificador del cliente: " + ((Movimiento) Main.movimientos.elementAt(i)).getId_inquilino());
                    System.out.println("Ganancia registrada: " + ((Movimiento) Main.movimientos.elementAt(i)).getImporte());
                    System.out.println("___________________________________");
                }
            }
        }


    }
    /**
     * Metodo para buscar solo gastos en el vector de Movimientos 
     * @param ID ID del cliente
     */
    public static void buscarGastos() {
        System.out.println("Inserte el ID del respectivo cliente: ");
        int id = Main.escanearInt();
        verificarMovimientos(id);
        for (int i = 0; i < Main.movimientos.size(); i++) {
            if (((Movimiento) Main.movimientos.elementAt(i)).tipoMovimiento == false) {
                if (id == ((Movimiento) Main.movimientos.elementAt(i)).getId_inquilino()) {
                    System.out.println("Nombre del cliente: " + ((Movimiento) Main.movimientos.elementAt(i)).getNombre_inquilino());
                    System.out.println("Identificador del cliente: " + ((Movimiento) Main.movimientos.elementAt(i)).getId_inquilino());
                    System.out.println("Gasto registrado: " + ((Movimiento) Main.movimientos.elementAt(i)).getImporte());
                    System.out.println("___________________________________");
                }
            }
        }
    }

    
    /**    
     * Metodo para verificar si existe el cliente en los movimientos
     * @param id ID del cliente
     */
    public static void verificarMovimientos(int id) {
        for (int i = 0; i < Main.movimientos.size(); i++) {
            if (id == ((Movimiento) Main.movimientos.elementAt(i)).getId_inquilino()) {
                System.out.println("Cliente hallado en los movimientos, nombre del cliente: " + ((Movimiento) Main.movimientos.elementAt(i)).getNombre_inquilino());
                Main.salto_espacio();
                return;
            }
        }
        System.out.println("No se ha encontrado a este cliente en los movimientos.");
        Main.salto_espacio();
        Main.back_to_main();
    }


    
    /**   
     * 
     * @param id_inmueble
     */
    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }


    
    /** 
     * @param id_inquilino
     */
    public void setId_inquilino(int id_inquilino) {
        this.id_inquilino = id_inquilino;
    }


    
    /** 
     * @param importe
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }


    
    /** 
     * @param nombre_inquilino
     */
    public void setNombre_inquilino(String nombre_inquilino) {
        this.nombre_inquilino = nombre_inquilino;
    }


    
    /** 
     * @param tipoMovimiento
     */
    public void setTipoMovimiento(boolean tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }


    
    /** 
     * @return int
     */
    public int getId_inmueble() {
        return id_inmueble;
    }


    
    /** 
     * @return int
     */
    public int getId_inquilino() {
        return id_inquilino;
    }


    
    /** 
     * @return float
     */
    public float getImporte() {
        return importe;
    }


    
    /** 
     * @return String
     */
    public String getNombre_inquilino() {
        return nombre_inquilino;
    }


}

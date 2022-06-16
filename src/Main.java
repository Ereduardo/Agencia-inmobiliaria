/********
 * 
 * La clase Main, donde se ubican los vectores que almanecenan datos y redirige al usuario a través de menús
 * 
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Vector;

/************************************************* ***********************
 * Palabra de honor:
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

 /**
 *
 *
 *
 *
 * Links utilizados:
 *
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
 * Metodo sleep para la pausa temporal
 *
 * https://es.acervolima.com/system-exit-en-java/
 * Utilizado para System.exit(0) para salir del programa
 *
 *
 * https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html
 * Utilizado para el uso de Vectores en java.
 *
 *https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
 * Utilizado para el metodo de numeros aleatorios como nuevo_ID() o generarCosto()
 *
 */


public class Main {
    public static Scanner leer = new Scanner(System.in);
    public static Vector inmuebles = new Vector(10, 2);
    public static Vector facturas = new Vector(10, 2);
    public static Vector usuarios = new Vector(10, 2);
    public static Vector movimientos = new Vector(10, 2);
    public static Vector cuentas = new Vector(10, 2);
    public static Vector alquileres = new Vector(10, 2);


    
    
    public static void main(String[] args) {

        imprimirMenu();

    }
    /********
     * Metodo para 5 segundos de pausa para el usuario.
     * 
     */
    public static void salto_espacio() {
        System.out.println("\nPor favor, espere, no ingrese nada aún.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    
    /** 
     * Metodo para escanear Strings
     * @return String
     */
    public static String escanear() {
        return leer.nextLine();
    }


    
    /** 
     * Metodo para escanear enteros
     * @return int
     */
    public static int escanearInt() {
        try {
            int numero = Integer.parseInt(leer.nextLine());
            if (numero <= 0) {
                System.out.println("Por favor, ingrese un numero positivo y valido: ");
                return escanearInt();
            }
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un numero valido: ");
            return escanearInt();
        }
    }


    
    /** 
     * Metodo para escanear Doubles
     * @return Double
     */
    public static Double escanearDouble() {
        try {
            double numero = Double.parseDouble(leer.nextLine());
            if (numero <= 0) {
                System.out.println("Por favor, ingrese un numero positivo y valido: ");
                return escanearDouble();
            }
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un numero valido: ");
            return escanearDouble();
        }
    }


    
    /** 
     * Metodo para escanear Float
     * @return Float
     */
    public static Float escanearFloat() {
        try {
            Float numero = Float.parseFloat(leer.nextLine());
            if (numero <= 0) {
                System.out.println("Por favor, ingrese un numero positivo y valido: ");
                return escanearFloat();
            }
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un numero valido: ");
            return escanearFloat();
        }
    }


    
    /** 
     * Metodo para retornar un entero aleatorio entre 1 y 99999
     * @return entero aleatorio entre 1 y 99999
     */
    public static int nuevo_ID() {
        int id = (new Random().nextInt(99999) + 1);
        return id;
    }

    /*******
     * Metodo para imprimir el menú principal del programa
     */
    private static void imprimirMenu() {
        System.out.println("Bienvenido a la agencia inmobliaria. ");
        System.out.println("\n Seleccione un metodo: ");
        System.out.println("------------------------");
        System.out.println("1. Gestión de inmuebles");
        System.out.println("2. Consulta de Inmuebles");
        System.out.println("3. Gestión de Usuarios");
        System.out.println("4. Gestión de Facturas");
        System.out.println("5. Consulta de movimientos");
        System.out.println("6. Gestión de cuentas bancarias");
        System.out.println("7. Gestión de alquiler");
        System.out.println("8. Salir");
        System.out.print("Opción: ");
        switch (escanearInt()) {
            case 1:
                menu_Inmuebles();
                break;
            case 2:
                menu_consulta_inmuebles();
                break;
            case 3:
                menu_gestion_usuarios();
                break;
            case 4:
                menu_Gestion_Facturas();
                break;
            case 5:
                menu_Consulta_movimientos();
                break;
            case 6:
                menu_Gestion_Cuentas();
                break;
            case 7:
                menu_gestion_alquiler();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                imprimirMenu();

        }
    }
    /**
     * Metodo para imprimir el menú de Gestión de inmuebles
     */
    private static void menu_Inmuebles() {
        System.out.println("\nUsted ha escogido 'Gestión de inmuebles' ");
        System.out.println("1: Registrar inmueble");
        System.out.println("2: Modificar inmueble");
        System.out.println("3: Eliminar inmueble");
        System.out.println("4: Salir");
        System.out.print("Opción: ");
        switch (escanearInt()) {
            case 1:
                Inmueble inmueble_Registrado = new Inmueble();
                menu_Inmuebles();
                break;
            case 2:
                Inmueble.modificarInmueble();
                menu_Inmuebles();
                break;
            case 3:
                Inmueble.eliminarInmueble();
                menu_Inmuebles();
                break;
            case 4:
                main(null);
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                menu_Inmuebles();
        }
    }

    /******
     * Metodo para imprimir el menú de consulta de Inmuebles
     */
    private static void menu_consulta_inmuebles() {
        System.out.println("\nUsted ha escogido 'Consulta de Inmuebles' ");
        System.out.println("1: Buscar un inmueble");
        System.out.println("2: Ver todos los inmuebles registrados");
        System.out.println("3: Regresar");
        System.out.print("Opción: ");

        switch (escanearInt()) {
            case 1:
                Inmueble.mostrarInmueble();
                menu_consulta_inmuebles();
                break;
            case 2:
                Inmueble.mostrarTodosLosinmuebles();
                menu_consulta_inmuebles();
                break;
            case 3:
                main(null);
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                menu_consulta_inmuebles();
        }
    }
    /*******
     * Metodo para imprimir el menú de Gestión de usuarios
     */
    public static void menu_gestion_usuarios() {
        System.out.println("\nUsted ha escogido 'Gestión de usuarios' ");
        System.out.println("1: Registrar un cliente");
        System.out.println("2: Buscar un cliente");
        System.out.println("3: Eliminar un cliente");
        System.out.println("4: Regresar");
        System.out.print("Opción: ");

        switch (escanearInt()) {
            case 1:
                Inquilino registrar = new Inquilino();
                break;
            case 2:
                Inquilino.buscarInquilino();
                main(null);
                break;
            case 3:
                Inquilino.renunciarInquilino(Inquilino.buscarInquilino());
                break;
            case 4:
                main(null);
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                menu_gestion_usuarios();
        }
    }
    /*******
     * Metodo para imprimir el menú de Gestión de Facturas
     */
    public static void menu_Gestion_Facturas() {
        System.out.println("\nUsted ha escogido 'Gestión de Facturas' ");
        System.out.println("1. Generar factura del inmueble");
        System.out.println("2. Buscar factura del inmueble");
        System.out.println("3. Aportar a la factura del inmueble");
        System.out.println("4: Regresar");
        System.out.print("Opción: ");

        switch (escanearInt()) {
            case 1:
                Factura.generarFactura();
                back_to_main();
                break;
            case 2:
                Factura.mostrarFactura();
                back_to_main();
                break;
            case 3:
                Factura.pagar_factura(Factura.mostrarFactura());
                back_to_main();
                break;
            case 4:
                back_to_main();
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                menu_Gestion_Facturas();
        }

    }
    /********
     * Metodo para imprimir el menú de Gestión de cuentas
     */
    public static void menu_Gestion_Cuentas() {
        System.out.println("\nUsted ha escogido 'Gestión de cuentas bancarias' ");
        System.out.println("1: Abrir cuenta para cliente.");
        System.out.println("2: Revisar saldo de cuenta.");
        System.out.println("3: Consignar saldo a cuenta.");
        System.out.println("4: Regresar");
        System.out.print("Opción: ");

        switch (escanearInt()) {
            case 1:
                Cuenta abrir = new Cuenta();
                menu_Gestion_Cuentas();
                break;
            case 2:
                Cuenta.mostrarSaldoCuenta();
                menu_Gestion_Cuentas();
                break;
            case 3:
                Cuenta.consignarCuenta();
                menu_Gestion_Cuentas();
                break;
            case 4:
                back_to_main();
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                menu_Gestion_Cuentas();
        }

    }
    /********
     * Metodo para imprimir el menú de Consulta de movimientos
     */
    public static void menu_Consulta_movimientos() {
        System.out.println("\nUsted ha escogido 'Consulta de movimientos' ");
        System.out.println("1: Consultar todos los movimientos de un cliente.");
        System.out.println("2: Consultar todos los gastos de un cliente.");
        System.out.println("3: Consultar todas las ganancias de un cliente.");
        System.out.println("4: Regresar.");
        System.out.print("Opción: ");

        switch (escanearInt()) {
            case 1:
                Movimiento.buscarMovimiento();
                menu_Consulta_movimientos();
                break;
            case 2:
                Movimiento.buscarGastos();
                menu_Consulta_movimientos();
                break;
            case 3:
                Movimiento.buscarGanancias();
                menu_Consulta_movimientos();
                break;
            case 4:
                back_to_main();
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                menu_Consulta_movimientos();
        }

    }
    /********
     * Metodo para imprimir el menú de Gestión de alquiler
     */
    public static void menu_gestion_alquiler() {
        System.out.println("\nUsted ha escogido 'Gestión de alquiler' ");
        System.out.println("1. Alquilar un inmueble.");
        System.out.println("2. Verifica alquiler de un inmueble.");
        System.out.println("3. Mostrar todos los alquileres de un cliente. ");
        System.out.println("4. Des-alquilar un inmueble.");
        System.out.println("4. Regresar");
        System.out.print("Opción: ");
        switch (escanearInt()) {
            case 1:
                Alquiler registrar = new Alquiler();
                menu_gestion_alquiler();
                break;
            case 2:
                Alquiler.mostrarAlquiler_inmueble();
                menu_gestion_alquiler();
                break;
            case 3:
                Alquiler.mostrarAlquileres_inquilino();
                menu_gestion_alquiler();
                break;
            case 4:
                Alquiler.desalquilar();
            case 5:
                back_to_main();
                break;
            default:
                System.out.println("Ingrese una opción dentro del menú.");
                Main.salto_espacio();
                menu_gestion_alquiler();
        }
    }
    /*******
     * Metodo para volver al Main, utilizado en las otras clases.
     */
    public static void back_to_main() {
        imprimirMenu();
    }


}

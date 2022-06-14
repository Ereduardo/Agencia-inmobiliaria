import java.util.Scanner;
import java.util.Random;
import java.util.Vector;

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
 * 
 * 
 * 
 */


public class Main {
    public static Scanner leer = new Scanner(System.in);
    public static Vector inmuebles = new Vector(10,2);
    public static Vector facturas = new Vector(10,2);
    public static Vector usuarios = new Vector(10,  2);
    public static Vector movimientos = new Vector(10,2);
    public static Vector cuentas = new Vector(10,2);

    
   
    public static void main(String[] args){
        imprimirMenu();
    }

    public static void salto_espacio(){
        System.out.println("\nPor favor, esperar.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        
    }

    
    public static String escanear(){
        return leer.nextLine();
    }

    
   
    public static int escanearInt(){
        try{
        int numero = Integer.parseInt(leer.nextLine());
        if(numero <= 0){System.out.println("Por favor, ingrese un numero positivo y valido: ");return escanearInt();}
        return numero;}
            catch(NumberFormatException e){
                System.out.println("Por favor, ingrese un numero valido: ");
                return escanearInt();
        }
    }

    
   
    public static Double escanearDouble(){
        try{
        double numero = Double.parseDouble(leer.nextLine());
        if(numero <= 0){System.out.println("Por favor, ingrese un numero positivo y valido: ");return escanearDouble();}
        return numero;}
            catch(NumberFormatException e){
                System.out.println("Por favor, ingrese un numero valido: ");
                return escanearDouble();
            }
    }

    
   
    public static Float escanearFloat(){
        try{
        Float numero = Float.parseFloat(leer.nextLine());
        if(numero <= 0){System.out.println("Por favor, ingrese un numero positivo y valido: ");return escanearFloat();}
        return numero;}
            catch(NumberFormatException e){
                System.out.println("Por favor, ingrese un numero valido: ");
                return escanearFloat();
            }
    }

    
    
    public static Boolean comparar_String(String a, String b) {
        Boolean validar = a.equalsIgnoreCase(b);
        return validar;

    }

    
    
    public static int nuevo_ID(){
        int id = (new Random().nextInt(99999)+1); 
        return id;
    }

    private static void imprimirMenu() {
        System.out.println("Bienvenido a la agencia inmobliaria. ");
        System.out.println("\n Seleccione un metodo: ");
        System.out.println("------------------------");
        System.out.println("1. Gestión de inmuebles");
        System.out.println("2. Consulta de Inmuebles");
        System.out.println("3. Gestión de Usuarios");
        System.out.println("4. Gestión de Facturas.");
        System.out.println("5. Consulta de movimientos y facturas");
        System.out.println("6. Gestión de cuentas.");
        System.out.println("7. Salir");
        switch(escanearInt()){
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
            case 6:
            menu_Gestion_Cuentas();
            break;
            case 7: System.exit(0);
            break;
            default: 
            imprimirMenu();
        
        }
    }

    private static void menu_Inmuebles(){
        System.out.println("\nUsted ha escogido 'Gestión de inmuebles' ");
        System.out.println("1: Registrar inmueble");
        System.out.println("2: Modificar inmueble");
        System.out.println("3: Eliminar inmueble");
        System.out.println("4: Salir");
        switch(escanearInt()){
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
            case 4: main(null);
            break;
            default: menu_Inmuebles();
        }
    } 

   

    private static void menu_consulta_inmuebles(){
        System.out.println("\nUsted ha escogido 'Consulta de Inmuebles' ");
        System.out.println("1: Buscar un inmueble");
        System.out.println("2: Ver todos los inmuebles registrados");
        System.out.println("3: Regresar");

        switch(escanearInt()){
            case 1:
            Inmueble.mostrarInmueble();
            menu_consulta_inmuebles();
            break;
            case 2:
            Inmueble.mostrarTodosLosinmuebles();
            menu_consulta_inmuebles();
            break;
            case 3: main(null);
            break;
            default: menu_consulta_inmuebles();
        }
    }

    public static void menu_gestion_usuarios(){
        System.out.println("\nUsted ha escogido 'Gestión de usuarios' ");
        System.out.println("1: Registrar un cliente.");
        System.out.println("2: Buscar un cliente.");
        System.out.println("3: Eliminar un cliente.");
        System.out.println("4: Regresar");

        switch (escanearInt()){
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
            default: menu_gestion_usuarios();
        }
    }

    public static void menu_Gestion_Facturas(){
        System.out.println("\nUsted ha escogido 'Gestión de Facturas' ");
        System.out.println("1. Generar factura del inmueble");
        System.out.println("2. Buscar factura del inmueble");
        System.out.println("3. Aportar a la factura del inmueble");
        System.out.println("4: Regresar");

        switch(escanearInt()){
            case 1: Factura.generarFactura();
            back_to_main();
            break;
            case 2: Factura.mostrarFactura();
            back_to_main();
            break;
            case 3: Factura.pagar_factura(Factura.mostrarFactura());
            back_to_main();
            break;
            case 4: back_to_main();
            break;
            default:
            menu_Gestion_Facturas();
        }

    }

    public static void menu_Gestion_Cuentas(){
        System.out.println("\nUsted ha escogido 'Gestión de cuentas' ");
        System.out.println("1: Abrir cuenta para cliente.");
        System.out.println("2: Revisar saldo de cuenta.");
        System.out.println("3: Consignar saldo a cuenta.");
        System.out.println("4: Regresar");

        switch(escanearInt()){
            case 1: Cuenta abrir = new Cuenta();
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
            menu_Gestion_Cuentas();
        }

    }

    public static void back_to_main(){
        imprimirMenu();
    }


    

}

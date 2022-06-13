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
    public static Vector usuarios = new Vector(10,2);

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
    public static Boolean comparar_String(String a, String b) {
        Boolean validar = a.equalsIgnoreCase(b);
        return validar;

    }

    public static int nuevo_ID(){
        int id = new Random().nextInt(99999); 
        return id;
    }

    private static void imprimirMenu() {
        System.out.println("Bienvenido a la agencia inmobliaria. ");
        System.out.println("\n Seleccione un metodo: ");
        System.out.println("------------------------");
        System.out.println("1. Gestión de inmuebles");
        System.out.println("2. Consulta de Inmuebles");
        System.out.println("3. Gestión de Usuarios");
        System.out.println("5. Gestión de movimientos.");
        System.out.println("6. Consulta de movimientos y facturas");
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
            case 7: System.exit(0);
            break;
            default: 
            main(null);
        
        }
    }

    private static void menu_Inmuebles(){
        System.out.println("\nUsted ha escogido 'Gestión de inmuebles' ");
        System.out.println("1: Registrar inmueble");
        System.out.println("2: Modificar inmueble");
        System.out.println("3: Eliminar inmueble");
        System.out.println("4 o +: Salir");
        switch(escanearInt()){
            case 1:
            Inmueble inmueble_Registrado = new Inmueble();
            main(null);
            break;
            case 2:
            Inmueble.modificarInmueble();
            main(null);
            break;
            case 3:
            Inmueble.eliminarInmueble();
            main(null);
            break;
            case 4: main(null);
            break;
            default: main(null);
        }
    } 

    private static void menu_consulta_inmuebles(){
        System.out.println("\nUsted ha escogido 'Consulta de Inmuebles' ");
        System.out.println("1: Buscar un inmueble");
        System.out.println("2: Ver todos los inmuebles registrados");

        switch(escanearInt()){
            case 1:
            Inmueble.mostrarInmueble();
            break;
            case 2:
            Inmueble.mostrarTodosLosinmuebles();
            break;
            default: main(null);   
        }
    }

    public static void menu_gestion_usuarios(){
        System.out.println("\nUsted ha escogido 'Gestión de usuarios' ");
        System.out.println("1: Registrar un cliente.");
        System.out.println("2: Buscar un cliente.");
        System.out.println("3: Eliminar un cliente.");

        switch (escanearInt()){
            case 1:
            Inquilino registrar = new Inquilino();
            break;
            case 2:
            Inquilino.buscarInquilino();
            main(null);
            case 3:
            Inquilino.renunciarInquilino(Inquilino.buscarInquilino());
            default: main(null);
        }
    }

    public static void back_to_main(){
        imprimirMenu();
    }


    

}

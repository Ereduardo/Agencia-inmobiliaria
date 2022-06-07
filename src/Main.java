import java.util.Scanner;
import java.util.Random;


/**
 * Links utilizados:
 * 
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
 * Metodo sleep para la pausa temporal
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class Main {
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args){
        
        
        imprimirMenu();
        
        
        //getOpcion();
        //Inquilino test = new Inquilino();
        //Inmueble esova = new Inmueble();
       // test = new Inquilino();
       // MainFrame aFrame = new MainFrame();
         // aFrame.inicializar(); 
      
                
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
        int min = 11111;
        int max = 99999;
        int id = new Random().nextInt(max + min); //EL identificador es un codigo entre 111111 y 999999
        return id;
    }

    private static void imprimirMenu() {
        System.out.println("Bienvenido a la agencia inmobliaria. ");
        System.out.println("\n Seleccione un metodo: ");
        System.out.println("------------------------");
        System.out.println("1. Gestión de inmuebles");
        System.out.println("2. Consulta de Inmuebles");
        System.out.println("3. Gestión de Usuarios");
        System.out.println("4. Consulta de Usuarios");
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
            //agregar menu de gestión de usuarios
            break;
            default: return;

            
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
            Inmueble.registrarInmueble();
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
            case 4: return;
            default: return;
        }
    } 

    private static void menu_consulta_inmuebles(){
        System.out.println("\nUsted ha escogido 'Consulta de Inmuebles' ");
        System.out.println("1: Buscar un inmueble");
        System.out.println("2: ");

        switch(escanearInt()){
            case 1:
            Inmueble.mostrarInmueble();
            main(null);
        }
    }



    
}

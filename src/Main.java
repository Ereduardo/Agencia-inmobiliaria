import java.util.Scanner;


public class Main {
    
    public static void main(String[] args){
        imprimirMenu();
        getOpcion();
        Inquilino test = new Inquilino();
        test = new Inquilino();
        //MainFrame aFrame = new MainFrame();
        //aFrame.inicializar(); 
      
                
    }


    public static String escanear(){
        Scanner leer = new Scanner(System.in);
        return leer.nextLine();
    }

    public static int escanearInt(){
        Scanner leer = new Scanner(System.in);
        return Integer.parseInt(leer.nextLine());
    }

    private static void imprimirMenu() {
        System.out.println("\n Seleccione un metodo: ");
        System.out.println("------------------------");
        System.out.println("1. Gestión de inmuebles");
        System.out.println("2. Consulta de Inmuebles");
        System.out.println("3. Consulta de Usuarios");
        System.out.println("4. Consulta de movimientos y facturas");
    }

    private static int getOpcion() throws NumberFormatException {
        int opcion = -1;
        while (opcion < 0 || opcion > 7){
                try {
            System.out.println("Introduzca su opción: \n");
            opcion = escanearInt();
            }
            catch(NumberFormatException e){
                System.out.println("Introduzca un número valido.");
                System.out.println("Presione Enter para continuar.\n");
                Scanner pausa = new Scanner(System.in);
            }
        } 
        return opcion;
    }
    

    
}

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
      
       imprimirMenu();
      

    }

    private static void imprimirMenu() {
        System.out.println("\n Seleccione un metodo: ");
        System.out.println("------------------------");
        System.out.println("1. Gestión de inmuebles");
        System.out.println("2. Consulta de Inmuebles");
        System.out.println("3. Consulta de Usuarios");
        System.out.println("4. Consulta de movimientos y facturas");
        getOpcion();
    }

    private static int getOpcion() throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        while (opcion < 0 || opcion > 7){
                try {
            System.out.println("Introduzca su opción: \n");
            opcion = Integer.parseInt(sc.nextLine());
                }
            catch(NumberFormatException e){
                System.out.println("Introduzca un número valido.");
                System.out.println("Presione Enter para continuar.\n");
                new java.util.Scanner(System.in).nextLine();
            }

        }        
        return opcion;
    }



    
}

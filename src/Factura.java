import java.util.Random;

public class Factura {
   
    private float telefono = generarCosto();// Telefono / Agua / Gas / Electricidad
    private float agua = generarCosto();
    private float gas = generarCosto();
    private float electricidad = generarCosto();
    private int id_inmueble;
    private int id_inquilino;



    public static void generarFactura(){
        if(Main.inmuebles.isEmpty()){
            System.out.println("Usted no tiene inmuebles registrados, registre primero.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        if(Main.usuarios.isEmpty()){
            System.out.println("No tiene clientes registrados, registrarlos primero.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        Factura factura = new Factura();
        System.out.println("¿Cual es el ID del cliente que está pagando?");
        int id_pagando = Main.escanearInt();
        System.out.println("¿Cual es el ID de su inmueble?");
        int id_hallar = Main.escanearInt();
        factura.verificar_factura_repetida(id_hallar);
        for(int i = 0; i<Main.inmuebles.size();i++){
            if(id_hallar ==((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble ){
                factura.id_inmueble = id_hallar;
                System.out.println("El inmueble registrado con ID: " + id_hallar);
                System.out.println("Tiene costos en su factura con conceptos de: ");
                System.out.println("Telefono: " + factura.telefono);
                System.out.println("Agua: " + factura.agua);
                System.out.println("Gas: " + factura.gas);
                System.out.println("Electricidad: " +factura.electricidad);
                System.out.println("Para un valor total a cancelar de: "+(factura.telefono+factura.agua+factura.gas+factura.electricidad));
            }
            Main.facturas.addElement(factura);
            
        }
        Main.salto_espacio();
        Main.back_to_main();
    }

    public static int mostrarFactura(){  
        if(Main.facturas.isEmpty() || Main.inmuebles.isEmpty()){
            System.out.println("No tiene ningún inmueble registrado o factura generada.");
            System.out.println("Por favor, registrar estos 2 primero.");
            Main.salto_espacio();
            Main.menu_Gestion_Movimientos();
        }
        
        System.out.println("¿Cual es el ID de su inmueble?");
        int id_hallar = Main.escanearInt();
        int pos_factura = buscar_pos_id_factura(id_hallar);

        if(pos_factura == id_hallar) {
            System.out.println("No se ha encontrado ningún inmueble con esa ID.");
                }else{
                float mostrar_tlf = ((Factura)Main.facturas.elementAt(pos_factura)).telefono;
                float mostrar_agua = ((Factura)Main.facturas.elementAt(pos_factura)).agua;
                float mostrar_gas = ((Factura)Main.facturas.elementAt(pos_factura)).gas;
                float mostrar_electricidad = ((Factura)Main.facturas.elementAt(pos_factura)).electricidad;
                System.out.println("El inmueble registrado con el ID: "+id_hallar);
                System.out.println("Tiene una factura pendiente con costos y conceptos de: ");
                System.out.println("Telefono: " + mostrar_tlf);
                System.out.println("Agua: " + mostrar_agua);
                System.out.println("Gas: " + mostrar_gas);
                System.out.println("Electricidad: " + mostrar_electricidad);
                System.out.println("Para un valor total a cancelar de: "+(mostrar_tlf+mostrar_agua+mostrar_gas+mostrar_electricidad));
                Main.salto_espacio();
         }
            return id_hallar;
}
        
    

    public static void pagar_factura(int id){
        int pos_factura = buscar_pos_id_factura(id);
        System.out.println("¿En cual factura del inmueble va a aportar?");
        System.out.println("1 = Telefono | 2 = Agua | 3 = Gas | 4 = Electricidad");
        switch(Main.escanearInt()){
            // PAGO DE FACTURA DE TELEFONO INICIO
            case 1: 
            if(((Factura)Main.facturas.elementAt(pos_factura)).telefono == 0){
                System.out.println("Usted está a paz y salvo con la factura del telefono.");
                Main.salto_espacio();
                Main.back_to_main();
            }
            System.out.println("¿De cuanto será su aporte?");
            ((Factura)Main.facturas.elementAt(pos_factura)).telefono = verificar_pago(Main.escanearFloat(),((Factura)Main.facturas.elementAt(pos_factura)).telefono);
            System.out.println("La factura de telefono ha quedado en: "+((Factura)Main.facturas.elementAt(pos_factura)).telefono+" peso(s). ");
            break;
            //PAGO DE FACTURA DE TELEFONO FINAL
            
             //PAGO DE FACTURA DE AGUA INICIO
            case 2:
            if(((Factura)Main.facturas.elementAt(pos_factura)).agua == 0){
                System.out.println("Usted está a paz y salvo con la factura del agua.");
                Main.salto_espacio();
                Main.back_to_main();
            }
            System.out.println("¿De cuanto será su aporte?");
            ((Factura)Main.facturas.elementAt(pos_factura)).agua = verificar_pago(Main.escanearFloat(),((Factura)Main.facturas.elementAt(pos_factura)).agua);
            System.out.println("La factura de agua ha quedado en: "+((Factura)Main.facturas.elementAt(pos_factura)).agua+" peso(s). ");
            break;
             //PAGO DE FACTURA DE AGUA FINAL

             //PAGO DE FACTURA DE GAS INICIO
            case 3:
            if(((Factura)Main.facturas.elementAt(pos_factura)).gas == 0){
                System.out.println("Usted está a paz y salvo con la factura del gas.");
                Main.salto_espacio();
                Main.back_to_main();
            }
            System.out.println("¿De cuanto será su aporte?");
            ((Factura)Main.facturas.elementAt(pos_factura)).gas = verificar_pago(Main.escanearFloat(),((Factura)Main.facturas.elementAt(pos_factura)).gas);
            System.out.println("La factura de gas ha quedado en: "+((Factura)Main.facturas.elementAt(pos_factura)).gas+" peso(s). ");
            break;
            //PAGO DE FACTURA DE GAS FINAL

            //PAGO DE FACTURA DE ELECTRICIDAD INICIO
            case 4:
            if(((Factura)Main.facturas.elementAt(pos_factura)).electricidad == 0){
                System.out.println("Usted está a paz y salvo con la factura de eectricidad.");
                Main.salto_espacio();
                Main.back_to_main();
            }
            System.out.println("¿De cuanto será su aporte?");
            ((Factura)Main.facturas.elementAt(pos_factura)).electricidad = verificar_pago(Main.escanearFloat(),((Factura)Main.facturas.elementAt(pos_factura)).electricidad);
            System.out.println("La factura de electricidad ha quedado en: "+((Factura)Main.facturas.elementAt(pos_factura)).electricidad+" peso(s). ");
            break;
            //PAGO DE FACTURA DE ELECTRICIDAD FINAL
            default:
            pagar_factura(id); //Repetir si escoje un numero incorrecto
        }
        verificar_factura_pagada();
        Main.salto_espacio();
        Main.back_to_main();
    }

    public static float verificar_pago(float pago, float factura){
        if(factura < pago){
            System.out.println("Ha aportado más de lo debido en la factura, se igualará el aporte a la factura.");
            Main.salto_espacio();
            pago = factura;
        }
        if(pago == 0){
            System.out.println("Ha digitado un aporte de 0 pesos, será regresado al menú. ");
            Main.salto_espacio();
            Main.back_to_main();
        }

        factura -= pago;

        return factura;
    }

    public static int buscar_pos_id_factura(int id){
        for(int i = 0; i <Main.facturas.size();i++){
            if(id == ((Factura)Main.facturas.elementAt(i)).id_inmueble){
                return i;
            }
        }
        return id;
    }

    public void verificar_factura_repetida(int id){
        for(int i = 0; i<Main.facturas.size();i++){
        if(id == ((Factura)Main.facturas.elementAt(i)).id_inmueble){ 
            System.out.println("Usted ya tiene su factura, busquela en su respectiva opción.");
            Main.salto_espacio();
            Main.back_to_main();
            }
        }
    }

    public static void verificar_factura_pagada(){
        float cobro_total = 1;
        for(int i = 0; i <Main.facturas.size();i++){
            cobro_total = (((Factura)Main.facturas.elementAt(i)).agua+((Factura)Main.facturas.elementAt(i)).gas+((Factura)Main.facturas.elementAt(i)).electricidad+((Factura)Main.facturas.elementAt(i)).telefono);
            if(cobro_total==0){
                Main.facturas.removeElementAt(i);
                System.out.println("La factura del inmueble de ID: "+((Factura)Main.facturas.elementAt(i)).id_inmueble);
                System.out.println("ha terminado de ser pagada, está a paz y salvo por este mes.");
                Main.salto_espacio();
                Main.back_to_main();
            }
        }
    }

     public float generarCosto(){
        float min = 25000;
        float max = 400000;
        float costo = new Random().nextFloat(max + min);
        return costo;
     }

}


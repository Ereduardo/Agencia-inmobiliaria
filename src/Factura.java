import java.util.Random;


public class Factura {
   
    private float telefono = generarCosto();// Telefono / Agua / Gas / Electricidad
    private float agua = generarCosto();
    private float gas = generarCosto();
    private float electricidad = generarCosto();
    private int mes; private int ano; // año
    private int id_facturando;



    public static void generarFactura(){
        Factura factura = new Factura();
        System.out.println("¿Cual es el ID de su inmueble?");
        int id_hallar = Main.escanearInt();
        factura.verificar_factura(id_hallar);
        for(int i = 0; i<Main.inmuebles.size();i++){
            if(id_hallar ==((Inmueble)Main.inmuebles.elementAt(i)).iD_inmueble ){
                factura.id_facturando = id_hallar;
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
    }

    public void mostrarFactura(){
     
        System.out.println("¿Cual es el ID de su inmueble?");
        int id_hallar = Main.escanearInt();
        for(int i=0; i<Main.inmuebles.size();i++){
            if(id_hallar == ((Factura)Main.facturas.elementAt(i)).id_facturando){
                float mostrar_tlf = ((Factura)Main.facturas.elementAt(i)).telefono;
                float mostrar_agua = ((Factura)Main.facturas.elementAt(i)).agua;
                float mostrar_gas = ((Factura)Main.facturas.elementAt(i)).gas;
                float mostrar_electricidad = ((Factura)Main.facturas.elementAt(i)).electricidad;
                System.out.println("El inmueble registrado con el ID: "+id_hallar);
                System.out.println("Tiene una factura pendiente con costos y conceptos de: ");
                System.out.println("Telefono: " + mostrar_tlf);
                System.out.println("Agua: " + mostrar_agua);
                System.out.println("Gas: " + mostrar_gas);
                System.out.println("Electricidad: " + mostrar_electricidad);
                System.out.println("Para un valor total a cancelar de: "+(mostrar_tlf+mostrar_agua+mostrar_gas+mostrar_electricidad));


            }
        }
        
    }

    public void verificar_factura(int id){
        for(int i = 0; i<Main.facturas.size();i++){
        if(id == ((Factura)Main.facturas.elementAt(i)).id_facturando){ 
            System.out.println("Usted ya tiene su factura, busquela en su respectiva opción.");
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


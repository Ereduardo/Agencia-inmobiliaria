import java.util.Random;


public class Factura {
    private Inmueble inmueble; 
    private float telefono = 0;// Telefono / Agua / Gas / Electricidad
    private float agua = 0;
    private float gas = 0;
    private float electricidad = 0;
    private int mes; private int ano; // año



    public void generarFactura(){
        System.out.println("¿Cual es el ID de su inmueble?");
        int id_hallar = Main.escanearInt();
        for(int i = 0; i<Inmueble.inmuebles.size();i++){
           
                
            
        }
    }

    public void mostrarFactura(int id){
        System.out.println("El inmueble de ID: ("+id+") registrado con: ");
        
    }

    public float generarCosto(){
        float min = 25000;
        float max = 400000;
        float costo = new Random().nextFloat(max + min);
        return costo;
     }

     public void setInmueble(Inmueble inmueble) {
         this.inmueble = inmueble;
     }
}


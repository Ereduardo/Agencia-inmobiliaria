public class Movimiento {
    private boolean tipoMovimiento;// 1 = ingreso or 0 = gasto
    private int id_inmueble; 
    private int id_inquilino;
    private float importe;  //Cantidad de dinero
    private String nombre_inquilino;
    
    
    public static void identificarGasto(int pos_inm, int pos_inqui, float importe) {
        Movimiento gasto = new Movimiento();
        gasto.setTipoMovimiento(false);
        gasto.setId_inmueble(((Inmueble)Main.inmuebles.elementAt(pos_inm)).iD_inmueble);
        gasto.setId_inquilino(((Inquilino)Main.usuarios.elementAt(pos_inqui)).getIdentificador());
        gasto.setNombre_inquilino(((Inquilino)Main.usuarios.elementAt(pos_inqui)).getNombre());
        importe *= -1;
        gasto.setImporte(importe);
        Main.movimientos.addElement(gasto);
    }

    
    public static void buscarMovimiento(){
        System.out.println("Inserte el ID del respectivo cliente: ");
        int id = Main.escanearInt();
        verificarMovimientos(id);
        for(int i = 0; i <Main.movimientos.size(); i++){
            if(id == ((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino()){
                System.out.println("___________________________________");
                System.out.println("Nombre del cliente: "+((Movimiento)Main.movimientos.elementAt(i)).getNombre_inquilino());
                System.out.println("ID del cliente: "+((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino());
                if(((Movimiento)Main.movimientos.elementAt(i)).tipoMovimiento){
                    System.out.println("Una ganancia de: "+((Movimiento)Main.movimientos.elementAt(i)).getImporte());
                }else{
                    System.out.println("Un gasto de: "+((Movimiento)Main.movimientos.elementAt(i)).getImporte());
                }
                
            }
        }
    }

    public static void identificarGanancia(int pos_inqui, Double importe){
        Movimiento ganancia = new Movimiento();
        ganancia.setTipoMovimiento(true);
        ganancia.setId_inmueble(0);//No necesitamos del inmueble en las ganancias
        ganancia.setId_inquilino(((Inquilino)Main.usuarios.elementAt(pos_inqui)).getIdentificador());
        ganancia.setNombre_inquilino(((Inquilino)Main.usuarios.elementAt(pos_inqui)).getNombre());
        float importe_float = importe.floatValue();
        ganancia.setImporte(importe_float);
        Main.movimientos.addElement(ganancia);

    }
    
    public static void buscarGanancias(){
        System.out.println("Inserte el ID del respectivo cliente: ");
        int id = Main.escanearInt();
        verificarMovimientos(id);
        for(int i=0;i<Main.movimientos.size();i++){ //Mientras llega al final del vector
            if(((Movimiento)Main.movimientos.elementAt(i)).tipoMovimiento){ //Mientras sea positivo el importe
                if(id == ((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino()){ //Mientras el importe sea del cliente
                    System.out.println("Nombre del cliente: "+((Movimiento)Main.movimientos.elementAt(i)).getNombre_inquilino());
                    System.out.println("Identificador del cliente: "+((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino());
                    System.out.println("Ganancia registrada: "+((Movimiento)Main.movimientos.elementAt(i)).getImporte());
                    System.out.println("___________________________________");
                }
            }
        }
        

    }

    public static void buscarGastos(){
        System.out.println("Inserte el ID del respectivo cliente: ");
        int id = Main.escanearInt();
        verificarMovimientos(id);
        for(int i=0; i<Main.movimientos.size(); i++){
            if(((Movimiento)Main.movimientos.elementAt(i)).tipoMovimiento==false){
                if(id == ((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino()){
                    System.out.println("Nombre del cliente: "+((Movimiento)Main.movimientos.elementAt(i)).getNombre_inquilino());
                    System.out.println("Identificador del cliente: "+((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino());
                    System.out.println("Gasto registrado: "+((Movimiento)Main.movimientos.elementAt(i)).getImporte());
                    System.out.println("___________________________________");
                }
            }
        }
    }
    
    public static void verificarMovimientos(int id){
        for(int i = 0; i<Main.movimientos.size(); i++){
            if(id == ((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino()){
                System.out.println("Cliente hallado en los movimientos, nombre del cliente: "+((Movimiento)Main.movimientos.elementAt(i)).getNombre_inquilino());
                Main.salto_espacio();
                return;
            }
        }
        System.out.println("No se ha encontrado a este cliente en los movimientos.");
        Main.salto_espacio();
        Main.back_to_main();
    }

  /*   public static int buscar_pos_id_movimiento(int id){
        for(int i = 0; i<Main.movimientos.size(); i++){
            if(id == ((Movimiento)Main.movimientos.elementAt(i)).getId_inquilino()){
                return i;
            }
        }
        return id;
    } */
  
    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    
   
    public void setId_inquilino(int id_inquilino) {
        this.id_inquilino = id_inquilino;
    }

    
   
    public void setImporte(float importe) {
        this.importe = importe;
    }

    
   
    public void setNombre_inquilino(String nombre_inquilino) {
        this.nombre_inquilino = nombre_inquilino;
    }
    
   
    public void setTipoMovimiento(boolean tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }


    
   
    public int getId_inmueble() {
        return id_inmueble;
    }
    
   
    public int getId_inquilino() {
        return id_inquilino;
    }

    
    
    public float getImporte() {
        return importe;
    }

    
    
    public String getNombre_inquilino() {
        return nombre_inquilino;
    }

    
}

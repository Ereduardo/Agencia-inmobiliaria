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

    
   
    public static void identificarGanancia(int pos_inqui, Double importe){
        Movimiento ganancia = new Movimiento();
        ganancia.setTipoMovimiento(true);
        ganancia.setId_inmueble(0);
        ganancia.setId_inquilino(((Inquilino)Main.usuarios.elementAt(pos_inqui)).getIdentificador());
        ganancia.setNombre_inquilino(((Inquilino)Main.usuarios.elementAt(pos_inqui)).getNombre());
        float importe_float = importe.floatValue();
        ganancia.setImporte(importe_float);
        Main.movimientos.addElement(ganancia);

    }
    


    
    
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

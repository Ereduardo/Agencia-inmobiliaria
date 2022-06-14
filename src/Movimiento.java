public class Movimiento {
    private boolean tipoMovimiento;// 1 = ingreso or 0 = gasto
    private int id_inmueble; 
    private int id_inquilino;
    private float importe;  //Cantidad de dinero
    private String nombre_inquilino;
    

    public static void identificarGasto() {
        Movimiento gasto = new Movimiento();
        gasto.setTipoMovimiento(false);
       
    }

    public static void identificarGanancia(){

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

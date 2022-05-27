import java.util.Date;


public class Factura {
    private int telefono = 0; 
    private float agua = 0;
    private float gas = 10;
    private float electricidad = 0;
    private Date fecha = new Date();

    public int getTelefono() {
        return telefono;
    }

    public float getAgua() {
        return agua;
    }

    public float getGas() {
        return gas;
    }

    public float getElectricidad() {
        return electricidad;
    }

    public Date getFecha() {
        return fecha;
    }

}


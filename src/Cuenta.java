public class Cuenta {
    private double cuenta;
    private int id_cliente;
    //private int id_nombre;
    private String nombre_cliente;

    Cuenta(){
        if(Main.usuarios.isEmpty()){
            System.out.println("No hay clientes registrados, volviendo al menú.");
            Main.salto_espacio();
            Main.back_to_main();
        }
        
        int pos_id = -1;
        System.out.println("Escriba el ID del cliente de la cuenta a abrir: ");
        int id = Inquilino.buscar_pos_id_inquilino(Main.escanearInt());
        if(id > Main.usuarios.size()){
            System.out.println("No se ha encontrado ningún cliente con ese ID.");
            Main.salto_espacio();
            Main.back_to_main();
        }else{
            pos_id = id;
        }

        this.setNombre_cliente(((Inquilino)Main.usuarios.elementAt(pos_id)).getNombre());
        this.setId_cliente(((Inquilino)Main.usuarios.elementAt(pos_id)).getIdentificador());
        System.out.println("¿Cuanto va a consignar en su cuenta para empezar?");
        this.setCuenta(Main.escanearDouble());
        Main.cuentas.addElement(this);

    }

public static void abrirCuenta(){
    

}

    



public void setCuenta(double cuenta) {
    this.cuenta = cuenta;
}



public void setId_cliente(int id_cliente) {
    this.id_cliente = id_cliente;
}


public void setNombre_cliente(String nombre_cliente) {
    this.nombre_cliente = nombre_cliente;
}



public String getNombre_cliente() {
    return nombre_cliente;
}

}

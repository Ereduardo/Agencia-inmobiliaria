public class Cuenta {
    private double cuenta;
    private int id_cliente;
    private String nombre_cliente;

    Cuenta() {
        if (Main.usuarios.isEmpty()) {
            System.out.println("No hay clientes registrados, volviendo al menú.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        System.out.println("Escriba el ID del cliente de la cuenta a abrir: ");
        int id = Main.escanearInt();
        Inquilino.verificar_inquilino(id);
        int pos_id = Inquilino.buscar_pos_id_inquilino(id);
        verificarCuentaRepetida(id);
        this.setNombre_cliente(((Inquilino) Main.usuarios.elementAt(pos_id)).getNombre());
        this.setId_cliente(((Inquilino) Main.usuarios.elementAt(pos_id)).getIdentificador());
        System.out.println("¿Cuanto va a consignar en su cuenta para empezar?");
        Double importe = Main.escanearDouble();
        this.setCuenta(importe);
        Main.cuentas.addElement(this);
        System.out.println("Su cuenta ha comenzado con: " + ((Cuenta) Main.cuentas.elementAt(pos_id)).getCuenta() + " $");
        Main.salto_espacio();
        Movimiento.identificarGanancia(pos_id, importe);

    }

    public static void consignarCuenta() {
        System.out.println("¿Cual es el ID del cliente dueño de la cuenta?");
        int id = Main.escanearInt();
        int pos_id = verificarCuenta(id);
        System.out.println("¿Cuanto va a consignar a la cuenta?");
        Double importe = Main.escanearDouble();
        ((Cuenta) Main.cuentas.elementAt(pos_id)).setCuenta((((Cuenta) Main.cuentas.elementAt(pos_id)).getCuenta() + importe));
        Main.salto_espacio();
        System.out.println("La cuenta actualmente tiene: " + ((Cuenta) Main.cuentas.elementAt(pos_id)).getCuenta());
        Movimiento.identificarGanancia(pos_id, importe);
        Main.salto_espacio();
        Main.back_to_main();

    }

    public static void verificarCuentaRepetida(int id) {
        for (int i = 0; i < Main.cuentas.size(); i++) {
            if (id == ((Cuenta) Main.cuentas.elementAt(i)).id_cliente) {
                System.out.println("Cuenta hallada, no hace falta volverla a abrir.");
                System.out.println("Nombre del dueño: ");
                System.out.println(((Cuenta) Main.cuentas.elementAt(i)).nombre_cliente);
                System.out.println("Saldo actual: ");
                System.out.println(((Cuenta) Main.cuentas.elementAt(i)).getCuenta());
                System.out.println("\nRegresando al menú...");
                Main.salto_espacio();
                Main.back_to_main();
            }
        }
    }

    public static int verificarCuenta(int id) {
        for (int i = 0; i < Main.cuentas.size(); i++) {
            if (id == ((Cuenta) Main.cuentas.elementAt(i)).id_cliente) {
                System.out.println("Cuenta hallada, nombre del dueño: ");
                System.out.println(((Cuenta) Main.cuentas.elementAt(i)).nombre_cliente);
                Main.salto_espacio();
                return i; // Retorna la posicion
            }
        }
        System.out.println("Cuenta no encontrada, regresando al menú.");
        Main.salto_espacio();
        Main.back_to_main();
        return 0;
    }

    public static void mostrarSaldoCuenta() {
        System.out.println("Ingresar el ID del dueño de la cuenta.");
        int pos_id_cliente = verificarCuenta(Main.escanearInt());
        System.out.println("El saldo del cliente: " + ((Cuenta) Main.cuentas.elementAt(pos_id_cliente)).nombre_cliente);
        System.out.println("Contiene la suma de: " + ((Cuenta) Main.cuentas.elementAt(pos_id_cliente)).cuenta + " $");
        Main.salto_espacio();
        Main.back_to_main();
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

    public double getCuenta() {
        return cuenta;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }


}

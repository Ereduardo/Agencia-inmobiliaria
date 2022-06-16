import java.util.Random;

/***********
 * La clase factura para las facturas de los inmuebles a conceptos de Telefono, agua, gas y electricidad
 * con sus respectivos costos
 */
public class Factura {

    private float telefono = generarCosto();// Telefono / Agua / Gas / Electricidad
    private float agua = generarCosto();
    private float gas = generarCosto();
    private float electricidad = generarCosto();
    private int id_inmueble;
    private int id_inquilino;

    /***********
     * Metodo para generar la factura de un inmueble con el ID del inmueble y de un cliente registrado
     */
    public static void generarFactura() {
        if (Main.inmuebles.isEmpty()) {
            System.out.println("Usted no tiene inmuebles registrados, registre primero.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        if (Main.usuarios.isEmpty()) {
            System.out.println("No tiene clientes registrados, registrarlos primero.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        Factura factura = new Factura();
        System.out.println("¿Cual es el ID del cliente que está pagando?");
        int id_pagando = Main.escanearInt();
        Inquilino.verificar_inquilino(id_pagando);
        System.out.println("¿Cual es el ID de su inmueble?");
        int id_hallar = Main.escanearInt();
        Inmueble.verificar_inmueble(id_hallar);
        factura.verificar_factura_repetida(id_hallar);
        for (int i = 0; i < Main.inmuebles.size(); i++) {
            if (id_hallar == ((Inmueble) Main.inmuebles.elementAt(i)).iD_inmueble) {
                factura.id_inquilino = id_pagando;
                factura.id_inmueble = id_hallar;
                System.out.println("El inmueble registrado con ID: " + id_hallar);
                System.out.println("Tiene costos en su factura con conceptos de: ");
                System.out.println("Telefono: " + factura.telefono);
                System.out.println("Agua: " + factura.agua);
                System.out.println("Gas: " + factura.gas);
                System.out.println("Electricidad: " + factura.electricidad);
                System.out.println("Para un valor total a cancelar de: " + (factura.telefono + factura.agua + factura.gas + factura.electricidad));
            }
            Main.facturas.addElement(factura);

        }
        Main.salto_espacio();
        Main.back_to_main();
    }


    
    /** 
     * Metodo para mostrar una factura del vector Facturas con el ID del inmueble
     * @return int ID del inmueble
     */
    public static int mostrarFactura() {
        if (Main.facturas.isEmpty() || Main.inmuebles.isEmpty()) {
            System.out.println("No tiene ningún inmueble registrado o factura generada.");
            System.out.println("Por favor, registrar estos 2 primero.");
            Main.salto_espacio();
            Main.menu_Gestion_Facturas();
        }

        System.out.println("¿Cual es el ID de su inmueble?");
        int id_hallar = Main.escanearInt();
        Inmueble.verificar_inmueble(id_hallar);
        if (buscar_pos_id_factura(id_hallar) == id_hallar) {
            System.out.println("No se ha encontrado factura, regresando al menú...");
            Main.salto_espacio();
            Main.back_to_main();
        }
        int pos_factura = buscar_pos_id_factura(id_hallar);
        float mostrar_tlf = ((Factura) Main.facturas.elementAt(pos_factura)).telefono;
        float mostrar_agua = ((Factura) Main.facturas.elementAt(pos_factura)).agua;
        float mostrar_gas = ((Factura) Main.facturas.elementAt(pos_factura)).gas;
        float mostrar_electricidad = ((Factura) Main.facturas.elementAt(pos_factura)).electricidad;
        System.out.println("El inmueble registrado con el ID: " + id_hallar);
        System.out.println("Tiene una factura pendiente con costos y conceptos de: ");
        System.out.println("Telefono: " + mostrar_tlf);
        System.out.println("Agua: " + mostrar_agua);
        System.out.println("Gas: " + mostrar_gas);
        System.out.println("Electricidad: " + mostrar_electricidad);
        System.out.println("Para un valor total a cancelar de: " + (mostrar_tlf + mostrar_agua + mostrar_gas + mostrar_electricidad));
        Main.salto_espacio();
        return id_hallar;
    }


    
    /** 
     * Metodo para pagar facturas con el ID del inmueble
     * @param id id del inmueble
     */
    public static void pagar_factura(int id) {

        System.out.println("¿Cual es la ID del cliente pagando?");
        int id_pagando = Main.escanearInt();
        Cuenta.verificarCuenta(id_pagando);
        System.out.println("El saldo escrito será tomado de su cuenta bancaria para pagar las facturas.");
        Main.salto_espacio();
        Inquilino.verificar_inquilino(id_pagando);
        int pos_inmueble = Inmueble.buscar_pos_id_inmueble(id);
        int pos_factura = buscar_pos_id_factura(id);
        int pos_pagando = Inquilino.buscar_pos_id_inquilino(id_pagando);
        float pago_factura;
        System.out.println("¿En cual factura del inmueble va a aportar?");
        System.out.println("1 = Telefono | 2 = Agua | 3 = Gas | 4 = Electricidad");
        int opcion = Main.escanearInt();
        System.out.println("¿De cuanto será su aporte?");
        pago_factura = Main.escanearFloat();
        switch (opcion) {
            // PAGO DE FACTURA DE TELEFONO INICIO
            case 1:
                if (((Factura) Main.facturas.elementAt(pos_factura)).telefono == 0) {
                    System.out.println("Usted está a paz y salvo con la factura del telefono.");
                    Main.salto_espacio();
                    Main.back_to_main();
                }
                System.out.println("¿De cuanto será su aporte?");
                ((Factura) Main.facturas.elementAt(pos_factura)).telefono = verificar_pago(pago_factura, ((Factura) Main.facturas.elementAt(pos_factura)).telefono, pos_pagando, pos_inmueble);
                System.out.println("La factura de telefono ha quedado en: " + ((Factura) Main.facturas.elementAt(pos_factura)).telefono + " peso(s). ");
                break;
            //PAGO DE FACTURA DE TELEFONO FINAL

            //PAGO DE FACTURA DE AGUA INICIO
            case 2:
                if (((Factura) Main.facturas.elementAt(pos_factura)).agua == 0) {
                    System.out.println("Usted está a paz y salvo con la factura del agua.");
                    Main.salto_espacio();
                    Main.back_to_main();
                }
                ((Factura) Main.facturas.elementAt(pos_factura)).agua = verificar_pago(pago_factura, ((Factura) Main.facturas.elementAt(pos_factura)).agua, pos_pagando, pos_inmueble);
                System.out.println("La factura de agua ha quedado en: " + ((Factura) Main.facturas.elementAt(pos_factura)).agua + " peso(s). ");
                break;
            //PAGO DE FACTURA DE AGUA FINAL

            //PAGO DE FACTURA DE GAS INICIO
            case 3:
                if (((Factura) Main.facturas.elementAt(pos_factura)).gas == 0) {
                    System.out.println("Usted está a paz y salvo con la factura del gas.");
                    Main.salto_espacio();
                    Main.back_to_main();
                }
                ((Factura) Main.facturas.elementAt(pos_factura)).gas = verificar_pago(pago_factura, ((Factura) Main.facturas.elementAt(pos_factura)).gas, pos_pagando, pos_inmueble);
                System.out.println("La factura de gas ha quedado en: " + ((Factura) Main.facturas.elementAt(pos_factura)).gas + " peso(s). ");

                break;
            //PAGO DE FACTURA DE GAS FINAL

            //PAGO DE FACTURA DE ELECTRICIDAD INICIO
            case 4:
                if (((Factura) Main.facturas.elementAt(pos_factura)).electricidad == 0) {
                    System.out.println("Usted está a paz y salvo con la factura de electricidad.");
                    Main.salto_espacio();
                    Main.back_to_main();
                }
                ((Factura) Main.facturas.elementAt(pos_factura)).electricidad = verificar_pago(pago_factura, ((Factura) Main.facturas.elementAt(pos_factura)).electricidad, pos_pagando, pos_inmueble);
                System.out.println("La factura de electricidad ha quedado en: " + ((Factura) Main.facturas.elementAt(pos_factura)).electricidad + " peso(s). ");
                break;
            //PAGO DE FACTURA DE ELECTRICIDAD FINAL
            default:
                pagar_factura(id); //Repetir si escoje un numero incorrecto
        }
        verificar_factura_pagada();
        ((Factura) Main.facturas.elementAt(pos_factura)).id_inquilino = id_pagando;

        Main.salto_espacio();
        Main.back_to_main();
    }


    
    /** 
     * Verificar el pago de la factura y cobrarle a la cuenta del cliente
     * @param pago
     * @param factura
     * @param pos_pagando
     * @param pos_inmueble
     * @return float Factura después del pago
     */
    public static float verificar_pago(float pago, float factura, int pos_pagando, int pos_inmueble) {
        Double cuenta = ((Cuenta) Main.cuentas.elementAt(pos_pagando)).getCuenta();

        if (pago > cuenta) {
            System.out.println("Se ha excedido el valor de la cuenta, no tiene suficiente saldo para esa cantidad.");
            System.out.println("Regresando al menú...");
            Main.salto_espacio();
            Main.back_to_main();
        }

        if (factura < pago) {
            System.out.println("Ha aportado más de lo debido en la factura, se igualará el aporte a la factura.");
            Main.salto_espacio();
            pago = factura;
        }
        factura -= pago;
        ((Cuenta) Main.cuentas.elementAt(pos_pagando)).setCuenta(cuenta - pago);
        Movimiento.identificarGasto(pos_inmueble, pos_pagando, pago);
        return factura;
    }


    
    /** 
     * Metodo para buscar la posición del id de la factura en el Vector
     * @param id ID del inmueble 
     * @return int posición del ID de la factura
     */
    public static int buscar_pos_id_factura(int id) {
        for (int i = 0; i < Main.facturas.size(); i++) {
            if (id == ((Factura) Main.facturas.elementAt(i)).id_inmueble) {
                return i;
            }
        }
        return id;
    }


    
    /** 
     * Metodo para verificar si la factura está repetida en el vector con el ID del inmueble
     * @param id ID del inmueble
     */
    public void verificar_factura_repetida(int id) {
        for (int i = 0; i < Main.facturas.size(); i++) {
            if (id == ((Factura) Main.facturas.elementAt(i)).id_inmueble) {
                System.out.println("Usted ya tiene su factura, busquela en su respectiva opción.");
                Main.salto_espacio();
                Main.back_to_main();
            }
        }
    }
    /*******
     * Verifica si la factura está a paz y salvo después de haber terminado de pagar su totalidad 
     */
    public static void verificar_factura_pagada() {
        float cobro_total = 1;
        for (int i = 0; i < Main.facturas.size(); i++) {
            cobro_total = (((Factura) Main.facturas.elementAt(i)).agua + ((Factura) Main.facturas.elementAt(i)).gas + ((Factura) Main.facturas.elementAt(i)).electricidad + ((Factura) Main.facturas.elementAt(i)).telefono);
            if (cobro_total == 0) {
                Main.facturas.removeElementAt(i);
                System.out.println("La factura del inmueble de ID: " + ((Factura) Main.facturas.elementAt(i)).id_inmueble);
                System.out.println("ha terminado de ser pagada, está a paz y salvo por este mes.");
                Main.salto_espacio();
                Main.back_to_main();
            }
        }
    }

    
    /** 
     * Genera los costos de las facturas con la libreria Random
     * @return float Costo de factura
     */
    public float generarCosto() {
        float min = 25000;
        float max = 400000;
        float costo = new Random().nextFloat(max + min);
        return costo + 1;
    }

}


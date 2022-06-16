public class Alquiler {
    private int inquilino_id;
    private int inmueble_id;
    private String nombre_inquilino;
    private String direccion_inmueble;
    
    Alquiler(){
        System.out.println("Ingrese el ID del inmueble: ");
        int id_inmueble = Main.escanearInt();
        verificarAlquilerRepetido(id_inmueble);
        Inmueble.verificar_inmueble(id_inmueble);
        System.out.println("Ingrese el ID del cliente: ");
        int id_cliente = Main.escanearInt();
        Inquilino.verificar_inquilino(id_cliente);
        pagarAlquiler(id_cliente, id_inmueble);
        int pos_inquilino = Inquilino.buscar_pos_id_inquilino(id_cliente);
        int pos_inmueble = Inmueble.buscar_pos_id_inmueble(id_inmueble);
        this.setNombre_inquilino(((Inquilino)Main.usuarios.elementAt(pos_inquilino)).getNombre());
        this.setInquilino_id(id_cliente);
        this.setInmueble_id(id_inmueble);
        this.setDireccion_inmueble(((Inmueble)Main.inmuebles.elementAt(pos_inmueble)).getDireccion());
        Main.alquileres.addElement(this);
        System.out.println("Contrato de alquiler completado correctamente.");
        Main.salto_espacio();
        Main.back_to_main();

     
    }
    public static void verificarAlquilerRepetido(int id_inmueble){
        for(int i = 0; i<Main.alquileres.size(); i++){
            if(id_inmueble == ((Alquiler)Main.alquileres.elementAt(i)).getInmueble_id()){
                System.out.println("Este inmueble ya se encuentra alquilado, no se puede volver a alquilar.");
                Main.salto_espacio();
                Main.back_to_main();
            }
        }

    }
    public static void pagarAlquiler(int id_cliente, int id_inmueble){
        System.out.println("En caso de que el cliente no tenga una cuenta abierta con la cual pagar alquiler");
        System.out.println("el sistema lo retornará automaticamente al menú.");
        Main.salto_espacio();
        int pos_cuenta = Cuenta.verificarCuenta(id_cliente);
        int pos_inmueble = Inmueble.buscar_pos_id_inmueble(id_inmueble);
        Double precio_alquiler = ((Inmueble)Main.inmuebles.elementAt(pos_inmueble)).precioAlquiler;
        int pos_inquilino = Inquilino.buscar_pos_id_inquilino(id_cliente);
        System.out.println("El precio de alquiler del inmueble con dirección "+((Inmueble)Main.inmuebles.elementAt(pos_inmueble)).direccion);
        System.out.println("es de: "+precio_alquiler+"$");
        System.out.println("¿Está seguro de pagar? Se cobrará de la cuenta del cliente.");
        System.out.println("Presione 1 para confirmar, 2 o + para regresar al menú.");
        if(Main.escanearInt()!=1){
            Main.back_to_main();
        }
        if(((Cuenta)Main.cuentas.elementAt(pos_cuenta)).getCuenta() < precio_alquiler ){
            System.out.println("No tiene dinero suficiente en cuenta para pagar el alquiler.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        ((Inmueble)Main.inmuebles.elementAt(pos_inmueble)).id_cliente = id_cliente;
        ((Cuenta)Main.cuentas.elementAt(pos_cuenta)).setCuenta(((Cuenta)Main.cuentas.elementAt(pos_cuenta)).getCuenta()-precio_alquiler);
        Movimiento.identificarGasto(pos_inmueble, pos_inquilino, precio_alquiler.floatValue());
        
    }

    public static void mostrarAlquiler_inmueble(){
        System.out.println("Ingrese el ID del inmueble para verificar su alquiler.");
        int id_inmueble = Main.escanearInt();
        verificarAlquiler_inmueble(id_inmueble);
        for(int i = 0; i <Main.alquileres.size(); i++){
            if(id_inmueble == ((Alquiler)Main.alquileres.elementAt(i)).inmueble_id){
                System.out.println("Inmueble alquilado, mostrando información del alquiler: ");
                System.out.println("Nombre del cliente alquilador: "+((Alquiler)Main.alquileres.elementAt(i)).nombre_inquilino);
                System.out.println("Se guarda el ID del cliente por confidencialidad.");
                System.out.println("ID del inmueble alquilado: "+((Alquiler)Main.alquileres.elementAt(i)).inmueble_id);
                System.out.println("Direccion del inmueble alquilado: "+((Alquiler)Main.alquileres.elementAt(i)).direccion_inmueble);
                Main.salto_espacio();
            }
        }

    }

    public static void mostrarAlquileres_inquilino(){
        System.out.println("Ingrese el ID del cliente a ver sus alquileres.");
        int id_inquilino = Main.escanearInt();
        verificarAlquiler_inquilino(id_inquilino);
        for(int i=0;i<Main.alquileres.size();i++){
            if(id_inquilino == ((Alquiler)Main.alquileres.elementAt(i)).inquilino_id){
                System.out.println("Nombre del cliente: "+((Alquiler)Main.alquileres.elementAt(i)).nombre_inquilino);
                System.out.println("ID del cliente: "+((Alquiler)Main.alquileres.elementAt(i)).inquilino_id);
                System.out.println("ID del inmueble alquilado: "+((Alquiler)Main.alquileres.elementAt(i)).inmueble_id);
                System.out.println("Dirección del inmueble alquilado: "+((Alquiler)Main.alquileres.elementAt(i)).direccion_inmueble);
                System.out.println("______________________________________");
                Main.salto_espacio();
            }
        }
        

    }

    public static void verificarAlquiler_inmueble (int id_inmueble){
        for(int i = 0; i <Main.alquileres.size(); i++){
            if(id_inmueble == ((Alquiler)Main.alquileres.elementAt(i)).inmueble_id){
                return;
            }
        }
        System.out.println("No se ha encontrado este inmueble en la lista de alquileres.");
        Main.salto_espacio();
    }

    public static void verificarAlquiler_inquilino(int id_inquilino){
        for(int i = 0; i <Main.alquileres.size(); i++){
            if(id_inquilino == ((Alquiler)Main.alquileres.elementAt(i)).inquilino_id){
                return;
            }
        }
        System.out.println("No se ha encontrado a este cliente en la lista de alquileres.");
        Main.salto_espacio();
        Main.back_to_main();
    }


    public static void desalquilar(){
        System.out.println("Ingrese el ID del alquilador.");
        int id_alquilador = Main.escanearInt();
        verificarAlquiler_inquilino(id_alquilador);
        System.out.println("Ingrese el ID del inmueble a desalquilar");
        int id_inmueble = Main.escanearInt();
        verificarAlquiler_inmueble(id_inmueble);
            for(int i=0;i<Main.alquileres.size();i++){
                if(((Alquiler)Main.alquileres.elementAt(i)).inquilino_id==id_alquilador && ((Alquiler)Main.alquileres.elementAt(i)).inmueble_id == id_inmueble){
                    System.out.println("Se ha encontrado su respectivo alquiler cliente.");
                    System.out.println("Actual dueño de alquiler. "+((Alquiler)Main.alquileres.elementAt(i)).nombre_inquilino);
                    System.out.println("Dirección del inmueble: "+((Alquiler)Main.alquileres.elementAt(i)).direccion_inmueble);
                    System.out.println("¿Desea eliminar este alquiler?");
                    if(Main.escanearInt()!=1){
                        eliminarAlquiler(i,id_inmueble);
                    }

                }
            }
        System.out.println("No se ha encontrado un alquiler de ese inmueble siendo este cliente el actual dueño, por favor, verificar si los ID son correctos.");
            Main.salto_espacio();
    }

        public static void eliminarAlquiler(int pos_alquiler, int id_inmueble){

        int pos_inmueble = Inmueble.buscar_pos_id_inmueble(id_inmueble);
            ((Inmueble)Main.inmuebles.elementAt(pos_inmueble)).id_cliente = 0;
            Main.alquileres.removeElementAt(pos_alquiler);
            System.out.println("Alquiler eliminado correctamente...");
            Main.salto_espacio();
            Main.back_to_main();

        }

    public int getInquilino_id() {
        return inquilino_id;
    }
    public int getInmueble_id() {
        return inmueble_id;
    }

    
    public void setInmueble_id(int inmueble_id) {
        this.inmueble_id = inmueble_id;
    }

    public void setInquilino_id(int inquilino_id) {
        this.inquilino_id = inquilino_id;
    }

    public void setNombre_inquilino(String nombre_inquilino) {
        this.nombre_inquilino = nombre_inquilino;
    }
    public String getNombre_inquilino() {
        return nombre_inquilino;
    }
    
    public String getDireccion_inmueble() {
        return direccion_inmueble;
    }
    public void setDireccion_inmueble(String direccion_inmueble) {
        this.direccion_inmueble = direccion_inmueble;
    }

}

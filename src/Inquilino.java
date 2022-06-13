

public class Inquilino {

    //private static Vector usuarios = new Vector(10,5);
    private String nombre;
    private String cedula;
    private int edad;
    private String sexo;
    private int iD = 1;


    Inquilino(){ // Metodo constructor
        System.out.println("Ingrese el nombre del cliente: ");
        this.setNombre(Main.escanear());
        System.out.println("Ingrese la cedula: ");
        this.setCedula(Main.escanear());
        System.out.println("Ingrese la edad: ");
        this.setEdad(Main.escanearInt());      
        System.out.println("Ingrese el sexo del cliente: ");
        this.setSexo(Main.escanear());
        this.iD = Main.nuevo_ID();
        registrarInquilino(this);
    }

    private void registrarInquilino(Inquilino cliente){
        Main.usuarios.addElement(cliente);
        System.out.println("El cliente tiene como nombre: "+cliente.getNombre());
        System.out.println("El cliente tiene como cedula: "+cliente.getCedula());
        System.out.println("El cliente se define como: "+cliente.getSexo());
        System.out.println("El cliente tiene la edad de "+cliente.getEdad());
        System.out.println("El cliente tiene como identificador: "+cliente.getIdentificador());
        Main.salto_espacio();
        Main.back_to_main();
    }

    public static int buscarInquilino(){
        if(Main.usuarios.isEmpty()){
            System.out.println("No se ha registrado ningún cliente. ");
            System.out.println("Por favor, registrarlos primero y volver a intentar.");
            Main.salto_espacio();
            Main.back_to_main();
        }

        System.out.println("Ingrese el identificador del cliente o ID: ");
        int id_cliente = Main.escanearInt();
        int pos_cliente = buscar_pos_id_inquilino(id_cliente);

        if(pos_cliente == id_cliente) {
            System.out.println("No se ha encontrado ningún cliente con esa ID.");
            Main.salto_espacio();
        }else{
                System.out.println("Datos del respectivo cliente: ");
                System.out.println("Nombre: "+((Inquilino)Main.usuarios.elementAt(pos_cliente)).nombre);
                System.out.println("Cedula: "+((Inquilino)Main.usuarios.elementAt(pos_cliente)).cedula);
                System.out.println("Edad: "+((Inquilino)Main.usuarios.elementAt(pos_cliente)).edad);
                System.out.println("Sexo: "+((Inquilino)Main.usuarios.elementAt(pos_cliente)).sexo);
                System.out.println("Identificador: "+((Inquilino)Main.usuarios.elementAt(pos_cliente)).iD);
                Main.salto_espacio();   
        }
                    return id_cliente;
    }

    public static void renunciarInquilino(int id){
        System.out.println("\n¿Es esta la información del cliente a dar de baja?");
        System.out.println("Escribe 1 de confirmar, 2 o + para regresar al menú. ");
        if(Main.escanearInt() == 1){
            Main.usuarios.removeElementAt(buscar_pos_id_inquilino(id));
            System.out.println("\nCliente eliminado.");
            Main.salto_espacio();
            Main.back_to_main();}
            else{
            Main.back_to_main();}
    }

    public static int buscar_pos_id_inquilino(int id){
        for(int i = 0; i <Main.usuarios.size();i++){
            if(id == ((Inquilino)Main.usuarios.elementAt(i)).iD){
                return i;
            }
        }
        return id;
    }
    

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getCedula() {
        return cedula;
    }
    
    public int getEdad() {
        return edad;
    }

    public int getIdentificador() {
        return iD;
    }

    public String getSexo() {
        return sexo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void modificarInquilino(){
//
    }
    public void eliminarInquilino(){
//
    }

}

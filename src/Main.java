import java.util.Scanner;

public class Main {
    private static Cliente [] cliente;
    private static Scanner scan;

    public static void main(String args[]){
        /* Datos iniciales */
        cliente = new Cliente[3];
        cliente[0] = new Cliente("Adrian","adrian", "adrian123", 30000);
        cliente[1] = new Cliente("Diego","diego", "diego123", 1500);
        cliente[2] = new Cliente("Juan", "juan", "juan123", 1500);
        cliente[0].nuevoMovimiento(500, Movimiento.DEPOSITO);
        cliente[0].nuevoMovimiento(800, Movimiento.DEPOSITO);
        cliente[0].nuevoMovimiento(200, Movimiento.RETIRO);
        scan = new Scanner(System.in);

        String usuario, contrasenia;
        boolean repetir = false;
        do {
            usuario = null;
            contrasenia = null;
            repetir = false;
            System.out.println("Banco XYZ");
            System.out.println("Ingrese su usuario: ");
            usuario = scan.next();
            System.out.println("Ingrese un contraseña: ");
            contrasenia = scan.next();
            System.out.println(contrasenia);
            for (int i=0;i<cliente.length;i++){
                if ((cliente[i].getUsuario().equals(usuario)) && (cliente[i].getContrasenia().equals(contrasenia))){
                    repetir = false;
                    System.out.println("Ha iniciado sesión.");
                    Menu menu = new Menu(cliente, cliente[i]);
                    menu.mostrarMenu();
                    break;
                }
                else{
                    repetir = true;
                }
            }
            if (repetir){
                System.out.println("Datos incorrectos. Inténtelo de nuevo.");
            }
        } while(repetir);
    }

}

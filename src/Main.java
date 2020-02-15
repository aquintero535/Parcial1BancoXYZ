import java.util.Scanner;
import java.util.Date;

public class Main {
    private static Cliente [] cliente;
    private static Scanner scan;

    public static void main(String args[]){
        cliente = new Cliente[3];
        cliente[0] = new Cliente("Adrian","adrian", "adrian123", 1500);
        cliente[1] = new Cliente("Diego","diego", "diego123", 1500);
        cliente[2] = new Cliente("BancoXYZ", "bancoxyz", "adminxyz", 100000);
        cliente[0].nuevoMovimiento(500, 1);
        cliente[0].nuevoMovimiento(800, 1);
        cliente[0].nuevoMovimiento(200, 0);

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
                    menu(cliente[i]);
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

    public static void menu(Cliente cliente){
        String nuevaContrasenia;
        System.out.println("Bienvenido, "+cliente.getNombre());
        Date date = new Date();
        System.out.println(date.toGMTString());
        System.out.println("\nPor favor, ingrese una nueva contrasenia: ");
        nuevaContrasenia = scan.next();
        cliente.setContrasenia(nuevaContrasenia);
        System.out.println("Ha cambiado su contraseña. "+cliente.getContrasenia());
        boolean repetir;
        int opcion;
        do{
            repetir = false;
            opcion = 0;
            System.out.println("[1] Ver estado de la cuenta.");
            System.out.println("[2] Solicitar un crédito.");
            System.out.println("[3] Cambiar contraseña.");
            System.out.println("[4] Salir del sistema.");
            System.out.println("Seleccione una opción: ");
            opcion = scan.nextInt();
            switch(opcion){
                case 1: estadoCuenta(cliente); repetir = true; break;
                case 2: solicitarCredito(cliente); repetir = true; break;
                case 3: cambiarContrasenia(cliente); repetir = true; break;
                case 4: System.exit(0); break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
                    repetir = true;
                    break;
            }
        } while(repetir);

    }

    public static void estadoCuenta(Cliente cliente){
        System.out.println("Movimientos de la cuenta: ");
        for (Movimiento movimiento: cliente.getMovimientos()){
            System.out.println(movimiento.toString());
        }
        System.out.println("\nSaldo actual: "+cliente.getSaldo());
        System.out.println("Presiona cualquier tecla para volver al menú.");
        scan.next();
    }

    public static void solicitarCredito(Cliente clienteActual){
        String solicitarUsuario;
        System.out.println("Introduzca el usuario de la cuenta a la que desea solicitar crédito: ");
        solicitarUsuario = scan.next();
        for (int i=0;i<cliente.length;i++){
            if ( (solicitarUsuario.equals(cliente[i].getUsuario())) && (!(clienteActual.getUsuario()
                    .equals(cliente[i].getUsuario())))){
                clienteActual.solicitarCredito(cliente[i]);
            }
        }
    }

    public static void cambiarContrasenia(Cliente cliente){
        System.out.println("Introduzca su nueva contraseña: ");
        String nuevaContrasenia = scan.next();
        cliente.setContrasenia(nuevaContrasenia);
        System.out.println("Su nueva contraseña es: "+cliente.getContrasenia());
    }
}

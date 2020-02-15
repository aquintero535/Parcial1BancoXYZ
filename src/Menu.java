import java.util.Date;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Cliente arregloClientes[];
    private Cliente cliente;

    public Menu(Cliente arregloClientes[], Cliente cliente){
        this.arregloClientes = arregloClientes;
        this.cliente = cliente;
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(){
        String nuevaContrasenia;
        System.out.println("Bienvenido, "+cliente.getNombre());
        Date date = new Date();
        System.out.println(date.toGMTString());
        System.out.println("\nPor favor, ingrese una nueva contrasenia: ");
        nuevaContrasenia = this.scanner.next();
        cliente.setContrasenia(nuevaContrasenia);
        System.out.println("Ha cambiado su contraseña. "+cliente.getContrasenia());
        boolean repetir = true;
        int opcion;
        while (repetir) {
            opcion = 0;
            System.out.println("[1] Ver estado de la cuenta.");
            System.out.println("[2] Solicitar un crédito.");
            System.out.println("[3] Cambiar contraseña.");
            System.out.println("[4] Salir del sistema.");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch(opcion){
                case 1: estadoCuenta(cliente); break;
                case 2: solicitarCredito(cliente); break;
                case 3: cambiarContrasenia(cliente); break;
                case 4: System.out.println("Sesión cerrada.\n"+date.toGMTString());
                        System.exit(0); break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
                    break;
            }
        }
    }

    public void estadoCuenta(Cliente cliente){
        System.out.println("Movimientos de la cuenta: ");
        for (Movimiento movimiento: cliente.getMovimientos()){
            System.out.println(movimiento.toString());
        }
        System.out.println("\nSaldo actual: "+cliente.getSaldo());
        System.out.println("Presiona cualquier tecla para volver al menú.");
        scanner.next();
    }

    public void solicitarCredito(Cliente clienteActual){
        String solicitarUsuario;
        System.out.println("Introduzca el usuario de la cuenta a la que desea solicitar crédito: ");
        solicitarUsuario = scanner.next();
        for (int i=0;i<arregloClientes.length;i++){
            if ( (solicitarUsuario.equals(arregloClientes[i].getUsuario())) && (!(clienteActual.getUsuario()
                    .equals(arregloClientes[i].getUsuario())))){
                clienteActual.solicitarCredito(arregloClientes[i]);
            }
        }
    }

    public void cambiarContrasenia(Cliente cliente){
        System.out.println("Introduzca su nueva contraseña: ");
        String nuevaContrasenia = scanner.next();
        cliente.setContrasenia(nuevaContrasenia);
        System.out.println("Su nueva contraseña es: "+cliente.getContrasenia());
    }

}

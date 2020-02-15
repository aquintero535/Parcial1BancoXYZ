import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String usuario;
    private String contrasenia;
    private double saldo;
    private ArrayList<Movimiento> movimientos;

    public Cliente(String nombre, String usuario, String contrasenia, double saldo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
        movimientos = new ArrayList<Movimiento>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void nuevoMovimiento(double cantidad, int tipoMovimiento){ //0 para retiro, 1 para depósito
        this.movimientos.add(new Movimiento(this.saldo, cantidad, tipoMovimiento));
        switch(tipoMovimiento){
            case 0: this.saldo -= cantidad; break;
            case 1: this.saldo += cantidad; break;
            default: break;
        }
    }

    public void solicitarCredito(Cliente clienteCredito){
        double credito = clienteCredito.getSaldo() * 0.90;
        System.out.println("Crédito: "+credito);
        double comisionBanco = credito*0.30;
        System.out.println("Comisión 30 % del banco: "+comisionBanco);
        credito = credito-comisionBanco;
        System.out.println("Total: "+credito);

        clienteCredito.setSaldo(clienteCredito.getSaldo() - (clienteCredito.getSaldo() * 0.90));
        this.movimientos.add(new Movimiento(this.saldo, credito, Movimiento.CREDITO));
        this.saldo += credito;
    }


}

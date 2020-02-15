public class Movimiento {
    private double montoInicial;
    private double cantidad;
    private double montoFinal;
    private String tipoMovimiento;

    public Movimiento(double saldoActual, double cantidad, int tipoMovimiento){ //0 para retiro, 1 para depósito, 2 solicitud crédito
        this.montoInicial = saldoActual;
        this.cantidad = cantidad;
        switch (tipoMovimiento){
            case 0: this.tipoMovimiento = "retiro"; this.montoFinal = saldoActual - cantidad; break;
            case 1: this.tipoMovimiento = "depósito"; this.montoFinal = saldoActual + cantidad; break;
            case 2: this.tipoMovimiento = "solicitud de crédito"; this.montoFinal = saldoActual + cantidad; break;
            default: this.tipoMovimiento = null; break;
        }
    }


    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String toString(){
        return " Tipo de movimiento: "+tipoMovimiento+". Monto inicial: "+this.getMontoInicial()+" Cantidad: "+
                this.cantidad+" Monto final: "+this.getMontoFinal();
    }
}

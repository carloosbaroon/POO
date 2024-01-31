public class Automovil {

    private String fabricante;
    private String modelo;
    private String color = "gris";
    private double cilindrada;
    private int capacidadTanque = 40;

    public String getFabricante() {
        return this.fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getColor() {
        return this.color;
    }

    public double getCilindrada() {
        return this.cilindrada;
    }

    public int getCapacidadTanque() {
        return this.capacidadTanque;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Automovil setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
        return this;
    }

    public String verDetalle() {
        return "auto.fabricante = " + this.fabricante +
                "\nauto.modelo = " + this.modelo +
                "\nauto.cilindrada = " + this.cilindrada +
                "\nauto.color = " + this.color;
    }

    public String acelerar(int rpm) {
        return "el auto " + this.fabricante + " acelerado a " + rpm + "rpm";
    }

    public String frenar() {
        return this.fabricante + " " + this.modelo + " frenando!";
    }

    public String acelerarFrenar(int rpm) {
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();

        return acelerar + "\n" + frenar;
    }

    public float calcularConsumo(int km, float porcentajeGas) {
        return km/(capacidadTanque*porcentajeGas);
    }

    public float calcularConsumo(int km, int porcentajeGas) {
        return km/(capacidadTanque*(porcentajeGas/100f));
    }
}

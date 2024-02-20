public class Motor {

    private double cilindrada;
    private TipoMotor tipo;

    public Motor() {
    }

    public Motor(double cilindrada, TipoMotor tipo) {
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public Motor setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
        return this;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public Motor setTipo(TipoMotor tipo) {
        this.tipo = tipo;
        return this;
    }
}

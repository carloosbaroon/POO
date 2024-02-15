public class Automovil {

    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private Motor motor;
    private Tanque tanque;
    private Persona conductor;
    private Rueda[] ruedas;
    private int id;
    private static Color colorPatente = Color.NARANJA;

    private TipoAutomovil tipo;

    private static int capacidadTanqueEstatico = 30;
    private static int ultimoId;
    public static final Integer VELOCIDAD_MAXIMA_CARRETERA = 120;
    public static final int VELOCIDAD_MAXIMA_CIUDAD = 50;

    public Automovil(){
        this.id = ++ultimoId;
    }

    public Automovil(String fabricante, String modelo) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color) {
        //Llamando constructor con dos parametros
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        //Llamando constructor con tres parametros
        this(fabricante, modelo, color);
        this.motor = motor;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanque) {
        //Llamando constructor con cuatro parametros
        this(fabricante, modelo, color, motor);
        this.tanque = tanque;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Color getColor() {
        return this.color;
    }

    public static Color getColorPatente() {
        return colorPatente;
    }

    public static int getCapacidadTanqueEstatico() {
        return capacidadTanqueEstatico;
    }

    public int getId() {
        return id;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static void setCapacidadTanqueEstatico(int capacidadTanqueEstatico) {
        Automovil.capacidadTanqueEstatico = capacidadTanqueEstatico;
    }

    public static void setColorPatente(Color colorPatente) {
        Automovil.colorPatente = colorPatente;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public Automovil setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
        return this;
    }

    public Automovil setId(int id) {
        this.id = id;
        return this;
    }

    public Motor getMotor() {
        return motor;
    }

    public Automovil setMotor(Motor motor) {
        this.motor = motor;
        return this;
    }

    public Tanque getTanque() {
        if (tanque == null) {
            this.tanque = new Tanque();
        }
        return tanque;
    }

    public Automovil setTanque(Tanque tanque) {
        this.tanque = tanque;
        return this;
    }

    public Persona getConductor() {
        return conductor;
    }

    public Automovil setConductor(Persona conductor) {
        this.conductor = conductor;
        return this;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public Automovil setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
        return this;
    }

    public String verDetalle() {
        return  "auto.id = " + this.getId() +
                "\nauto.fabricante = " + this.getFabricante() +
                "\nauto.modelo = " + this.getModelo() +
                "\nauto.tipo = " + this.getTipo().getDescripcion() +
                "\nauto.cilindrada = " + this.motor.getCilindrada() +
                "\nauto.colorPatente = " + colorPatente +
                "\nauto.color = " + this.getColor();
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
        return km/(this.tanque.getCapacidad()*porcentajeGas);
    }

    public float calcularConsumo(int km, int porcentajeGas) {
        return km/(this.tanque.getCapacidad()*(porcentajeGas/100f));
    }

    public static float calcularConsumoEstatico(int km, int porcentajeGas) {
        return km/(Automovil.capacidadTanqueEstatico*(porcentajeGas/100f));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if(!(obj instanceof Automovil)) {
            return false;
        }

        Automovil a = (Automovil) obj;
        return (this.fabricante != null
                && this.modelo != null
                && this.fabricante.equals(a.getFabricante())
                && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", cilindrada=" + this.motor.getCilindrada() +
                ", capacidadTanque=" + this.tanque.getCapacidad() +
                '}';
    }
}

public class Automovil {

    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private double cilindrada;
    private int capacidadTanque = 40;
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

    public Automovil(String fabricante, String modelo, Color color, double cilindrada) {
        //Llamando constructor con tres parametros
        this(fabricante, modelo, color);
        this.cilindrada = cilindrada;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada, int capacidadTanque) {
        //Llamando constructor con cuatro parametros
        this(fabricante, modelo, color, cilindrada);
        this.capacidadTanque = capacidadTanque;
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

    public double getCilindrada() {
        return this.cilindrada;
    }

    public int getCapacidadTanque() {
        return this.capacidadTanque;
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

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public static void setCapacidadTanqueEstatico(int capacidadTanqueEstatico) {
        Automovil.capacidadTanqueEstatico = capacidadTanqueEstatico;
    }

    public Automovil setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
        return this;
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

    public String verDetalle() {
        return  "auto.id = " + this.getId() +
                "\nauto.fabricante = " + this.getFabricante() +
                "\nauto.modelo = " + this.getModelo() +
                "\nauto.tipo = " + this.getTipo().getDescripcion() +
                "\nauto.cilindrada = " + this.getCilindrada() +
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
        return km/(capacidadTanque*porcentajeGas);
    }

    public float calcularConsumo(int km, int porcentajeGas) {
        return km/(capacidadTanque*(porcentajeGas/100f));
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
                ", cilindrada=" + cilindrada +
                ", capacidadTanque=" + capacidadTanque +
                '}';
    }
}

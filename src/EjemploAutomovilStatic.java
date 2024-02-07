import java.util.Date;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Automovil subaru = new Automovil("Subaru", "Impresa");
        subaru.setCilindrada(2.0);
        subaru.setColor(Automovil.COLOR_BLANCO);

        Automovil mazda = new Automovil("Mazda", "BT-50", Automovil.COLOR_ROJO, 3.0);
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());

        Automovil nissan = new Automovil("Nissan", "Navara", Automovil.COLOR_GRIS, 3.5, 50);
        Automovil nissan2 = new Automovil("Nissan", "Navara", Automovil.COLOR_GRIS, 3.5, 50);
        Automovil auto = new Automovil();

        Automovil.setCapacidadTanqueEstatico(45);

        Automovil.setColorPatente(Automovil.COLOR_AZUL);

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());

        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("Automovil.calcularConsumoEstatico(300, 60) = " + Automovil.calcularConsumoEstatico(300, 60));

        System.out.println("VELOCIDAD_MAXIMA_CARRETERA: " + Automovil.VELOCIDAD_MAXIMA_CARRETERA);
        System.out.println("VELOCIDAD_MAXIMA_CIUDAD: " + Automovil.VELOCIDAD_MAXIMA_CIUDAD);

    }
}
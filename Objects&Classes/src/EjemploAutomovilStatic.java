import java.util.Date;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Motor motorSubaru = new Motor(2.0, TipoMotor.BENCINA);
        Automovil subaru = new Automovil("Subaru", "Impresa");
        subaru.setMotor(motorSubaru);
        subaru.setColor(Color.BLANCO);
        subaru.setTanque(new Tanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTanque(new Tanque(45));
        mazda.setTipo(TipoAutomovil.FURGON);
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());

        Motor motorNissan = new Motor(4.0, TipoMotor.DIESEL);
        Tanque tanqueNissan = new Tanque(50);

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, motorNissan, tanqueNissan);
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS, motorNissan, tanqueNissan);
        Automovil auto = new Automovil();

        nissan.setTipo(TipoAutomovil.PICKUP);
        nissan2.setTipo(TipoAutomovil.PICKUP);

        Automovil.setCapacidadTanqueEstatico(45);

        Automovil.setColorPatente(Color.AZUL);

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());

        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente().getColor());
        System.out.println("Automovil.calcularConsumoEstatico(300, 60) = " + Automovil.calcularConsumoEstatico(300, 60));

        System.out.println("VELOCIDAD_MAXIMA_CARRETERA: " + Automovil.VELOCIDAD_MAXIMA_CARRETERA);
        System.out.println("VELOCIDAD_MAXIMA_CIUDAD: " + Automovil.VELOCIDAD_MAXIMA_CIUDAD);

        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("tipoSubaru.getNombre() = " + tipoSubaru.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipoSubaru.getDescripcion());

    }
}
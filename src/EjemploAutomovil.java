import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {

        Motor motorSubaru = new Motor(2.0, TipoMotor.BENCINA);
        Automovil subaru = new Automovil("Subaru", "Impresa");
        subaru.setMotor(motorSubaru);
        subaru.setTanque(new Tanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.SEDAN);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTanque(new Tanque(45));
        mazda.setTipo(TipoAutomovil.FURGON);
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());


        Motor motorNissan = new Motor(4.0, TipoMotor.DIESEL);
        Tanque tanqueNissan = new Tanque(50);

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, motorNissan, tanqueNissan);
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS, motorNissan, tanqueNissan);

        nissan.setTipo(TipoAutomovil.PICKUP);
        nissan2.setTipo(TipoAutomovil.PICKUP);

        Automovil auto = new Automovil();
        Date fecha = new Date();

        System.out.println("Son iguales? " + (nissan == nissan2));
        System.out.println("Son iguales? " + (nissan.equals(nissan2)));
        System.out.println(auto.equals(nissan));
        System.out.println(auto.equals(fecha));

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(subaru.acelerar(3000));
        System.out.println(subaru.frenar());

        System.out.println(mazda.acelerarFrenar(4000));

        System.out.println("Kilometros por litro " + subaru.calcularConsumo(300, 0.6f));
        System.out.println("Kilometros por litro " + subaru.calcularConsumo(300, 60));
        System.out.println("Kilometros por litro " + nissan.calcularConsumo(300, 60));

        System.out.println(nissan);

    }
}
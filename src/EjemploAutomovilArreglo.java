import java.lang.reflect.Array;
import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {

        Persona conductorSubaru = new Persona("Carlos", "Baron");
        Motor motorSubaru = new Motor(2.0, TipoMotor.BENCINA);
        Automovil subaru = new Automovil("Subaru", "Impresa");
        subaru.setMotor(motorSubaru);
        subaru.setColor(Color.BLANCO);
        subaru.setTanque(new Tanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductorSubaru);

        Persona conductorMazda = new Persona("Leticia", "Gonzalez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTanque(new Tanque(45));
        mazda.setTipo(TipoAutomovil.FURGON);
        mazda.setConductor(conductorMazda);

        Motor motorNissan = new Motor(4.0, TipoMotor.DIESEL);
        Tanque tanqueNissan = new Tanque(50);
        Persona personaNissan = new Persona("Aleph", "Baron");

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, motorNissan, tanqueNissan);
        Automovil suzuki = new Automovil("Suzuki", "Vitara", Color.GRIS, new Motor(1.6, TipoMotor.BENCINA), new Tanque(50));
        nissan.setConductor(personaNissan);
        suzuki.setConductor(new Persona("Camila", "Baron"));
        nissan.setTipo(TipoAutomovil.PICKUP);
        suzuki.setTipo(TipoAutomovil.SUV);

        Automovil audi = new Automovil("Audi", "A3");
        audi.setConductor(new Persona("Luis", "Baron"));
        audi.setMotor(new Motor(1.5, TipoMotor.BENCINA));
        audi.setTanque(new Tanque(20));

        Automovil[] autos = new Automovil[5];
        autos[0] = subaru;
        autos[1] = mazda;
        autos[2] = nissan;
        autos[3] = suzuki;
        autos[4] = audi;

        // Here we are sorting the array using the method compareTo from Automovil
        Arrays.sort(autos);
        for (Automovil auto : autos) {
            System.out.println(auto);
        }
    }
}
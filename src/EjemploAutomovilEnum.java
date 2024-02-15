public class EjemploAutomovilEnum {
    public static void main(String[] args) {

        Motor motorSubaru = new Motor(2.0, TipoMotor.BENCINA);
        Automovil subaru = new Automovil("Subaru", "Impresa");
        subaru.setMotor(motorSubaru);
        subaru.setColor(Color.BLANCO);
        subaru.setTanque(new Tanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());
        mazda.setTipo(TipoAutomovil.PICKUP);

        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("tipoSubaru.getNombre() = " + tipoSubaru.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipoSubaru.getDescripcion());


        switch (tipoSubaru) {
            case CONVERTIBLE ->
                System.out.println("El automovil es deportivo y descapotable de dos puerta");
            case COUPE ->
                System.out.println("El automovil es pequeno de dos puerta y tipicamente deportivo");
            case FURGON ->
                System.out.println("El automovil es utilitario de transporte de empresas");
            case HATCHBACK ->
                System.out.println("El automovil es mediano compacto, aspecto deportivo");
            case PICKUP ->
                System.out.println("Es un automovild de doble cabina o camioneta");
            case SEDAN ->
                System.out.println("Es un automovil mediano");
            case STATION_WAGON ->
                System.out.println("Es un automovil grande, con maleta grande");
        }

        TipoAutomovil[] tipos = TipoAutomovil.values();
        for(TipoAutomovil ta: tipos) {
            //name() == toString method
            System.out.print(ta + " => " + ta.name() + " , " +
                    ta.getNombre() + " , " +
                    ta.getDescripcion() + " , " +
                    ta.getNumeroPuerta());
            System.out.println();
        }

    }
}
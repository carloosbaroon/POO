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
        //subaru.setRuedas(ruedasSubaru);
        Rueda[] ruedasSubaru = new Rueda[5];

        for(int i = 0; i < ruedasSubaru.length; i++) {
            subaru.addRueda(new Rueda("Yoko", 16, 7.5));
        }

        Persona conductorMazda = new Persona("Leticia", "Gonzalez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTanque(new Tanque(45));
        mazda.setTipo(TipoAutomovil.FURGON);
        mazda.setConductor(conductorMazda);
        //mazda.setRuedas(ruedasMazda);
        Rueda[] ruedasMazda = new Rueda[5];

        for(int i = 0; i < ruedasMazda.length; i++) {
            mazda.addRueda(new Rueda("Miche", 18, 10.5));
        }

        Motor motorNissan = new Motor(4.0, TipoMotor.DIESEL);
        Tanque tanqueNissan = new Tanque(50);
        Persona personaNissan = new Persona("Aleph", "Baron");

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, motorNissan, tanqueNissan);
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS, motorNissan, tanqueNissan);
        nissan.setConductor(personaNissan);
        nissan2.setConductor(personaNissan);
        nissan.setTipo(TipoAutomovil.PICKUP);
        nissan2.setTipo(TipoAutomovil.PICKUP);

        nissan.addRueda(new Rueda("Pire", 20, 12.5))
                .addRueda(new Rueda("Pire", 20, 12.5))
                .addRueda(new Rueda("Pire", 20, 12.5))
                .addRueda(new Rueda("Pire", 20, 12.5))
                .addRueda(new Rueda("Pire", 20, 12.5));

        Rueda[] ruedasNissan2 = new Rueda[5];

        for(int i = 0; i < ruedasNissan2.length; i++) {
            nissan2.addRueda(new Rueda("Pire", 20, 12.5));
        }

        Automovil.setCapacidadTanqueEstatico(45);

        Automovil.setColorPatente(Color.AZUL);

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());

        System.out.println("subaru.getConductor() = " + subaru.getConductor());
        for(Rueda r: subaru.getRuedas()) {
            System.out.println(r.getFabricante() +  ", aro: " + r.getAro() + ", ancho" + r.getAncho());
        }
    }
}
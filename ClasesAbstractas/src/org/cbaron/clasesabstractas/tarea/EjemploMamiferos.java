package org.cbaron.clasesabstractas.tarea;

public class EjemploMamiferos {

    public static void main(String[] args) {

        Mamifero[] mamiferos = new Mamifero[6];

        Mamifero leon = new Leon(120d, 5, 7.5f, 58, "Sur Africa", 120, 220, 190);
        Mamifero tigre = new Tigre("Siberiano", 7.9f, 72, "Rusia", 130, 330, 300);
        Mamifero lobo = new Lobo(9, "Ibérico", 2.5f, "Gris marrón y negro", "Europa", 80, 120, 70);
        Mamifero perro = new Perro(317, 2.5f, "Tricolor de manchas negras, blancas y óxido", "Africa", 43, 92, 35);
        Mamifero tigreBengala = new Tigre("Bengala", 7.9f, 72, "India e Indonesia", 110, 270, 220);
        Mamifero guepardo = new Guepardo(4.9f, 130, "Africa", 94, 140, 72);

        mamiferos[0] = leon;
        mamiferos[1] = tigre;
        mamiferos[2] = lobo;
        mamiferos[3] = perro;
        mamiferos[4] = tigreBengala;
        mamiferos[5] = guepardo;

        for (Mamifero animal : mamiferos) {

            System.out.println(" =============== " + animal.getClass().getSimpleName() + " =============== ");
            System.out.println("Habitat:" + animal.getHabitat());
            System.out.println("Altura:" + animal.getAltura());
            System.out.println("Largo:" + animal.getLargo());
            System.out.println("Peso:" + animal.getPeso());

            if (animal instanceof Canino) {
                System.out.println("Clomillos:" + ((Canino) animal).getTamanoColmillos());
                System.out.println("Color:" + ((Canino) animal).getColor());

                if (animal instanceof Lobo) {
                    System.out.println("Especie Lobo:" + ((Lobo) animal).getEspecieLobo());
                    System.out.println("Número Integrantes:" + ((Lobo) animal).getNumCamada());
                }
                if (animal instanceof Perro) {
                    System.out.println("Fuerza mordida kg:" + ((Perro) animal).getFuerzaMordida());
                }
            }

            if (animal instanceof Felino) {
                System.out.println("Tamaño Garras:" + ((Felino) animal).getTamanoGarras());
                System.out.println("Velocidad:" + ((Felino) animal).getVelocidad());

                if (animal instanceof Leon) {
                    System.out.println("Potencia Rugido:" + ((Leon) animal).getPotenciaRugidoDecibel());
                    System.out.println("Número Integrantes:" + ((Leon) animal).getNumManada());
                }
                if (animal instanceof Tigre) {
                    System.out.println("especie Tigre:" + ((Tigre) animal).getEspecieTigre());
                }
            }

            System.out.println(animal.comer());
            System.out.println(animal.dormir());
            System.out.println(animal.correr());
            System.out.println(animal.comunicarse());
        }
    }
}

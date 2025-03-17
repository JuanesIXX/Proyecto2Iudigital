import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido de la persona " + (i + 1) + ":");
            String apellido = scanner.nextLine();

            String genero;
            while (true) {
                System.out.println("Ingrese el género de la persona " + (i + 1) + " (Masculino/Femenino):");
                genero = scanner.nextLine();
                if (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino")) {
                    break;
                } else {
                    System.out.println("Género inválido. Por favor, ingrese 'Masculino' o 'Femenino'.");
                }
            }

            System.out.println("Ingrese la edad de la persona " + (i + 1) + ":");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            personas[i] = new Persona(nombre, apellido, genero, edad);
        }

        System.out.println("Nombres y géneros de las personas capturadas:");
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre() + ", Género: " + persona.getGenero());
        }

        System.out.println("Promedio de edades: " + calcularPromedioEdades(personas));
        System.out.println("Cantidad de personas con género Masculino: " + contarGenero(personas, "Masculino"));
        System.out.println("Cantidad de personas con género Femenino: " + contarGenero(personas, "Femenino"));

        scanner.close();
    }

    public static double calcularPromedioEdades(Persona[] personas) {
        int sumaEdades = 0;
        for (Persona persona : personas) {
            sumaEdades += persona.getEdad();
        }
        return (double) sumaEdades / personas.length;
    }

    public static int contarGenero(Persona[] personas, String genero) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona.getGenero().equalsIgnoreCase(genero)) {
                contador++;
            }
        }
        return contador;
    }
}
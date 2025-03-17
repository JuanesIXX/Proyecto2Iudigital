import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Individuo[] individuos = new Individuo[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre del individuo " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido del individuo " + (i + 1) + ":");
            String apellido = scanner.nextLine();

            String sexo;
            while (true) {
                System.out.println("Ingrese el sexo del individuo " + (i + 1) + " (1 para Masculino, 2 para Femenino, o escriba el género):");
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    sexo = "Masculino";
                    break;
                } else if (input.equals("2")) {
                    sexo = "Femenino";
                    break;
                } else if (input.equalsIgnoreCase("Masculino") || input.equalsIgnoreCase("Femenino")) {
                    sexo = input;
                    break;
                } else {
                    System.out.println("Sexo inválido. Por favor, ingrese '1', '2', 'Masculino' o 'Femenino'.");
                }
            }

            System.out.println("Ingrese la edad del individuo " + (i + 1) + ":");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            individuos[i] = new Individuo(nombre, apellido, sexo, edad);
        }

        System.out.println("Nombres y sexos de los individuos capturados:");
        for (Individuo individuo : individuos) {
            System.out.println("Nombre: " + individuo.getNombre() + ", Sexo: " + individuo.getSexo());
        }

        System.out.println("Promedio de edades: " + calcularPromedioEdades(individuos));
        System.out.println("Cantidad de individuos con sexo Masculino: " + contarSexo(individuos, "Masculino"));
        System.out.println("Cantidad de individuos con sexo Femenino: " + contarSexo(individuos, "Femenino"));

        scanner.close();
    }

    public static double calcularPromedioEdades(Individuo[] individuos) {
        int sumaEdades = 0;
        for (Individuo individuo : individuos) {
            sumaEdades += individuo.getEdad();
        }
        return (double) sumaEdades / individuos.length;
    }

    public static int contarSexo(Individuo[] individuos, String sexo) {
        int contador = 0;
        for (Individuo individuo : individuos) {
            if (individuo.getSexo().equalsIgnoreCase(sexo)) {
                contador++;
            }
        }
        return contador;
    }
}
// Output e....
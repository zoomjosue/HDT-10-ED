import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        // A=0, B=1, C=2, D=3, E=4
        grafo.agregarArco(0, 1, 3);  
        grafo.agregarArco(0, 3, 7);  
        grafo.agregarArco(1, 2, 1);  
        grafo.agregarArco(1, 4, 8);  
        grafo.agregarArco(2, 3, 2);  
        grafo.agregarArco(3, 4, 3); 
        grafo.agregarArco(4, 0, 4); 

        Floyd floyd = new Floyd(grafo);

        double[][] resultado = floyd.obtenerDistancias();

        System.out.println("Matriz de caminos más cortos:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                if (resultado[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("∞\t");
                } else {
                    System.out.print((int) resultado[i][j] + "\t");
                }
            }
            System.out.println();
        }

        int centro = floyd.calcularCentroGrafo();
        System.out.println("\nEl centro del grafo es el nodo: " + centro + " (" + convertirCiudad(centro) + ")");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Ruta más corta ---");
        System.out.println("Estaciones disponibles:");
        System.out.println("0: Ciudad de Guatemala (A)");
        System.out.println("1: Zacapa (B)");
        System.out.println("2: Chiquimula (C)");
        System.out.println("3: Quetzaltenango (D)");
        System.out.println("4: Cobán (E)");

        System.out.print("Ingrese el número de estación de origen: ");
        int origen = scanner.nextInt();

        System.out.print("Ingrese el número de estación de destino: ");
        int destino = scanner.nextInt();

        List<Integer> ruta = floyd.obtenerRuta(origen, destino);

        if (ruta.isEmpty()) {
            System.out.println("No existe una ruta entre las estaciones seleccionadas.");
        } else {
            System.out.print("Ruta más corta: ");
            for (int i = 0; i < ruta.size(); i++) {
                System.out.print(convertirCiudad(ruta.get(i)));
                if (i < ruta.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println("\nDistancia total: " + floyd.obtenerDistancias()[origen][destino]);
        }
    }

    private static String convertirCiudad(int indice) {
        return switch (indice) {
            case 0 -> "Ciudad de Guatemala (A)";
            case 1 -> "Zacapa (B)";
            case 2 -> "Chiquimula (C)";
            case 3 -> "Quetzaltenango (D)";
            case 4 -> "Cobán (E)";
            default -> "Desconocido";
        };
    }
}

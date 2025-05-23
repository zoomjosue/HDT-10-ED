import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del algoritmo de Floyd-Warshall para encontrar las distancias más cortas
 */
public class Floyd {

    private final double[][] distancias;
    private final int[][] siguientes;
    private final int tamaño;

    /**
     * Constructor
     * @param grafo
     */
    public Floyd(Grafo grafo) {
        this.tamaño = grafo.obtenerTamaño();
        this.distancias = new double[tamaño][tamaño];
        this.siguientes = new int[tamaño][tamaño];

        double[][] original = grafo.obtenerMatrizAdyacencia();

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                distancias[i][j] = original[i][j];

                if (i != j && original[i][j] != Double.POSITIVE_INFINITY) {
                    siguientes[i][j] = j;
                } else {
                    siguientes[i][j] = -1;
                }
            }
        }

        calcularCaminos();
    }

    /**
     * Calcula los caminos más cortos entre todos los pares de nodos
     */
    private void calcularCaminos() {
        for (int k = 0; k < tamaño; k++) {
            for (int i = 0; i < tamaño; i++) {
                for (int j = 0; j < tamaño; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        siguientes[i][j] = siguientes[i][k];
                    }
                }
            }
        }
    }

    /**
     * Obtiene la matriz de distancias más cortas
     * @return
     */
    public double[][] obtenerDistancias() {
        return distancias;
    }

    /**
     * Obtiene la ruta más corta entre dos nodos
     * @param desde
     * @param hacia
     * @return
     */
    public List<Integer> obtenerRuta(int desde, int hacia) {
        List<Integer> ruta = new ArrayList<>();

        if (siguientes[desde][hacia] == -1) {
            return ruta; // ruta vacía, no hay camino
        }

        ruta.add(desde);
        while (desde != hacia) {
            desde = siguientes[desde][hacia];
            ruta.add(desde);
        }

        return ruta;
    }

    /**
     * Calcula el centro del grafo
     * @return
     */
    public int calcularCentroGrafo() {
        int centro = -1;
        double menorExcentricidad = Double.POSITIVE_INFINITY;

        for (int i = 0; i < tamaño; i++) {
            double excentricidad = 0;
            for (int j = 0; j < tamaño; j++) {
                if (distancias[i][j] > excentricidad) {
                    excentricidad = distancias[i][j];
                }
            }
            if (excentricidad < menorExcentricidad) {
                menorExcentricidad = excentricidad;
                centro = i;
            }
        }

        return centro;
    }
}

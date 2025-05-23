/**
 * Clase que representa un grafo dirigido utilizando una matriz de adyacencia
 */
public class Grafo {
    private final int tamaño;
    private final double[][] matrizAdyacencia;

    public Grafo(int tamaño) {
        this.tamaño = tamaño;
        matrizAdyacencia = new double[tamaño][tamaño];
        inicializarMatriz();
    }

    /**  
     * Inicializa la matriz de adyacencia con valores por defecto
     */
    private void inicializarMatriz() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (i == j) {
                    matrizAdyacencia[i][j] = 0;
                } else {
                    matrizAdyacencia[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    /**
     * Agrega un arco al grafo
     * @param desde
     * @param hacia
     * @param peso
     */
    public void agregarArco(int desde, int hacia, double peso) {
        matrizAdyacencia[desde][hacia] = peso;
    }

    /**
     * Elimina un arco del grafo
     * @param desde
     * @param hacia
     */
    public void eliminarArco(int desde, int hacia) {
        matrizAdyacencia[desde][hacia] = Double.POSITIVE_INFINITY;
    }

    /**
     * Obtiene la matriz de adyacencia del grafo
     * @return
     */
    public double[][] obtenerMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    /**
     * Obtiene el tamaño del grafo
     * @return
     */
    public int obtenerTamaño() {
        return tamaño;
    }
}

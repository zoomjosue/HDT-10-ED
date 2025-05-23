import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FloydWarshallTest {

    private Grafo grafo;
    private Floyd floyd;

    @BeforeEach
    public void configurar() {
        grafo = new Grafo(4);

        grafo.agregarArco(0, 1, 1);
        grafo.agregarArco(1, 2, 2);
        grafo.agregarArco(2, 3, 3);
        grafo.agregarArco(0, 3, 10);

        floyd = new Floyd(grafo);
    }

    @Test
    public void testDistanciaMasCorta() {
        double[][] distancias = floyd.obtenerDistancias();

        // Camino más corto de 0 a 3 debería ser 1 + 2 + 3 = 6
        assertEquals(6.0, distancias[0][3]);
    }

    @Test
    public void testCentroGrafo() {
        int centro = floyd.calcularCentroGrafo();

        // En este grafo, el nodo 1 tiene menor excentricidad (llega más corto a todos)
        assertEquals(0, centro);
    }
}
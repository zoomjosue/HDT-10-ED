import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrafoTest {

    private Grafo grafo;

    @BeforeEach
    public void configurar() {
        grafo = new Grafo(3);
    }

    @Test
    public void testAgregarArco() {
        grafo.agregarArco(0, 1, 5.0);
        assertEquals(5.0, grafo.obtenerMatrizAdyacencia()[0][1]);
    }

    @Test
    public void testEliminarArco() {
        grafo.agregarArco(1, 2, 10.0);
        grafo.eliminarArco(1, 2);
        assertEquals(Double.POSITIVE_INFINITY, grafo.obtenerMatrizAdyacencia()[1][2]);
    }

    @Test
    public void testInicializacionDiagonalCero() {
        for (int i = 0; i < 3; i++) {
            assertEquals(0.0, grafo.obtenerMatrizAdyacencia()[i][i]);
        }
    }
}

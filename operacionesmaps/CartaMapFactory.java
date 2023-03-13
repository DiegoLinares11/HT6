package operacionesmaps;

import java.util.List;
import java.util.Map;

public interface CartaMapFactory {

    Map<String, String> createMap();

    // Map<String, Integer> createMap2();

    void agregarCarta(String nombre, String tipo);

    String obtenerTipo(String nombre);

    void mostrarCartas();

    void mostrarCartasOrdenadasTipo();

    void contarCartasPorTipo();

    void contarCartasPorTipoOrdendas();

    // void contarCartasRepetidas();

}

package operacionesmaps;

import java.util.Map;

public interface Factory {

    Map<String, String> createMap();

    void agregarCarta(String nombre, String tipo);

    String obtenerTipo(String nombre);

    void mostrarCartas();

    void mostrarCartasOrdenadasTipo();

    void contarCartasPorTipo();

    void contarCartasPorTipoOrdendas();

}

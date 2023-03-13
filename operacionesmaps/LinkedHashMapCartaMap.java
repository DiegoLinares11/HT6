package operacionesmaps;

//import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHashMapCartaMap implements CartaMapFactory {

    private LinkedHashMap<String, String> map;
    // private LinkedHashMap<String, Integer> map2;

    @Override
    public Map<String, String> createMap() {
        map = new LinkedHashMap<>();
        return map;
    }

    /*
     * @Override
     * public Map<String, Integer> createMap2() {
     * map2 = new LinkedHashMap<>();
     * return map2;
     * }
     */
    @Override
    public void agregarCarta(String nombre, String tipo) {
        if (this.map.containsKey(nombre)) {
            System.out.println("Ya existe una carta de " + nombre);

        } else {
            this.map.put(nombre, tipo);

        }

    }

    @Override
    public String obtenerTipo(String nombre) {
        return this.map.get(nombre);

    }

    @Override
    public void mostrarCartas() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Carta: " + entry.getKey() + " - " + entry.getValue());

        }
    }

    @Override
    public void mostrarCartasOrdenadasTipo() {
        List<Map.Entry<String, String>> entradas = new ArrayList<>(this.map.entrySet());

        Collections.sort(entradas, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        for (Map.Entry<String, String> entrada : entradas) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

    }

    @Override
    public void contarCartasPorTipo() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Carta: " + entry.getKey() + " - " + entry.getValue());
        }
    }

    /*
     * @Override
     * public void contarCartasRepetidas() {
     * for (Map.Entry<String, String> entrada : map.entrySet()) {
     * String llave = entrada.getKey();
     * // String valor = entrada.getValue();
     * 
     * // Si la llave no está en el segundo mapa, la agregamos con valor inicial 0
     * if (!map2.containsKey(llave)) {
     * map2.put(llave, 0);
     * }
     * 
     * // Incrementamos el valor del contador para la llave correspondiente
     * map2.put(llave, map2.get(llave) + 1);
     * }
     * }
     */
    @Override
    public void contarCartasPorTipoOrdendas() {
        List<Map.Entry<String, String>> entradas = new ArrayList<>(this.map.entrySet());

        Collections.sort(entradas, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        for (Map.Entry<String, String> entrada : entradas) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

    }
}

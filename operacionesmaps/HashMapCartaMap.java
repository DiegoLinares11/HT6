package operacionesmaps;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HashMapCartaMap implements Factory {

    private HashMap<String, String> map;

    @Override
    public Map<String, String> createMap() {
        map = new HashMap<>();
        return map;
    }

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

    @Override
    public void contarCartasPorTipoOrdendas() {
        List<Map.Entry<String, String>> entradas = new ArrayList<>(this.map.entrySet());

        Collections.sort(entradas, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        for (Map.Entry<String, String> entrada : entradas) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

    }
}

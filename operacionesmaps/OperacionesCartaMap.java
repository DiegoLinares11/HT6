package operacionesmaps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OperacionesCartaMap {

    public static void main(String[] args) {
        CartaMapFactory mapFactoryCartas = null;
        CartaMapFactory mapFactoryCartasUsuario = null;

        // Leemos la entrada del usuario para determinar qué implementación de Map usar
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de Mapa: ");
        System.out.println(" 1 - HashMap");
        System.out.println(" 2 - TreeMap");
        System.out.println(" 3 - LinkedHashMap");
        int opcion = 0;
        do {
            try {
                opcion = scanner.nextInt();

            } catch (Exception ex) {
                scanner.nextLine();
                System.out.println("Ingrese una opción válida para el Mapa...");
            }

            // scanner.close();
            // Creamos la fábrica correspondiente según la selección del usuario
            switch (opcion) {
                case 1:
                    mapFactoryCartas = new HashMapCartaMap();
                    mapFactoryCartasUsuario = new HashMapCartaMap();
                    opcion = 1;
                    break;
                case 2:
                    mapFactoryCartas = new TreeMapCartaMap();
                    mapFactoryCartasUsuario = new TreeMapCartaMap();
                    opcion = 1;
                    break;
                case 3:
                    mapFactoryCartas = new LinkedHashMapCartaMap();
                    mapFactoryCartasUsuario = new LinkedHashMapCartaMap();
                    opcion = 1;
                    break;
                default:
                    System.out.println("Tipo de Mapa no válido.");
                    break;
            }
        } while (opcion != 1);
        // Creamos el Map utilizando la fábrica seleccionada
        // Map<String, String> mapCartas = mapFactory.createMap();
        mapFactoryCartas.createMap();
        mapFactoryCartasUsuario.createMap();
        // Map<String, String> mapUsuario = mapFactory.createMap();

        // Leemos el archivo de cartas y las agregamos al Map
        try {
            BufferedReader br = new BufferedReader(new FileReader("cards_desc.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String nombre = parts[0].trim();
                String tipo = parts[1].trim();
                mapFactoryCartas.agregarCarta(nombre, tipo);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Error en la lectura del archivo.");
            System.exit(0);
        }

        // Mostramos el contenido del Map
        /*
         * for (Map.Entry<String, String> entry : map.entrySet()) {
         * System.out.println(entry.getKey() + " - " + entry.getValue());
         * }
         */
        // Scanner scanner = new Scanner(System.in);
        // Map<String, Integer> cartas = obtenerCartas();
        opcion = 0;
        String nombreCartaBuscar = "";
        String tipoCarta = "";
        do {
            System.out.println("========= MENU CARTAS =========");
            System.out.println("1. Agregar carta a la colección");
            System.out.println("2. Mostrar tipo de carta");
            System.out.println("3. Mostrar nombre, tipo y cantidad de sus cartas");
            System.out.println("4. Mostrar nombre, tipo y cantidad de sus cartas, ordenadas tipo");
            System.out.println("5. Mostrar nombre, tipo de todas las cartas");
            System.out.println("6. Mostrar nombre, tipo de todas las cartas, ordenadas por tipo");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
            } catch (Exception ex) {
                opcion = 0;
                System.out.println("Ingrese una opcion válida");
                scanner.nextLine();
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la carta: ");
                    nombreCartaBuscar = scanner.nextLine();

                    tipoCarta = mapFactoryCartas.obtenerTipo(nombreCartaBuscar);

                    if (tipoCarta == null) {
                        System.out.println("Carta: " + nombreCartaBuscar + " No fue encontrada");
                    } else {
                        mapFactoryCartasUsuario.agregarCarta(nombreCartaBuscar, tipoCarta);
                        System.out.println("Carta " + nombreCartaBuscar + " fue agregada...");
                    }

                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();

                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la carta: ");
                    nombreCartaBuscar = scanner.nextLine();
                    tipoCarta = mapFactoryCartas.obtenerTipo(nombreCartaBuscar);
                    if (tipoCarta == null) {
                        System.out.println("Carta: " + nombreCartaBuscar + " No fue encontrada");
                    } else {
                        System.out.println("El tipo de la carta " + nombreCartaBuscar + " es " + tipoCarta);
                    }

                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 3:
                    mapFactoryCartasUsuario.contarCartasPorTipo();
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    // mapFactoryCartasUsuario.contarCartasRepetidas();
                    // mostrarCartas(cartas);
                    // mapFactoryCartasUsuario.contarCartas();
                    break;
                case 4:
                    mapFactoryCartasUsuario.contarCartasPorTipoOrdendas();
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 5:
                    mapFactoryCartas.mostrarCartas();
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 6:
                    mapFactoryCartas.mostrarCartasOrdenadasTipo();
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                    break;

                case 7:
                    System.out.println("Hasta luego!");
                    opcion = 7;
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            System.out.println(); // Imprimir una línea en blanco
        } while (opcion != 7);
        scanner.close();

    }

}

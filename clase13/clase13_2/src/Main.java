import java.util.*;

public class Main {

    static class Ruta {
        int destino;
        int costo;

        public Ruta(int destino, int costo) {
            this.destino = destino;
            this.costo = costo;
        }
    }


    private Map<Integer, List<Ruta>> grafo = new HashMap<>();
    private int costoMinimo = Integer.MAX_VALUE;  

    public void agregarRuta(int origen, int destino, int costo) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new Ruta(destino, costo));
    }


    public int encontrarCaminoMinimo(int origen, int destino) {
        Set<Integer> visitados = new HashSet<>();
        backtracking(origen, destino, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, visitados);
        return costoMinimo;
    }

    // Función recursiva de backtracking con poda alfa-beta
    private void backtracking(int actual, int destino, int costoActual, int alfa, int beta, Set<Integer> visitados) {
        if (actual == destino) {
            costoMinimo = Math.min(costoMinimo, costoActual);
            return;
        }

        visitados.add(actual);

        for (Ruta ruta : grafo.getOrDefault(actual, new ArrayList<>())) {
            if (!visitados.contains(ruta.destino)) {
                int nuevoCosto = costoActual + ruta.costo;

                if (nuevoCosto < costoMinimo) {
                    alfa = Math.max(alfa, nuevoCosto);
                    if (alfa < beta) {
                        backtracking(ruta.destino, destino, nuevoCosto, alfa, beta, visitados);
                    }
                }
            }
        }
        visitados.remove(actual);
    }
    public static void main(String[] args) {
        Main sistemaViaje = new Main();

        sistemaViaje.agregarRuta(1, 2, 10);
        sistemaViaje.agregarRuta(1, 3, 15);
        sistemaViaje.agregarRuta(2, 4, 12);
        sistemaViaje.agregarRuta(2, 3, 5);
        sistemaViaje.agregarRuta(3, 4, 10);
        sistemaViaje.agregarRuta(4, 5, 2);
        sistemaViaje.agregarRuta(3, 5, 10);

        int origen = 1;
        int destino = 5;
        int costoMinimo = sistemaViaje.encontrarCaminoMinimo(origen, destino);

        System.out.println("El costo mínimo desde " + origen + " hasta " + destino + " es: " + costoMinimo);
    }
}

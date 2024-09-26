import java.util.*;

// Clase para representar una arista entre dos nodos y el peso (tiempo en minutos)
class Arista {
    int destino;
    int peso;

    public Arista(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

public class Main{

    //aplicar el algoritmo de Dijkstra y encontrar el camino más corto
    public static void dijkstra(List<List<Arista>> grafo, int origen) {
        int numNodos = grafo.size();
        int[] distancias = new int[numNodos];  //guarda las distancias mínimas desde el nodo origen
        Arrays.fill(distancias, Integer.MAX_VALUE);  //Inicializamos todas las distancias como infinitas
        distancias[origen] = 0;

        //Cola de prioridad para seleccionar siempre el nodo con la distancia mínima
        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(arista -> arista.peso));
        pq.add(new Arista(origen, 0));

        //Mientras haya nodos que procesar en la cola de prioridad
        while (!pq.isEmpty()) {
            Arista aristaActual = pq.poll();
            int nodoActual = aristaActual.destino;

            for (Arista vecino : grafo.get(nodoActual)) {
                int nuevoPeso = distancias[nodoActual] + vecino.peso;

                //Si encontramos un camino más corto al vecino
                if (nuevoPeso < distancias[vecino.destino]) {
                    distancias[vecino.destino] = nuevoPeso;
                    pq.add(new Arista(vecino.destino, nuevoPeso));
                }
            }
        }
        System.out.println("Distancias mínimas desde el centro de distribución principal:");
        for (int i = 0; i < numNodos; i++) {
            System.out.println("Centro " + origen + " a Centro " + i + ": " + distancias[i] + " minutos");
        }
    }

    public static void main(String[] args) {
        int numNodos = 5;
        List<List<Arista>> grafo = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }


        grafo.get(0).add(new Arista(1, 10));
        grafo.get(0).add(new Arista(2, 5));
        grafo.get(1).add(new Arista(2, 2));
        grafo.get(1).add(new Arista(3, 1));
        grafo.get(2).add(new Arista(1, 3));
        grafo.get(2).add(new Arista(3, 9));
        grafo.get(2).add(new Arista(4, 2));
        grafo.get(3).add(new Arista(4, 4));
        grafo.get(4).add(new Arista(0, 7));
        grafo.get(4).add(new Arista(3, 6));

        int centroPrincipal = 0;
        dijkstra(grafo, centroPrincipal);
    }
}

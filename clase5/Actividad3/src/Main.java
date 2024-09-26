import java.util.*;

// Clase para representar una arista entre dos nodos y su peso
class Arista implements Comparable<Arista> {
    int destino;
    int peso;

    public Arista(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.peso - otra.peso;  // Comparar aristas por su peso
    }
}

public class Main{
    //Aplicar el algoritmo de Prim y obtener el Árbol de Recubrimiento Mínimo
    public static void primMST(List<List<Arista>> grafo, int numNodos) {
        boolean[] visitado = new boolean[numNodos];  //Para rastrear los nodos visitados
        PriorityQueue<Arista> pq = new PriorityQueue<>();  //Cola de prioridad para elegir la arista con el peso mínimo
        List<Arista> mst = new ArrayList<>();  //Para almacenar las aristas del Árbol de Recubrimiento Mínimo

        //Empezamos desde el nodo 0 (puedes comenzar desde cualquier nodo)
        visitado[0] = true;
        pq.addAll(grafo.get(0));

        int costoTotal = 0;

        while (!pq.isEmpty()) {
            Arista aristaActual = pq.poll();  //Sacamos la arista de menor peso

            if (!visitado[aristaActual.destino]) {
                //Si el nodo destino no ha sido visitado, lo añadimos al MST
                visitado[aristaActual.destino] = true;
                mst.add(aristaActual);
                costoTotal += aristaActual.peso;

                //Añadimos todas las aristas del nodo destino a la cola de prioridad
                for (Arista arista : grafo.get(aristaActual.destino)) {
                    if (!visitado[arista.destino]) {
                        pq.add(arista);
                    }
                }
            }
        }

        //Mostrar el resultado
        System.out.println("Aristas del Árbol de Recubrimiento Mínimo (MST):");
        for (Arista arista : mst) {
            System.out.println("Destino: " + arista.destino + " Peso: " + arista.peso);
        }
        System.out.println("Costo total: " + costoTotal);
    }

    public static void main(String[] args) {
        int numNodos = 4;
        List<List<Arista>> grafo = new ArrayList<>();

        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }


        grafo.get(0).add(new Arista(1, 5));
        grafo.get(0).add(new Arista(2, 10));
        grafo.get(1).add(new Arista(0, 5));
        grafo.get(1).add(new Arista(2, 6));
        grafo.get(1).add(new Arista(3, 7));
        grafo.get(2).add(new Arista(0, 10));
        grafo.get(2).add(new Arista(1, 6));
        grafo.get(2).add(new Arista(3, 8));
        grafo.get(3).add(new Arista(1, 7));
        grafo.get(3).add(new Arista(2, 8));

        primMST(grafo, numNodos);
    }
}

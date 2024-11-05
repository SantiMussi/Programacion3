import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {


    static List<List<Integer>> grafo = new ArrayList<>();
    static boolean[] visitado;

    public static void main(String[] args) {
        int numNodos = 9;


        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }

        agregarArista(0, 1);
        agregarArista(0, 2);
        agregarArista(1, 3);
        agregarArista(1, 4);
        agregarArista(2, 5);
        agregarArista(3, 6);
        agregarArista(4, 7);
        agregarArista(4, 8);


        visitado = new boolean[numNodos];


        System.out.print("Recorrido BFS: ");
        bfs(0);
    }


    public static void agregarArista(int origen, int destino) {
        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen);
    }


    public static void bfs(int nodoInicial) {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(nodoInicial);
        visitado[nodoInicial] = true;

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(nodo + " ");


            for (int vecino : grafo.get(nodo)) {
                if (!visitado[vecino]) {
                    cola.add(vecino);
                    visitado[vecino] = true;
                }
            }
        }
    }
}

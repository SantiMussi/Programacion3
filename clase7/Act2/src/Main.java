import java.util.Arrays;

class Logistica {

    static final int INF = 10000000;
    public static void floydWarshall(int[][] grafo, int n) {
        int[][] dist = new int[n][n]; // Matriz de distancias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = grafo[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("El grafo contiene un ciclo negativo.");
                return;
            }
        }
        imprimirSolucion(dist, n);
    }
    public static void imprimirSolucion(int[][] dist, int n) {
        System.out.println("Matriz de tiempos mínimos entre los centros de distribución:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] grafo = {
                {0, 3, INF, 5},
                {2, 0, INF, 4},
                {INF, 1, 0, INF},
                {INF, INF, 2, 0}
        };
        floydWarshall(grafo, n);
    }
}

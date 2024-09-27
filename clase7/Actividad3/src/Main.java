import java.util.Scanner;

 class Logistica {

    static final int INF = 10000000;
    public static void floydWarshall(int[][] grafo, int n) {
        int[][] dist = new int[n][n];
        int[][] pred = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = grafo[i][j];
                if (grafo[i][j] != INF && i != j) {
                    pred[i][j] = i;
                } else {
                    pred[i][j] = -1;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el centro de origen (0 a " + (n - 1) + "): ");
        int origen = sc.nextInt();
        System.out.print("Introduce el centro de destino (0 a " + (n - 1) + "): ");
        int destino = sc.nextInt();
        if (dist[origen][destino] == INF) {
            System.out.println("No hay camino disponible entre " + origen + " y " + destino);
        } else {
            System.out.println("El tiempo mínimo entre " + origen + " y " + destino + " es: " + dist[origen][destino]);
            System.out.print("El camino más corto es: ");
            imprimirCamino(origen, destino, pred);
            System.out.println(destino);
        }
    }
    public static void imprimirCamino(int u, int v, int[][] pred) {
        if (pred[u][v] == -1) {
            return;
        }
        if (u != v) {
            imprimirCamino(u, pred[u][v], pred);
        }
        System.out.print(pred[u][v] + " -> ");
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

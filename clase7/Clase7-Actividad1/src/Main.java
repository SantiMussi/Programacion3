public class Main {
    final static int INF = 99999; // Usamos un valor grande para representar 'infinito'

    public static void floydWarshall(int[][] grafo) {
        int n = grafo.length;
        int[][] distancias = new int[n][n]; // Matriz de distancias mínimas

        // Inicializar la matriz de distancias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distancias[i][j] = grafo[i][j];
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias mínimas
        imprimirMatriz(distancias);
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matriz[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grafo = {
                {0, 2, INF, 5},
                {INF, 0, INF, 4},
                {INF, INF, 0, INF},
                {INF, INF, 2, 0}
        };

        floydWarshall(grafo);
    }
}
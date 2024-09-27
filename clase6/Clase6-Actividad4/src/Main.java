public class Main {

    // Metodo para calcular la ganancia máxima dentro del presupuesto permitido
    public static int gananciaMaxima(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] progDinamica = new int[n + 1][presupuesto + 1];

        // Rellenar la tabla progDinamica de abajo hacia arriba
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    progDinamica[i][w] = Math.max(ganancias[i - 1] + progDinamica[i - 1][w - costos[i - 1]], progDinamica[i - 1][w]);
                } else {
                    progDinamica[i][w] = progDinamica[i - 1][w];
                }
            }
        }
        return progDinamica[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {2, 3, 4, 5};
        int[] ganancias = {3, 4, 5, 6};
        int presupuesto = 7;

        System.out.println("Ganancia máxima obtenible: " + gananciaMaxima(costos, ganancias, presupuesto));
    }
}
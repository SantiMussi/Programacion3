public class Main {
    private static int[] pesos = {2, 5, 6, 7};
    private static int[] valores = {4, 2, 1, 6};
    private static int pesoMaximo = 10;

    // Función para calcular el máximo valor utilizando fuerza bruta
    public static int mochilaFuerzaBruta(int indice, int pesoRestante) {
        if (indice == pesos.length) {
            return 0;
        }
        int valorMaximoNoActual = mochilaFuerzaBruta(indice + 1, pesoRestante);
        int valorMaximoActual = 0;
        if (pesos[indice] <= pesoRestante) {
            valorMaximoActual = valores[indice] + mochilaFuerzaBruta(indice + 1, pesoRestante - pesos[indice]);
        }
        return Math.max(valorMaximoNoActual, valorMaximoActual);
    }

    public static int mochilaProgDinamica() {
        int n = pesos.length;
        int[][] progDinamica = new int[n + 1][pesoMaximo + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= pesoMaximo; w++) {
                if (pesos[i - 1] <= w) {
                    progDinamica[i][w] = Math.max(valores[i - 1] + progDinamica[i - 1][w - pesos[i - 1]], progDinamica[i - 1][w]);
                } else {
                    progDinamica[i][w] = progDinamica[i - 1][w];
                }
            }
        }
        return progDinamica[n][pesoMaximo];
    }

    public static void main(String[] args) {
        System.out.println("Máximo valor obtenible con fuerza bruta: " + mochilaFuerzaBruta(0, pesoMaximo));
        System.out.println("Máximo valor obtenible con Programación dinámica: " + mochilaProgDinamica());
    }
}
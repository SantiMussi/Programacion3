 class Mochila {
    public static int mochila_FB(int[] pesos, int[] valores, int capacidad, int n) {
        if (n == 0 || capacidad == 0) {
            return 0;
        }
        if (pesos[n-1] > capacidad) {
            return mochila_FB(pesos, valores, capacidad, n-1);
        } else {
            int incluir = valores[n-1] + mochila_FB(pesos, valores, capacidad - pesos[n-1], n-1);
            int excluir = mochila_FB(pesos, valores, capacidad, n-1);
            return Math.max(incluir, excluir);
        }
    }
    public static int mochila_PD(int[] pesos, int[] valores, int capacidad, int n) {
        int[][] pd = new int[n+1][capacidad+1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) {
                    pd[i][w] = 0;
                } else if (pesos[i-1] <= w) {
                    pd[i][w] = Math.max(valores[i-1] + pd[i-1][w-pesos[i-1]], pd[i-1][w]);
                } else {
                    pd[i][w] = pd[i-1][w];
                }
            }
        }
        return pd[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = {3, 4, 2};
        int[] valores = {4, 5, 3};
        int capacidad = 6;
        int n = valores.length;

        int maxValorFuerzaBruta = mochila_PD(pesos, valores, capacidad, n);
        System.out.println("Máximo valor con Fuerza Bruta: " + maxValorFuerzaBruta);

        int maxValorDP = mochila_PD(pesos, valores, capacidad, n);
        System.out.println("Máximo valor con Programación Dinámica: " + maxValorDP);
    }
}

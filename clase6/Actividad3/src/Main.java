import java.util.Arrays;

 class SeleccionProyectos {
    public static int fuerza_bruta(int[] costos, int[] beneficios, int presupuesto, int n) {
        if (n == 0 || presupuesto == 0) {
            return 0;
        }
        if (costos[n-1] > presupuesto) {
            return fuerza_bruta(costos, beneficios, presupuesto, n-1);
        } else {
            int incluir = beneficios[n-1] + fuerza_bruta(costos, beneficios, presupuesto - costos[n-1], n-1);
            int excluir = fuerza_bruta(costos, beneficios, presupuesto, n-1);
            return Math.max(incluir, excluir);
        }
    }

    public static int PD(int[] costos, int[] beneficios, int presupuesto, int n) {
        int[][] dp = new int[n+1][presupuesto+1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= presupuesto; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (costos[i-1] <= w) {
                    dp[i][w] = Math.max(beneficios[i-1] + dp[i-1][w - costos[i-1]], dp[i-1][w]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][presupuesto];
    }

    public static int Greedy(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        double[] ratio = new double[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) beneficios[i] / costos[i];
        }
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> Double.compare(ratio[j], ratio[i]));

        int beneficioTotal = 0;
        int presupuestoRestante = presupuesto;

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (costos[idx] <= presupuestoRestante) {
                beneficioTotal += beneficios[idx];
                presupuestoRestante -= costos[idx];
            }
        }

        return beneficioTotal;
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;
        int n = costos.length;

        int maxBeneficioFuerzaBruta = fuerza_bruta(costos, beneficios, presupuesto, n);
        System.out.println("Máximo beneficio con Fuerza Bruta: " + maxBeneficioFuerzaBruta);

        int maxBeneficioDP = PD(costos, beneficios, presupuesto, n);
        System.out.println("Máximo beneficio con Programación Dinámica: " + maxBeneficioDP);

        int maxBeneficioGreedy = Greedy(costos, beneficios, presupuesto);
        System.out.println("Máximo beneficio con Greedy: " + maxBeneficioGreedy);
    }
}

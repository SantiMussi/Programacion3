import java.util.*;
public class CambioMonedas {
        // Función para encontrar la cantidad mínima de monedas
        public static List<Integer> encontrarMinimoMonedas(int[] monedas, int monto) {
            // algoritmo de burbuja para ordenar => n cuadrado
            Arrays.sort(monedas);  // n log(n)
            List<Integer> resultado = new ArrayList<>(); // 1
            for (int i = monedas.length - 1; i >= 0; i--) {  // aprox. n
                while (monto >= monedas[i]) {
                    monto -= monedas[i];
                    resultado.add(monedas[i]);
                }
            }
            return resultado;
        }
}

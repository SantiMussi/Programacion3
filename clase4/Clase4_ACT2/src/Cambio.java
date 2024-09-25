import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Cambio {
    public static List<Double> encontrarMinimoComprobantes(double[] monedas, double monto) {
        Arrays.sort(monedas);  // Ordenar en orden ascendente
        List<Double> listaMonedas = new ArrayList<>();
        for (double moneda : monedas) {
            listaMonedas.add(moneda);
        }
        Collections.reverse(listaMonedas);  // Invertir el orden para obtener orden descendente

        List<Double> resultado = new ArrayList<>();
        for (double moneda : listaMonedas) {
            while (monto >= moneda) {
                monto = monto - moneda;
                resultado.add(moneda);
            }
        }
        return resultado;
    }
}



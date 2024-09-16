public class Main{
    public static int[] encontrarDosMaximos(int[] lista) {
        if (lista.length == 1) {
            return new int[]{lista[0], Integer.MIN_VALUE};
        }
        if (lista.length == 2) {
            return new int[]{Math.min(lista[0], lista[1]), Math.max(lista[0], lista[1])};
        }

        int mitad = lista.length / 2;
        int[] izquierda = encontrarDosMaximos(sliceArray(lista, 0, mitad));
        int[] derecha = encontrarDosMaximos(sliceArray(lista, mitad, lista.length));

        return combinar(izquierda, derecha);
    }

    private static int[] sliceArray(int[] array, int inicio, int fin) {
        int[] resultado = new int[fin - inicio];
        System.arraycopy(array, inicio, resultado, 0, fin - inicio);
        return resultado;
    }

    private static int[] combinar(int[] izquierda, int[] derecha) {
        int[] maximos = new int[]{izquierda[0], izquierda[1], derecha[0], derecha[1]};
        java.util.Arrays.sort(maximos);
        return new int[]{maximos[2], maximos[3]};
    }

    public static void main(String[] args) {
        int[] lista = {45, 22, 39, 87, 56, 90, 67};
        int[] maximos = encontrarDosMaximos(lista);
        System.out.println("Los dos máximos son: " + maximos[0] + " y " + maximos[1]);
    }
}

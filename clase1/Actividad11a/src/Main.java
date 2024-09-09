public class Main {
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] array = {3, 7, 2, 5, 10, 1};
        System.out.println("El máximo es: " + findMax(array));
    }
}

/*
* Complejidad en tiempo: O(n), ya que el algoritmo recorre todos los elementos del array una sola vez.
* Complejidad en espacio: O(1), porque solo se utiliza una variable adicional para almacenar el valor máximo.
*/
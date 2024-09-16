import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main{

    public static ArrayList<Integer> encontrarNMayores(ArrayList<Integer> lista, int n) {
        //Caso base
        if (lista.size() <= n) {
            return lista;
        }

        int mitad = lista.size() / 2;
        ArrayList<Integer> mitadIzquierda = new ArrayList<>(lista.subList(0, mitad));
        ArrayList<Integer> mitadDerecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        //Encontrar los n mayores en cada mitad
        ArrayList<Integer> mayoresIzquierda = encontrarNMayores(mitadIzquierda, n);
        ArrayList<Integer> mayoresDerecha = encontrarNMayores(mitadDerecha, n);

        //Fusionar y ordenar los resultados
        return fusionarYSeleccionar(mayoresIzquierda, mayoresDerecha, n);
    }

    //Método para fusionar dos listas y devolver los n mayores elementos
    private static ArrayList<Integer> fusionarYSeleccionar(ArrayList<Integer> izquierda, ArrayList<Integer> derecha, int n) {
        ArrayList<Integer> fusionada = new ArrayList<>(izquierda);
        fusionada.addAll(derecha);

        Collections.sort(fusionada, Collections.reverseOrder());

        return new ArrayList<>(fusionada.subList(0, n));
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 7, 6, 3, 8, 4));
        int n = 3;

        ArrayList<Integer> resultado = encontrarNMayores(lista, n);
        System.out.println("Los " + n + " elementos más grandes son: " + resultado);
    }
}

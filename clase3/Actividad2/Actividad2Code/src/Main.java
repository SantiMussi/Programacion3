import java.util.Arrays;

public class Main {

    public static int[] encontrarDosMayores(int[] lista) {
        //Caso base
        if (lista.length == 2) {
            if (lista[0] > lista[1]) {
                return new int[]{lista[0], lista[1]};
            } else {
                return new int[]{lista[1], lista[0]};
            }
        }

        int mitad = lista.length / 2;
        int[] mitadIzquierda = Arrays.copyOfRange(lista, 0, mitad);
        int[] mitadDerecha = Arrays.copyOfRange(lista, mitad, lista.length);

        //Obtenemos los dos mayores de cada mitad recursivamente
        int[] mayoresIzquierda = encontrarDosMayores(mitadIzquierda);
        int[] mayoresDerecha = encontrarDosMayores(mitadDerecha);

        int mayor, segundoMayor;
        if (mayoresIzquierda[0] > mayoresDerecha[0]) {
            mayor = mayoresIzquierda[0];
            segundoMayor = Math.max(mayoresIzquierda[1], mayoresDerecha[0]);
        } else {
            mayor = mayoresDerecha[0];
            segundoMayor = Math.max(mayoresDerecha[1], mayoresIzquierda[0]);
        }

        return new int[]{mayor, segundoMayor};
    }

    public static void main(String[] args) {
        int[] lista = {3, 9, 2, 10, 7, 6, 12, 8};
        int[] resultado = encontrarDosMayores(lista);

        System.out.println("Mayor: " + resultado[0]);
        System.out.println("Segundo mayor: " + resultado[1]);
    }
}

/*
* El algoritmo es lineal O(n), ya que en cada llamada recursiva se divide el tamaño de la lista a la mitad.
* En cada llamada recursiva se obtienen los dos mayores de cada mitad y se comparan para obtener los dos mayores de la lista completa.
* */

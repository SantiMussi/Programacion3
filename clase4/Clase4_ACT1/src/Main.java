import java.util.*;

public class Main {
    public static void main(String[] args) {
        CambioMonedas cash= new CambioMonedas();
        int[] monedas = { 1, 5, 10, 25 };
        int monto = 64;
        List<Integer> resultado = cash.encontrarMinimoMonedas(monedas, monto);
        System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);
    }
}

// COMPLEJIDAD: O(n log n  + n)
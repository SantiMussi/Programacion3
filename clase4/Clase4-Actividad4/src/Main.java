import java.util.*;

public class Main {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int costeTotal = 0;
        int cantPersonas = 0;
        for (int i = c.length - 1; i >= 0; i--){
            costeTotal += (cantPersonas /k+1) * c[i];
            cantPersonas++;
        }
        return costeTotal;
    }

    public static void main(String[] args){
        int k = 3;
        int[] c = {1,3,5,7,9};
        int resultado = getMinimumCost(k, c);
        System.out.println(resultado);
    }
}
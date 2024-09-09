public class SumaRecursiva {
    public static void main(String[] args) {
        int n = 5;
        int resultado = suma(n);
        System.out.println("La suma de los primeros " + n + " números es: " + resultado);
    }
    public static int suma(int n) {
        if (n == 1) {
            return 1; }
        else {
            return n + suma(n - 1);
        }
    }
}

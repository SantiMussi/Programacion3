import java.math.BigInteger;
public class ejemploBigInteger {
    public static void main(String[] args) {
        //Inicializamos BigInteger con números grandes
        BigInteger a = new BigInteger("100000000000000000000");
        BigInteger b = new BigInteger("200000000000000000000");

        //Suma
        BigInteger sum = a.add(b);

        // Multiplicación
        BigInteger product = a.multiply(b);

        System.out.println("Suma (BigInteger): " + sum);
        System.out.println("Multiplicación (BigInteger): " + product);
    }
}


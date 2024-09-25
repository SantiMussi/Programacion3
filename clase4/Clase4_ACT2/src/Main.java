import java.util.List;

public class Main {
    public static void main(String[] args) {
                Cambio cash= new Cambio();
                double [] valores = {0.01,0.05, 0.1, 0.25,1.0,10.0,20.0,50.0,100.0,200.0,500.0,1000.0};
                double monto = 5673.20;
                List<Double> resultado = cash.encontrarMinimoComprobantes(valores, monto);
                System.out.println("Comprobantes usadas para hacer " + monto + ": " + resultado);
    }
}// devuelve un centavo de menos, lo hablamos con el profe en clase y dijo que no pasa nada que lo dejemos asi

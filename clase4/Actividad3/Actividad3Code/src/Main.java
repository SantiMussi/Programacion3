import java.util.*;

class Objeto {
    int peso;
    int valor;

    public Objeto(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double valorPorPeso() {
        return (double) valor / peso;
    }
}

public class Main{

    public static List<String> greedyCarga(List<Objeto> listaObjetos, int camionCapacidad) {
        //Se ordenan los objetos por valor por peso de mayor a menor
        listaObjetos.sort((o1, o2) -> Double.compare(o2.valorPorPeso(), o1.valorPorPeso()));

        int capacidadActual = 0;
        double valorTotal = 0;
        List<String> listaObjetosCargados = new ArrayList<>();

        for (Objeto objeto : listaObjetos) {
            if (capacidadActual + objeto.peso <= camionCapacidad) {
                capacidadActual += objeto.peso;
                valorTotal += objeto.valor;
                listaObjetosCargados.add("Objeto completo con peso: " + objeto.peso + " y valor: " + objeto.valor);
            } else {
                //Cargamos una fracción del objeto
                int espacioRestante = camionCapacidad - capacidadActual;
                double fraccion = (double) espacioRestante / objeto.peso;
                valorTotal += fraccion * objeto.valor;
                capacidadActual += espacioRestante;
                listaObjetosCargados.add("Fracción de objeto con peso: " + espacioRestante + " y valor: " + (fraccion * objeto.valor));
                break;  // El camión está lleno
            }
        }

        System.out.println("Valor total cargado: " + valorTotal);
        return listaObjetosCargados;
    }

    public static void main(String[] args) {
        List<Objeto> listaObjetos = new ArrayList<>();
        listaObjetos.add(new Objeto(10, 60));  // Peso 10, Valor 60
        listaObjetos.add(new Objeto(20, 100)); // Peso 20, Valor 100
        listaObjetos.add(new Objeto(30, 120)); // Peso 30, Valor 120

        int camionCapacidad = 50;

        List<String> objetosCargados = greedyCarga(listaObjetos, camionCapacidad);
        System.out.println("Objetos cargados: " + objetosCargados);
    }
}

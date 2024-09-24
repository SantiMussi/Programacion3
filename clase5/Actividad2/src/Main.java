import java.util.ArrayList;
import java.util.List;

class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // agregar una arista entre dos vértices
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
        }
    }

    // eliminar una arista
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;
        }
    }

    // verificar si existe una arista
    public boolean verificarArista(int origen, int destino) {
        return origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices && matrizAdyacencia[origen][destino] == 1;
    }

    // listar los vértices adyacentes a un vértice dado
    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
        }
        return adyacentes;
    }

    // contar el grado de salida de un vértice
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
        }
        return gradoSalida;
    }

    // contar el grado de entrada de un vértice
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
        }
        return gradoEntrada;
    }

    // mostrar la matriz de adyacencia
    public void mostrarMatrizAdyacencia() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(4, 0);
        grafo.mostrarMatrizAdyacencia();
        System.out.println(grafo.verificarArista(0, 1));
        System.out.println(grafo.verificarArista(1, 0));
        System.out.println(grafo.listarAdyacentes(0));
        System.out.println(grafo.contarGradoSalida(0));
        System.out.println(grafo.contarGradoEntrada(0));
    }
}
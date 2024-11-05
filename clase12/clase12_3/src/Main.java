import java.util.*;

// Clase que representa un almacén
class Almacen {
    private int id;
    private String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Almacen{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}

// Clase que representa el grafo de almacenes
class Grafo {
    private Map<Integer, Almacen> almacenes; // Mapeo de ID de almacén a Almacen
    private Map<Integer, List<Integer>> rutas; // Lista de adyacencia

    public Grafo() {
        almacenes = new HashMap<>();
        rutas = new HashMap<>();
    }

    // Método para agregar un almacén
    public void agregarAlmacen(int id, String nombre) {
        Almacen nuevoAlmacen = new Almacen(id, nombre);
        almacenes.put(id, nuevoAlmacen);
        rutas.putIfAbsent(id, new ArrayList<>());
    }

    // Método para conectar dos almacenes
    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            rutas.get(id1).add(id2);
            rutas.get(id2).add(id1); // Conexión bidireccional
        } else {
            System.out.println("Almacén no encontrado.");
        }
    }

    // Método para realizar DFS (recorrido en profundidad) con backtracking
    public void dfsBacktracking(int inicio) {
        Set<Integer> visitado = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRecursivo(inicio, visitado);
    }

    private void dfsRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo);
        System.out.println(almacenes.get(nodo));

        // Recorremos los vecinos
        for (int vecino : rutas.get(nodo)) {
            if (!visitado.contains(vecino)) {
                dfsRecursivo(vecino, visitado);
            }
        }

        // Simulamos backtracking desmarcando el nodo (si fuera necesario)
        visitado.remove(nodo); // Se desmarca el nodo para el "backtracking"
    }

    // Método para realizar BFS (recorrido en anchura)
    public void bfs(int inicio) {
        Set<Integer> visitado = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        visitado.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.println(almacenes.get(nodo));

            // Procesamos los vecinos
            for (int vecino : rutas.get(nodo)) {
                if (!visitado.contains(vecino)) {
                    cola.add(vecino);
                    visitado.add(vecino);
                }
            }
        }
    }
}

// Clase principal para probar el sistema
public class Main {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        // Agregamos almacenes
        redAlmacenes.agregarAlmacen(0, "Almacen Central");
        redAlmacenes.agregarAlmacen(1, "Almacen Norte");
        redAlmacenes.agregarAlmacen(2, "Almacen Sur");
        redAlmacenes.agregarAlmacen(3, "Almacen Este");
        redAlmacenes.agregarAlmacen(4, "Almacen Oeste");

        // Conectamos almacenes
        redAlmacenes.conectarAlmacenes(0, 1);
        redAlmacenes.conectarAlmacenes(0, 2);
        redAlmacenes.conectarAlmacenes(1, 3);
        redAlmacenes.conectarAlmacenes(2, 4);

        // Realizamos el recorrido DFS desde el almacén 0
        redAlmacenes.dfsBacktracking(0);

        // Realizamos el recorrido BFS desde el almacén 0
        redAlmacenes.bfs(0);
    }
}

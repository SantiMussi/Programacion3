import java.util.*;


class Usuario {
    private int id;
    private String nombre;

    public Usuario(int id, String nombre) {
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
        return "Usuario{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}


class RedSocial {
    private Map<Integer, Usuario> usuarios;
    private Map<Integer, List<Integer>> amistades;

    public RedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }


    public void agregarUsuario(int id, String nombre) {
        Usuario nuevoUsuario = new Usuario(id, nombre);
        usuarios.put(id, nuevoUsuario);
        amistades.putIfAbsent(id, new ArrayList<>());
    }


    public void conectarAmistad(int id1, int id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2);
            amistades.get(id2).add(id1);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }


    public void dfsBacktracking(int idInicial) {
        Set<Integer> visitado = new HashSet<>();
        System.out.println("Recorrido DFS desde el usuario " + usuarios.get(idInicial).getNombre() + ":");
        dfsRecursivo(idInicial, visitado);
    }

    private void dfsRecursivo(int usuario, Set<Integer> visitado) {
        visitado.add(usuario);
        System.out.println(usuarios.get(usuario));


        for (int amigo : amistades.get(usuario)) {
            if (!visitado.contains(amigo)) {
                dfsRecursivo(amigo, visitado);
            }
        }


        visitado.remove(usuario);
    }


    public void bfs(int idInicial) {
        Set<Integer> visitado = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(idInicial);
        visitado.add(idInicial);

        System.out.println("Recorrido BFS desde el usuario " + usuarios.get(idInicial).getNombre() + ":");
        while (!cola.isEmpty()) {
            int usuario = cola.poll();
            System.out.println(usuarios.get(usuario));


            for (int amigo : amistades.get(usuario)) {
                if (!visitado.contains(amigo)) {
                    cola.add(amigo);
                    visitado.add(amigo);
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();


        red.agregarUsuario(0, "Juana");
        red.agregarUsuario(1, "Carlos");
        red.agregarUsuario(2, "Micaela");
        red.agregarUsuario(3, "Maximo");
        red.agregarUsuario(4, "Camila");

     
        red.conectarAmistad(0, 1); // Alice - Bob
        red.conectarAmistad(0, 2); // Alice - Charlie
        red.conectarAmistad(1, 3); // Bob - David
        red.conectarAmistad(2, 4); // Charlie - Eve


        red.dfsBacktracking(0);


        red.bfs(0);
    }
}

public class Main {
    public static void main(String[] args) {
        busqueda_binaria tree = new busqueda_binaria();

        // Crear un árbol de ejemplo
        arbol root = new arbol(10);
        root.left = new arbol(5);
        root.right = new arbol(20);
        root.left.left = new arbol(3);
        root.left.right = new arbol(7);
        root.right.left = new arbol(15);
        root.right.right = new arbol(25);
        root.right.right.right = new arbol(30);

        // Buscar el valor 7 en el árbol
        int valueToSearch = 7;
        arbol result = tree.bst(root, valueToSearch);

        if (result != null) {
            System.out.println("Valor " + result.value + " encontrado en el árbol.");
        } else {
            System.out.println("Valor no encontrado en el árbol.");
        }
        System.out.println("Altura del arbol " + tree.altura(root));

    }
}

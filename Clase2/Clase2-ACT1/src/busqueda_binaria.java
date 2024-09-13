public class busqueda_binaria {

        // Método para buscar un valor en el BST
        public arbol bst(arbol root, int x) {
            // Caso base: si  es nulo o si  es el que estamos buscando
            if (root == null || root.value == x) {
                return root;
            }

            // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
            if (x < root.value) {
                return bst(root.left, x);
            }

            // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
            return bst(root.right, x);
        }

        public static int altura(arbol root) {
            if(root==null) {
                return -1;
            } else {
                return 1+ Math.max(altura(root.left),
                        altura(root.right));
            }
        }
}

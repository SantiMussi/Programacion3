class Cliente {
    int id;
    String nombre;
    int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
}

public class MaxScoringCliente {

    public static Cliente encontrarClienteConScoringMaximo(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            //Caso base: si solo hay un cliente, retornarlo.
            return clientes[inicio];
        }

        int mitad = (inicio + fin) / 2;
        Cliente clienteIzquierdo = encontrarClienteConScoringMaximo(clientes, inicio, mitad);
        Cliente clienteDerecho = encontrarClienteConScoringMaximo(clientes, mitad + 1, fin);

        //Conquistar: Comparar los clientes y retornar el de mayor scoring
        if (clienteIzquierdo.scoring > clienteDerecho.scoring) {
            return clienteIzquierdo;
        } else {
            return clienteDerecho;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Santiago", 750),
                new Cliente(2, "Nicolas", 900),
                new Cliente(3, "Julian", 850),
                new Cliente(4, "Matias", 970)
        };

        Cliente maxScoring = encontrarClienteConScoringMaximo(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con máximo scoring: " + maxScoring.nombre + " con un scoring de " + maxScoring.scoring);
    }
}

/* La complejidad algorítmica es de tiempo lineal O(n)
ya que el problema se divide en dos subproblemas de tamaño 𝑛/2, se resuelve cada mitad y luego se combina el resultado con una comparación de tiempo constante. 
Por lo tanto, el algoritmo realiza un número lineal de comparaciones en función del tamaño de la lista de clientes.
 */

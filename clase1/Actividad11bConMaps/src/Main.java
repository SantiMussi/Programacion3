import java.util.*;
class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

class ClienteFactura {
    int idCliente;
    String nombre;
    double sumaImportes;

    public ClienteFactura(int idCliente, String nombre, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.sumaImportes = sumaImportes;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Total Facturado: " + sumaImportes;
    }
}


public class Main {
    public static Map<Integer, ClienteFactura> generarListaClientesFacturas(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, ClienteFactura> resultado = new HashMap<>();

        for (Factura factura : facturas) {
            if (resultado.containsKey(factura.idCliente)) {
                ClienteFactura clienteFactura = resultado.get(factura.idCliente);
                clienteFactura.sumaImportes += factura.importe;
            } else {
                Cliente cliente = clientes.stream()
                        .filter(c -> c.idCliente == factura.idCliente)
                        .findFirst().orElse(null);
                if (cliente != null) {
                    resultado.put(factura.idCliente, new ClienteFactura(factura.idCliente, cliente.nombre, factura.importe));
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.0));
        facturas.add(new Factura(2, 2, 200.0));
        facturas.add(new Factura(3, 1, 50.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan"));
        clientes.add(new Cliente(2, "María"));

        Map<Integer, ClienteFactura> resultado = generarListaClientesFacturas(facturas, clientes);
        for (ClienteFactura clienteFactura : resultado.values()) {
            System.out.println(clienteFactura);
        }
    }
}

/*
* Diferencia Complejidad asintótica
Tiempo: Usar Maps mejora la eficiencia temporal, ya que reducimos la complejidad de O(m×n) a O(n+m), especialmente cuando el número de facturas y clientes es grande.
Espacio: La complejidad espacial es O(m) en ambos casos, ya que en ambos enfoques almacenamos información por cada cliente.
* */
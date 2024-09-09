import java.util.ArrayList;
import java.util.List;

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

public class SistemaFacturacionSinMap {
    public static List<ClienteFactura> generarListaClientesFacturas(List<Factura> facturas, List<Cliente> clientes) {
        List<ClienteFactura> resultado = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double suma = 0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    suma += factura.importe;
                }
            }
            resultado.add(new ClienteFactura(cliente.idCliente, cliente.nombre, suma));
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

        List<ClienteFactura> resultado = generarListaClientesFacturas(facturas, clientes);
        for (ClienteFactura clienteFactura : resultado) {
            System.out.println(clienteFactura);
        }
    }
}


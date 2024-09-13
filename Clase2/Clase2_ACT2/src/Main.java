public class Main {
    public static void main(String[] args) {
        Busqueda_binaria busc= new Busqueda_binaria();
        int [] arr= {1,2,3,4,5,6,7,8,9,10};
        int valor=9;
        int resultado= busc.busquedaBinaria(arr,valor);

        if (resultado==-1){
            System.out.println("No se encontró el número");
        }
        else {
            System.out.println("Elemento encontado en el indice:"+resultado);
        }

    }
}
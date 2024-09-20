public class Usuario {
    private String nombre;
    public Usuario(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    @Override
    public String toString(){
        return nombre;
    }
}

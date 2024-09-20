import java.util.*;

public class Main {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();
        Usuario matias = new Usuario("Matias");
        Usuario esteban = new Usuario("Esteban");
        Usuario nicolas = new Usuario("Nicolas");
        Usuario santiago = new Usuario("Santiago");

        red.agregarUsuario(matias);
        red.agregarUsuario(esteban);
        red.agregarUsuario(nicolas);
        red.agregarUsuario(santiago);

        red.seguir(matias, esteban);
        red.seguir(matias, nicolas);
        red.seguir(esteban, santiago);
        red.seguir(nicolas, esteban);

        System.out.println("A Esteban le siguen: " + red.listarSeguidores(esteban));
        System.out.println("Esteban sigue a: " + red.listarSeguidos(esteban));
        red.dejarDeSeguir(nicolas, esteban);
        red.dejarDeSeguir(nicolas, esteban);
        System.out.println("A Esteban le siguen: " + red.listarSeguidores(esteban));
        System.out.println("Esteban sigue a: " + red.listarSeguidos(esteban));

    }
}
class RedSocial{
    private Map<Usuario, List<Usuario>> seguidores;
    public RedSocial(){
        seguidores = new HashMap<>();
    }

    public void agregarUsuario(Usuario user){
        if(!seguidores.containsKey(user)){
            seguidores.put(user,new ArrayList<>());
        }
        else {
            System.out.println("Error, el usuario ya existe.");
        }
    }

    public void seguir(Usuario seguidor, Usuario seguido){
        if(seguidores.containsKey(seguidor) & seguidores.containsKey(seguido)){
            List<Usuario> seguidosPorSeguidor = seguidores.get(seguidor);
            if(!seguidosPorSeguidor.contains(seguido)){
                seguidosPorSeguidor.add(seguido);
            }
            else{
                System.out.println("Error, " + seguidor.getNombre() + " ya sigue a " + seguido.getNombre() + ".");
            }
        }
        else {
            System.out.println("Error, uno o ambos usuarios no existen.");
        }
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido){
        if (seguidores.containsKey(seguidor) & seguidores.containsKey(seguido)){
            List<Usuario> seguidosPorSeguidor = seguidores.get(seguidor);
            if (seguidosPorSeguidor.contains(seguido)){
                seguidosPorSeguidor.remove(seguido);
            }
            else {
                System.out.println(seguidor.getNombre() + " no sigue a " + seguido.getNombre() + ".");
            }
        }
        else{
            System.out.println("Error, uno o ambos usuarios no existen.");
        }
    }

    public List<Usuario> listarSeguidos(Usuario user){
        if (seguidores.containsKey(user)){
            return seguidores.get(user);
        }
        System.out.println("Error, el usuario no existe.");
        return Collections.emptyList();
    }

    public List<Usuario> listarSeguidores(Usuario user){
        List<Usuario> listaDeSeguidores = new ArrayList<>();
        for(Map.Entry<Usuario, List<Usuario>> entry : seguidores.entrySet()){
            if (entry.getValue().contains(user)){
                listaDeSeguidores.add(entry.getKey());
            }
        }
        return listaDeSeguidores;
    }
}
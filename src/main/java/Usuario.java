import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private int iduser;
    private String nombre;
    public List<Pedido> misPedidos;//Lista donde se añadiran los pedidos que voy haciendo
    public Usuario(int id, String nomb){ //CONSTRUCTOR
        iduser = id;
        nombre = nomb;
        this.misPedidos = new LinkedList<Pedido>();

    }
}

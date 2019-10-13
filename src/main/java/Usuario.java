import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String iduser;
    private String nombre;
    public List<Pedido> misPedidos;//Lista donde se añadiran los pedidos que voy haciendo
    public Usuario(String id, String nomb){ //CONSTRUCTOR
        iduser = id;
        nombre = nomb;
        this.misPedidos = new LinkedList<Pedido>();

    }
}

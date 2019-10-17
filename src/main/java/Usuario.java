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
    public String getIdusario (){
        return iduser;
    }
    public String devuelvePedido1(){//devuelve el primer pedido
        Pedido aux = misPedidos.get(0);
        return aux.dimeIdUserv2();
    }
    public void addPedidoalHistorial(Pedido c){
        misPedidos.add(c);
    }

}

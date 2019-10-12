import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GestorProductosImpl implements GestorProductos {
    Queue<Pedido> pedidos;
    List<Producto> productos;
    HashMap<String,Usuario> users;

    public GestorProductosImpl(){
        this.productos = new LinkedList<Producto>();
        this.users = new HashMap<String, Usuario>();
    }


    public List<Producto> productosOrdPrecio() {
        return null;
    }

    public void anotarPedido(Pedido c) { //El pedido se añade a la cola
        pedidos.add(c);
    }

    public void servirPedido() {
        Pedido pedido1 = pedidos.peek();
        int auxIdUsuario =pedido1.dimeIdUser(pedido1);

        for (int j=0; j<pedido1.listapedido.size();j++){
            String producto;
            pedido1.listapedido

        }
















        Pedido pedido = pedidos.peek();

        for (Pedido.LP lp: pedido.getLPs()) {
            nomProducte = lp.getProducte();
            producto = consultarProducto(nomProducte);
            producto.updateNumVendes(lp.getQuantitat);
        }

        User user = this.users.get(pedido.getUser());
        user.addPedido(pedido);


    }

    public List<Pedido> pedidoPorUser(String iduser) {
        return null;
    }

    public List<Producto> productosOrdVentas() {
        return null;
    }
}

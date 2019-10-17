import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GestorProductosImpl implements GestorProductos {
    public Logger log = LogManager.getLogger(GestorProductosImpl.class);
    Queue<Pedido> pedidos;
    List<Producto> productos;
    HashMap<String,Usuario> users;

    public GestorProductosImpl(){
        this.productos = new LinkedList<Producto>();
        this.users = new HashMap<String, Usuario>();
        this.pedidos = new LinkedList<Pedido>();
    }
    public void actualizaProducto(String nom, int q){
        for (int j=0;j<productos.size();j++){
            Producto prod = productos.get(j);
            if(nom.equals(prod.getNombre())){ //Equals per comparar objectes
                prod.aumentarNumVentas(q);
            }
        }
    }
    public void addProducto(String id,String nom, int pre){ //Añadimos un producto a nuestra lista
        productos.add(new Producto(id,nom,pre));
    }
    public void addUser(Usuario c){
        users.put(c.getIdusario(),c);
    }
    public List<Producto> productosOrdPrecio(){
        return null;
    }

    public void anotarPedido(Pedido c) { //El pedido se añade a la cola
        pedidos.add(c);
    }

    public void servirPedido() { //Retiramos el pedido de la cola y actualizamos el numero de ventas de los productos
        Pedido pedido1 = pedidos.peek();
        log.info(" PEDIDO del user "+pedido1.dimeIdUserv2());
        String auxIdUsuario =pedido1.dimeIdUser(pedido1);
        log.info(" Num ventas antes de añadir");
        for (int j=0; j<pedido1.listapedido.size();j++){
            String producto = pedido1.nombProd(j);
            int plus = pedido1.cantProd(j);
            actualizaProducto(producto,plus);
        }
        Usuario a = users.get(auxIdUsuario);
        a.addPedidoalHistorial(pedido1);
    }
    public List<Pedido> pedidoPorUser(String iduser) {
        return null;
    }

    public List<Producto> productosOrdVentas() {
        return null;
    }
}

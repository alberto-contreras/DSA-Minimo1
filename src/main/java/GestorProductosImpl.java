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
    public void actualizaProducto(String nom, int q){
        for (int j=0;j<productos.size();j++){
            Producto prod = productos.get(j);
            if(nom ==prod.getNombre()){
                prod.aumentarNumVentas(q);
            }
        }
    }
    public void addProducto(int id,String nom, int pre){ //Añadimos un producto a nuestra lista
        productos.add(new Producto(id,nom,pre));
    }
    public void adduser(String id,String nombre){
        users.put(id,new Usuario(id,nombre));

    }
    public List<Producto> productosOrdPrecio(){
        return null;
    }

    public void anotarPedido(Pedido c) { //El pedido se añade a la cola
        pedidos.add(c);
    }

    public void servirPedido() { //Retiramos el pedido de la cola y actualizamos el numero de ventas de los productos
        Pedido pedido1 = pedidos.peek();
        String auxIdUsuario =pedido1.dimeIdUser(pedido1);

        for (int j=0; j<pedido1.listapedido.size();j++){
            String producto = pedido1.nombProd(j);
            int plus = pedido1.cantProd(j);
            actualizaProducto(producto,plus);
        }

    }

    public List<Pedido> pedidoPorUser(String iduser) {
        return null;
    }

    public List<Producto> productosOrdVentas() {
        return null;
    }
}

import java.util.*;
import java.lang.Comparable;
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
        users.put(c.getIdusuario(),c);
        log.info("Num users in the hashmap:"+ users.size());
    }

    public void anotarPedido(Pedido c) { //El pedido se añade a la cola
        log.info("Anotando pedido del user: "+c.dimeIdUserv2());
        pedidos.add(c);
    }

    public void servirPedido() { //Retiramos el pedido de la cola y actualizamos el numero de ventas de los productos
        Pedido pedido1 = pedidos.poll();
        log.info(" Sirviendo PEDIDO del user: "+pedido1.dimeIdUser(pedido1));
        String auxIdUsuario =pedido1.dimeIdUser(pedido1);
        for (int j=0; j<pedido1.listapedido.size();j++){
            String producto = pedido1.nombProd(j);
            int plus = pedido1.cantProd(j);
            actualizaProducto(producto,plus);
        }
        Usuario a = users.get(auxIdUsuario);
        a.addPedidoalHistorial(pedido1);
    }
    public List<Pedido> pedidoPorUser(String iduser) {
        Usuario b = users.get(iduser);
        log.info("DATA lista pedidos user"+b.miHistorial());
        return b.miHistorial();

    }

    public List<Producto> productosOrdVentas() { //Creamos una copia de la lista y definimos el metodo comparar en este caso
        List<Producto> clon = new LinkedList<Producto>();// como nos interese
        clon.addAll(this.productos);
        Collections.sort(clon, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return (o1.getNumVentas() - o2.getNumVentas());
            }
        });
        //log.info("DATA lista pedidos por ventas"+clon);
        return clon;
    }
    public List<Producto> productosOrdPrecio(){//Creamos una copia de la lista y definimos el metodo comparar en este caso
        List<Producto> clon = new LinkedList<Producto>();// como nos interese
        clon.addAll(this.productos);
        Collections.sort(clon, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return (o1.getPrecio() - o2.getPrecio());
            }
        });
        //log.info("DATA lista productos por precio"+clon);
        return clon;



    }
}

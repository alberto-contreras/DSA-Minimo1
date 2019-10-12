import java.util.List;

public interface GestorProductos {
    public List<Producto> productosOrdPrecio();
    public void anotarPedido(Pedido c);
    public void servirPedido();
    public List<Pedido> pedidoPorUser(String iduser);
    public List<Producto> productosOrdVentas();
}

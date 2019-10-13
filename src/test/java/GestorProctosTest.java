import org.junit.Before;
import org.junit.Test;

public class GestorProctosTest {
    GestorProductos gestor ;

    @Before
    public void setUp() {

        gestor = new GestorProductosImpl();
        ((GestorProductosImpl) gestor).addProducto(1,"CocaCola",2);//porque no me deja directo
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "choco");
        pedido.añadirLP(1, "coca-zero");
        pedido.añadirLP(1, "bocataJamon");

        gestor.anotarPedido(pedido);
    }
    @Test
    public void testEncolarPedido() {
        Pedido pedido = new Pedido("111");
        pedido.addLP(1, "choco");
        pedido.addLP(5, "coca-zero");
        pedido.addLP(2, "bocataJamon");

        gestor.anotarPedido(pedido);

        gestor.servirPedido();

        User toni = gestor.getUser("111");
        Assert.assertEquals("cola", 1, toni.getPedidos().size);


    }
    @Test
    public void servirPedido(){

    }
}

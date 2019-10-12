import org.junit.Before;

public class GestorProctosTest {
    GestorProductos gestor ;

    @Before
    public void setUp() {

        gestor = new GestorProductosImpl();
        gestor.addProduct("coca-zero", " ", 2.5);
        gestor.addProduct("choco", "", "1");
        gestor.addProduct("cafeLlet", "", 1.5);
        gestor.addProduct("cafeLlet", "", 1.5);

        gestor.addUser("111", "toni");

        Pedido pedido = new Pedido("111");
        pedido.addLP(3, "choco");
        pedido.addLP(1, "coca-zero");
        pedido.addLP(1, "bocataJamon");

        gestor.anotarPedido(pedido);
    }

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
}

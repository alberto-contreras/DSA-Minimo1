import com.sun.tools.javac.util.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.LogManager;

public class GestorProctosTest {
    GestorProductos gestor ;

    @Before
    public void setUp() {

        gestor = new GestorProductosImpl();
        gestor.addProducto("1","CocaCola-Zero",2);//porque no me deja directo
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "choco");
        pedido.añadirLP(1, "coca-zero");
        pedido.añadirLP(1, "bocataJamon");


    }
    @Test
    public void encolarPedido() {

        gestor.addProducto("1","CocaCola",2);
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "choco");
        pedido.añadirLP(1, "coca-zero");
        pedido.añadirLP(1, "bocataJamon");
        gestor.anotarPedido(pedido); // añadir pedido



    }
    @Test
    public void servirPedido(){
        gestor.addProducto("1","CocaCola",2);
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "choco");
        pedido.añadirLP(1, "coca-zero");
        pedido.añadirLP(1, "bocataJamon");
        gestor.anotarPedido(pedido); // añadir pedido
        Usuario alberto = new Usuario("111","Alberto");
        Assert.assertEquals("Añadir correctamente usuario","111", alberto.getIdusario());
        gestor.addUser(alberto);
        Assert.assertEquals("Añadir correctamente producto en el pedido","coca-zero",pedido.nombProd(1) );
        gestor.servirPedido();//servimos pedido
        Assert.assertEquals("Añadir correctamente producto en el pedido","111",alberto.devuelvePedido1());

    }
}

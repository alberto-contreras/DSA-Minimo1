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
        gestor.addProducto("1","CocaCola-Zero",2);
        gestor.addProducto("2","baguette",1);
        gestor.addProducto("3","bravas",3);
        Pedido pedido1 = new Pedido("222");
        pedido1.añadirLP(3, "baguette");
        pedido1.añadirLP(1, "croissant");
        pedido1.añadirLP(1, "bravas");
        Usuario toni = new Usuario("222","toni");
        gestor.anotarPedido(pedido1);
        gestor.addUser(toni);
        gestor.servirPedido();


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
        Usuario alberto = new Usuario("111","Alberto");
        gestor.addUser(alberto);
        gestor.addProducto("1","CocaCola",2);
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "bravas");
        pedido.añadirLP(1, "CocaCola-Zero");
        pedido.añadirLP(1, "bocataJamon");
        gestor.anotarPedido(pedido); // añadir pedido
        Assert.assertEquals("Añadir correctamente usuario","111", alberto.getIdusuario());
        gestor.servirPedido();//servimos pedido
        Assert.assertEquals("Añadir correctamente producto en el pedido","111",alberto.devuelvePedido1());

    }
    @Test
    public void listapedidoPorUser(){
        gestor.addProducto("4","CocaCola",2);
        gestor.addProducto("5","choco",2);
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "choco");
        pedido.añadirLP(1, "coca-zero");
        pedido.añadirLP(1, "bocataJamon");
        gestor.anotarPedido(pedido); // añadir pedido
        Usuario alberto = new Usuario("111","Alberto");
        Assert.assertEquals("Añadir correctamente usuario","111", alberto.getIdusuario());
        gestor.addUser(alberto);
        Assert.assertEquals("Añadir correctamente producto en el pedido","bocataJamon",pedido.nombProd(2) );
        gestor.servirPedido();//servimos pedido
        gestor.pedidoPorUser(alberto.getIdusuario());

    }
    @Test
    public void listaproductosVentas() {
        gestor.addProducto("4","CocaCola",2);
        gestor.addProducto("5","choco",2);
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "choco");
        pedido.añadirLP(1, "coca-zero");
        pedido.añadirLP(1, "bocataJamon");
        gestor.anotarPedido(pedido); // añadir pedido
        Usuario alberto = new Usuario("111","Alberto");
        Assert.assertEquals("Añadir correctamente usuario","111", alberto.getIdusuario());
        gestor.addUser(alberto);
        Assert.assertEquals("Añadir correctamente producto en el pedido","bocataJamon",pedido.nombProd(2) );
        gestor.servirPedido();//servimos pedido
        gestor.productosOrdVentas();

    }
    @Test
    public void listaproductosPrecio() {
        gestor.addProducto("4","CocaCola",2);
        gestor.addProducto("5","choco",2);
        Pedido pedido = new Pedido("111");
        pedido.añadirLP(3, "choco");
        pedido.añadirLP(1, "coca-zero");
        pedido.añadirLP(1, "bocataJamon");
        gestor.anotarPedido(pedido); // añadir pedido
        Usuario alberto = new Usuario("111","Alberto");
        Assert.assertEquals("Añadir correctamente usuario","111", alberto.getIdusuario());
        gestor.addUser(alberto);
        Assert.assertEquals("Añadir correctamente producto en el pedido","bocataJamon",pedido.nombProd(2) );
        gestor.servirPedido();//servimos pedido
        gestor.productosOrdPrecio();

    }
}

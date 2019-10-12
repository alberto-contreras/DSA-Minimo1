import java.util.LinkedList;
import java.util.List;

public class Pedido {
    private int idUser;
    List<LP> listapedido; // = new List<Producto>(10);


    public class LP { //nombre del producto y cantidad
        private int q;
        private String producte;

         public LP(int cant, String prod) {
             q=cant;
             producte = prod;
         }
     }
    public Pedido(int id) {//Constructor
        idUser = id;
        this.listapedido = new LinkedList<LP>();
    }

    public List<LP>getLPs() {
        return this.listapedido;
    }
    public void añadirLP(int cant, String prod){ //añadimos producto y cantidad a nuestra lista
         LP auxLP = new LP(cant,prod);
        listapedido.add(auxLP);

    }
    public int dimeIdUser(Pedido h){
        return h.idUser;
    }
    public int cantProd(){

    }
}

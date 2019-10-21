import java.util.LinkedList;
import java.util.List;

public class Pedido {
    private String idUser;
    List<LP> listapedido;


    public class LP { //nombre del producto y cantidad
        private int q;
        private String producto;

         public LP(int cant, String prod) {
             q=cant;
             producto = prod;
         }
         public String getLPproducto(){
             return producto;
         }
         public int getLPq() {
             return q;
        }
     }
    public Pedido(String id) {//Constructor
        idUser = id;
        this.listapedido = new LinkedList<LP>();
    }

    public List<LP> getLPs() {
        return this.listapedido;
    }

    public void añadirLP(int cant, String prod){ //añadimos producto y cantidad a nuestra lista
         LP auxLP = new LP(cant,prod);
        listapedido.add(auxLP);

    }
    public String dimeIdUser(Pedido h){//Nos devuelve el id del usuario del pedido que le pasamos por parametro
        return h.idUser;
    }
    public String dimeIdUserv2(){ return this.idUser;}

    public int cantProd(int i){ // Nos devuelve la cantidad del producto en la posición i
        LP aux = listapedido.get(i);
        return aux.getLPq();

    }
    public String nombProd(int i){ // Nos devuelve el nombre del producto del producto en la posición i
        LP aux = listapedido.get(i);
        return aux.getLPproducto();

    }

}

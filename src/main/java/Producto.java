public class Producto {
    private int id;
    private String nombre;
    private int numVentas;
    private int precio;
    public Producto(int ident,String nomb, int prec){//CONSTRUCTOR
        id=ident;
        nombre=nomb;
        precio=prec;
        numVentas=0;

    }
    public void aumentarNumVentas(Producto c,int plus){
        c.numVentas = numVentas + plus;
    }
}

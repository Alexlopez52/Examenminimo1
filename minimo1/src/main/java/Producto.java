import java.util.LinkedList;
import java.util.List;

public class Producto {
    private int idProducto;
    private String nomPro;
    private int numVentas;
    private double precio;
    private List<Producto> products = new LinkedList<Producto>();

    public Producto(int id, String nombre, int num, double prec) {
        idProducto = id;
        nomPro = nombre;
        numVentas = num;
        precio = prec;

    }

    public int getId() {
        return idProducto;
    }
    public String getNombre() {
        return nomPro;
    }
    public int getNumVentas() {
        return numVentas;
    }
    public double getPrecio() {
        return precio;
    }
}

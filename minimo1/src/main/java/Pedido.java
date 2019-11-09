import java.util.LinkedList;
import java.util.List;

public class Pedido {
    public String idUserp;
    public List<LP> lps;
//preguntar sobre de donde se saca la lista de productos que existen
    public Pedido(String id) {
        idUserp = id;
        lps = new LinkedList<LP>();
    }

    public String getId() {
        return idUserp;
    }

    public void addLP(int i, String s) {

        this.lps.add(new LP(i, s));
    }

    public List<LP> getLPs() {
        return this.lps;
    }


    // CLASS LP

    public class LP {
        private int q; //cantidad
        private String producto; //nombre

        protected LP (int i, String s) { //declaracion
            this.q = i;
            this.producto = s;
        }

        public String getProducto() {
            return producto;
        }
    }
}


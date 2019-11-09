import java.util.*;

public class GestorProductosImpl implements GestorProductos {
    private HashMap<String, User> users;
    private List<Producto> productos;//hacer una funcion que haga addproducti y guardar
    private Queue<Pedido> pedidos;   //aqui



    protected GestorProductosImpl(){
        this.productos = new ArrayList<Producto>(); //inicializado en test
        this.pedidos = new LinkedList<Pedido>();
        this.users = new HashMap<String, User>();
    }



    public void addProduct(String nombre, double precio)
    {
        productos.add(new Producto(this.productos.get(productos.size()-1).getId(), nombre, 0, precio));
        //mirar si va scon el getsize-1

    }
      public void addUser(String id, String nombre) {
        users.put(id, new User(id,nombre));
    }





    public List<Producto> productOrdPrecio() { //1
        //We create a copy of the list
        List<Producto> ret = this.productos;
        ret.addAll(this.productos);

        //We have to tell to the sort method, which criteria we want to apply
        Collections.sort(ret, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //Ascending order
                return (int) (o1.getPrecio() - o2.getPrecio());
            }
        });
        return ret;
    }

    public void anotarPedido (String id, Pedido c){ //2 //ID ALOMEJOR INNECESARIO
       //enlazar con un user
        users.get(id).addPedido(c);
        pedidos.add(c);

    }

    }
    public void servirPedido(){ //3
        Pedido pedido = pedidos.peek();
        String producto;
        for (Pedido.LP lp: pedido.getLPs()){
            producto = lp.getProducto();
            Producto prod = getProducto(producto);
            prod.updateNumVendes (lp.getQ());
        }

        User theUser = this.users.get(pedido.getidUser());

        if(theUser!=null) {
           theUser.addPedido(pedido);
        }


    }
    public List<Producto> productOrdVentas(){ //4
        //We create a copy of the list
        List<Producto> ret = this.productos;
        ret.addAll(this.productos);

        //We have to tell to the sort method, which criteria we want to apply
        Collections.sort(ret, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //Descending order
                return (-1)*(o1.getNumVentas()-o2.getNumVentas());
            }
        });

        return ret;

    }
    public Queue<Pedido> pedidosPorUsuario(){ //5
        Queue<Pedido> pedidos = null;

        //We want to find the given user
        User theUser = this.users.get(users);//preguntar sobre hashmap

        if(theUser!=null){
            pedidos = theUser.Pedido();
        }
        else throw new UserNotFoundException();

        return pedidos;

    }
}


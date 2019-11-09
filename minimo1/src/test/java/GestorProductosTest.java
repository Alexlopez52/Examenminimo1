




public class GestorProductosTest {
    GestorProductos g = null;
    public void setUp() {
        g = new GestorProductosImpl();
        g.addProduct("COCA", 2.5);
        g.addProduct("CAFE-SOLO", 1);
        g.addProduct("BOCATA-JAMON", 3);
        g.addUser("28282X", "Toni");
    }



    public void testPedido() {
        Pedido p = new Pedido("28282X"); //creas objeto de pedido, lo configuras y lo pasas
        //p.addUser("28282X");    // para anotarlo
        p.addLP(2, "COCA");
        p.addLP(1, "BOCATA-JAMON");

        g.anotarPedido("28282X", p);
    }
}

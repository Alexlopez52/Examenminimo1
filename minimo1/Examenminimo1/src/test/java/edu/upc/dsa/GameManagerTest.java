package edu.upc.dsa;

import edu.upc.dsa.models.UserNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {


    private GameManager g;

    @Before
    public void setUp() {
g=GameManagerImpl.getInstance();
        g.addUser("12", "Pepe","Perez");
        g.addUser("13", "Petronilo","Gutierrez");
        g.addUser("14", "Alejandro","Lopez");
    }
    @Test
   // método de test para añadir un usuario en el sistema y verificar el
    //número de usuarios.
    public void testUser() throws UserNotFoundException //
    {
        g.addUser("15","Federico","Gonzalez");
       g.UserOrden();

        Assert.assertEquals(4 ,g.Usersize());
    }
    @Test
    //- método de test para añadir un objeto asociado a un usuario y verificar
    //el número de objetos asociados a un usuario
    public void testServir() {
        g.addObject("Espada","12");
        Assert.assertEquals(1 ,g.userSizeObjects("12"));

    }


    @After
    public void tearDown(){
        g.clear();
    }

}

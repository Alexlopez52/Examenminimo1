package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameManagerImpl implements GameManager {
    static final Logger log=Logger.getLogger(GameManagerImpl.class);
    private HashMap<String, User> users;


    private static GameManager instance; // singleton

    public static GameManager getInstance() {
        //singleton
        if (instance == null) {
            //Generamos una instancia
            instance = new GameManagerImpl();
        }
        return instance;
    }
    public GameManagerImpl(){
        this.users = new HashMap<String, User>();
    }


    public List<User> UserOrden(){


        List<User> ret = new ArrayList<>(users.values());
        log.info(ret.get(0).getNom());
        log.info(ret.get(1).getNom());
        ret.sort(new Comparador());
        log.info(ret.get(0).getNom());
        log.info(ret.get(1).getNom());
        return ret;




    }
    public void addUser(String id, String nombre, String apellido) {


        users.put(id, new User(id,nombre,apellido));
        log.info("added " + users.get(id).getNom());
    }





    public int editUser(String id ,User usuario){
        log.info("before user edit: " +users.get(id));
        try {
            users.replace(id, usuario);
        } catch (Exception e) {
            return -1;
        }
        log.info("after user edit: " +users.get(id));
        return 0;

    }
    public int Usersize()
    {log.info("user size: " +users.size());
        return this.users.size();

    }
    public User getinfoUser(String id)
    {
        User u = users.get(id);


        log.info("user id :" + u.getIdUser());

        log.info("user name :"+u.getNom());

        log.info("user surname : "+u.getApellidos());
        return u;

    }
    public void addObject(String objeto, String id)
    {
        log.info("old user number of objects : "+users.get(id).getObjetos().size());
          Objeto obj= new Objeto(objeto);
          users.get(id).addObjeto(obj);
        log.info("new user number of objects : "+users.get(id).getObjetos().size());


    }
    public List<Objeto> userObjects(String id)
    {

        List<Objeto> objetos=new LinkedList<Objeto>();
        objetos=users.get(id).getObjetos();
        log.info(objetos.get(0).getNombre());
        Collections.reverse(objetos);
        log.info(objetos.get(0).getNombre());
        return objetos;

    }
    public int userSizeObjects(String id)
    {
        log.info(users.get(id).getObjetos().size());
        return users.get(id).getObjetos().size();


    }

@Override
    public void clear() {
        users.clear();

    }

}

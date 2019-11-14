package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;

import java.util.List;

public interface GameManager {


    public List<User> UserOrden();
    public void addUser(String id, String nombre,String apellido);
    public int editUser(String id, User usuario);
    public int Usersize();
    public User getinfoUser(String id);
    public void addObject(String objeto,String id);
    public List<Objeto> userObjects(String id);
    public int userSizeObjects(String id);
public void clear();






}

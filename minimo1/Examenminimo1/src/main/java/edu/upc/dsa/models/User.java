package edu.upc.dsa.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {
    private String idUser;
    private String nom;
    private String apellidos;
    public List<Objeto> objetos;

      public User(){}
    public User(String id, String nombre,String apellidos) {
        idUser = id;
        nom = nombre;
        this.apellidos=apellidos;
        objetos = new LinkedList<Objeto>();
    }



    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void addObjeto(Objeto c) {

        objetos.add(c);
    }

    public  List<Objeto> getObjetos() {

        return this.objetos;
    }


}



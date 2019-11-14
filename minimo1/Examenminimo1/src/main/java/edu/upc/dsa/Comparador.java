package edu.upc.dsa;

import edu.upc.dsa.models.User;

import java.util.Comparator;

public class Comparador implements Comparator<User> {
    @Override
    public int compare(User p1, User p2) {

        return p1.getNom().compareTo(p2.getNom());
    }
}

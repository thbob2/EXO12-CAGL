package server.src;

import javax.ejb.*;
/**
 ** three methodes are implemented in the interface
 *? add : add a student to the database
 *! pop : remove a student from the data base
 ** show print the students to the user screen
 */
@Remote
public interface Student {
    public boolean add(String name,String lastName, int nbRegistration);
    public boolean pop(int nbRegistration);
    public void print(int nbRegistration);
}
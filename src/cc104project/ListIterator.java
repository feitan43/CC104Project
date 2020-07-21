/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc104project;

/**
 *
 * @author Administrator
 */
public interface ListIterator {
     
    Reservation next();
    boolean hasNext();
    void add(Reservation element);
    void remove();
    void makeNewReservation(Reservation element);
    void set(Reservation element);
}



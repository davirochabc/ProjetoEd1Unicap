/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class NodoEvento {
    Events data;
    NodoEvento next;
    NodoEvento prev;

    public NodoEvento(Events data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

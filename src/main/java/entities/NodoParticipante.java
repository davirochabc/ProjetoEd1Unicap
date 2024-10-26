/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class NodoParticipante {
    ParticipanteEvento data;
    NodoParticipante next;

    public NodoParticipante(ParticipanteEvento data) {
        this.data = data;
        this.next = null;
    }
}


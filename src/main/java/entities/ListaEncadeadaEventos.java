/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class ListaEncadeadaEventos {
    private NodoEvento head;

   
    public void inserirEvento(Events evento) {
        NodoEvento newNode = new NodoEvento(evento);
        if (head == null) {
            head = newNode;
        } else {
            NodoEvento temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

   
    public void exibirEventos() {
        if (head == null) {
            System.out.println("Nenhum evento registrado.");
            return;
        }

        NodoEvento temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

  
    public void exibirEventosInverso() {
        if (head == null) {
            System.out.println("Nenhum evento registrado.");
            return;
        }

        NodoEvento temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }
}

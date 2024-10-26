/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class ListaEncadeadaMesa {
    private NodoMesa head;
    private NodoMesa tail;

    
    public void inserirMesa(Mesas mesa) {
        NodoMesa newNode = new NodoMesa(mesa);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; 
        }
    }

    
    public void exibirMesas() {
        if (head == null) {
            System.out.println("Nenhuma mesa registrada.");
            return;
        }

        NodoMesa temp = head;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != head);
        }
    
    public void removerMesa(int id) {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        NodoMesa current = head;
        NodoMesa previous = null;
       
        do {
            if (current.data.getNumber() == id) { // Supondo que Mesas tenha um método getId()
                if (current == head && current == tail) { 
                    // Caso único onde há apenas uma mesa
                    head = null;
                    tail = null;
                } else if (current == head) {
                    // Removendo a cabeça
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    // Removendo a cauda
                    tail = previous;
                    tail.next = head;
                } else {
                    // Removendo um nó intermediário
                    previous.next = current.next;
                }
                System.out.println("Mesa #" + id + " foi removida.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Mesa com ID " + id + " não encontrada.");
    }
}

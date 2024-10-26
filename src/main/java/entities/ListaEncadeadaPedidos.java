/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class ListaEncadeadaPedidos {
private NodoPedidos head;

    // Método para inserir um novo paciente no final da lista
    public void inserirPedido(Pedidos pedido) {
        NodoPedidos newNode = new NodoPedidos(pedido);
        if (head == null) {
            head = newNode;
        } else {
            NodoPedidos temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Método para exibir todos os pacientes
    public void exibirPedidos() {
        if (head == null) {
            System.out.println("Nenhum pedido na lista.");
            return;
        }

        NodoPedidos temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    

       
}

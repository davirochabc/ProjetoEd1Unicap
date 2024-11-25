/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class ListaEncadeadaPacientes {
    private NodoPaciente head;

    // Método para inserir um novo paciente no final da lista
    public void inserirPaciente(Pacientes paciente) {
        NodoPaciente newNode = new NodoPaciente(paciente);
        if (head == null) {
            head = newNode;
        } else {
            NodoPaciente temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Método para exibir todos os pacientes
    public void exibirPacientes() {
        if (head == null) {
            System.out.println("Nenhum paciente na lista.");
            return;
        }

        NodoPaciente temp = head;
        while (temp != null) {
            System.out.println("--------Paciente--------");
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public Pacientes buscarPaciente(String nome){
        if (head == null) {
            System.out.println("Nenhum paciente na lista.");
            return null;
        }
        NodoPaciente temp = head;
        while(temp != null){
            if (temp.data.getNome().equalsIgnoreCase(nome)) {
               return temp.data; 
            }
            temp = temp.next;
        }
        System.out.println("Paciente não encontrado.");
        return null;
    }


    // Método para remover um paciente (exemplo básico)
    public void removerPaciente(String nome) {
        if (head == null) return;

        if (head.data.getNome().equals(nome)) {
            head = head.next;
            return;
        }

        NodoPaciente temp = head;
        while (temp.next != null && !temp.next.data.getNome().equals(nome)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}

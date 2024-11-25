package entities;

import java.util.PriorityQueue;
import java.util.Stack;
public class FilaPaciente {

    private PriorityQueue<Pacientes> filaPacientes;
    private Stack<Pacientes> pilhaDesfazer;
    public FilaPaciente() {
        filaPacientes = new PriorityQueue<>();
        pilhaDesfazer = new Stack<>();
    }

    // Adicionar paciente à fila
    public void adicionarPaciente(Pacientes paciente) {
        filaPacientes.add(paciente);
        System.out.println("Paciente adicionado à fila: " + paciente.getNome());
    }

    public void atenderPaciente() {
        if (!filaPacientes.isEmpty()) {
            Pacientes atendido = filaPacientes.poll();  
            pilhaDesfazer.push(atendido);
            System.out.println("Atendendo: \n" + atendido);
        } else {
            System.out.println("Nenhum paciente na fila.");
        }
    }

    // Exibir todos os pacientes na fila
    public void exibirFila() {
        if (filaPacientes.isEmpty()) {
            System.out.println("A fila está vazia.");

        } else {

            System.out.println("Pacientes na fila:" + filaPacientes);

        }
    }

    // Buscar paciente pelo nome
    public Pacientes buscarPaciente(String nome) {
        for (Pacientes paciente : filaPacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Paciente encontrado: " + paciente.getNome());
                return paciente;
            }
        }

        System.out.println("Paciente não encontrado: " + nome);
        return null;
    }
    public void desfazerAtendimento() {
        if (!pilhaDesfazer.isEmpty()) {
            Pacientes desfazer = pilhaDesfazer.pop(); // Remove o último paciente da pilha
            filaPacientes.add(desfazer); // Adiciona o paciente de volta à fila
            System.out.println("Atendimento desfeito. Paciente retornado à fila: " + desfazer.getNome());
        } else {
            System.out.println("Nenhum atendimento para desfazer.");
        }
    }
}
    
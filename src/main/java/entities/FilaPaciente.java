package entities;

import java.util.PriorityQueue;

public class FilaPaciente {

    private PriorityQueue<Pacientes> filaPacientes;

    public FilaPaciente() {
        filaPacientes = new PriorityQueue<>();
    }

    // Adicionar paciente à fila
    public void adicionarPaciente(Pacientes paciente) {
        filaPacientes.add(paciente);
        System.out.println("Paciente adicionado à fila: " + paciente.getNome());
    }

    public void atenderPaciente() {
        if (!filaPacientes.isEmpty()) {
            Pacientes atendido = filaPacientes.poll();  
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
}

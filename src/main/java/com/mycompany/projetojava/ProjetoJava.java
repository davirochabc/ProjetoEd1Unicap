package com.mycompany.projetojava;

import entities.ClinicaMedica;
import entities.Consultas;
import entities.Eventos;
import entities.Events;
import entities.Medicos;
import entities.Mesas;
import entities.Pacientes;
import entities.ParticipanteEvento;
import entities.Pedidos;
import entities.Restaurante;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author j040v
 */
public class ProjetoJava {

    public static void main(String[] args) throws ParseException {

        ClinicaMedica clinica = new ClinicaMedica();
        Medicos medico = new Medicos();
        Pacientes paciente = new Pacientes();

        Eventos evento = new Eventos();
        Events event = new Events();
        ParticipanteEvento participante = new ParticipanteEvento();

        Restaurante restauran = new Restaurante();
        Pedidos pedido = new Pedidos();
        Mesas mesa = new Mesas();

        Scanner s = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n*** MENU PRINCIPAL ***");
            System.out.println("1. Gerenciar Clínica Médica");
            System.out.println("2. Gerenciar Eventos");
            System.out.println("3. Gerenciar Restaurante");
            System.out.println("0. Sair");

            System.out.println("Escolha uma opção");

            int op = s.nextInt();
            switch (op) {
                case 1:
                    clinicaMenu(clinica, medico, paciente);
                    break;

                case 2:
                    eventosMenu(evento, event, participante);
                    break;
                case 3:
                    restauranteMenu(restauran, pedido, mesa);
                    break;
                case 0:
                    running = false;
                    break;
            }
        }

    }

    public static void clinicaMenu(ClinicaMedica clinica, Medicos medico, Pacientes paciente) throws ParseException {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean clinicRunning = true;

        while (clinicRunning) {
            System.out.println("\n*** MENU DA CLÍNICA MÉDICA ***");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Médico");
            System.out.println("3. Buscar Paciente");
            System.out.println("4. Buscar Médicos");
            System.out.println("5. Agendar consulta");
            System.out.println("6. Editar histórico do paciente");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int op = s.nextInt();
            s.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Digite o nome do paciente: ");
                    String nomeP = s.nextLine();

                    System.out.println("Digite o histórico do paciente: ");
                    String historico = s.nextLine();

                    System.out.println("Digite a idade do paciente: ");
                    int idade = s.nextInt();

                    System.out.println("Informe a última consulta do paciente: ");
                    System.out.println("Formato dd/MM/yyyy");
                    Date ultimaConsulta = sdf.parse(s.next());

                    paciente = new Pacientes(nomeP, historico, idade, ultimaConsulta);
                    clinica.addPaciente(paciente);
                    break;
                case 2:
                    System.out.println("Digite o nome do médico: ");
                    String nomeM = s.nextLine();
                    System.out.println("Especialidade do médico: ");
                    String especialidade = s.nextLine();

                    System.out.println("Disponibilidade do médico: ");
                    System.out.println("(true) - disponivel || (false) - indisponivel");
                    boolean disponibilidade = s.nextBoolean();

                    medico = new Medicos(nomeM, especialidade, disponibilidade);
                    clinica.addMedico(medico);
                    break;
                case 3:
                    System.out.println("Digite o nome do paciente que deseja encontrar: ");
                    String nomePaciente = s.nextLine();
                    Pacientes pacienteEncontrado = clinica.buscaPaciente(nomePaciente);

                    if (pacienteEncontrado != null) {
                        System.out.println("Paciente Encontrado: ");
                        System.out.println(pacienteEncontrado);
                    } else {
                        System.out.println("Paciente não encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do medico que deseja encontrar: ");
                    String nomeMedico = s.nextLine();
                    Medicos medicoEncontrado = clinica.buscaMedico(nomeMedico);

                    if (medicoEncontrado != null) {
                        System.out.println("Medico Encontrado: ");
                        System.out.println(medicoEncontrado);
                    } else {
                        System.out.println("Medico não encontrado");
                    }
                    break;
                case 5:
                    System.out.println("Digite seu nome: ");
                    String nomePacienteConsulta = s.nextLine();

                    System.out.println("Digite o historico do paciente: ");
                    String historicoConsulta = s.nextLine();

                    System.out.println("Digite sua idade: ");
                    int idadeConsulta = s.nextInt();

                    System.out.println("Informe a data da consulta que deseja: ");
                    System.out.println("Formato dd/MM/yyyy");
                    Date dateConsulta = sdf.parse(s.next());
                    s.nextLine();
                    System.out.println("Digite o nome do médico");
                    String nomeMedicoConsulta = s.nextLine();

                    Medicos procuraMedico = clinica.buscaMedico(nomeMedicoConsulta);
                    if (procuraMedico != null) {
                        if (procuraMedico.isDisponibilidade() == true) {
                            System.out.println("Marcada");
                            medico.setDisponibilidae(false);
                        } else {
                            System.out.println("Medico indisponivel");
                        }
                    } else {
                        System.out.println("Medico inexistente");
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do paciente que deseja encontrar: ");
                    String alterarPaciente = s.nextLine();
                    Pacientes pacienteAlterado = clinica.buscaPaciente(alterarPaciente);
                    if (pacienteAlterado != null) {
                        System.out.println("Atualize o historico do paciente: " + pacienteAlterado.getNome());
                        String novoHistorico = s.nextLine();
                        paciente.setHistorico(novoHistorico);
                    }

                case 0:
                    clinicRunning = false;
                    break;
            }

        }
    }

    public static void eventosMenu(Eventos evento, Events event, ParticipanteEvento participante) throws ParseException {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean clinicaRunning = true;

        while (clinicaRunning) {
            System.out.println("\n*** MENU DO EVENTO ***");
            System.out.println("1. Inserir dados do evento");
            System.out.println("2. Adicionar Participante do evento");
            System.out.println("3. Cancelar inscrição do evento");
            System.out.println("4. Catálogo de Evento");
            System.out.println("5. Buscar por participante");
            System.out.println("6. Alterar dados do evento");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int op = s.nextInt();
            s.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Digite o nome do Evento: ");
                    String nomeEvento = s.nextLine();

                    System.out.println("Digite a data que ocorrerá o evento: ");
                    System.out.println("Formato dd/MM/yyyy");
                    Date dataEvento = sdf.parse(s.next());

                    s.nextLine();

                    System.out.println("Digite local do evento: ");
                    String localEvento = s.nextLine();

                    System.out.println(localEvento);

                    System.out.println("Digite a capacidade do evento: ");
                    int capacidadeEvento = s.nextInt();

                    event = new Events(nomeEvento, dataEvento, localEvento, capacidadeEvento);
                    evento.addEvent(event);
                    break;

                case 2:
                    System.out.println("Digite o nome do participante: ");
                    String nomeParticipante = s.nextLine();

                    System.out.println("Digite o numero da inscrição: ");
                    int inscricaoEvento = s.nextInt();
                    
                    
                    ParticipanteEvento encontrarInscricaop = evento.buscarInscrição(inscricaoEvento);
                    if (encontrarInscricaop != null){
                        System.out.println("Numero de inscrição já utilizado, Digite um válido: ");
                        inscricaoEvento = s.nextInt();
                    }
                    s.nextLine();
                    System.out.println("Digite o nome do evento que irá participar: ");
                    String eventoNome = s.nextLine();

                    Events encontrarEvento = evento.buscarEvento(eventoNome);
                    if (encontrarEvento != null) {
                        if (event.getCapacity() == 0) {
                            System.out.println("Evento Lotado.");
                        } else {
                            participante = new ParticipanteEvento(nomeParticipante, inscricaoEvento, eventoNome);
                            evento.addParticipantes(participante);
                            System.out.println("Inscrição Realizada");
                            encontrarEvento.setCapacity(encontrarEvento.getCapacity() - 1);
                        }
                    } else {
                        System.out.println("Evento não encontrado");
                    }
                    break;

                case 3:
                    System.out.println("Digite o codigo de inscrição para cancelamento da presença no evento: ");
                    int codigoInscrição = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite o nome do evento: ");
                    String cancelarPresenca = s.nextLine();

                    ParticipanteEvento encontrarInscricao = evento.buscarInscrição(codigoInscrição);
                    if (encontrarInscricao != null) {
                        System.out.println("Participante encontrado: ");
                        System.out.println(encontrarInscricao);

                        Events encontrarEventoCancelar = evento.buscarEvento(cancelarPresenca);
                        if (encontrarEventoCancelar != null) {
                            evento.removeParticipantes(encontrarInscricao);
                            encontrarEventoCancelar.setCapacity(encontrarEventoCancelar.getCapacity() + 1);
                            System.out.println("Inscrição removida");

                        } else {
                            System.out.println("Código inexistente");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Lista de todos os eventos listados: ");
                    evento.imprimirEventos();
                    break;

                case 5:
                    System.out.println("Digite o codigo de inscrição do participante: ");
                    int buscaInscricao = s.nextInt();
                    encontrarInscricao = evento.buscarInscrição(buscaInscricao);
                    if (encontrarInscricao != null) {
                        System.out.println("Participante encontrado: ");
                        System.out.println(encontrarInscricao);
                    } else {
                        System.out.println("Código inexistente");
                    }
                    break;

                case 6:
                    System.out.println("Digite o nome do evento que deseja alterar");
                    String eventoAlterar = s.nextLine();
                    encontrarEvento = evento.buscarEvento(eventoAlterar);
                    if (encontrarEvento != null) {

                        boolean change = true;
                        while (change) {
                            System.out.println("Deseja alterar qual dado: ");
                            System.out.println("\n*** OPÇÕES ***");
                            System.out.println("1. Alterar nome");
                            System.out.println("2. Alterar data");
                            System.out.println("3. Alterar Local");
                            System.out.println("0. Para retornar ao menu de eventos");

                            int opt = s.nextInt();
                            s.nextLine();
                            switch (opt) {
                                case 1:
                                    System.out.println("Digite o novo nome do evento");
                                    String novoNome = s.nextLine();
                                    encontrarEvento.setName(novoNome);
                                    break;

                                case 2:
                                    System.out.println("Digite a nova data do evento: ");
                                    Date newDate = sdf.parse(s.next());
                                    encontrarEvento.setDate(newDate);
                                    break;

                                case 3:
                                    System.out.println("Digite o novo local do evento: ");
                                    String novoLocal = s.nextLine();
                                    encontrarEvento.setLocal(novoLocal);
                                    break;
                                case 0:
                                    change = false;
                                    break;

                            }
                        }
                    }
                case 0:
                    clinicaRunning = false;
                    break;
            }

        }
    }

    public static void restauranteMenu(Restaurante restauran, Pedidos pedido, Mesas mesa) {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean restRunning = true;

        while (restRunning) {
            System.out.println("\n*** MENU DO RESTAURANTE ***");
            System.out.println("1. Reservar mesa");
            System.out.println("2. Fazer pedido");
            System.out.println("3. Adicionar pedido");
            System.out.println("4. Fechar conta");
            System.out.println("5. Buscar mesa");
            System.out.println("6. Buscar pedido");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int restOp = s.nextInt();

            s.nextLine();

            switch (restOp) {
                case 1:
                    System.out.println("Digite o numero da mesa desejada: ");
                    int numeroMesa = s.nextInt();

                    s.nextLine();

                    System.out.println("Digite o nome do cliente da mesa");
                    String clienteNome = s.nextLine();

                    boolean status = false;

                    mesa = new Mesas(numeroMesa, clienteNome, status);
                    restauran.addMesas(mesa);

                    System.out.println("Mesa reservada com sucesso");
                    break;
                case 2:
                    System.out.println("Digite o numero da mesa que fará o pedido.");
                    int numeroMesaPedido = s.nextInt();
                    s.nextLine();
                    Mesas buscarNumeroMesa = restauran.buscarMesa(numeroMesaPedido);
                    if (buscarNumeroMesa != null) {
                        System.out.println("Digite o pedido: ");
                        String order = s.nextLine();

                        System.out.println("Valor do pedido");
                        double preco = s.nextDouble();

                        System.out.println("Quantidade do pedido");
                        int quantidade = s.nextInt();

                        pedido = new Pedidos(order, quantidade, preco);
                        mesa.addPedidos(pedido);
                        break;
                    } else {
                        System.out.println("Mesa vazia");
                        break;
                    }
                case 3:
                    System.out.println("Digite o numero da mesa que fará um novo pedido.");
                    int numeroMesaNovoPedido = s.nextInt();
                    s.nextLine();
                    buscarNumeroMesa = restauran.buscarMesa(numeroMesaNovoPedido);
                    if (buscarNumeroMesa != null) {
                        System.out.println("Digite o pedido: ");
                        String order = s.nextLine();

                        System.out.println("Valor do pedido");
                        double preco = s.nextDouble();

                        System.out.println("Quantidade do pedido");
                        int quantidade = s.nextInt();

                        pedido = new Pedidos(order, quantidade, preco);
                        mesa.addPedidos(pedido);
                        break;
                    } else {
                        System.out.println("Mesa não encontrada");
                    }
                case 4:
                    System.out.println("Digite o numero da mesa: ");
                    int numeroMesaConta = s.nextInt();
                    s.nextLine();
                    buscarNumeroMesa = restauran.buscarMesa(numeroMesaConta);
                    if (buscarNumeroMesa != null) {
                        System.out.println(mesa);
                        System.out.println("Conta paga. Mesa desocupada");
                        buscarNumeroMesa.setClient(null);
                        buscarNumeroMesa.setStatus(true);
                        buscarNumeroMesa.limparPedido();
                        break;
                    } else {
                        System.out.println("Código da mesa inválido");
                    }
                case 5:
                    System.out.println("Digite o numero da mesa: ");
                    int numeroMesaBusca = s.nextInt();
                    s.nextLine();
                    buscarNumeroMesa = restauran.buscarMesa(numeroMesaBusca);
                    if (buscarNumeroMesa != null) {
                        System.out.println(mesa);
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do seu pedido: ");
                    String nomePedidoBusca = s.nextLine();
                    
                    Pedidos pedidoEncontrado = mesa.buscaPedidos(nomePedidoBusca);
                    if(pedidoEncontrado != null){
                        System.out.println(pedidoEncontrado);
                    }
                    break;
                case 0:
                    restRunning = false;
                    break;
            }
        }
    }
}

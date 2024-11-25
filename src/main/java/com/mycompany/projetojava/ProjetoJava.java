package com.mycompany.projetojava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.ClinicaMedica;
import entities.Eventos;
import entities.Events;
import entities.FilaPaciente;
import entities.PilhaMesa;
import entities.ListaEncadeadaEventos;
import entities.ListaEncadeadaMesa;
import entities.ListaEncadeadaPacientes;
import entities.ListaEncadeadaParticipantes;
import entities.ListaEncadeadaPedidos;
import entities.Medicos;
import entities.Mesas;
import entities.Pacientes;
import entities.ParticipanteEvento;
import entities.Pedidos;
import entities.Restaurante;

/**
 *
 * @author j040v
 */
public class ProjetoJava {

    public static void main(String[] args) throws ParseException {

        ListaEncadeadaPacientes listaPacientes = new ListaEncadeadaPacientes();
        ListaEncadeadaEventos listaEventos = new ListaEncadeadaEventos();
        ListaEncadeadaParticipantes listaParticipantes = new ListaEncadeadaParticipantes();
        ListaEncadeadaMesa listaMesas = new ListaEncadeadaMesa();
        ListaEncadeadaPedidos listaPedidos = new ListaEncadeadaPedidos();

        FilaPaciente filaPaciente = new FilaPaciente();
        PilhaMesa pilhaMesa = new PilhaMesa();

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
                    clinicaMenu(clinica, medico, paciente, listaPacientes, filaPaciente);
                    break;

                case 2:
                    eventosMenu(evento, event, participante, listaEventos, listaParticipantes);
                    break;
                case 3:
                    restauranteMenu(restauran, pedido, mesa, listaMesas, listaPedidos, pilhaMesa, clinica);
                    break;
                case 0:
                    running = false;
                    break;
            }
        }

    }

    public static void clinicaMenu(ClinicaMedica clinica, Medicos medico, Pacientes paciente, ListaEncadeadaPacientes listaPacientes, FilaPaciente filaPaciente) throws ParseException {
        clinica.addMedico(new Medicos("Joao", "Pediatra", true, 5234));
        clinica.addMedico(new Medicos("Maria", "Cirurgiã Geral", true, 4215));
        clinica.addMedico(new Medicos("Carlos", "Cardiologista", true, 5521));
        clinica.addMedico(new Medicos("Jose", "Psiquiatra", true, 4233));
        clinica.addMedico(new Medicos("Katia", "Neurologista", false, 5523));
        clinica.addMedico(new Medicos("Mauricio", "Ginecologista", true, 1224));

        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean clinicRunning = true;

        while (clinicRunning) {
            System.out.println("\n*** MENU DA CLÍNICA MÉDICA ***");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Catálogo dos pacientes");
            System.out.println("3. Catálogo dos médicos");
            System.out.println("4. Atender Paciente");
            System.out.println("5. Buscar Médicos");
            System.out.println("6. Agendar consulta");
            System.out.println("7. Editar histórico do paciente");
            System.out.println("8. Médicos mais requisitados");
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

                    System.out.println("Digite o grau de risco do paciente :");
                    int grau = s.nextInt();

                    System.out.println("Informe a última consulta do paciente: ");
                    System.out.println("Formato dd/MM/yyyy");
                    Date ultimaConsulta = sdf.parse(s.next());

                    paciente = new Pacientes(nomeP, historico, idade, ultimaConsulta, grau);
                    clinica.addPaciente(paciente);

                    filaPaciente.adicionarPaciente(paciente);
                    break;

                case 2:

                    filaPaciente.exibirFila();

                    break;

                case 3:

                    clinica.imprimirCatalogo();

                    break;

                case 4:
                    filaPaciente.atenderPaciente();

                    break;

                case 5:
                    System.out.println("Selecione  medico que deseja encontrar: ");
                    String nomeMedico = s.nextLine();
                    Medicos medicoEncontrado = clinica.buscaMedico(nomeMedico);

                    if (medicoEncontrado != null) {
                        System.out.println("Medico Encontrado: ");
                        System.out.println(medicoEncontrado);
                    } else {
                        System.out.println("Medico não encontrado");
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do paciente que deseja marcar uma consulta:");
                    String pacienteP = s.nextLine();
                    Pacientes pacienteFind = filaPaciente.buscarPaciente(pacienteP);
                    while (pacienteFind == null) {
                        System.out.print("Digite o nome do paciente que deseja marcar uma consulta: ");
                        pacienteP = s.nextLine();
                        pacienteFind = filaPaciente.buscarPaciente(pacienteP);
                    }

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
                            procuraMedico.incrementarConsultas();

                        } else {
                            System.out.println("Medico indisponivel");
                        }
                    } else {
                        System.out.println("Medico inexistente");
                    }
                    break;
                case 7:
                    System.out.println("Digite o nome do paciente que deseja encontrar: ");
                    String alterarPaciente = s.nextLine();
                    Pacientes pacienteAlterado = filaPaciente.buscarPaciente(alterarPaciente);
                    if (pacienteAlterado != null) {
                        System.out.println("Atualize o historico do paciente: " + pacienteAlterado.getNome());
                        String novoHistorico = s.nextLine();
                        paciente.setHistorico(novoHistorico);
                        break;
                    }
                case 8:
                    Medicos medicoMaisRequisitado = clinica.medicoMaisConsultas();
                    if (medicoMaisRequisitado != null) {
                        System.out.println("Médico mais requisitado:");
                        System.out.println(medicoMaisRequisitado);
                    } else {
                        System.out.println("Nenhum médico registrado.");
                    }
                    break;
                case 0:
                    clinicRunning = false;
                    break;
            }

        }
    }

    public static void eventosMenu(Eventos evento, Events event, ParticipanteEvento participante, ListaEncadeadaEventos listaEventos, ListaEncadeadaParticipantes listaParticipantes) throws ParseException {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int capacidadeEvento = 0;
        boolean clinicaRunning = true;

        while (clinicaRunning) {
            System.out.println("\n*** MENU DO EVENTO ***");
            System.out.println("1. Inserir dados do evento");
            System.out.println("2. Adicionar Participante do evento");
            System.out.println("3. Cancelar inscrição do evento");
            System.out.println("4. Catálogo de Evento");
            System.out.println("5. Buscar por participante");
            System.out.println("6. Listas de todos os participantes de todos os eventos");
            System.out.println("7. Alterar dados do evento");
            System.out.println("8. Evento mais flopado");
            System.out.println("9. Mais inscrições");
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
                    capacidadeEvento = s.nextInt();

                    event = new Events(nomeEvento, dataEvento, localEvento, capacidadeEvento);
                    evento.addEvent(event);

                    listaEventos.inserirEvento(event);

                    break;

                case 2:
                    System.out.println("Digite o nome do participante: ");
                    String nomeParticipante = s.nextLine();

                    System.out.println("Digite o numero da inscrição: ");
                    int inscricaoEvento = s.nextInt();

                    ParticipanteEvento encontrarInscricaop = evento.buscarInscrição(inscricaoEvento);
                    if (encontrarInscricaop != null) {
                        System.out.println("Numero de inscrição já utilizado, Digite um válido: ");
                        inscricaoEvento = s.nextInt();
                    }
                    s.nextLine();
                    System.out.println("Digite o nome do evento que irá participar: ");
                    String eventoNome = s.nextLine();

                    Events encontrarEvento = evento.buscarEvento(eventoNome);
                    if (encontrarEvento != null) {
                        if (encontrarEvento.getCapacity() == 0) {
                            System.out.println("Evento Lotado.");
                        } else {
                            participante = new ParticipanteEvento(nomeParticipante, inscricaoEvento, eventoNome);
                            evento.addParticipantes(participante);

                            listaParticipantes.inserirParticipante(participante);

                            System.out.println("Inscrição Realizada");
                            participante.incrementar();
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
                            listaParticipantes.removerParticipante(encontrarInscricao.getName());

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
                    listaParticipantes.exibirParticipantes();

                case 7:
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

                case 8:
                    Events diferencaCapacidade = evento.eventoFlopado(capacidadeEvento);
                    System.out.println(diferencaCapacidade);
                    break;
                case 9:
                    ParticipanteEvento maisInscricoes = evento.encontrarMaisInscricoes();
                    System.out.println(maisInscricoes);
                case 0:
                    clinicaRunning = false;
                    break;
            }

        }
    }

    public static void restauranteMenu(Restaurante restauran, Pedidos pedido, Mesas mesa, ListaEncadeadaMesa listaMesas, ListaEncadeadaPedidos listaPedidos, PilhaMesa pilhaMesa, ClinicaMedica clinica) {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean isMedico = false;
        boolean restRunning = true;

        while (restRunning) {
            System.out.println("\n*** MENU DO RESTAURANTE ***");
            System.out.println("1. Reservar mesa");
            System.out.println("2. Fazer pedido");
            System.out.println("3. Remover último pedido");
            System.out.println("4. Desfazer última alteração");
            System.out.println("5. Fechar conta");
            System.out.println("6. Fechar conta para Médico");
            System.out.println("7. Buscar mesa");
            System.out.println("8. Mesa mais lucrativa");
            System.out.println("9. Exibir todos os pedidos feitos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int restOp = s.nextInt();

            s.nextLine();

            switch (restOp) {
                case 1:
                    System.out.println("Digite o numero da mesa desejada: ");
                    int numeroMesa = s.nextInt();

                    s.nextLine();
                    Mesas mesaExistentes = restauran.buscarMesa(numeroMesa);
                    if (mesaExistentes != null) {
                        System.out.println("A mesa #" + numeroMesa + " já está reservada por " + mesaExistentes.getClient());
                        break;
                    }

                    System.out.println("Digite o nome do cliente da mesa");
                    String clienteNome = s.nextLine();

                    boolean status = false;

                    Mesas novaMesa = new Mesas(numeroMesa, clienteNome, status);
                    restauran.addMesas(novaMesa);

                    listaMesas.inserirMesa(novaMesa);

                    System.out.println("Mesa reservada com sucesso");
                    break;
                case 2:
                    System.out.println("Digite o numero da mesa que fará o pedido.");
                    int numeroMesaPedido = s.nextInt();
                    s.nextLine();
                    Mesas buscarNumeroMesa = restauran.buscarMesa(numeroMesaPedido);
                    if (buscarNumeroMesa != null) {
                        System.out.println("Selecione um pedido do cardápio:");
                        System.out.println("1. Pizza - R$30.00");
                        System.out.println("2. Hambúrguer - R$20.00");
                        System.out.println("3. Salada - R$15.00");
                        System.out.println("4. Refrigerante - R$5.00");
                        System.out.println("0. Sair");
                        int opcaoPedido = s.nextInt();
                        int quantidade = 0;
                        double precoPedido = 0;
                        String nomePedido = "";

                        switch (opcaoPedido) {

                            case 1:
                                nomePedido = "Pizza";
                                precoPedido = 30.00;
                                System.out.println("Digite a quantidade do pedido");
                                int quantidadePedido = s.nextInt();
                                pedido = new Pedidos(nomePedido, quantidadePedido, precoPedido);
                                buscarNumeroMesa.addPedidos(pedido);

                                pilhaMesa.addPedido(pedido);

                                break;
                            case 2:
                                nomePedido = "Hamburguer";
                                precoPedido = 20.00;
                                System.out.println("Digite a quantidade do pedido");
                                quantidadePedido = s.nextInt();
                                pedido = new Pedidos(nomePedido, quantidadePedido, precoPedido);
                                buscarNumeroMesa.addPedidos(pedido);

                                pilhaMesa.addPedido(pedido);

                                break;
                            case 3:
                                nomePedido = "Salada";
                                precoPedido = 15.00;
                                System.out.println("Digite a quantidade do pedido");
                                quantidadePedido = s.nextInt();
                                pedido = new Pedidos(nomePedido, quantidadePedido, precoPedido);
                                buscarNumeroMesa.addPedidos(pedido);

                                pilhaMesa.addPedido(pedido);

                                break;
                            case 4:
                                nomePedido = "Refrigerante";
                                precoPedido = 5.00;
                                System.out.println("Digite a quantidade do pedido");
                                quantidadePedido = s.nextInt();
                                pedido = new Pedidos(nomePedido, quantidadePedido, precoPedido);
                                buscarNumeroMesa.addPedidos(pedido);

                                pilhaMesa.addPedido(pedido);

                                break;
                            case 0:
                                System.out.println("Saindo do cardapio");
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;

                        }
                        System.out.println(pedido);
                    } else {
                        System.out.println("Mesa vazia");
                        break;
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da mesa para remover o último pedido:");
                    int mesaNumeroRemover = s.nextInt();
                    s.nextLine();
                    Mesas mesaRemovePedido = restauran.buscarMesa(mesaNumeroRemover);
                    if (mesaRemovePedido != null) {
                          Pedidos ultimoPedido = pilhaMesa.removerUltimoPedido();
                        if (ultimoPedido != null) {
                            mesaRemovePedido.removePedidos(ultimoPedido);  
                        }
                    } else {
                        System.out.println("Mesa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Desfazendo a última alteração:");
                    pilhaMesa.desfazerAlt();
                    break;

                case 5:
                    System.out.println("Digite o numero da mesa: ");
                    int numeroMesaConta = s.nextInt();
                    s.nextLine();
                    buscarNumeroMesa = restauran.buscarMesa(numeroMesaConta);
                    if (buscarNumeroMesa != null) {
                        System.out.println(buscarNumeroMesa);
                        System.out.println("Efetuando pagamento");
                        System.out.println("Conta paga: Mesa desocupada");
                        buscarNumeroMesa.limparPedido();
                        restauran.limparMesas();
                        listaMesas.removerMesa(numeroMesaConta);
                        break;

                    } else {
                        System.out.println("Código da mesa inválido");
                    }
                case 6:
                    System.out.println("Digite o CRM do médico: ");
                    int CRM = s.nextInt();
                    s.nextLine();
                    Medicos procurarCRM = clinica.buscarCRM(CRM);
                    if (procurarCRM != null) {
                        isMedico = true;
                        System.out.println("Digite o número da mesa: ");
                        int numeroMesaMedico = s.nextInt();
                        s.nextLine();
                        buscarNumeroMesa = restauran.buscarMesa(numeroMesaMedico);
                        if (buscarNumeroMesa != null) {
                            pedido.setIsMedico(isMedico);
                            double valorTotal = buscarNumeroMesa.getTotalPedido();
                            if (isMedico) {
                                double valorDesconto = valorTotal * 0.90;
                                System.out.println("Valor original: R$" + valorTotal);
                                System.out.println("Valor com desconto de 10%: R$" + valorDesconto);
                            } else {
                                System.out.println("Valor Total: R$" + valorTotal);
                            }

                            System.out.println("Efetuando pagamento");
                            System.out.println("Conta paga: Mesa desocupada");
                            buscarNumeroMesa.limparPedido();
                            restauran.limparMesas();
                            listaMesas.removerMesa(numeroMesaMedico);
                            break;
                        } else {
                            System.out.println("Mesa não encontrada!");
                        }
                    } else {
                        System.out.println("CRM inválido! Não foi possível aplicar desconto.");
                    }

                case 7:
                    System.out.println("Digite o numero da mesa: ");
                    int numeroMesaBusca = s.nextInt();
                    s.nextLine();
                    Mesas buscarNumeroMesap = restauran.buscarMesa(numeroMesaBusca);
                    if (buscarNumeroMesap != null) {
                        System.out.println(buscarNumeroMesap);
                    } else {
                        System.out.println("Mesa desocupada");
                    }
                    break;
                case 8:
                    Mesas mesaQueFezMaisDin = restauran.maisDinheiroMesa();
                    if (mesaQueFezMaisDin != null) {
                        System.out.println("Mesa que fez mais dinheiro: #" + mesaQueFezMaisDin.getNumber());
                        System.out.println("Cliente: " + mesaQueFezMaisDin.getClient());
                        System.out.println("Total: R$" + mesaQueFezMaisDin.getTotalPedido());
                    } else {
                        System.out.println("Nenhuma mesa encontrada");
                    }
                case 0:
                    restRunning = false;
                    break;

                case 9:
                    pilhaMesa.exibirPedido();
            }
        }
    }
}

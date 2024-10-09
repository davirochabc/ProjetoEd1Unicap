

package com.mycompany.projetojava;

import entities.ClinicaMedica;
import entities.Medicos;
import entities.Pacientes;
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
    Scanner s = new Scanner (System.in);
    
    boolean running = true;
    
    while(running){
        System.out.println("\n*** MENU PRINCIPAL ***");
        System.out.println("1. Gerenciar Clínica Médica");
        System.out.println("2. Gerenciar Eventos");
        System.out.println("3. Gerenciar Restaurante");
        System.out.println("0. Sair");
        
        System.out.println("Escolha uma opção");
        
        int op = s.nextInt();
        switch(op){
            case 1: 
                clinicaMenu(clinica);
        }
    }
    
    }
    public static void clinicaMenu(ClinicaMedica clinica) throws ParseException {
        Scanner s = new Scanner (System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean clinicRunning = true;
        
        while(clinicRunning){
            System.out.println("\n*** MENU DA CLÍNICA MÉDICA ***");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Médico");
            System.out.println("3. Buscar Paciente");
            System.out.println("4. Exibir Médicos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");  
            
            
            int op = s.nextInt();
            s.nextLine();            
            switch(op){
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
                    
                    Pacientes paciente = new Pacientes(nomeP, historico, idade, ultimaConsulta);                   
                    clinica.addPaciente(paciente);                                      
                    clinicRunning = false;
                    break;
                case 2:
                    System.out.println("Digite o nome do médico: ");
                    String nomeM = s.nextLine();
                    s.nextLine();
                    System.out.println("Especialidade do médico: ");
                    String especialidade = s.nextLine();
                    
                    System.out.println("Disponibilidade do médico: ");
                    System.out.println("(true) - disponivel || (false) - indisponivel");
                    boolean disponibilidade = s.nextBoolean();
                    
                    Medicos medico = new Medicos(nomeM, especialidade, disponibilidade);
                    clinicRunning = false;
                    break;
                case 3:
                    System.out.println("Digite o nome do paciente que deseja encontrar: ");
                    String nomeBusca = s.nextLine();
                    Pacientes pacienteEncontrado = clinica.buscaPaciente(nomeBusca);                  
                    
                    if(pacienteEncontrado != null){
                        System.out.println("Paciente Encontrado: ");
                        System.out.println(pacienteEncontrado);
                    }else{
                        System.out.println("Paciente não encontrado");
                    }
                    clinicRunning = false;
                    break;
            }
        
        }
    }
   
}

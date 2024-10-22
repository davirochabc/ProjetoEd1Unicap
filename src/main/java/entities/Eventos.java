/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j040v
 */
public class Eventos {

    private List<ParticipanteEvento> participantes = new ArrayList<ParticipanteEvento>();
    private List<Events> event = new ArrayList<Events>();

    public Eventos() {
    }

    public void addParticipantes(ParticipanteEvento participante) {
        participantes.add(participante);
    }

    public void removeParticipantes(ParticipanteEvento participante) {
        participantes.remove(participante);
    }

    public void addEvent(Events evento) {
        event.add(evento);
    }

    public void removeEvent(Events evento) {
        event.remove(evento);
    }
    
    public Events eventoFlopado(int capacidade){
        Events eventoMenosVendas = event.get(0);
        for(Events e : event){
            if(e.getCapacity() > eventoMenosVendas.getCapacity()){
                eventoMenosVendas = e;
            }
        }
        return eventoMenosVendas;
              
    }

    public Events buscarEvento(String nome) {
        for (Events e : event) {
            String eventoName = e.getName().trim();
            if (eventoName.length() == nome.length()) {
                boolean igual = true;
                for (int i = 0; i < eventoName.length(); i++) {
                    if (Character.toLowerCase(eventoName.charAt(i)) != Character.toLowerCase(nome.charAt(i))) {
                        igual = false;
                        break;
                    }
                }
                if (igual) {
                    return e;
                }

            }
        }
        return null;
    }

    public ParticipanteEvento buscarInscrição(int inscricao) {
        for (ParticipanteEvento p : participantes) {
            int codigo = p.getRegistration();
            if (codigo == inscricao) {
                return p;
            }
        }
        return null;
    }

    public void imprimirEventos() {
        if (event.isEmpty()) {
            System.out.println("Nenhum evento registrado.");
        } else {
            for (Events e : event) {
                System.out.println("----------------------");
                System.out.println(e);  // Chama o toString() de Events
                System.out.println("----------------------");
            }
        }
    }

}

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
    private List<Event> events = new ArrayList<Event>();

    public Eventos() {
    }
    
    public void addParticipantes(ParticipanteEvento participante){
        participantes.add(participante);
    }
    public void removeParticipantes(ParticipanteEvento participante){
        participantes.remove(participante);
    }
    
    public void addEvent(Event evento){
        events.add(evento);
    }
    public void removeEvent(Event evento){
        events.remove(evento);
    }
}

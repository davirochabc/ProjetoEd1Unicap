/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class ParticipanteEvento {
    private String name;
    private Integer registration;
    private String registeredEvent;

    public ParticipanteEvento() {
    }

    public ParticipanteEvento(String name, Integer registration, String registeredEvent) {
        this.name = name;
        this.registration = registration;
        this.registeredEvent = registeredEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public String getRegisteredEvent() {
        return registeredEvent;
    }

    public void setRegisteredEvent(String registeredEvent) {
        this.registeredEvent = registeredEvent;
    }
    
    
}

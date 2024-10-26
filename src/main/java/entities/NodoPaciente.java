/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class NodoPaciente {
    Pacientes data;
    NodoPaciente next;

    public NodoPaciente(Pacientes data) {
        this.data = data;
        this.next = null;
    } 
}

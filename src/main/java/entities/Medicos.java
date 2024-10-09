/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class Medicos {
    private String nome;
    private String especialidade;
    private boolean disponibilidae;

    public Medicos() {
    }

    public Medicos(String nome, String especialidade, boolean disponibilidae) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponibilidae = disponibilidae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidae;
    }

    public void setDisponibilidae(boolean disponibilidae) {
        this.disponibilidae = disponibilidae;
    }
    
    
}
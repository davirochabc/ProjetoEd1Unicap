/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;

/**
 *
 * @author j040v
 */
public class Consultas {

    private String nome;
    private String historico;
    private Integer idade;
    private Date consulta;
    private String nomeMedico;

    public Consultas() {
    }

    public Consultas(String nome, String historico, Integer idade, Date consulta, String nomeMedico) {
        this.nome = nome;
        this.historico = historico;
        this.idade = idade;
        this.consulta = consulta;
        this.nomeMedico = nomeMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getConsulta() {
        return consulta;
    }

    public void setConsulta(Date consulta) {
        this.consulta = consulta;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

}

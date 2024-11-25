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
    private Boolean disponibilidae;
    private Integer consultasMarcadas;
    private int CRM;

    public Medicos() {
    }

    public Medicos(String nome, String especialidade, boolean disponibilidae, int CRM) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponibilidae = disponibilidae;
        this.CRM = CRM;
        this.consultasMarcadas = 0;
    }

    public String getNome() {
        return nome;
    }
    
    public void incrementarConsultas(){
        consultasMarcadas++;
    }
    public int getConsultasMarcadas(){
        return consultasMarcadas;
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

    public int getCRM() {
        return CRM;
    }  

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do medico: " + nome+"\n");       
        sb.append("Especialidade: " + especialidade+"\n");  
        sb.append("CRM: " + CRM+"\n");
        if (disponibilidae == true) {
            sb.append("Médico Disponivel\n");
            sb.append("Consultas marcadas: " + consultasMarcadas);
        } else {
            sb.append("Médico indisponivel\n");
            
            
        }
        return sb.toString();

    }

}


package entities;
import entities.Medicos;
import entities.Pacientes;
import java.util.ArrayList;
import java.util.List;

public class ClinicaMedica {
    
    private List<Medicos> medico = new ArrayList<Medicos>();
    private List<Pacientes> paciente = new ArrayList<Pacientes>();

    public ClinicaMedica() {
    }
    
    public void addMedico(Medicos medicos){
        medico.add(medicos);
    }
    public void removeMedico(Medicos medicos){
        medico.remove(medicos);
    }
    
    public void addPaciente(Pacientes pacientes){
        paciente.add(pacientes);
    }
    public void removePaciente(Pacientes pacientes){
        paciente.remove(pacientes);
    }
    
    public Pacientes buscaPaciente(String nome){
        for(Pacientes p : paciente){               
            String nomePaciente = p.getNome().trim();           
            if(nomePaciente.length() == nome.length()){
                boolean igual = true;
                for(int i=0; i < nomePaciente.length();i++){
                    if(Character.toLowerCase(nomePaciente.charAt(i)) != Character.toLowerCase(nome.charAt(i))){
                        igual = false;
                        break;
                    }
                }
                if(igual){
                    return p;
                }
            }
        }return null;   
    }
    
    
}

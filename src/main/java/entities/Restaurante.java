
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j040v
 */
public class Restaurante {
    
    private List<Mesas> mesa = new ArrayList<Mesas>();

    public Restaurante() {
    }
    
    public void addMesas(Mesas mesas){
        mesa.add(mesas);
    }
    public void removeMesas(Mesas mesas){
        mesa.add(mesas);
    }
    
    public Mesas buscarMesa (int codigo){
        for(Mesas m : mesa){          
            int codigoMesa = m.getNumber();
            if(codigoMesa == codigo){         
                return m;
            }
        }return null;
    }
    public void imprimirPedidos() {
    if (mesa.isEmpty()) {
        System.out.println("Nenhum evento registrado.");
    } else {
        for (Mesas m : mesa) {
            System.out.println("----------------------");
            System.out.println(m);  // Chama o toString() de Events
            System.out.println("----------------------");
        }
    }
}
}


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
}

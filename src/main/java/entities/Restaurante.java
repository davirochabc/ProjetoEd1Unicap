
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j040v
 */
public class Restaurante {
    
    private List<Mesas> mesa = new ArrayList<Mesas>();
    private List<Pedidos> pedido = new ArrayList<Pedidos>();

    public Restaurante() {
    }
    
    public void addMesas(Mesas mesas){
        mesa.add(mesas);
    }
    public void removeMesas(Mesas mesas){
        mesa.add(mesas);
    }
    
    public void addPedidos(Pedidos pedidos){
        pedido.add(pedidos);
    }
    public void removePedidos(Pedidos pedidos){
        pedido.remove(pedidos);
    }
}

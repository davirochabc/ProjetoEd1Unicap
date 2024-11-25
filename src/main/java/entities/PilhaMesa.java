
package entities;

import java.util.Stack;

public class PilhaMesa {
    private Stack<Pedidos> pilhaPedidos; // Gerenciamento de pedidos como uma pilha
    private Stack<Stack<Pedidos>> historico; // Pilha de histórico para desfazer ações
    
    private String tipo; // "adicionar" ou "processar"
    private Pedidos pedido; // Pedido afetado pela operação
    
    public PilhaMesa() {
        this.pilhaPedidos = new Stack<>();
        this.historico = new Stack<>();
    } 
    
    public PilhaMesa(String tipo, Pedidos pedido) {
        this.tipo = tipo;
        this.pedido = pedido;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public Pedidos getPedido() {
        return pedido;
    }
    
     public Pedidos removerUltimoPedido() {
        if (!pilhaPedidos.isEmpty()) {
            return pilhaPedidos.pop();
        } else {
            System.out.println("Nenhum pedido para remover.");
            return null;
        }
    }
     
     public void desfazerAlt() {
        if (!historico.isEmpty()) {
            pilhaPedidos = historico.pop(); 
            System.out.println("Última ação desfeita com sucesso.");
        } else {
            System.out.println("Nenhuma ação para desfazer.");
        }
    }
     
   @Override
    public String toString() {
        return "Operação [Tipo: " + tipo + ", Pedido: " + pedido.getOrderName() + "]";
    }
}
    
    

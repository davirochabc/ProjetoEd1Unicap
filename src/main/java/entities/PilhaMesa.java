
package entities;

import java.util.Stack;

public class PilhaMesa {
    private Stack<Pedidos> pilhaPedidos; // Gerenciamento de pedidos como uma pilha
    private Stack<Stack<Pedidos>> historico; // Pilha de histórico para desfazer ações
    
    private Integer number; // Número da mesa
    private String client; // Nome do cliente
    private Boolean status; // Status da mesa (reservada ou livre)

    public PilhaMesa() {
        this.pilhaPedidos = new Stack<>();
        this.historico = new Stack<>();
    } 
    
    public PilhaMesa(Integer number, String client, boolean status) {
        this.number = number;
        this.client = client;
        this.status = status;
        this.pilhaPedidos = new Stack<>();
        this.historico = new Stack<>();
    }
    
    private void backup() {
        historico.push((Stack<Pedidos>) pilhaPedidos.clone());
    }
    
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }        
    
     public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
     public void addPedido(Pedidos pedido) {
        backup();
        pilhaPedidos.push(pedido);
        System.out.println("Pedido adicionado: " + pedido.getOrderName());
    }
    
     public Pedidos removerUltimoPedido() {
        if (!pilhaPedidos.isEmpty()) {
            backup();
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
     
    public void exibirPedido() {
        if (pilhaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado na mesa " + number);
        } else {
            System.out.println("Pedidos na mesa " + number + ":");
            for (int i = pilhaPedidos.size() - 1; i >= 0; i--) {
                System.out.println(pilhaPedidos.get(i));
            }
        }
    } 
   
}
    
    

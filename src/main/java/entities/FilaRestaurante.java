/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.PriorityQueue;
import java.util.Stack;


public class FilaRestaurante {
    private PriorityQueue<Pedidos> filaPrioridade;
    private Stack<PilhaMesa> desfazerPedido;
    public FilaRestaurante() {
        this.filaPrioridade = new PriorityQueue<>();
        this.desfazerPedido = new Stack<>();
    }
    public void adicionarPedido(Pedidos pedido) {
        filaPrioridade.add(pedido);
        desfazerPedido.push(new PilhaMesa("adicionar", pedido));
        System.out.println("Pedido adicionado: " + pedido.getOrderName());
    }

    // Processa o próximo pedido na fila
    public Pedidos processarPedido() {
        if (filaPrioridade.isEmpty()) {
            System.out.println("Nenhum pedido na fila para processar.");
            return null;
        }
        Pedidos pedidoProcessado = filaPrioridade.poll();
        System.out.println("Processando pedido: " + pedidoProcessado.getOrderName());
        return pedidoProcessado;
    }

    // Lista todos os pedidos na fila
    public void listarPedidos() {
        if (filaPrioridade.isEmpty()) {
            System.out.println("Nenhum pedido na fila.");
            return;
        }
        System.out.println("Pedidos na fila:");
        for (Pedidos pedido : filaPrioridade) {
            System.out.println(pedido);
        }
    }
    
    public void desfazerUltimaOperacao() {
        if (desfazerPedido.isEmpty()) {
            System.out.println("Nenhuma operação para desfazer.");
            return;
        }

        PilhaMesa ultimaOperacao = desfazerPedido.pop();
        System.out.println("Desfazendo operação: " + ultimaOperacao);

        switch (ultimaOperacao.getTipo()) {
            case "adicionar":
                // Remover o pedido adicionado
                filaPrioridade.remove(ultimaOperacao.getPedido());
                System.out.println("Pedido removido: " + ultimaOperacao.getPedido().getOrderName());
                break;

            case "processar":
                // Re-adicionar o pedido processado
                filaPrioridade.add(ultimaOperacao.getPedido());
                System.out.println("Pedido re-adicionado: " + ultimaOperacao.getPedido().getOrderName());
                break;

            default:
                System.out.println("Tipo de operação desconhecido.");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j040v
 */
public class Mesas {

    private List<Pedidos> pedido = new ArrayList<Pedidos>();

    private Integer number;
    private String client;
    private Boolean status;

    public Mesas() {
    }

    public Mesas(Integer number, String client, boolean status) {
        this.number = number;
        this.client = client;
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public void addPedidos(Pedidos pedidos) {
        pedido.add(pedidos);
             
    }
    public double getTotalPedido(){
       double total = 0.0; 
       for(Pedidos p : pedido){
           total += p.getTotal();
       }
       return total;
    }
    public void removePedidos(Pedidos pedidos) {
        pedido.remove(pedidos);
    }

    public void limparPedido() {
        this.pedido.clear();
    }
    

    public Pedidos buscaPedidos(String nome) {
        for (Pedidos p : pedido) {
            String nomePedido = p.getOrderName().trim();
            if (nomePedido.length() == nome.length()) {
                boolean igual = true;
                for (int i = 0; i < nomePedido.length(); i++) {
                    if (Character.toLowerCase(nomePedido.charAt(i)) != Character.toLowerCase(nome.charAt(i))) {
                        igual = false;
                        break;
                    }
                }
                if (igual) {
                    return p;
                }
            }
        }
        return null;
    }
    

    @Override
    public String toString() {
        double soma = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Mesa de numero #" + number + "\n");
        sb.append("Do cliente: " + client + "\n");
        if (pedido.isEmpty()) {
            System.out.println("------------------------");
            System.out.println("    Nenhum pedido");
            System.out.println("------------------------");
        } else {
            for (Pedidos p : pedido) {
                System.out.println("--------PEDIDOS---------");
                System.out.println(p);
                System.out.println("------------------------");
                soma += p.getTotal();
            }
            sb.append("Total a pagar: R$" + soma);
        }

        return sb.toString();
    }
}

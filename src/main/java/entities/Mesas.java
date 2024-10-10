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
    private boolean status;

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

    public void removePedidos(Pedidos pedidos) {
        pedido.remove(pedidos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mesa de numero #" + number + "\n");
        sb.append("Do cliente: " + client + "\n");
        sb.append("Disponibilidade: ");
        if (status == true) {
            sb.append("*DISPONÍVEL*" + "\n");
        } else {
            sb.append("*INDISPONÍVEL*" + "\n");
        }
        if (pedido.isEmpty()) {
            System.out.println("Nenhum pedido");
        } else {
            for (Pedidos p : pedido) {
                System.out.println("--------PEDIDOS---------"); 
                System.out.println(p);
                System.out.println("------------------------");
            }
        }

        return sb.toString();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author j040v
 */
public class Pedidos {

    private String orderName;
    private Integer quantity;
    private Double price;

    public Pedidos() {
    }

    public Pedidos(String orderName, Integer quantity, Double price) {
        this.orderName = orderName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        double total = quantity * price;
        return total;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido: " + orderName + "\n");
        sb.append("Quantidade: " + quantity + "\n");
        sb.append("Preço por unidade: " + price + "\n");
        sb.append("Total a pagar: R$" + getTotal() + "\n");

        return sb.toString();
    }
}

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
    private Boolean isMedico = false;

    public Pedidos() {
    }

    public Pedidos(String orderName, Integer quantity, Double price) {
        this.orderName = orderName;
        this.quantity = quantity;
        this.price = price;
    }

    public Pedidos(String orderName, Integer quantity, Double price, Boolean isMedico) {
        this.orderName = orderName;
        this.quantity = quantity;
        this.price = price;
        this.isMedico = isMedico;
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

    public void setIsMedico(Boolean isMedico) {
        this.isMedico = isMedico;
    }

    public Double getTotal() {
        double total = quantity * price;
        if(isMedico){
            total *= 0.9;
        }
        return total;
    }      

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isMedico == false){
        sb.append("Pedido: " + orderName + "\n");
        sb.append("Quantidade: " + quantity + "\n");
        sb.append("Preço por unidade: " + price + "\n");
        sb.append("Total a pagar: R$" + getTotal() + "\n");
        }
        return sb.toString();
    }
}

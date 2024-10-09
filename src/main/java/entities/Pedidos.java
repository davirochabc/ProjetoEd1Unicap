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
    private Double total;
    private Double price;

    public Pedidos() {
    }

    public Pedidos(String orderName, Integer quantity, Double total, Double price) {
        this.orderName = orderName;
        this.quantity = quantity;
        this.total = total;
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
        total = quantity * price;
        return total;
    }
    
    
}

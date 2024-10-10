/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author j040v
 */
public class Events {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private Date date;
    private String local;
    private int capacity;

    public Events() {
    }

    public Events(String name, Date date, String local, int capacity) {
        this.name = name;
        this.date = date;
        this.local = local;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Nome: ").append(name).append("\n");
    sb.append("Data: ").append(sdf.format(date)).append("\n");
    sb.append("Local: ").append(local).append("\n");
    sb.append("Capacidade: ").append(capacity).append("\n");
    return sb.toString();
    
    
    }
        
}

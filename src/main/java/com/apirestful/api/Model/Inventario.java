package com.apirestful.api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "inventario")
public class Inventario {
    
    @Id
    @Column (unique = true)
    private Integer sku;   
    private String nombre;  
    private Integer cantidad;    

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public void restarProducto(Integer sku) {
        
        this.cantidad -= cantidad;
    }
}

package com.amz.franquicias.models;

import lombok.Data;   
import java.util.UUID;

@Data   
public class Producto {  
    private String id;  
    private String nombre;  
    private int stock;  
        public Producto() {}

    public Producto(String nombre, int stock) {
        // Asignar un id único si no se provee
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.stock = stock;
    }

    // Getters y setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}  
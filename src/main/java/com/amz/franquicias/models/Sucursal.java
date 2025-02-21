/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amz.franquicias.models;

import lombok.Data;  
import java.util.List;  
import java.util.UUID;
 
@Data  
public class Sucursal {  
    private String id;  
    private String nombre;  
    private List<Producto> productos;  
     public Sucursal() {}

    public Sucursal(String nombre, List<Producto> productos) {
        // Asignar un id único si no se provee
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.productos = productos;
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
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}  
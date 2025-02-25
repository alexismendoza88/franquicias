
package com.amz.franquicias.models;

import lombok.Data;  
import org.springframework.data.annotation.Id;  
import org.springframework.data.mongodb.core.mapping.Document;  
import java.util.List;  

@Data  
@Document(collection = "franquicias")  
public class Franquicia {  
    @Id  
    private String id;  
    private String nombre;  
    private List<Sucursal> sucursales;  
      public Franquicia() {}

    public Franquicia(String nombre, List<Sucursal> sucursales) {
        this.nombre = nombre;
        this.sucursales = sucursales;
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
    public List<Sucursal> getSucursales() {
        return sucursales;
    }
    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}  
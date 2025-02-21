
package com.amz.franquicias.controllers;

import com.amz.franquicias.services.FranquiciaService;
import com.amz.franquicias.services.ProductoService;
import com.amz.franquicias.models.Producto;
import com.amz.franquicias.models.Franquicia;

import lombok.RequiredArgsConstructor;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.*;  
import reactor.core.publisher.Flux;  
import reactor.core.publisher.Mono;  
import java.util.List;  

@RestController  
@RequestMapping("/api/franquicias")  
@RequiredArgsConstructor  
public class FranquiciaController {  

    private final FranquiciaService franquiciaService;
    private final ProductoService productoService;


    @PostMapping
    public Mono<Franquicia> crearFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.crearFranquicia(franquicia);
    }

    @PutMapping("/{id}/nombre")
    public Mono<Franquicia> actualizarNombre(@PathVariable String id, @RequestParam String nombre) {
        return franquiciaService.actualizarNombre(id, nombre);
    }

    @GetMapping("/{id}")
    public Mono<Franquicia> obtenerFranquicia(@PathVariable String id) {
        return franquiciaService.obtenerFranquicia(id);
    }

    @GetMapping
    public Flux<Franquicia> obtenerTodas() {
        return franquiciaService.obtenerTodas();
    }
    
    // Endpoint para obtener el producto con mayor stock por sucursal de una franquicia
    @GetMapping("/{id}/max-stock")
    public Mono<List<Producto>> obtenerProductoConMasStock(@PathVariable String id) {
        return productoService.productoConMasStockPorSucursal(id);
    }

}

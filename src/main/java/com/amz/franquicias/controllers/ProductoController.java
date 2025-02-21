
package com.amz.franquicias.controllers;

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
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos")
@RequiredArgsConstructor  
public class ProductoController {
  private final ProductoService productoService;

    @PostMapping
    public Mono<Franquicia> agregarProducto(@PathVariable String franquiciaId,
                                              @PathVariable String sucursalId,
                                              @RequestBody Producto producto) {
        return productoService.agregarProducto(franquiciaId, sucursalId, producto);
    }

    @DeleteMapping("/{productoId}")
    public Mono<Franquicia> eliminarProducto(@PathVariable String franquiciaId,
                                               @PathVariable String sucursalId,
                                               @PathVariable String productoId) {
        return productoService.eliminarProducto(franquiciaId, sucursalId, productoId);
    }

    @PutMapping("/{productoId}/stock")
    public Mono<Franquicia> actualizarStock(@PathVariable String franquiciaId,
                                              @PathVariable String sucursalId,
                                              @PathVariable String productoId,
                                              @RequestParam int stock) {
        return productoService.actualizarStock(franquiciaId, sucursalId, productoId, stock);
    }

    @PutMapping("/{productoId}/nombre")
    public Mono<Franquicia> actualizarNombreProducto(@PathVariable String franquiciaId,
                                                     @PathVariable String sucursalId,
                                                     @PathVariable String productoId,
                                                     @RequestParam String nombre) {
        return productoService.actualizarNombreProducto(franquiciaId, sucursalId, productoId, nombre);
    }
}

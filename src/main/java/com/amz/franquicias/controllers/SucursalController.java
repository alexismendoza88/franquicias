
package com.amz.franquicias.controllers;

import com.amz.franquicias.services.SucursalService;
import com.amz.franquicias.models.Franquicia;
import com.amz.franquicias.models.Producto;
import com.amz.franquicias.models.Sucursal;

import lombok.RequiredArgsConstructor;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.*;  
import reactor.core.publisher.Flux;  
import reactor.core.publisher.Mono;  


@RestController
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales")
@RequiredArgsConstructor 
public class SucursalController {
    private final SucursalService sucursalService;

    @PostMapping
    public Mono<Franquicia> agregarSucursal(@PathVariable String franquiciaId, @RequestBody Sucursal sucursal) {
        return sucursalService.agregarSucursal(franquiciaId, sucursal);
    }

    @PutMapping("/{sucursalId}/nombre")
    public Mono<Franquicia> actualizarNombreSucursal(
            @PathVariable String franquiciaId,
            @PathVariable String sucursalId,
            @RequestParam String nombre) {
        return sucursalService.actualizarNombreSucursal(franquiciaId, sucursalId, nombre);
    }
}

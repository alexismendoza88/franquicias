
package com.amz.franquicias.services;
import com.amz.franquicias.repository.FranquiciaRepository;
import com.amz.franquicias.models.Franquicia;
import com.amz.franquicias.models.Producto;
import com.amz.franquicias.models.Sucursal;

import lombok.RequiredArgsConstructor;  
import org.springframework.stereotype.Service;  
import reactor.core.publisher.Flux;  
import reactor.core.publisher.Mono;  

import java.util.List;  
import java.util.ArrayList;  
import java.util.NoSuchElementException;  
import java.util.stream.Collectors;  
import java.util.Comparator; 
import java.util.UUID;

@Service  
@RequiredArgsConstructor  
public class SucursalService {
 private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> agregarSucursal(String franquiciaId, Sucursal sucursal) {
        return franquiciaRepository.findById(franquiciaId)
            .flatMap(franquicia -> {
                List<Sucursal> sucursales = franquicia.getSucursales();
                if (sucursales == null) {
                    sucursales = new ArrayList<>();
                }
                // Asignar un id si no lo tiene
                if(sucursal.getId() == null) {
                    sucursal.setId(UUID.randomUUID().toString());
                }
                sucursales.add(sucursal);
                franquicia.setSucursales(sucursales);
                return franquiciaRepository.save(franquicia);
            });
    }

    public Mono<Franquicia> actualizarNombreSucursal(String franquiciaId, String sucursalId, String nuevoNombre) {
        return franquiciaRepository.findById(franquiciaId)
            .flatMap(franquicia -> {
                if(franquicia.getSucursales() != null) {
                    franquicia.getSucursales().stream()
                        .filter(s -> s.getId() != null && s.getId().equals(sucursalId))
                        .findFirst()
                        .ifPresent(s -> s.setNombre(nuevoNombre));
                }
                return franquiciaRepository.save(franquicia);
            });
    }
}

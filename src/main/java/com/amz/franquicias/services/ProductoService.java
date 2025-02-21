
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
import java.util.Optional; 

@Service  
@RequiredArgsConstructor  
public class ProductoService {
 private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> agregarProducto(String franquiciaId, String sucursalId, Producto producto) {
        return franquiciaRepository.findById(franquiciaId)
            .flatMap(franquicia -> {
                List<Sucursal> sucursales = franquicia.getSucursales();
                if (sucursales != null) {
                    for(Sucursal s : sucursales) {
                        if(s.getId() != null && s.getId().equals(sucursalId)) {
                            if(s.getProductos() == null) {
                                s.setProductos(new ArrayList<>());
                            }
                            // Asignar un id al producto si no lo tiene
                            if(producto.getId() == null) {
                                producto.setId(UUID.randomUUID().toString());
                            }
                            s.getProductos().add(producto);
                            break;
                        }
                    }
                }
                return franquiciaRepository.save(franquicia);
            });
    }

    public Mono<Franquicia> eliminarProducto(String franquiciaId, String sucursalId, String productoId) {
        return franquiciaRepository.findById(franquiciaId)
            .flatMap(franquicia -> {
                List<Sucursal> sucursales = franquicia.getSucursales();
                if (sucursales != null) {
                    for(Sucursal s : sucursales) {
                        if(s.getId() != null && s.getId().equals(sucursalId)) {
                            if(s.getProductos() != null) {
                                s.setProductos(
                                  s.getProductos().stream().filter(p -> !p.getId().equals(productoId)).toList()
                                );
                            }
                            break;
                        }
                    }
                }
                return franquiciaRepository.save(franquicia);
            });
    }
    
    public Mono<Franquicia> actualizarStock(String franquiciaId, String sucursalId, String productoId, int nuevoStock) {
        return franquiciaRepository.findById(franquiciaId)
            .flatMap(franquicia -> {
                List<Sucursal> sucursales = franquicia.getSucursales();
                if(sucursales != null) {
                    for(Sucursal s : sucursales) {
                        if(s.getId() != null && s.getId().equals(sucursalId)) {
                            if(s.getProductos() != null) {
                                for(Producto p : s.getProductos()) {
                                    if(p.getId() != null && p.getId().equals(productoId)) {
                                        p.setStock(nuevoStock);
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                return franquiciaRepository.save(franquicia);
            });
    }

    public Mono<Franquicia> actualizarNombreProducto(String franquiciaId, String sucursalId, String productoId, String nuevoNombre) {
        return franquiciaRepository.findById(franquiciaId)
            .flatMap(franquicia -> {
                List<Sucursal> sucursales = franquicia.getSucursales();
                if(sucursales != null) {
                    for(Sucursal s : sucursales) {
                        if(s.getId() != null && s.getId().equals(sucursalId)) {
                            if(s.getProductos() != null) {
                                for(Producto p : s.getProductos()) {
                                    if(p.getId() != null && p.getId().equals(productoId)) {
                                        p.setNombre(nuevoNombre);
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                return franquiciaRepository.save(franquicia);
            });
    }

    // Retorna, por cada sucursal, el producto con mayor stock
    public Mono<List<Producto>> productoConMasStockPorSucursal(String franquiciaId) {
        return franquiciaRepository.findById(franquiciaId)
            .flatMap(franquicia -> {
                List<Producto> result = new ArrayList<>();
                if (franquicia.getSucursales() != null) {
                    franquicia.getSucursales().forEach(sucursal -> {
                        if(sucursal.getProductos() != null && !sucursal.getProductos().isEmpty()) {
                            Optional<Producto> maxProducto = sucursal.getProductos().stream()
                                .max((p1, p2) -> Integer.compare(p1.getStock(), p2.getStock()));
                            maxProducto.ifPresent(result::add);
                        }
                    });
                }
                return Mono.just(result);
            });
    }
}

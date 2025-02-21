/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
import java.util.NoSuchElementException;  
import java.util.stream.Collectors;  
import java.util.Comparator; 

@Service  
@RequiredArgsConstructor  
public class FranquiciaService {  

    private final FranquiciaRepository franquiciaRepository;  

    public Mono<Franquicia> crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Mono<Franquicia> actualizarNombre(String id, String nuevoNombre) {
        return franquiciaRepository.findById(id)
            .flatMap(f -> {
                f.setNombre(nuevoNombre);
                return franquiciaRepository.save(f);
            });
    }

    public Mono<Franquicia> obtenerFranquicia(String id) {
        return franquiciaRepository.findById(id);
    }

    public Flux<Franquicia> obtenerTodas() {
        return franquiciaRepository.findAll();
    }
}  

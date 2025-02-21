/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amz.franquicias.repository;
import com.amz.franquicias.models.Franquicia;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;  
import reactor.core.publisher.Mono;  
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends ReactiveMongoRepository<Franquicia, String> {    
} 
package com.dgp.dgptransito.dgptransito_api.api.controller;

import com.dgp.dgptransito.dgptransito_api.api.repository.ProprietarioRepository;
import com.dgp.dgptransito.dgptransito_api.domain.model.Proprietario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")

public class ProprietarioController {

    private ProprietarioRepository proprietarioRepository;

    @GetMapping
    public List<Proprietario> listar(){
        return proprietarioRepository.findAll();
//        return proprietarioRepository.findByNome("Joao da silva");
    }

    @GetMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> buscar(@PathVariable Long proprietarioId){
        return proprietarioRepository.findById(proprietarioId)
                .map(proprietario -> ResponseEntity.ok(proprietario))
                .orElse(ResponseEntity.notFound().build());

//        if (proprietario.isPresent()){
//            return ResponseEntity.ok(proprietario.get());
//        }
//        return ResponseEntity.notFound().build();
    }

}

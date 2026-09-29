package com.dgp.dgptransito.dgptransito_api.api.controller;

import com.dgp.dgptransito.dgptransito_api.api.repository.ProprietarioRepository;
import com.dgp.dgptransito.dgptransito_api.domain.model.Proprietario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController

public class ProprietarioController {

    private ProprietarioRepository proprietarioRepository;

    @GetMapping ("/proprietarios")
    public List<Proprietario> listar(){
        return proprietarioRepository.findAll();
//        return proprietarioRepository.findByNome("Joao da silva");
    }

}

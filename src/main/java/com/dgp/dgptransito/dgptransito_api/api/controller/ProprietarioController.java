package com.dgp.dgptransito.dgptransito_api.api.controller;

import com.dgp.dgptransito.dgptransito_api.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController

public class ProprietarioController {

    @GetMapping ("/proprietarios")
    public List<Proprietario> listar(){
        var proprietario1 = new Proprietario();
        proprietario1.setId(1L);
        proprietario1.setNome("Davi");
        proprietario1.setTelefone("81 32411785");
        proprietario1.setEmail("davi@fbsr.com.br");

        var proprietario2 = new Proprietario();
        proprietario2.setId(2L);
        proprietario2.setNome("Luciana");
        proprietario2.setTelefone("81 986629583");
        proprietario2.setEmail("luciana@avon.com.br");

        return Arrays.asList(proprietario1, proprietario2);
    }

}

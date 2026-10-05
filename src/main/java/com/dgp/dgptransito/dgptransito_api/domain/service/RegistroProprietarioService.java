package com.dgp.dgptransito.dgptransito_api.domain.service;


import com.dgp.dgptransito.dgptransito_api.domain.model.Proprietario;
import com.dgp.dgptransito.dgptransito_api.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {


    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario){
       return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long prprietarioId){
        proprietarioRepository.deleteById(prprietarioId);
    }
}

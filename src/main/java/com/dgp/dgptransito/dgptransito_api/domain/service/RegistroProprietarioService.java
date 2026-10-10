package com.dgp.dgptransito.dgptransito_api.domain.service;


import com.dgp.dgptransito.dgptransito_api.domain.exception.NegocioException;
import com.dgp.dgptransito.dgptransito_api.domain.model.Proprietario;
import com.dgp.dgptransito.dgptransito_api.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {


    private final ProprietarioRepository proprietarioRepository;

    public Proprietario buscar(Long proprietarioId) {
        return proprietarioRepository.findById(novoVeiculo.getProprietario().getId())
                .orElseThrow(() -> new NegocioException("Proprietario não encontrado"));

    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario){

        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();
        if (emailEmUso){
            throw new NegocioException("Já existe um proprietario cadastrado com esse email!");
        }
        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long prprietarioId){
        proprietarioRepository.deleteById(prprietarioId);
    }
}

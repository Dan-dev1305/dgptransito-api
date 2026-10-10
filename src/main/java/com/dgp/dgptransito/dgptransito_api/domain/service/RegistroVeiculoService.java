package com.dgp.dgptransito.dgptransito_api.domain.service;

import com.dgp.dgptransito.dgptransito_api.domain.exception.NegocioException;
import com.dgp.dgptransito.dgptransito_api.domain.model.Proprietario;
import com.dgp.dgptransito.dgptransito_api.domain.model.StatusVeiculo;
import com.dgp.dgptransito.dgptransito_api.domain.model.Veiculo;
import com.dgp.dgptransito.dgptransito_api.domain.repository.ProprietarioRepository;
import com.dgp.dgptransito.dgptransito_api.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final RegistroProprietarioService registroProprietarioService;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo){
        if (novoVeiculo.getId() != null){
            throw new NegocioException("Veículo a ser cadastrado não deve possuir um id informado.");
        }

        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                        .filter(veiculo -> !veiculo.equals(novoVeiculo))
                        .isPresent();

        if (placaEmUso) {
            throw new NegocioException("Já existe um veículo com esta placa cadastrada.");
        }

        Proprietario proprietario = registroProprietarioService.buscar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(LocalDateTime.now());

        return veiculoRepository.save(novoVeiculo);
    }
}

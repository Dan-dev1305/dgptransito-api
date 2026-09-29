package com.dgp.dgptransito.dgptransito_api.api.repository;

import com.dgp.dgptransito.dgptransito_api.domain.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
}

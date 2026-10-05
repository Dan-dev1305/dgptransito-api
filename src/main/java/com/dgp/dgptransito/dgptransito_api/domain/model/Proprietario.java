package com.dgp.dgptransito.dgptransito_api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Table (name = "tb_proprietario")

public class Proprietario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size (max = 60)
    private String nome;

    @NotBlank
    @Size (max = 255)
    @Email
    private String email;

    @NotBlank
    @Size (max = 20)
    @Column(name = "fone")
    private String telefone;


}

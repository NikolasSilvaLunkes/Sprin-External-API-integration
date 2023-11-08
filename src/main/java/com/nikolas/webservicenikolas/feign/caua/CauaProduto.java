package com.nikolas.webservicenikolas.feign.caua;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CauaProduto {
    Long id;
    String nome;
    LocalDate dataNasc;
    String cpf;
    String email;
    String fone;
    String uf;
    Long cidadeId;
    Long nCasa;
}

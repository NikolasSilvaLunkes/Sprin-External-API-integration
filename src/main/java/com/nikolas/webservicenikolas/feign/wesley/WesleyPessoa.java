package com.nikolas.webservicenikolas.feign.wesley;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WesleyPessoa {
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

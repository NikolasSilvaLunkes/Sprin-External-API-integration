package com.nikolas.webservicenikolas.generic.classes;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class DefaultModel {
    @Id
    private Long id;

    private LocalDateTime dataCriacao;

    private String baseServidorIntegrado;

}

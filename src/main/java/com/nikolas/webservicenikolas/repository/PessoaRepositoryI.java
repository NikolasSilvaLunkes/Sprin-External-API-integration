package com.nikolas.webservicenikolas.repository;

import com.nikolas.webservicenikolas.generic.interfaces.IDefaultRepository;
import com.nikolas.webservicenikolas.model.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositoryI extends IDefaultRepository<Pessoa> {
}

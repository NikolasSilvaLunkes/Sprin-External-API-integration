package com.nikolas.webservicenikolas.repository;

import com.nikolas.webservicenikolas.generic.interfaces.IDefaultRepository;
import com.nikolas.webservicenikolas.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositoryI extends IDefaultRepository<Produto> {
}

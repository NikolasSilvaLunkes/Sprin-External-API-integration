package com.nikolas.webservicenikolas.repository;

import com.nikolas.webservicenikolas.generic.interfaces.IDefaultRepository;
import com.nikolas.webservicenikolas.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryI extends IDefaultRepository<Usuario> {
}

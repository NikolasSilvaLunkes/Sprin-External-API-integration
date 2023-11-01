package com.nikolas.webservicenikolas.generic.classes;

import com.nikolas.webservicenikolas.generic.interfaces.IDefaultController;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class DefaultController<T extends DefaultModel, S extends DefaultService<T>> implements IDefaultController<T, S> {

    private final S service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<T> getAll() {
        List<T> entities = service.retornaTodos();
        return entities;
    }

    @GetMapping("/filtrado")
    @ResponseStatus(HttpStatus.OK)
    public List<T> filtrado(@RequestBody Specification<T> especificacao, @RequestBody Pageable page) {
        List<T> entities = service.listaFiltrada(especificacao, page);
        return entities;
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        return service.buscaPorId(id);
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.inserir(entity);
    }

    @PutMapping
    public T update(@RequestBody T entity) {
        return service.alterar(entity);
    }

    @DeleteMapping
    public void delete(@RequestBody T entity) {
        service.remover(entity);
    }
}
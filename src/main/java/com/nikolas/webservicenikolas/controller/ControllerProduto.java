package com.nikolas.webservicenikolas.controller;

import com.nikolas.webservicenikolas.generic.classes.DefaultController;
import com.nikolas.webservicenikolas.model.Produto;
import com.nikolas.webservicenikolas.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ControllerProduto extends DefaultController<Produto, ProdutoService> {
    public ControllerProduto(ProdutoService service) {
        super(service);
    }
}









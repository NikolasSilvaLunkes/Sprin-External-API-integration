package com.nikolas.webservicenikolas.controller;

import com.nikolas.webservicenikolas.generic.classes.DefaultController;
import com.nikolas.webservicenikolas.model.Pessoa;
import com.nikolas.webservicenikolas.service.PessoaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class ControllerPessoa extends DefaultController<Pessoa, PessoaService> {
    public ControllerPessoa(PessoaService service) {
        super(service);
    }
}









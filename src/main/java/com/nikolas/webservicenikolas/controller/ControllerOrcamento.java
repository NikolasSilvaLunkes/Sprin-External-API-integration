package com.nikolas.webservicenikolas.controller;

import com.nikolas.webservicenikolas.generic.classes.DefaultController;
import com.nikolas.webservicenikolas.model.Orcamento;
import com.nikolas.webservicenikolas.service.OrcamentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orcamento")
public class ControllerOrcamento extends DefaultController<Orcamento, OrcamentoService> {
    public ControllerOrcamento(OrcamentoService service) {
        super(service);
    }
}









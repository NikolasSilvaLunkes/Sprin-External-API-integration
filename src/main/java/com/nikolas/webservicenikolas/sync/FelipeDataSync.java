package com.nikolas.webservicenikolas.sync;

import com.nikolas.webservicenikolas.feign.ricardo.RicardoFeign;
import com.nikolas.webservicenikolas.feign.ricardo.RicardoPessoa;
import com.nikolas.webservicenikolas.model.Pessoa;
import com.nikolas.webservicenikolas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FelipeDataSync {

    @Autowired
    private RicardoFeign ricardoFeign;

    @Autowired
    private PessoaService pessoaService;

    @Scheduled(fixedDelay = 60000)
    public void syncData() {
        try {
            List<RicardoPessoa> fetchedPessoas = ricardoFeign.getPessoas("8", "Nicolas");
            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            fetchedPessoas.forEach((RicardoPessoa p) -> {
                Pessoa pessoa = new Pessoa(p.getDs_usuario(), p.getDs_cpf());
                pessoa.setId(p.getCd_usuario() + 20000);
                pessoa.setBaseServidorIntegrado("ricardo");
                pessoaService.alterar(pessoa);
            });
            // Process and insert external data into your API
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

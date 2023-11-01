package com.nikolas.webservicenikolas.sync;

import com.nikolas.webservicenikolas.feign.caua.CauaFeign;
import com.nikolas.webservicenikolas.feign.caua.CauaPessoa;
import com.nikolas.webservicenikolas.model.Pessoa;
import com.nikolas.webservicenikolas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CauaDataSync {

    @Autowired
    private CauaFeign cauaFeign;

    @Autowired
    private PessoaService pessoaService;

    @Scheduled(fixedDelay = 60000)
    public void syncData() {
        try {
            List<CauaPessoa> fetchedPessoas = cauaFeign.getPessoas("8", "Nicolas");
            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            fetchedPessoas.forEach((CauaPessoa p) -> {
                Pessoa pessoa = new Pessoa(p.getNome(), p.getCpf());
                pessoa.setId(p.getId() + 10000);
                pessoa.setBaseServidorIntegrado("caua");
                pessoaService.alterar(pessoa);
            });

            // Process and insert external data into your API
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

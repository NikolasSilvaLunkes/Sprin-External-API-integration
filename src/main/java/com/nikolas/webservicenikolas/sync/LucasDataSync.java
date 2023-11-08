package com.nikolas.webservicenikolas.sync;

import com.nikolas.webservicenikolas.feign.lucas.LucasFeign;
import com.nikolas.webservicenikolas.feign.lucas.LucasPessoa;
import com.nikolas.webservicenikolas.model.Pessoa;
import com.nikolas.webservicenikolas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LucasDataSync {

    @Autowired
    private LucasFeign lucasFeign;

    @Autowired
    private PessoaService pessoaService;

    @Scheduled(fixedDelay = 60000)
    public void syncData() {
        try {
            List<LucasPessoa> fetchedPessoas = lucasFeign.getPessoas();
            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            fetchedPessoas.forEach((LucasPessoa p) -> {
                Pessoa pessoa = new Pessoa(p.getDs_usuario(), p.getDs_cpf());
                pessoa.setId(p.getCd_usuario() + 30000);
                pessoa.setBaseServidorIntegrado("lucas");
                pessoaService.alterar(pessoa);
            });
            // Process and insert external data into your API
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.nikolas.webservicenikolas.sync;

import com.nikolas.webservicenikolas.feign.caua.CauaFeign;
import com.nikolas.webservicenikolas.feign.caua.CauaPessoa;
import com.nikolas.webservicenikolas.feign.caua.CauaProduto;
import com.nikolas.webservicenikolas.model.Pessoa;
import com.nikolas.webservicenikolas.service.PessoaService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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
                if (p.getId() > 100000) {
                    return;
                }
                pessoa.setId(p.getId() + 10000);
                pessoa.setBaseServidorIntegrado("caua");
                pessoaService.alterar(pessoa);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Specification<Pessoa> spec = new Specification<Pessoa>() {
                @Override
                public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.isEmpty(root.get("baseServidorIntegrado"));
                }
            };
            List<Pessoa> allPessoas = pessoaService.listaFiltrada(spec, PageRequest.of(0, 999999999));

            allPessoas.forEach((Pessoa p) -> {
                CauaProduto pp = new CauaProduto();
                pp.setId(p.getId() + 100000);
                pp.setCpf(p.getCpf());
                pp.setNome(p.getNome());
                //cauaFeign.postProdutos(pp);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

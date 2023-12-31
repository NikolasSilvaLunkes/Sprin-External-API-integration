package com.nikolas.webservicenikolas.feign.caua;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "CauaFeign", url = "${feign.caua.url}")
public interface CauaFeign {


    @GetMapping("/clientes")
    List<CauaPessoa> getPessoas(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "pwd") String pwd);

    @GetMapping("/produtos")
    String getProdutos(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "pwd") String pwd);

    @PostMapping("/inserir?id=8&pwd=Nicolas&entidade=nomeDaEntiadade")
    void postProdutos(@RequestBody CauaProduto p);
}
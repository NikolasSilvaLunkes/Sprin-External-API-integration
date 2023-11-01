package com.nikolas.webservicenikolas.feign.wesley;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "WesleyFeign", url = "${feign.wesley.url}")
public interface WesleyFeign {
    @GetMapping("/clientes")
    List<WesleyPessoa> getPessoas(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "pwd") String pwd);

    @GetMapping("/produtos")
    String getProdutos(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "pwd") String pwd);
}
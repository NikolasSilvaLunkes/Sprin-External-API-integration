package com.nikolas.webservicenikolas.feign.ricardo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "RicardoFeign", url = "${feign.ricardo.url}")
public interface RicardoFeign {


    @GetMapping("/usuarios_ws.php")
    List<RicardoPessoa> getPessoas(
            @RequestParam(value = "cdu") String cdu,
            @RequestParam(value = "pwd") String pwd);
}
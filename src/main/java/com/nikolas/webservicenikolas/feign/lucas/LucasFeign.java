package com.nikolas.webservicenikolas.feign.lucas;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "LucasFeign", url = "${feign.lucas.url}")
public interface LucasFeign {


    @GetMapping("/servidor_json_bd.php")
    List<LucasPessoa> getPessoas();
}
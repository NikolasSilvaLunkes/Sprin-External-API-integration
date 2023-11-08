package com.nikolas.webservicenikolas.feign.felipe;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "FelipeFeign", url = "${feign.felipe.url}")
public interface FelipeFeign {

    @Headers("Authorization: e8ea876f49a6de0c5132a2889d4d35e6bdd81e3a3f3048691862fa490375d0bb")
    @GetMapping("/cadastre.get-products")
    List<FelipePessoa> get();
}
package com.crowdfunding.dp.backend.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("rest/api/price")
public class EtherPriceController {

    @GetMapping
    public String getEtherPrice(){
        final String uri = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=EUR&api_key=2d8b3ea5659cf6c8da89ef214a8869d534d544dc4a75dfddac47074439cf412e";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri, String.class);
    }
}

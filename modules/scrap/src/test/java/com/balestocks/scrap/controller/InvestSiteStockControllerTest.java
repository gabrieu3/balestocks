package com.balestocks.scrap.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InvestSiteStockControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testStockSiteApiResponse() throws IOException {
        // URL da API que você quer testar
        String url = "/api/invest";

        // Fazer a chamada à API
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // Carregar o arquivo de referência (arquivo verdade)
        String expectedResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/expected-response2.json")));

        // Comparar a resposta da API com o conteúdo do arquivo de referência
        assertEquals(expectedResponse, responseEntity.getBody());
    }
}
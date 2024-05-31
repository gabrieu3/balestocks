package com.balestocks.scrap.controller;

import com.balestocks.scrap.domain.dto.StockDadosMercadoDto;
import com.balestocks.scrap.service.DadosMercadoStocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DadosMercadoStocksController {

    @Autowired
    private DadosMercadoStocksService dadosMercadoStocksService;

    @GetMapping("/stocks")
    public List<StockDadosMercadoDto> stocks(){
        return dadosMercadoStocksService.scrap();
    }
}

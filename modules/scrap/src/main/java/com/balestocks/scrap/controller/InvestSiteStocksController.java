package com.balestocks.scrap.controller;

import com.balestocks.scrap.domain.dto.StockInvestSiteDto;
import com.balestocks.scrap.service.InvestSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestSiteStocksController {

    @Autowired
    private InvestSiteService investSiteService;

    @GetMapping("/invest")
    public List<StockInvestSiteDto> stocks() throws InterruptedException {
        return investSiteService.scrap();
    }
}

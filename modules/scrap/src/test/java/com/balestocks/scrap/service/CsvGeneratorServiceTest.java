package com.balestocks.scrap.service;

import com.balestocks.scrap.domain.DadosInvestSite;
import com.balestocks.scrap.domain.enums.StockEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")  // Ativa o perfil "test" onde o Liquibase está desabilitado
public class CsvGeneratorServiceTest {

    @Autowired
    InvestSiteService investSiteService;

    @Test
    public void geraCsvComDadosRAIZ4DoSiteInvestSite() throws IOException, IllegalAccessException {
        List listTest = new ArrayList<>();
        listTest.add(investSiteService.scrapStock(StockEnum.RAIZ4));
        investSiteService.saveScrapList(listTest);
        CsvGeneratorService.generateCsv(listTest);
    }

    @Test
    public void geraCsvComDadosDoSiteInvestSite() throws IOException, IllegalAccessException, InterruptedException {
        List listStock = investSiteService.scrap();
        investSiteService.saveScrapList(listStock);
        CsvGeneratorService.generateCsv(listStock);
    }

}

package com.balestocks.scrap.service;

import com.balestocks.scrap.domain.DadosInvestSite;
import com.balestocks.scrap.domain.enums.StockEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CsvGeneratorServiceTest {

    @Autowired
    InvestSiteService investSiteService;

    @Test
    public void geraCsvComDadosDoSiteInvestSite() throws IOException, IllegalAccessException {
        List listTest = new ArrayList<>();
        listTest.add(investSiteService.scrapStock(StockEnum.CIEL3));
        CsvGeneratorService.generateCsv(listTest,"InvesteSiteData.csv");
    }


}

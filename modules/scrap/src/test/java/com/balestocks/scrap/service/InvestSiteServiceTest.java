package com.balestocks.scrap.service;

import com.balestocks.scrap.domain.DadosInvestSite;
import com.balestocks.scrap.domain.enums.StockEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Ativa o perfil "test" onde o Liquibase está desabilitado
public class InvestSiteServiceTest {

    @Autowired
    InvestSiteService investSiteService;

    @Test
    public void validarAlgo() throws InterruptedException {
        investSiteService.scrap();
    }

    @Test
    public void validarOsEnums(){
        DadosInvestSite dadosInvestSite = new DadosInvestSite();
        for(
            StockEnum stock: StockEnum.values()){
            System.out.println(dadosInvestSite.urlStock(stock));
        }
    }

}

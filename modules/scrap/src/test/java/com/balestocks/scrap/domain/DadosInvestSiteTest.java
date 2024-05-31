package com.balestocks.scrap.domain;

import com.balestocks.scrap.domain.enums.StockEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class DadosInvestSiteTest {

    @Test
    void validaConcatStockUrl() {
        String urlVerdade = "https://www.investsite.com.br/principais_indicadores.php?cod_negociacao=CIEL3";
        DadosInvestSite dadosInvestSite = new DadosInvestSite();
        String urlGerada = dadosInvestSite.urlStock(StockEnum.CIEL3);
        Assert.isTrue(urlVerdade.equals(urlGerada), "URL não está correta verdade: ".concat(urlVerdade).concat(" alvo: ").concat(urlGerada));
    }
}

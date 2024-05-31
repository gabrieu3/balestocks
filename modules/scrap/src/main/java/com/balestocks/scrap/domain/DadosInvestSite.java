package com.balestocks.scrap.domain;

import com.balestocks.scrap.domain.enums.StockEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DadosInvestSite {

    private final String url = "https://www.investsite.com.br/principais_indicadores.php?cod_negociacao=:1";

    public String urlStock(StockEnum stockEnum){
        return this.url.replace(":1",stockEnum.toString());
    }
}

package com.balestocks.scrap.domain.mapper;

import com.balestocks.scrap.domain.dto.StockDadosMercadoDto;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;

public class DadosMercadoMapper {

    public static StockDadosMercadoDto toStockDto(Element el) {
        Elements tds = el.select("td");  // Seleciona todos os <td> dentro do <tr>

        return StockDadosMercadoDto.builder()
                .stockCode(tds.get(0).text()) // Extrai o texto do primeiro <td>
                .stockCompanyName(tds.get(1).text()) // Extrai o texto do segundo <td>
                .quantityBusiness(parseInteger(tds.get(2).text())) // Extrai e converte o texto do terceiro <td>
                .value(parseBigDecimal(tds.get(3).text())) // Extrai e converte o texto do quarto <td>
                .valueVariation(tds.get(4).text()) // Extrai e converte o texto do quinto <td>
                .build();
    }

    private static Integer parseInteger(String text) {
        // Remove pontos de milhar e converte para Integer
        try {
            return Integer.parseInt(text.replaceAll("\\.", "").replaceAll(",", ""));
        } catch (NumberFormatException e) {
            // Lide com o erro conforme necessário
            return null;
        }
    }

    private static BigDecimal parseBigDecimal(String text) {
        // Converte texto para BigDecimal, trocando a vírgula por ponto para o formato correto
        try {
            return new BigDecimal(text.replaceAll("\\.", "").replace(",", "."));
        } catch (NumberFormatException e) {
            // Lide com o erro conforme necessário
            return null;
        }
    }
}

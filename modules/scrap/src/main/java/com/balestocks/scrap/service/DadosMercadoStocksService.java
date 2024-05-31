package com.balestocks.scrap.service;

import com.balestocks.scrap.domain.DadosMercadoSite;
import com.balestocks.scrap.domain.dto.StockDadosMercadoDto;
import com.balestocks.scrap.domain.mapper.DadosMercadoMapper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class DadosMercadoStocksService {

    @Autowired
    private WebDriverService driver;

    public List<StockDadosMercadoDto> scrap() {
        DadosMercadoSite dadosMercadoSite = new DadosMercadoSite();
        String url = dadosMercadoSite.getUrl();
        By locator = By.xpath("//div[contains(@class, 'table-container')]");
        Document documentPage = this.getDocumentPage(url, locator, null);

        // Seleciona o tbody dentro da div com a classe "table-container"
        Elements tableBody = documentPage.select("div.table-container table#stocks tbody");

        // Seleciona todos os elementos <tr> dentro do <tbody>
        Elements rows = tableBody.select("tr");

        List<StockDadosMercadoDto> stockList = new ArrayList<StockDadosMercadoDto>();

        // Itera sobre os elementos <tr> e faz algo com eles
        for (Element row : rows) {
            StockDadosMercadoDto dto = DadosMercadoMapper.toStockDto(row);
            log.info(dto.getStockCode().concat("(\"").concat(dto.getStockCompanyName()).concat("\"),"));
            stockList.add(dto);
        }
        return stockList;
    }

    protected Document getDocumentPage(String url, By locator, String text) {
        log.info("Scrapping: " + url);
        String html = isNull(locator) ? driver.run(url) : isNull(text) ? driver.runWait(url, locator) : driver.runWaitContent(url, locator, text);
        return Jsoup.parse(html);
    }

}

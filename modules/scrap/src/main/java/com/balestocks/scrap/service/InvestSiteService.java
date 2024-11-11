package com.balestocks.scrap.service;

import com.balestocks.scrap.domain.DadosInvestSite;
import com.balestocks.scrap.domain.dto.StockInvestSiteDto;
import com.balestocks.scrap.domain.enums.StockEnum;
import com.balestocks.scrap.domain.mapper.InvestSiteMapper;
import com.balestocks.scrap.repository.StockInvestSiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class InvestSiteService {

    @Autowired
    private WebDriverService driver;

    @Autowired
    private StockInvestSiteRepository stockInvestSiteRepository;

    public List<StockInvestSiteDto> scrap() throws InterruptedException {
        List<StockInvestSiteDto> listStockInvest = new ArrayList<>();
        for (StockEnum stock : StockEnum.values()) {
            listStockInvest.add(scrapStock(stock));
            Thread.sleep(2000);
        }
        return listStockInvest;
    }

    public StockInvestSiteDto scrapStock(StockEnum stockCode) {
        DadosInvestSite dadosInvestSite = new DadosInvestSite();
        By locator = By.xpath("//main[contains(@id, 'main-content')]");
        return carregaDados(stockCode,
                this.getDocumentPage(dadosInvestSite.urlStock(stockCode), locator, null));
    }

    public void saveScrapList(List<StockInvestSiteDto> list) {
        list.forEach(stock -> stockInvestSiteRepository.save(InvestSiteMapper.toEntity(stock)));
    }

    protected Document getDocumentPage(String url, By locator, String text) {
        log.info("Scrapping: " + url);
        String html = isNull(locator) ? driver.run(url) : isNull(text) ? driver.runWait(url, locator) : driver.runWaitContent(url, locator, text);
        return Jsoup.parse(html);
    }

    private StockInvestSiteDto carregaDados(StockEnum stockCode, Document documentPage) {
        StockInvestSiteDto stockInvestSiteDto = new StockInvestSiteDto();
        stockInvestSiteDto.setStockCode(stockCode);
        extrairDadosBasicos(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaPrecosRelativos(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaDRE12Meses(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaDre3Meses(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaPrecos(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaMargensRetornos(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaBp(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaFluxoCaixa12Meses(stockInvestSiteDto, documentPage);
        extrairDadosResumoEmpresaFluxoCaixa3Meses(stockInvestSiteDto, documentPage);
        return stockInvestSiteDto;
    }

    private void extrairDadosBasicos(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa");
        try {

            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Variáveis para armazenar os valores extraídos
                String empresa = "";
                String razaoSocial = "";
                String situacaoRegistro = "";
                String situacaoEmissor = "";
                String segmentoListagem = "";
                String atividade = "";
                String acao = "";
                String dataCotacao = "";
                String tipoAcao = "";
                String ultimoFechamento = "";
                String fatorCotacao = "";
                String volumeFinanceiro = "";
                String ultimoDemonstrativo = "";
                String setor = "";
                String subsetor = "";
                String segmento = "";
                String participacaoIndices = "";

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");
                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String key = leftCells.get(0).text();
                        String value = rightCells.get(0).text();

                        switch (key) {
                            case "Empresa":
                                empresa = value;
                                break;
                            case "Razão Social":
                                razaoSocial = value;
                                break;
                            case "Situação Registro":
                                situacaoRegistro = value;
                                break;
                            case "Situação Emissor":
                                situacaoEmissor = value;
                                break;
                            case "Segmento de Listagem":
                                segmentoListagem = value;
                                break;
                            case "Atividade":
                                atividade = value;
                                break;
                            case "Ação":
                                acao = value;
                                break;
                            case "Data Cotação":
                                dataCotacao = value;
                                break;
                            case "Tipo de Ação":
                                tipoAcao = value;
                                break;
                            case "Último Fechamento":
                                ultimoFechamento = value;
                                break;
                            case "Fator de Cotação":
                                fatorCotacao = value;
                                break;
                            case "Volume Financeiro":
                                volumeFinanceiro = value;
                                break;
                            case "Último Demonstrativo":
                                ultimoDemonstrativo = value;
                                break;
                            case "Setor":
                                setor = value;
                                break;
                            case "Subsetor":
                                subsetor = value;
                                break;
                            case "Segmento":
                                segmento = value;
                                break;
                            case "Part. Índices":
                                participacaoIndices = value;
                                break;
                        }
                    }
                }

                stockInvestSiteDto.setDadosBasicos(StockInvestSiteDto.DadosBasicos
                        .builder()
                        .empresa(empresa)
                        .razaoSocial(razaoSocial)
                        .situacaoRegistro(situacaoRegistro)
                        .situacaoEmissor(situacaoEmissor)
                        .segmentoListagem(segmentoListagem)
                        .atividade(atividade)
                        .dataCotacao(dataCotacao)
                        .tipoAcao(tipoAcao)
                        .acao(acao)
                        .ultimoFechamento(ultimoFechamento)
                        .fatorCotacao(fatorCotacao)
                        .volumeFinanceiro(volumeFinanceiro)
                        .ultimoDemonstrativo(ultimoDemonstrativo)
                        .setor(setor)
                        .subsetor(subsetor)
                        .segmento(segmento)
                        .participacaoIndices(participacaoIndices)
                        .build());
            } else {
                System.out.println("Tabela não encontrada tabela_resumo_empresa");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void extrairDadosResumoEmpresaPrecosRelativos(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa_precos_relativos"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_precos_relativos");

        // Variáveis para armazenar os valores extraídos
        String precoLucro = "";
        String precoVpa = "";
        String precoReceitaLiquida = "";
        String precoFco = "";
        String precoFcf = "";
        String precoAtivoTotal = "";
        String precoEbit = "";
        String precoCapitalGiro = "";
        String precoNcav = "";
        String evEbit = "";
        String evEbitda = "";
        String evReceitaLiquida = "";
        String evFco = "";
        String evFcf = "";
        String evAtivoTotal = "";
        String marketCapEmpresa = "";
        String enterpriseValue = "";
        String dataDemonstracaoFinanceiraAtual = "";
        String precoAtualAcao = "";
        String dataPrecoAcao = "";
        String dividendYield = "";

        try {
            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.text().trim();

                        switch (label) {
                            case "Preço/Lucro":
                                precoLucro = value;
                                break;
                            case "Preço/VPA":
                                precoVpa = value;
                                break;
                            case "Preço/Receita Líquida":
                                precoReceitaLiquida = value;
                                break;
                            case "Preço/FCO":
                                precoFco = value;
                                break;
                            case "Preço/FCF":
                                precoFcf = value;
                                break;
                            case "Preço/Ativo Total":
                                precoAtivoTotal = value;
                                break;
                            case "Preço/EBIT":
                                precoEbit = value;
                                break;
                            case "Preço/Capital Giro":
                                precoCapitalGiro = value;
                                break;
                            case "Preço/NCAV":
                                precoNcav = value;
                                break;
                            case "EV/EBIT":
                                evEbit = value;
                                break;
                            case "EV/EBITDA":
                                evEbitda = value;
                                break;
                            case "EV/Receita Líquida":
                                evReceitaLiquida = value;
                                break;
                            case "EV/FCO":
                                evFco = value;
                                break;
                            case "EV/FCF":
                                evFcf = value;
                                break;
                            case "EV/Ativo Total":
                                evAtivoTotal = value;
                                break;
                            case "Market Cap Empresa":
                                marketCapEmpresa = value;
                                break;
                            case "Enterprise Value":
                                enterpriseValue = value;
                                break;
                            case "Data Demonstração Financeira Atual":
                                dataDemonstracaoFinanceiraAtual = value;
                                break;
                            case "Preço Atual da Ação":
                                precoAtualAcao = value;
                                break;
                            case "Data do Preço da Ação":
                                dataPrecoAcao = value;
                                break;
                            case "Dividend Yield":
                                dividendYield = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construir e retornar o objeto ResumoEmpresaPrecosRelativos
        stockInvestSiteDto.setResumoEmpresaPrecosRelativos(StockInvestSiteDto.ResumoEmpresaPrecosRelativos.builder()
                .precoLucro(precoLucro)
                .precoVpa(precoVpa)
                .precoReceitaLiquida(precoReceitaLiquida)
                .precoFco(precoFco)
                .precoFcf(precoFcf)
                .precoAtivoTotal(precoAtivoTotal)
                .precoEbit(precoEbit)
                .precoCapitalGiro(precoCapitalGiro)
                .precoNcav(precoNcav)
                .evEbit(evEbit)
                .evEbitda(evEbitda)
                .evReceitaLiquida(evReceitaLiquida)
                .evFco(evFco)
                .evFcf(evFcf)
                .evAtivoTotal(evAtivoTotal)
                .marketCapEmpresa(marketCapEmpresa)
                .enterpriseValue(enterpriseValue)
                .dataDemonstracaoFinanceiraAtual(dataDemonstracaoFinanceiraAtual)
                .precoAtualAcao(precoAtualAcao)
                .dataPrecoAcao(dataPrecoAcao)
                .dividendYield(dividendYield)
                .build());
    }

    private void extrairDadosResumoEmpresaDRE12Meses(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa_dre_12meses"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_dre_12meses");

        // Variáveis para armazenar os valores extraídos
        String receitaLiquida = "";
        String resultadoBruto = "";
        String ebit = "";
        String depreciacaoAmortizacao = "";
        String ebitda = "";
        String lucroLiquido = "";
        String lucroAcao = "";

        try {
            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.text().trim();

                        switch (label) {
                            case "Receita Líquida":
                                receitaLiquida = value;
                                break;
                            case "Resultado Bruto":
                                resultadoBruto = value;
                                break;
                            case "EBIT":
                                ebit = value;
                                break;
                            case "Depreciação e Amortização":
                                depreciacaoAmortizacao = value;
                                break;
                            case "EBITDA":
                                ebitda = value;
                                break;
                            case "Lucro Líquido":
                                lucroLiquido = value;
                                break;
                            case "Lucro/Ação":
                                lucroAcao = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construir e retornar o objeto ResumoEmpresaDRE12Meses
        stockInvestSiteDto.setResumoEmpresaDRE12Meses(StockInvestSiteDto.ResumoEmpresaDRE12Meses.builder()
                .receitaLiquida(receitaLiquida)
                .resultadoBruto(resultadoBruto)
                .ebit(ebit)
                .depreciacaoAmortizacao(depreciacaoAmortizacao)
                .ebitda(ebitda)
                .lucroLiquido(lucroLiquido)
                .lucroAcao(lucroAcao)
                .build());
    }

    private void extrairDadosResumoEmpresaDre3Meses(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa_dre_3meses"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_dre_3meses");

        // Variáveis para armazenar os valores extraídos
        String receitaLiquida = "";
        String resultadoBruto = "";
        String ebit = "";
        String depreciacaoAmortizacao = "";
        String ebitda = "";
        String lucroLiquido = "";
        String lucroAcao = "";

        try {
            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita a");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.text().trim();

                        switch (label) {
                            case "Receita Líquida":
                                receitaLiquida = value;
                                break;
                            case "Resultado Bruto":
                                resultadoBruto = value;
                                break;
                            case "EBIT":
                                ebit = value;
                                break;
                            case "Depreciação e Amortização":
                                depreciacaoAmortizacao = value;
                                break;
                            case "EBITDA":
                                ebitda = value;
                                break;
                            case "Lucro Líquido":
                                lucroLiquido = value;
                                break;
                            case "Lucro/Ação":
                                lucroAcao = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construir e definir o objeto ResumoEmpresaDre3Meses
        stockInvestSiteDto.setResumoEmpresaDre3Meses(StockInvestSiteDto.ResumoEmpresaDre3Meses.builder()
                .receitaLiquida(receitaLiquida)
                .resultadoBruto(resultadoBruto)
                .ebit(ebit)
                .depreciacaoAmortizacao(depreciacaoAmortizacao)
                .ebitda(ebitda)
                .lucroLiquido(lucroLiquido)
                .lucroAcao(lucroAcao)
                .build());
    }

    private void extrairDadosResumoEmpresaPrecos(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_precos");

        String menorPreco52Semanas = "";
        String maiorPreco52Semanas = "";
        String variacao2024 = "";
        String variacao1Ano = "";
        String variacao2AnosTotal = "";
        String variacao2AnosAnual = "";
        String variacao3AnosTotal = "";
        String variacao3AnosAnual = "";
        String variacao4AnosTotal = "";
        String variacao4AnosAnual = "";
        String variacao5AnosTotal = "";
        String variacao5AnosAnual = "";
        String volumeDiarioMedio3Meses = "";

        try {
            if (table != null) {
                Elements rows = table.select("tbody tr");

                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.text().trim();

                        switch (label) {
                            case "Menor Preço 52 sem.":
                                menorPreco52Semanas = value;
                                break;
                            case "Maior Preço 52 sem.":
                                maiorPreco52Semanas = value;
                                break;
                            case "Variação 2024":
                                variacao2024 = value;
                                break;
                            case "Variação 1 ano":
                                variacao1Ano = value;
                                break;
                            case "Variação 2 anos (total)":
                                variacao2AnosTotal = value;
                                break;
                            case "Variação 2 anos (anual)":
                                variacao2AnosAnual = value;
                                break;
                            case "Variação 3 anos (total)":
                                variacao3AnosTotal = value;
                                break;
                            case "Variação 3 anos (anual)":
                                variacao3AnosAnual = value;
                                break;
                            case "Variação 4 anos (total)":
                                variacao4AnosTotal = value;
                                break;
                            case "Variação 4 anos (anual)":
                                variacao4AnosAnual = value;
                                break;
                            case "Variação 5 anos (total)":
                                variacao5AnosTotal = value;
                                break;
                            case "Variação 5 anos (anual)":
                                variacao5AnosAnual = value;
                                break;
                            case "Volume Diário Médio (3 meses)":
                                volumeDiarioMedio3Meses = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        stockInvestSiteDto.setResumoEmpresaPrecos(StockInvestSiteDto.ResumoEmpresaPrecos.builder()
                .menorPreco52Semanas(menorPreco52Semanas)
                .maiorPreco52Semanas(maiorPreco52Semanas)
                .variacao2024(variacao2024)
                .variacao1Ano(variacao1Ano)
                .variacao2AnosTotal(variacao2AnosTotal)
                .variacao2AnosAnual(variacao2AnosAnual)
                .variacao3AnosTotal(variacao3AnosTotal)
                .variacao3AnosAnual(variacao3AnosAnual)
                .variacao4AnosTotal(variacao4AnosTotal)
                .variacao4AnosAnual(variacao4AnosAnual)
                .variacao5AnosTotal(variacao5AnosTotal)
                .variacao5AnosAnual(variacao5AnosAnual)
                .volumeDiarioMedio3Meses(volumeDiarioMedio3Meses)
                .build());
    }

    private void extrairDadosResumoEmpresaMargensRetornos(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa_margens_retornos"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_margens_retornos");

        // Variáveis para armazenar os valores extraídos
        String retornoCapitalTangivelInicial = "";
        String retornoCapitalInvestidoInicial = "";
        String retornoCapitalTangivelInicialPreImpostos = "";
        String retornoCapitalInvestidoInicialPreImpostos = "";
        String retornoPatrimonioLiquidoInicial = "";
        String retornoAtivoInicial = "";
        String margemBruta = "";
        String margemLiquida = "";
        String margemEbit = "";
        String margemEbitda = "";
        String giroAtivoInicial = "";
        String alavancagemFinanceira = "";
        String passivoPatrimonioLiquido = "";
        String dividaLiquidaEbitda = "";

        try {
            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.text().trim();

                        switch (label) {
                            case "Retorno s/ Capital Tangível Inicial":
                                retornoCapitalTangivelInicial = value;
                                break;
                            case "Retorno s/ Capital Investido Inicial":
                                retornoCapitalInvestidoInicial = value;
                                break;
                            case "Retorno s/ Capital Tangível Inicial Pré-Impostos":
                                retornoCapitalTangivelInicialPreImpostos = value;
                                break;
                            case "Retorno s/ Capital Investido Inicial Pré-Impostos":
                                retornoCapitalInvestidoInicialPreImpostos = value;
                                break;
                            case "Retorno s/ Patrimônio Líquido Inicial":
                                retornoPatrimonioLiquidoInicial = value;
                                break;
                            case "Retorno s/ Ativo Inicial":
                                retornoAtivoInicial = value;
                                break;
                            case "Margem Bruta":
                                margemBruta = value;
                                break;
                            case "Margem Líquida":
                                margemLiquida = value;
                                break;
                            case "Margem EBIT":
                                margemEbit = value;
                                break;
                            case "Margem EBITDA":
                                margemEbitda = value;
                                break;
                            case "Giro do Ativo Inicial":
                                giroAtivoInicial = value;
                                break;
                            case "Alavancagem Financeira":
                                alavancagemFinanceira = value;
                                break;
                            case "Passivo/Patrimônio Líquido":
                                passivoPatrimonioLiquido = value;
                                break;
                            case "Dívida Líquida/EBITDA":
                                dividaLiquidaEbitda = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construir e retornar o objeto ResumoEmpresaMargensRetornos
        stockInvestSiteDto.setResumoEmpresaMargensRetornos(StockInvestSiteDto.ResumoEmpresaMargensRetornos.builder()
                .retornoCapitalTangivelInicial(retornoCapitalTangivelInicial)
                .retornoCapitalInvestidoInicial(retornoCapitalInvestidoInicial)
                .retornoCapitalTangivelInicialPreImpostos(retornoCapitalTangivelInicialPreImpostos)
                .retornoCapitalInvestidoInicialPreImpostos(retornoCapitalInvestidoInicialPreImpostos)
                .retornoPatrimonioLiquidoInicial(retornoPatrimonioLiquidoInicial)
                .retornoAtivoInicial(retornoAtivoInicial)
                .margemBruta(margemBruta)
                .margemLiquida(margemLiquida)
                .margemEbit(margemEbit)
                .margemEbitda(margemEbitda)
                .giroAtivoInicial(giroAtivoInicial)
                .alavancagemFinanceira(alavancagemFinanceira)
                .passivoPatrimonioLiquido(passivoPatrimonioLiquido)
                .dividaLiquidaEbitda(dividaLiquidaEbitda)
                .build());
    }

    private void extrairDadosResumoEmpresaBp(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa_bp"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_bp");

        // Variáveis para armazenar os valores extraídos
        String caixaEquivalentes = "";
        String ativoTotal = "";
        String dividaCurtoPrazo = "";
        String dividaLongoPrazo = "";
        String dividaBruta = "";
        String dividaLiquida = "";
        String patrimonioLiquido = "";
        String valorPatrimonialAcao = "";
        String acoesOrdinarias = "";
        String acoesPreferenciais = "";
        String totalAcoes = "";
        String acoesOrdinariasTesouraria = "";
        String acoesPreferenciaisTesouraria = "";
        String totalAcoesTesouraria = "";
        String acoesOrdinariasExTesouraria = "";
        String acoesPreferenciaisExTesouraria = "";
        String totalAcoesExTesouraria = "";

        try {
            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.text().trim();

                        switch (label) {
                            case "Caixa e Equivalentes de Caixa":
                                caixaEquivalentes = value;
                                break;
                            case "Ativo Total":
                                ativoTotal = value;
                                break;
                            case "Dívida de Curto Prazo":
                                dividaCurtoPrazo = value;
                                break;
                            case "Dívida de Longo Prazo":
                                dividaLongoPrazo = value;
                                break;
                            case "Dívida Bruta":
                                dividaBruta = value;
                                break;
                            case "Dívida Líquida":
                                dividaLiquida = value;
                                break;
                            case "Patrimônio Líquido":
                                patrimonioLiquido = value;
                                break;
                            case "Valor Patrimonial da Ação":
                                valorPatrimonialAcao = value;
                                break;
                            case "Ações Ordinárias":
                                acoesOrdinarias = value;
                                break;
                            case "Ações Preferenciais":
                                acoesPreferenciais = value;
                                break;
                            case "Total":
                                totalAcoes = value;
                                break;
                            case "Ações Ordinárias em Tesouraria":
                                acoesOrdinariasTesouraria = value;
                                break;
                            case "Ações Preferenciais em Tesouraria":
                                acoesPreferenciaisTesouraria = value;
                                break;
                            case "Total em Tesouraria":
                                totalAcoesTesouraria = value;
                                break;
                            case "Ações Ordinárias (Exceto Tesouraria)":
                                acoesOrdinariasExTesouraria = value;
                                break;
                            case "Ações Preferenciais (Exceto Tesouraria)":
                                acoesPreferenciaisExTesouraria = value;
                                break;
                            case "Total (Exceto Tesouraria)":
                                totalAcoesExTesouraria = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construir e definir o objeto ResumoEmpresaBp
        stockInvestSiteDto.setResumoEmpresaBp(StockInvestSiteDto.ResumoEmpresaBp.builder()
                .caixaEquivalentes(caixaEquivalentes)
                .ativoTotal(ativoTotal)
                .dividaCurtoPrazo(dividaCurtoPrazo)
                .dividaLongoPrazo(dividaLongoPrazo)
                .dividaBruta(dividaBruta)
                .dividaLiquida(dividaLiquida)
                .patrimonioLiquido(patrimonioLiquido)
                .valorPatrimonialAcao(valorPatrimonialAcao)
                .acoesOrdinarias(acoesOrdinarias)
                .acoesPreferenciais(acoesPreferenciais)
                .totalAcoes(totalAcoes)
                .acoesOrdinariasTesouraria(acoesOrdinariasTesouraria)
                .acoesPreferenciaisTesouraria(acoesPreferenciaisTesouraria)
                .totalAcoesTesouraria(totalAcoesTesouraria)
                .acoesOrdinariasExTesouraria(acoesOrdinariasExTesouraria)
                .acoesPreferenciaisExTesouraria(acoesPreferenciaisExTesouraria)
                .totalAcoesExTesouraria(totalAcoesExTesouraria)
                .build());
    }

    private void extrairDadosResumoEmpresaFluxoCaixa12Meses(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa_fc_12meses"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_fc_12meses");

        // Variáveis para armazenar os valores extraídos
        String fluxoCaixaOperacional = "";
        String fluxoCaixaInvestimentos = "";
        String fluxoCaixaFinanciamentos = "";
        String aumentoReducaoCaixa = "";

        try {
            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.text().trim();

                        switch (label) {
                            case "Fluxo de Caixa Operacional":
                                fluxoCaixaOperacional = value;
                                break;
                            case "Fluxo de Caixa de Investimentos":
                                fluxoCaixaInvestimentos = value;
                                break;
                            case "Fluxo de Caixa de Financiamentos":
                                fluxoCaixaFinanciamentos = value;
                                break;
                            case "Aumento (Redução) de Caixa e Equivalentes":
                                aumentoReducaoCaixa = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construir e retornar o objeto ResumoEmpresaFluxoCaixa
        stockInvestSiteDto.setResumoEmpresaFluxoCaixa12Meses(StockInvestSiteDto.ResumoEmpresaFluxoCaixa12Meses.builder()
                .fluxoCaixaOperacional(fluxoCaixaOperacional)
                .fluxoCaixaInvestimentos(fluxoCaixaInvestimentos)
                .fluxoCaixaFinanciamentos(fluxoCaixaFinanciamentos)
                .aumentoReducaoCaixa(aumentoReducaoCaixa)
                .build());
    }

    private void extrairDadosResumoEmpresaFluxoCaixa3Meses(StockInvestSiteDto stockInvestSiteDto, Document documentPage) {
        // Encontrar a tabela com id "tabela_resumo_empresa_fc_3meses"
        Element table = documentPage.selectFirst("#tabela_resumo_empresa_fc_3meses");

        // Variáveis para armazenar os valores extraídos
        String fluxoCaixaOperacional = "";
        String fluxoCaixaInvestimentos = "";
        String fluxoCaixaFinanciamentos = "";
        String aumentoReducaoCaixa = "";

        try {
            if (table != null) {
                // Selecionar todas as linhas da tabela
                Elements rows = table.select("tbody tr");

                // Iterar sobre as linhas para extrair os dados
                for (Element row : rows) {
                    Elements leftCells = row.select("td.esquerda");
                    Elements rightCells = row.select("td.direita");

                    if (!leftCells.isEmpty() && !rightCells.isEmpty()) {
                        String label = leftCells.text().trim();
                        String value = rightCells.select("a").text().trim();

                        switch (label) {
                            case "Fluxo de Caixa Operacional":
                                fluxoCaixaOperacional = value;
                                break;
                            case "Fluxo de Caixa de Investimentos":
                                fluxoCaixaInvestimentos = value;
                                break;
                            case "Fluxo de Caixa de Financiamentos":
                                fluxoCaixaFinanciamentos = value;
                                break;
                            case "Aumento (Redução) de Caixa e Equivalentes":
                                aumentoReducaoCaixa = value;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construir e retornar o objeto ResumoEmpresaFluxoCaixa
        stockInvestSiteDto.setResumoEmpresaFluxoCaixa3Meses(StockInvestSiteDto.ResumoEmpresaFluxoCaixa3Meses.builder()
                .fluxoCaixaOperacional(fluxoCaixaOperacional)
                .fluxoCaixaInvestimentos(fluxoCaixaInvestimentos)
                .fluxoCaixaFinanciamentos(fluxoCaixaFinanciamentos)
                .aumentoReducaoCaixa(aumentoReducaoCaixa)
                .build());
    }

}

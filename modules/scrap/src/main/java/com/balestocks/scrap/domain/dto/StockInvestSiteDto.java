package com.balestocks.scrap.domain.dto;

import com.balestocks.scrap.domain.enums.StockEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StockInvestSiteDto {

    private StockEnum stockCode;
    private DadosBasicos dadosBasicos;
    private ResumoEmpresaPrecosRelativos resumoEmpresaPrecosRelativos;
    private ResumoEmpresaDRE12Meses resumoEmpresaDRE12Meses;
    private ResumoEmpresaDre3Meses resumoEmpresaDre3Meses;
    private ResumoEmpresaPrecos resumoEmpresaPrecos;
    private ResumoEmpresaMargensRetornos resumoEmpresaMargensRetornos;
    private ResumoEmpresaBp resumoEmpresaBp;
    private ResumoEmpresaFluxoCaixa12Meses resumoEmpresaFluxoCaixa12Meses;
    private ResumoEmpresaFluxoCaixa3Meses resumoEmpresaFluxoCaixa3Meses;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class DadosBasicos {
        private String empresa;
        private String razaoSocial;
        private String situacaoRegistro;
        private String situacaoEmissor;
        private String segmentoListagem;
        private String atividade;
        private String acao;
        private String dataCotacao;
        private String tipoAcao;
        private String ultimoFechamento;
        private String fatorCotacao;
        private String volumeFinanceiro;
        private String ultimoDemonstrativo;
        private String setor;
        private String subsetor;
        private String segmento;
        private String participacaoIndices;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaPrecosRelativos {
        private String precoLucro;
        private String precoVpa;
        private String precoReceitaLiquida;
        private String precoFco;
        private String precoFcf;
        private String precoAtivoTotal;
        private String precoEbit;
        private String precoCapitalGiro;
        private String precoNcav;
        private String evEbit;
        private String evEbitda;
        private String evReceitaLiquida;
        private String evFco;
        private String evFcf;
        private String evAtivoTotal;
        private String marketCapEmpresa;
        private String enterpriseValue;
        private String dataDemonstracaoFinanceiraAtual;
        private String precoAtualAcao;
        private String dataPrecoAcao;
        private String dividendYield;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaDRE12Meses {
        private String receitaLiquida;
        private String resultadoBruto;
        private String ebit;
        private String depreciacaoAmortizacao;
        private String ebitda;
        private String lucroLiquido;
        private String lucroAcao;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaDre3Meses {
        private String receitaLiquida;
        private String resultadoBruto;
        private String ebit;
        private String depreciacaoAmortizacao;
        private String ebitda;
        private String lucroLiquido;
        private String lucroAcao;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaPrecos {
        private String menorPreco52Semanas;
        private String maiorPreco52Semanas;
        private String variacao2024;
        private String variacao1Ano;
        private String variacao2AnosTotal;
        private String variacao2AnosAnual;
        private String variacao3AnosTotal;
        private String variacao3AnosAnual;
        private String variacao4AnosTotal;
        private String variacao4AnosAnual;
        private String variacao5AnosTotal;
        private String variacao5AnosAnual;
        private String volumeDiarioMedio3Meses;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaMargensRetornos {
        private String retornoCapitalTangivelInicial;
        private String retornoCapitalInvestidoInicial;
        private String retornoCapitalTangivelInicialPreImpostos;
        private String retornoCapitalInvestidoInicialPreImpostos;
        private String retornoPatrimonioLiquidoInicial;
        private String retornoAtivoInicial;
        private String margemBruta;
        private String margemLiquida;
        private String margemEbit;
        private String margemEbitda;
        private String giroAtivoInicial;
        private String alavancagemFinanceira;
        private String passivoPatrimonioLiquido;
        private String dividaLiquidaEbitda;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaBp {
        private String caixaEquivalentes;
        private String ativoTotal;
        private String dividaCurtoPrazo;
        private String dividaLongoPrazo;
        private String dividaBruta;
        private String dividaLiquida;
        private String patrimonioLiquido;
        private String valorPatrimonialAcao;
        private String acoesOrdinarias;
        private String acoesPreferenciais;
        private String totalAcoes;
        private String acoesOrdinariasTesouraria;
        private String acoesPreferenciaisTesouraria;
        private String totalAcoesTesouraria;
        private String acoesOrdinariasExTesouraria;
        private String acoesPreferenciaisExTesouraria;
        private String totalAcoesExTesouraria;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaFluxoCaixa12Meses {
        private String fluxoCaixaOperacional;
        private String fluxoCaixaInvestimentos;
        private String fluxoCaixaFinanciamentos;
        private String aumentoReducaoCaixa;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class ResumoEmpresaFluxoCaixa3Meses {
        private String fluxoCaixaOperacional;
        private String fluxoCaixaInvestimentos;
        private String fluxoCaixaFinanciamentos;
        private String aumentoReducaoCaixa;
    }
}



package com.balestocks.scrap.domain.mapper;

import com.balestocks.scrap.domain.dto.StockInvestSiteDto;
import com.balestocks.scrap.domain.enums.StockEnum;
import com.balestocks.scrap.entity.StockInvestSite;

import java.util.Optional;

public class InvestSiteMapper {

    public static StockInvestSite toEntity(StockInvestSiteDto dto) {
        if (dto == null) {
            return null;
        }

        StockInvestSite entity = new StockInvestSite();
        entity.setStockCode(Optional.ofNullable(dto.getStockCode()).map(Enum::name).orElse(null));

        if (dto.getDadosBasicos() != null) {
            entity.setDadosBasicosEmpresa(dto.getDadosBasicos().getEmpresa());
            entity.setDadosBasicosRazaoSocial(dto.getDadosBasicos().getRazaoSocial());
            entity.setDadosBasicosSituacaoRegistro(dto.getDadosBasicos().getSituacaoRegistro());
            entity.setDadosBasicosSituacaoEmissor(dto.getDadosBasicos().getSituacaoEmissor());
            entity.setDadosBasicosSegmentoListagem(dto.getDadosBasicos().getSegmentoListagem());
            entity.setDadosBasicosAtividade(dto.getDadosBasicos().getAtividade());
            entity.setDadosBasicosAcao(dto.getDadosBasicos().getAcao());
            entity.setDadosBasicosDataCotacao(dto.getDadosBasicos().getDataCotacao());
            entity.setDadosBasicosTipoAcao(dto.getDadosBasicos().getTipoAcao());
            entity.setDadosBasicosUltimoFechamento(dto.getDadosBasicos().getUltimoFechamento());
            entity.setDadosBasicosFatorCotacao(dto.getDadosBasicos().getFatorCotacao());
            entity.setDadosBasicosVolumeFinanceiro(dto.getDadosBasicos().getVolumeFinanceiro());
            entity.setDadosBasicosUltimoDemonstrativo(dto.getDadosBasicos().getUltimoDemonstrativo());
            entity.setDadosBasicosSetor(dto.getDadosBasicos().getSetor());
            entity.setDadosBasicosSubsetor(dto.getDadosBasicos().getSubsetor());
            entity.setDadosBasicosSegmento(dto.getDadosBasicos().getSegmento());
            entity.setDadosBasicosParticipacaoIndices(dto.getDadosBasicos().getParticipacaoIndices());
        }

        if (dto.getResumoEmpresaPrecosRelativos() != null) {
            entity.setResumoEmpresaPrecosRelativosPrecoLucro(dto.getResumoEmpresaPrecosRelativos().getPrecoLucro());
            entity.setResumoEmpresaPrecosRelativosPrecoVpa(dto.getResumoEmpresaPrecosRelativos().getPrecoVpa());
            entity.setResumoEmpresaPrecosRelativosPrecoReceitaLiquida(dto.getResumoEmpresaPrecosRelativos().getPrecoReceitaLiquida());
            entity.setResumoEmpresaPrecosRelativosPrecoFco(dto.getResumoEmpresaPrecosRelativos().getPrecoFco());
            entity.setResumoEmpresaPrecosRelativosPrecoFcf(dto.getResumoEmpresaPrecosRelativos().getPrecoFcf());
            entity.setResumoEmpresaPrecosRelativosPrecoAtivoTotal(dto.getResumoEmpresaPrecosRelativos().getPrecoAtivoTotal());
            entity.setResumoEmpresaPrecosRelativosPrecoEbit(dto.getResumoEmpresaPrecosRelativos().getPrecoEbit());
            entity.setResumoEmpresaPrecosRelativosPrecoCapitalGiro(dto.getResumoEmpresaPrecosRelativos().getPrecoCapitalGiro());
            entity.setResumoEmpresaPrecosRelativosPrecoNcav(dto.getResumoEmpresaPrecosRelativos().getPrecoNcav());
            entity.setResumoEmpresaPrecosRelativosEvEbit(dto.getResumoEmpresaPrecosRelativos().getEvEbit());
            entity.setResumoEmpresaPrecosRelativosEvEbitda(dto.getResumoEmpresaPrecosRelativos().getEvEbitda());
            entity.setResumoEmpresaPrecosRelativosEvReceitaLiquida(dto.getResumoEmpresaPrecosRelativos().getEvReceitaLiquida());
            entity.setResumoEmpresaPrecosRelativosEvFco(dto.getResumoEmpresaPrecosRelativos().getEvFco());
            entity.setResumoEmpresaPrecosRelativosEvFcf(dto.getResumoEmpresaPrecosRelativos().getEvFcf());
            entity.setResumoEmpresaPrecosRelativosEvAtivoTotal(dto.getResumoEmpresaPrecosRelativos().getEvAtivoTotal());
            entity.setResumoEmpresaPrecosRelativosMarketCapEmpresa(dto.getResumoEmpresaPrecosRelativos().getMarketCapEmpresa());
            entity.setResumoEmpresaPrecosRelativosEnterpriseValue(dto.getResumoEmpresaPrecosRelativos().getEnterpriseValue());
            entity.setResumoEmpresaPrecosRelativosDataDemonstracaoFinanceiraAtual(dto.getResumoEmpresaPrecosRelativos().getDataDemonstracaoFinanceiraAtual());
            entity.setResumoEmpresaPrecosRelativosPrecoAtualAcao(dto.getResumoEmpresaPrecosRelativos().getPrecoAtualAcao());
            entity.setResumoEmpresaPrecosRelativosDataPrecoAcao(dto.getResumoEmpresaPrecosRelativos().getDataPrecoAcao());
            entity.setResumoEmpresaPrecosRelativosDividendYield(dto.getResumoEmpresaPrecosRelativos().getDividendYield());
        }

        if (dto.getResumoEmpresaDRE12Meses() != null) {
            entity.setResumoEmpresaDre12MesesReceitaLiquida(dto.getResumoEmpresaDRE12Meses().getReceitaLiquida());
            entity.setResumoEmpresaDre12MesesResultadoBruto(dto.getResumoEmpresaDRE12Meses().getResultadoBruto());
            entity.setResumoEmpresaDre12MesesEbit(dto.getResumoEmpresaDRE12Meses().getEbit());
            entity.setResumoEmpresaDre12MesesDepreciacaoAmortizacao(dto.getResumoEmpresaDRE12Meses().getDepreciacaoAmortizacao());
            entity.setResumoEmpresaDre12MesesEbitda(dto.getResumoEmpresaDRE12Meses().getEbitda());
            entity.setResumoEmpresaDre12MesesLucroLiquido(dto.getResumoEmpresaDRE12Meses().getLucroLiquido());
            entity.setResumoEmpresaDre12MesesLucroAcao(dto.getResumoEmpresaDRE12Meses().getLucroAcao());
        }

        if (dto.getResumoEmpresaDre3Meses() != null) {
            entity.setResumoEmpresaDre3MesesReceitaLiquida(dto.getResumoEmpresaDre3Meses().getReceitaLiquida());
            entity.setResumoEmpresaDre3MesesResultadoBruto(dto.getResumoEmpresaDre3Meses().getResultadoBruto());
            entity.setResumoEmpresaDre3MesesEbit(dto.getResumoEmpresaDre3Meses().getEbit());
            entity.setResumoEmpresaDre3MesesDepreciacaoAmortizacao(dto.getResumoEmpresaDre3Meses().getDepreciacaoAmortizacao());
            entity.setResumoEmpresaDre3MesesEbitda(dto.getResumoEmpresaDre3Meses().getEbitda());
            entity.setResumoEmpresaDre3MesesLucroLiquido(dto.getResumoEmpresaDre3Meses().getLucroLiquido());
            entity.setResumoEmpresaDre3MesesLucroAcao(dto.getResumoEmpresaDre3Meses().getLucroAcao());
        }

        if (dto.getResumoEmpresaPrecos() != null) {
            entity.setResumoEmpresaPrecosMenorPreco52Semanas(dto.getResumoEmpresaPrecos().getMenorPreco52Semanas());
            entity.setResumoEmpresaPrecosMaiorPreco52Semanas(dto.getResumoEmpresaPrecos().getMaiorPreco52Semanas());
            entity.setResumoEmpresaPrecosVariacao2024(dto.getResumoEmpresaPrecos().getVariacao2024());
            entity.setResumoEmpresaPrecosVariacao1Ano(dto.getResumoEmpresaPrecos().getVariacao1Ano());
            entity.setResumoEmpresaPrecosVariacao2AnosTotal(dto.getResumoEmpresaPrecos().getVariacao2AnosTotal());
            entity.setResumoEmpresaPrecosVariacao2AnosAnual(dto.getResumoEmpresaPrecos().getVariacao2AnosAnual());
            entity.setResumoEmpresaPrecosVariacao3AnosTotal(dto.getResumoEmpresaPrecos().getVariacao3AnosTotal());
            entity.setResumoEmpresaPrecosVariacao3AnosAnual(dto.getResumoEmpresaPrecos().getVariacao3AnosAnual());
            entity.setResumoEmpresaPrecosVariacao4AnosTotal(dto.getResumoEmpresaPrecos().getVariacao4AnosTotal());
            entity.setResumoEmpresaPrecosVariacao4AnosAnual(dto.getResumoEmpresaPrecos().getVariacao4AnosAnual());
            entity.setResumoEmpresaPrecosVariacao5AnosTotal(dto.getResumoEmpresaPrecos().getVariacao5AnosTotal());
            entity.setResumoEmpresaPrecosVariacao5AnosAnual(dto.getResumoEmpresaPrecos().getVariacao5AnosAnual());
            entity.setResumoEmpresaPrecosVolumeDiarioMedio3Meses(dto.getResumoEmpresaPrecos().getVolumeDiarioMedio3Meses());
        }

        if (dto.getResumoEmpresaMargensRetornos() != null) {
            entity.setResumoEmpresaMargensRetornosRetornoCapitalTangivelInicial(dto.getResumoEmpresaMargensRetornos().getRetornoCapitalTangivelInicial());
            entity.setResumoEmpresaMargensRetornosRetornoCapitalInvestidoInicial(dto.getResumoEmpresaMargensRetornos().getRetornoCapitalInvestidoInicial());
            entity.setResumoEmpresaMargensRetornosRetornoCapitalTangivelInicialPreImpostos(dto.getResumoEmpresaMargensRetornos().getRetornoCapitalTangivelInicialPreImpostos());
            entity.setResumoEmpresaMargensRetornosRetornoCapitalInvestidoInicialPreImpostos(dto.getResumoEmpresaMargensRetornos().getRetornoCapitalInvestidoInicialPreImpostos());
            entity.setResumoEmpresaMargensRetornosRetornoPatrimonioLiquidoInicial(dto.getResumoEmpresaMargensRetornos().getRetornoPatrimonioLiquidoInicial());
            entity.setResumoEmpresaMargensRetornosRetornoAtivoInicial(dto.getResumoEmpresaMargensRetornos().getRetornoAtivoInicial());
            entity.setResumoEmpresaMargensRetornosMargemBruta(dto.getResumoEmpresaMargensRetornos().getMargemBruta());
            entity.setResumoEmpresaMargensRetornosMargemLiquida(dto.getResumoEmpresaMargensRetornos().getMargemLiquida());
            entity.setResumoEmpresaMargensRetornosMargemEbit(dto.getResumoEmpresaMargensRetornos().getMargemEbit());
            entity.setResumoEmpresaMargensRetornosMargemEbitda(dto.getResumoEmpresaMargensRetornos().getMargemEbitda());
            entity.setResumoEmpresaMargensRetornosGiroAtivoInicial(dto.getResumoEmpresaMargensRetornos().getGiroAtivoInicial());
            entity.setResumoEmpresaMargensRetornosAlavancagemFinanceira(dto.getResumoEmpresaMargensRetornos().getAlavancagemFinanceira());
            entity.setResumoEmpresaMargensRetornosPassivoPatrimonioLiquido(dto.getResumoEmpresaMargensRetornos().getPassivoPatrimonioLiquido());
            entity.setResumoEmpresaMargensRetornosDividaLiquidaEbitda(dto.getResumoEmpresaMargensRetornos().getDividaLiquidaEbitda());
        }

        if (dto.getResumoEmpresaBp() != null) {
            entity.setResumoEmpresaBpCaixaEquivalentes(dto.getResumoEmpresaBp().getCaixaEquivalentes());
            entity.setResumoEmpresaBpAtivoTotal(dto.getResumoEmpresaBp().getAtivoTotal());
            entity.setResumoEmpresaBpDividaCurtoPrazo(dto.getResumoEmpresaBp().getDividaCurtoPrazo());
            entity.setResumoEmpresaBpDividaLongoPrazo(dto.getResumoEmpresaBp().getDividaLongoPrazo());
            entity.setResumoEmpresaBpDividaBruta(dto.getResumoEmpresaBp().getDividaBruta());
            entity.setResumoEmpresaBpDividaLiquida(dto.getResumoEmpresaBp().getDividaLiquida());
            entity.setResumoEmpresaBpPatrimonioLiquido(dto.getResumoEmpresaBp().getPatrimonioLiquido());
            entity.setResumoEmpresaBpValorPatrimonialAcao(dto.getResumoEmpresaBp().getValorPatrimonialAcao());
            entity.setResumoEmpresaBpAcoesOrdinarias(dto.getResumoEmpresaBp().getAcoesOrdinarias());
            entity.setResumoEmpresaBpAcoesPreferenciais(dto.getResumoEmpresaBp().getAcoesPreferenciais());
            entity.setResumoEmpresaBpTotalAcoes(dto.getResumoEmpresaBp().getTotalAcoes());
            entity.setResumoEmpresaBpAcoesOrdinariasTesouraria(dto.getResumoEmpresaBp().getAcoesOrdinariasTesouraria());
            entity.setResumoEmpresaBpAcoesPreferenciaisTesouraria(dto.getResumoEmpresaBp().getAcoesPreferenciaisTesouraria());
            entity.setResumoEmpresaBpTotalAcoesTesouraria(dto.getResumoEmpresaBp().getTotalAcoesTesouraria());
            entity.setResumoEmpresaBpAcoesOrdinariasExTesouraria(dto.getResumoEmpresaBp().getAcoesOrdinariasExTesouraria());
            entity.setResumoEmpresaBpAcoesPreferenciaisExTesouraria(dto.getResumoEmpresaBp().getAcoesPreferenciaisExTesouraria());
            entity.setResumoEmpresaBpTotalAcoesExTesouraria(dto.getResumoEmpresaBp().getTotalAcoesExTesouraria());
        }

        if (dto.getResumoEmpresaFluxoCaixa12Meses() != null) {
            entity.setResumoEmpresaFluxoCaixa12MesesFluxoCaixaOperacional(dto.getResumoEmpresaFluxoCaixa12Meses().getFluxoCaixaOperacional());
            entity.setResumoEmpresaFluxoCaixa12MesesFluxoCaixaInvestimentos(dto.getResumoEmpresaFluxoCaixa12Meses().getFluxoCaixaInvestimentos());
            entity.setResumoEmpresaFluxoCaixa12MesesFluxoCaixaFinanciamentos(dto.getResumoEmpresaFluxoCaixa12Meses().getFluxoCaixaFinanciamentos());
            entity.setResumoEmpresaFluxoCaixa12MesesAumentoReducaoCaixa(dto.getResumoEmpresaFluxoCaixa12Meses().getAumentoReducaoCaixa());
        }

        if (dto.getResumoEmpresaFluxoCaixa3Meses() != null) {
            entity.setResumoEmpresaFluxoCaixa3MesesFluxoCaixaOperacional(dto.getResumoEmpresaFluxoCaixa3Meses().getFluxoCaixaOperacional());
            entity.setResumoEmpresaFluxoCaixa3MesesFluxoCaixaInvestimentos(dto.getResumoEmpresaFluxoCaixa3Meses().getFluxoCaixaInvestimentos());
            entity.setResumoEmpresaFluxoCaixa3MesesFluxoCaixaFinanciamentos(dto.getResumoEmpresaFluxoCaixa3Meses().getFluxoCaixaFinanciamentos());
            entity.setResumoEmpresaFluxoCaixa3MesesAumentoReducaoCaixa(dto.getResumoEmpresaFluxoCaixa3Meses().getAumentoReducaoCaixa());
        }

        return entity;
    }

    public static StockInvestSiteDto toDto(StockInvestSite entity) {
        if (entity == null) {
            return null;
        }

        return StockInvestSiteDto.builder()
                .stockCode(Optional.ofNullable(entity.getStockCode()).map(StockEnum::valueOf).orElse(null))
                .dadosBasicos(StockInvestSiteDto.DadosBasicos.builder()
                        .empresa(entity.getDadosBasicosEmpresa())
                        .razaoSocial(entity.getDadosBasicosRazaoSocial())
                        .situacaoRegistro(entity.getDadosBasicosSituacaoRegistro())
                        .situacaoEmissor(entity.getDadosBasicosSituacaoEmissor())
                        .segmentoListagem(entity.getDadosBasicosSegmentoListagem())
                        .atividade(entity.getDadosBasicosAtividade())
                        .acao(entity.getDadosBasicosAcao())
                        .dataCotacao(entity.getDadosBasicosDataCotacao())
                        .tipoAcao(entity.getDadosBasicosTipoAcao())
                        .ultimoFechamento(entity.getDadosBasicosUltimoFechamento())
                        .fatorCotacao(entity.getDadosBasicosFatorCotacao())
                        .volumeFinanceiro(entity.getDadosBasicosVolumeFinanceiro())
                        .ultimoDemonstrativo(entity.getDadosBasicosUltimoDemonstrativo())
                        .setor(entity.getDadosBasicosSetor())
                        .subsetor(entity.getDadosBasicosSubsetor())
                        .segmento(entity.getDadosBasicosSegmento())
                        .participacaoIndices(entity.getDadosBasicosParticipacaoIndices())
                        .build())
                .resumoEmpresaPrecosRelativos(StockInvestSiteDto.ResumoEmpresaPrecosRelativos.builder()
                        .precoLucro(entity.getResumoEmpresaPrecosRelativosPrecoLucro())
                        .precoVpa(entity.getResumoEmpresaPrecosRelativosPrecoVpa())
                        .precoReceitaLiquida(entity.getResumoEmpresaPrecosRelativosPrecoReceitaLiquida())
                        .precoFco(entity.getResumoEmpresaPrecosRelativosPrecoFco())
                        .precoFcf(entity.getResumoEmpresaPrecosRelativosPrecoFcf())
                        .precoAtivoTotal(entity.getResumoEmpresaPrecosRelativosPrecoAtivoTotal())
                        .precoEbit(entity.getResumoEmpresaPrecosRelativosPrecoEbit())
                        .precoCapitalGiro(entity.getResumoEmpresaPrecosRelativosPrecoCapitalGiro())
                        .precoNcav(entity.getResumoEmpresaPrecosRelativosPrecoNcav())
                        .evEbit(entity.getResumoEmpresaPrecosRelativosEvEbit())
                        .evEbitda(entity.getResumoEmpresaPrecosRelativosEvEbitda())
                        .evReceitaLiquida(entity.getResumoEmpresaPrecosRelativosEvReceitaLiquida())
                        .evFco(entity.getResumoEmpresaPrecosRelativosEvFco())
                        .evFcf(entity.getResumoEmpresaPrecosRelativosEvFcf())
                        .evAtivoTotal(entity.getResumoEmpresaPrecosRelativosEvAtivoTotal())
                        .marketCapEmpresa(entity.getResumoEmpresaPrecosRelativosMarketCapEmpresa())
                        .enterpriseValue(entity.getResumoEmpresaPrecosRelativosEnterpriseValue())
                        .dataDemonstracaoFinanceiraAtual(entity.getResumoEmpresaPrecosRelativosDataDemonstracaoFinanceiraAtual())
                        .precoAtualAcao(entity.getResumoEmpresaPrecosRelativosPrecoAtualAcao())
                        .dataPrecoAcao(entity.getResumoEmpresaPrecosRelativosDataPrecoAcao())
                        .dividendYield(entity.getResumoEmpresaPrecosRelativosDividendYield())
                        .build())
                .resumoEmpresaDRE12Meses(StockInvestSiteDto.ResumoEmpresaDRE12Meses.builder()
                        .receitaLiquida(entity.getResumoEmpresaDre12MesesReceitaLiquida())
                        .resultadoBruto(entity.getResumoEmpresaDre12MesesResultadoBruto())
                        .ebit(entity.getResumoEmpresaDre12MesesEbit())
                        .depreciacaoAmortizacao(entity.getResumoEmpresaDre12MesesDepreciacaoAmortizacao())
                        .ebitda(entity.getResumoEmpresaDre12MesesEbitda())
                        .lucroLiquido(entity.getResumoEmpresaDre12MesesLucroLiquido())
                        .lucroAcao(entity.getResumoEmpresaDre12MesesLucroAcao())
                        .build())
                .resumoEmpresaDre3Meses(StockInvestSiteDto.ResumoEmpresaDre3Meses.builder()
                        .receitaLiquida(entity.getResumoEmpresaDre3MesesReceitaLiquida())
                        .resultadoBruto(entity.getResumoEmpresaDre3MesesResultadoBruto())
                        .ebit(entity.getResumoEmpresaDre3MesesEbit())
                        .depreciacaoAmortizacao(entity.getResumoEmpresaDre3MesesDepreciacaoAmortizacao())
                        .ebitda(entity.getResumoEmpresaDre3MesesEbitda())
                        .lucroLiquido(entity.getResumoEmpresaDre3MesesLucroLiquido())
                        .lucroAcao(entity.getResumoEmpresaDre3MesesLucroAcao())
                        .build())
                .resumoEmpresaPrecos(StockInvestSiteDto.ResumoEmpresaPrecos.builder()
                        .menorPreco52Semanas(entity.getResumoEmpresaPrecosMenorPreco52Semanas())
                        .maiorPreco52Semanas(entity.getResumoEmpresaPrecosMaiorPreco52Semanas())
                        .variacao2024(entity.getResumoEmpresaPrecosVariacao2024())
                        .variacao1Ano(entity.getResumoEmpresaPrecosVariacao1Ano())
                        .variacao2AnosTotal(entity.getResumoEmpresaPrecosVariacao2AnosTotal())
                        .variacao2AnosAnual(entity.getResumoEmpresaPrecosVariacao2AnosAnual())
                        .variacao3AnosTotal(entity.getResumoEmpresaPrecosVariacao3AnosTotal())
                        .variacao3AnosAnual(entity.getResumoEmpresaPrecosVariacao3AnosAnual())
                        .variacao4AnosTotal(entity.getResumoEmpresaPrecosVariacao4AnosTotal())
                        .variacao4AnosAnual(entity.getResumoEmpresaPrecosVariacao4AnosAnual())
                        .variacao5AnosTotal(entity.getResumoEmpresaPrecosVariacao5AnosTotal())
                        .variacao5AnosAnual(entity.getResumoEmpresaPrecosVariacao5AnosAnual())
                        .volumeDiarioMedio3Meses(entity.getResumoEmpresaPrecosVolumeDiarioMedio3Meses())
                        .build())
                .resumoEmpresaMargensRetornos(StockInvestSiteDto.ResumoEmpresaMargensRetornos.builder()
                        .retornoCapitalTangivelInicial(entity.getResumoEmpresaMargensRetornosRetornoCapitalTangivelInicial())
                        .retornoCapitalInvestidoInicial(entity.getResumoEmpresaMargensRetornosRetornoCapitalInvestidoInicial())
                        .retornoCapitalTangivelInicialPreImpostos(entity.getResumoEmpresaMargensRetornosRetornoCapitalTangivelInicialPreImpostos())
                        .retornoCapitalInvestidoInicialPreImpostos(entity.getResumoEmpresaMargensRetornosRetornoCapitalInvestidoInicialPreImpostos())
                        .retornoPatrimonioLiquidoInicial(entity.getResumoEmpresaMargensRetornosRetornoPatrimonioLiquidoInicial())
                        .retornoAtivoInicial(entity.getResumoEmpresaMargensRetornosRetornoAtivoInicial())
                        .margemBruta(entity.getResumoEmpresaMargensRetornosMargemBruta())
                        .margemLiquida(entity.getResumoEmpresaMargensRetornosMargemLiquida())
                        .margemEbit(entity.getResumoEmpresaMargensRetornosMargemEbit())
                        .margemEbitda(entity.getResumoEmpresaMargensRetornosMargemEbitda())
                        .giroAtivoInicial(entity.getResumoEmpresaMargensRetornosGiroAtivoInicial())
                        .alavancagemFinanceira(entity.getResumoEmpresaMargensRetornosAlavancagemFinanceira())
                        .passivoPatrimonioLiquido(entity.getResumoEmpresaMargensRetornosPassivoPatrimonioLiquido())
                        .dividaLiquidaEbitda(entity.getResumoEmpresaMargensRetornosDividaLiquidaEbitda())
                        .build())
                .resumoEmpresaBp(StockInvestSiteDto.ResumoEmpresaBp.builder()
                        .caixaEquivalentes(entity.getResumoEmpresaBpCaixaEquivalentes())
                        .ativoTotal(entity.getResumoEmpresaBpAtivoTotal())
                        .dividaCurtoPrazo(entity.getResumoEmpresaBpDividaCurtoPrazo())
                        .dividaLongoPrazo(entity.getResumoEmpresaBpDividaLongoPrazo())
                        .dividaBruta(entity.getResumoEmpresaBpDividaBruta())
                        .dividaLiquida(entity.getResumoEmpresaBpDividaLiquida())
                        .patrimonioLiquido(entity.getResumoEmpresaBpPatrimonioLiquido())
                        .valorPatrimonialAcao(entity.getResumoEmpresaBpValorPatrimonialAcao())
                        .acoesOrdinarias(entity.getResumoEmpresaBpAcoesOrdinarias())
                        .acoesPreferenciais(entity.getResumoEmpresaBpAcoesPreferenciais())
                        .totalAcoes(entity.getResumoEmpresaBpTotalAcoes())
                        .acoesOrdinariasTesouraria(entity.getResumoEmpresaBpAcoesOrdinariasTesouraria())
                        .acoesPreferenciaisTesouraria(entity.getResumoEmpresaBpAcoesPreferenciaisTesouraria())
                        .totalAcoesTesouraria(entity.getResumoEmpresaBpTotalAcoesTesouraria())
                        .acoesOrdinariasExTesouraria(entity.getResumoEmpresaBpAcoesOrdinariasExTesouraria())
                        .acoesPreferenciaisExTesouraria(entity.getResumoEmpresaBpAcoesPreferenciaisExTesouraria())
                        .totalAcoesExTesouraria(entity.getResumoEmpresaBpTotalAcoesExTesouraria())
                        .build())
                .resumoEmpresaFluxoCaixa12Meses(StockInvestSiteDto.ResumoEmpresaFluxoCaixa12Meses.builder()
                        .fluxoCaixaOperacional(entity.getResumoEmpresaFluxoCaixa12MesesFluxoCaixaOperacional())
                        .fluxoCaixaInvestimentos(entity.getResumoEmpresaFluxoCaixa12MesesFluxoCaixaInvestimentos())
                        .fluxoCaixaFinanciamentos(entity.getResumoEmpresaFluxoCaixa12MesesFluxoCaixaFinanciamentos())
                        .aumentoReducaoCaixa(entity.getResumoEmpresaFluxoCaixa12MesesAumentoReducaoCaixa())
                        .build())
                .resumoEmpresaFluxoCaixa3Meses(StockInvestSiteDto.ResumoEmpresaFluxoCaixa3Meses.builder()
                        .fluxoCaixaOperacional(entity.getResumoEmpresaFluxoCaixa3MesesFluxoCaixaOperacional())
                        .fluxoCaixaInvestimentos(entity.getResumoEmpresaFluxoCaixa3MesesFluxoCaixaInvestimentos())
                        .fluxoCaixaFinanciamentos(entity.getResumoEmpresaFluxoCaixa3MesesFluxoCaixaFinanciamentos())
                        .aumentoReducaoCaixa(entity.getResumoEmpresaFluxoCaixa3MesesAumentoReducaoCaixa())
                        .build())
                .build();
    }
}

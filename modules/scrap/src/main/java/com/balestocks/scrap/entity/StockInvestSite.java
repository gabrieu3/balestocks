package com.balestocks.scrap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "STOCK_INVEST_SITE")
public class StockInvestSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "dados_basicos_empresa")
    private String dadosBasicosEmpresa;

    @Column(name = "dados_basicos_razao_social")
    private String dadosBasicosRazaoSocial;

    @Column(name = "dados_basicos_situacao_registro")
    private String dadosBasicosSituacaoRegistro;

    @Column(name = "dados_basicos_situacao_emissor")
    private String dadosBasicosSituacaoEmissor;

    @Column(name = "dados_basicos_segmento_listagem")
    private String dadosBasicosSegmentoListagem;

    @Column(name = "dados_basicos_atividade")
    private String dadosBasicosAtividade;

    @Column(name = "dados_basicos_acao")
    private String dadosBasicosAcao;

    @Column(name = "dados_basicos_data_cotacao")
    private String dadosBasicosDataCotacao;

    @Column(name = "dados_basicos_tipo_acao")
    private String dadosBasicosTipoAcao;

    @Column(name = "dados_basicos_ultimo_fechamento")
    private String dadosBasicosUltimoFechamento;

    @Column(name = "dados_basicos_fator_cotacao")
    private String dadosBasicosFatorCotacao;

    @Column(name = "dados_basicos_volume_financeiro")
    private String dadosBasicosVolumeFinanceiro;

    @Column(name = "dados_basicos_ultimo_demonstrativo")
    private String dadosBasicosUltimoDemonstrativo;

    @Column(name = "dados_basicos_setor")
    private String dadosBasicosSetor;

    @Column(name = "dados_basicos_subsetor")
    private String dadosBasicosSubsetor;

    @Column(name = "dados_basicos_segmento")
    private String dadosBasicosSegmento;

    @Column(name = "dados_basicos_participacao_indices")
    private String dadosBasicosParticipacaoIndices;

    @Column(name = "resumo_empresa_precos_relativos_preco_lucro")
    private String resumoEmpresaPrecosRelativosPrecoLucro;

    @Column(name = "resumo_empresa_precos_relativos_preco_vpa")
    private String resumoEmpresaPrecosRelativosPrecoVpa;

    @Column(name = "resumo_empresa_precos_relativos_preco_receita_liquida")
    private String resumoEmpresaPrecosRelativosPrecoReceitaLiquida;

    @Column(name = "resumo_empresa_precos_relativos_preco_fco")
    private String resumoEmpresaPrecosRelativosPrecoFco;

    @Column(name = "resumo_empresa_precos_relativos_preco_fcf")
    private String resumoEmpresaPrecosRelativosPrecoFcf;

    @Column(name = "resumo_empresa_precos_relativos_preco_ativo_total")
    private String resumoEmpresaPrecosRelativosPrecoAtivoTotal;

    @Column(name = "resumo_empresa_precos_relativos_preco_ebit")
    private String resumoEmpresaPrecosRelativosPrecoEbit;

    @Column(name = "resumo_empresa_precos_relativos_preco_capital_giro")
    private String resumoEmpresaPrecosRelativosPrecoCapitalGiro;

    @Column(name = "resumo_empresa_precos_relativos_preco_ncav")
    private String resumoEmpresaPrecosRelativosPrecoNcav;

    @Column(name = "resumo_empresa_precos_relativos_ev_ebit")
    private String resumoEmpresaPrecosRelativosEvEbit;

    @Column(name = "resumo_empresa_precos_relativos_ev_ebitda")
    private String resumoEmpresaPrecosRelativosEvEbitda;

    @Column(name = "resumo_empresa_precos_relativos_ev_receita_liquida")
    private String resumoEmpresaPrecosRelativosEvReceitaLiquida;

    @Column(name = "resumo_empresa_precos_relativos_ev_fco")
    private String resumoEmpresaPrecosRelativosEvFco;

    @Column(name = "resumo_empresa_precos_relativos_ev_fcf")
    private String resumoEmpresaPrecosRelativosEvFcf;

    @Column(name = "resumo_empresa_precos_relativos_ev_ativo_total")
    private String resumoEmpresaPrecosRelativosEvAtivoTotal;

    @Column(name = "resumo_empresa_precos_relativos_market_cap_empresa")
    private String resumoEmpresaPrecosRelativosMarketCapEmpresa;

    @Column(name = "resumo_empresa_precos_relativos_enterprise_value")
    private String resumoEmpresaPrecosRelativosEnterpriseValue;

    @Column(name = "resumo_empresa_precos_relativos_data_demonstracao_financeira_atual")
    private String resumoEmpresaPrecosRelativosDataDemonstracaoFinanceiraAtual;

    @Column(name = "resumo_empresa_precos_relativos_preco_atual_acao")
    private String resumoEmpresaPrecosRelativosPrecoAtualAcao;

    @Column(name = "resumo_empresa_precos_relativos_data_preco_acao")
    private String resumoEmpresaPrecosRelativosDataPrecoAcao;

    @Column(name = "resumo_empresa_precos_relativos_dividend_yield")
    private String resumoEmpresaPrecosRelativosDividendYield;

    @Column(name = "resumo_empresa_dre12_meses_receita_liquida")
    private String resumoEmpresaDre12MesesReceitaLiquida;

    @Column(name = "resumo_empresa_dre12_meses_resultado_bruto")
    private String resumoEmpresaDre12MesesResultadoBruto;

    @Column(name = "resumo_empresa_dre12_meses_ebit")
    private String resumoEmpresaDre12MesesEbit;

    @Column(name = "resumo_empresa_dre12_meses_depreciacao_amortizacao")
    private String resumoEmpresaDre12MesesDepreciacaoAmortizacao;

    @Column(name = "resumo_empresa_dre12_meses_ebitda")
    private String resumoEmpresaDre12MesesEbitda;

    @Column(name = "resumo_empresa_dre12_meses_lucro_liquido")
    private String resumoEmpresaDre12MesesLucroLiquido;

    @Column(name = "resumo_empresa_dre12_meses_lucro_acao")
    private String resumoEmpresaDre12MesesLucroAcao;

    @Column(name = "resumo_empresa_dre3_meses_receita_liquida")
    private String resumoEmpresaDre3MesesReceitaLiquida;

    @Column(name = "resumo_empresa_dre3_meses_resultado_bruto")
    private String resumoEmpresaDre3MesesResultadoBruto;

    @Column(name = "resumo_empresa_dre3_meses_ebit")
    private String resumoEmpresaDre3MesesEbit;

    @Column(name = "resumo_empresa_dre3_meses_depreciacao_amortizacao")
    private String resumoEmpresaDre3MesesDepreciacaoAmortizacao;

    @Column(name = "resumo_empresa_dre3_meses_ebitda")
    private String resumoEmpresaDre3MesesEbitda;

    @Column(name = "resumo_empresa_dre3_meses_lucro_liquido")
    private String resumoEmpresaDre3MesesLucroLiquido;

    @Column(name = "resumo_empresa_dre3_meses_lucro_acao")
    private String resumoEmpresaDre3MesesLucroAcao;

    @Column(name = "resumo_empresa_precos_menor_preco_52_semanas")
    private String resumoEmpresaPrecosMenorPreco52Semanas;

    @Column(name = "resumo_empresa_precos_maior_preco_52_semanas")
    private String resumoEmpresaPrecosMaiorPreco52Semanas;

    @Column(name = "resumo_empresa_precos_variacao_2024")
    private String resumoEmpresaPrecosVariacao2024;

    @Column(name = "resumo_empresa_precos_variacao_1_ano")
    private String resumoEmpresaPrecosVariacao1Ano;

    @Column(name = "resumo_empresa_precos_variacao_2_anos_total")
    private String resumoEmpresaPrecosVariacao2AnosTotal;

    @Column(name = "resumo_empresa_precos_variacao_2_anos_anual")
    private String resumoEmpresaPrecosVariacao2AnosAnual;

    @Column(name = "resumo_empresa_precos_variacao_3_anos_total")
    private String resumoEmpresaPrecosVariacao3AnosTotal;

    @Column(name = "resumo_empresa_precos_variacao_3_anos_anual")
    private String resumoEmpresaPrecosVariacao3AnosAnual;

    @Column(name = "resumo_empresa_precos_variacao_4_anos_total")
    private String resumoEmpresaPrecosVariacao4AnosTotal;

    @Column(name = "resumo_empresa_precos_variacao_4_anos_anual")
    private String resumoEmpresaPrecosVariacao4AnosAnual;

    @Column(name = "resumo_empresa_precos_variacao_5_anos_total")
    private String resumoEmpresaPrecosVariacao5AnosTotal;

    @Column(name = "resumo_empresa_precos_variacao_5_anos_anual")
    private String resumoEmpresaPrecosVariacao5AnosAnual;

    @Column(name = "resumo_empresa_precos_volume_diario_medio_3_meses")
    private String resumoEmpresaPrecosVolumeDiarioMedio3Meses;

    @Column(name = "resumo_empresa_margens_retornos_retorno_capital_tangivel_inicial")
    private String resumoEmpresaMargensRetornosRetornoCapitalTangivelInicial;

    @Column(name = "resumo_empresa_margens_retornos_retorno_capital_investido_inicial")
    private String resumoEmpresaMargensRetornosRetornoCapitalInvestidoInicial;

    @Column(name = "resumo_empresa_margens_retornos_retorno_capital_tangivel_inicial_pre_impostos")
    private String resumoEmpresaMargensRetornosRetornoCapitalTangivelInicialPreImpostos;

    @Column(name = "resumo_empresa_margens_retornos_retorno_capital_investido_inicial_pre_impostos")
    private String resumoEmpresaMargensRetornosRetornoCapitalInvestidoInicialPreImpostos;

    @Column(name = "resumo_empresa_margens_retornos_retorno_patrimonio_liquido_inicial")
    private String resumoEmpresaMargensRetornosRetornoPatrimonioLiquidoInicial;

    @Column(name = "resumo_empresa_margens_retornos_retorno_ativo_inicial")
    private String resumoEmpresaMargensRetornosRetornoAtivoInicial;

    @Column(name = "resumo_empresa_margens_retornos_margem_bruta")
    private String resumoEmpresaMargensRetornosMargemBruta;

    @Column(name = "resumo_empresa_margens_retornos_margem_liquida")
    private String resumoEmpresaMargensRetornosMargemLiquida;

    @Column(name = "resumo_empresa_margens_retornos_margem_ebit")
    private String resumoEmpresaMargensRetornosMargemEbit;

    @Column(name = "resumo_empresa_margens_retornos_margem_ebitda")
    private String resumoEmpresaMargensRetornosMargemEbitda;

    @Column(name = "resumo_empresa_margens_retornos_giro_ativo_inicial")
    private String resumoEmpresaMargensRetornosGiroAtivoInicial;

    @Column(name = "resumo_empresa_margens_retornos_alavancagem_financeira")
    private String resumoEmpresaMargensRetornosAlavancagemFinanceira;

    @Column(name = "resumo_empresa_margens_retornos_passivo_patrimonio_liquido")
    private String resumoEmpresaMargensRetornosPassivoPatrimonioLiquido;

    @Column(name = "resumo_empresa_margens_retornos_divida_liquida_ebitda")
    private String resumoEmpresaMargensRetornosDividaLiquidaEbitda;

    @Column(name = "resumo_empresa_bp_caixa_equivalentes")
    private String resumoEmpresaBpCaixaEquivalentes;

    @Column(name = "resumo_empresa_bp_ativo_total")
    private String resumoEmpresaBpAtivoTotal;

    @Column(name = "resumo_empresa_bp_divida_curto_prazo")
    private String resumoEmpresaBpDividaCurtoPrazo;

    @Column(name = "resumo_empresa_bp_divida_longo_prazo")
    private String resumoEmpresaBpDividaLongoPrazo;

    @Column(name = "resumo_empresa_bp_divida_bruta")
    private String resumoEmpresaBpDividaBruta;

    @Column(name = "resumo_empresa_bp_divida_liquida")
    private String resumoEmpresaBpDividaLiquida;

    @Column(name = "resumo_empresa_bp_patrimonio_liquido")
    private String resumoEmpresaBpPatrimonioLiquido;

    @Column(name = "resumo_empresa_bp_valor_patrimonial_acao")
    private String resumoEmpresaBpValorPatrimonialAcao;

    @Column(name = "resumo_empresa_bp_acoes_ordinarias")
    private String resumoEmpresaBpAcoesOrdinarias;

    @Column(name = "resumo_empresa_bp_acoes_preferenciais")
    private String resumoEmpresaBpAcoesPreferenciais;

    @Column(name = "resumo_empresa_bp_total_acoes")
    private String resumoEmpresaBpTotalAcoes;

    @Column(name = "resumo_empresa_bp_acoes_ordinarias_tesouraria")
    private String resumoEmpresaBpAcoesOrdinariasTesouraria;

    @Column(name = "resumo_empresa_bp_acoes_preferenciais_tesouraria")
    private String resumoEmpresaBpAcoesPreferenciaisTesouraria;

    @Column(name = "resumo_empresa_bp_total_acoes_tesouraria")
    private String resumoEmpresaBpTotalAcoesTesouraria;

    @Column(name = "resumo_empresa_bp_acoes_ordinarias_ex_tesouraria")
    private String resumoEmpresaBpAcoesOrdinariasExTesouraria;

    @Column(name = "resumo_empresa_bp_acoes_preferenciais_ex_tesouraria")
    private String resumoEmpresaBpAcoesPreferenciaisExTesouraria;

    @Column(name = "resumo_empresa_bp_total_acoes_ex_tesouraria")
    private String resumoEmpresaBpTotalAcoesExTesouraria;

    @Column(name = "resumo_empresa_fluxo_caixa_12_meses_fluxo_caixa_operacional")
    private String resumoEmpresaFluxoCaixa12MesesFluxoCaixaOperacional;

    @Column(name = "resumo_empresa_fluxo_caixa_12_meses_fluxo_caixa_investimentos")
    private String resumoEmpresaFluxoCaixa12MesesFluxoCaixaInvestimentos;

    @Column(name = "resumo_empresa_fluxo_caixa_12_meses_fluxo_caixa_financiamentos")
    private String resumoEmpresaFluxoCaixa12MesesFluxoCaixaFinanciamentos;

    @Column(name = "resumo_empresa_fluxo_caixa_12_meses_aumento_reducao_caixa")
    private String resumoEmpresaFluxoCaixa12MesesAumentoReducaoCaixa;

    @Column(name = "resumo_empresa_fluxo_caixa_3_meses_fluxo_caixa_operacional")
    private String resumoEmpresaFluxoCaixa3MesesFluxoCaixaOperacional;

    @Column(name = "resumo_empresa_fluxo_caixa_3_meses_fluxo_caixa_investimentos")
    private String resumoEmpresaFluxoCaixa3MesesFluxoCaixaInvestimentos;

    @Column(name = "resumo_empresa_fluxo_caixa_3_meses_fluxo_caixa_financiamentos")
    private String resumoEmpresaFluxoCaixa3MesesFluxoCaixaFinanciamentos;

    @Column(name = "resumo_empresa_fluxo_caixa_3_meses_aumento_reducao_caixa")
    private String resumoEmpresaFluxoCaixa3MesesAumentoReducaoCaixa;

}

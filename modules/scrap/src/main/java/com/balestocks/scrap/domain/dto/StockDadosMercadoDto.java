package com.balestocks.scrap.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class StockDadosMercadoDto {
    private String stockCode;
    private String stockCompanyName;
    private Integer quantityBusiness;
    private BigDecimal value;
    private String valueVariation;
}


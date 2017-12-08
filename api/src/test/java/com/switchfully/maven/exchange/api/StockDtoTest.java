package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.domain.StockCurrency;
import com.switchfully.maven.exchange.domain.StockPrice;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static com.switchfully.maven.exchange.domain.StockCurrency.EUR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class StockDtoTest {

    @Test
    public void toStockDto_givenEnrichedStock_thenMapAllDataToStockDto()  {
        Stock stock = new Stock("ABC", "AyBeCe");
        stock.setPrice(new StockPrice(new BigDecimal(10), EUR));

        StockDto stockDto = StockDto.toStockDto(stock);

        assertThat(stockDto.getId()).isEqualTo("ABC");
        assertThat(stockDto.getName()).isEqualTo("AyBeCe");
        assertThat(stockDto.getPrice()).isEqualTo(new BigDecimal(10));
        assertThat(stockDto.getCurrency()).isEqualTo(EUR.getLabel());
    }

    @Test
    public void toStockDto_givenUnknownStockWithoutPrice_thenMapIdAndNameToStockDto()  {
        Stock stock = new Stock("ABC", "AyBeCe");

        StockDto stockDto = StockDto.toStockDto(stock);

        assertThat(stockDto.getId()).isEqualTo("ABC");
        assertThat(stockDto.getName()).isEqualTo("AyBeCe");
        assertThat(stockDto.getPrice()).isEqualTo(new BigDecimal(0));
        assertThat(stockDto.getCurrency()).isEqualTo("Unknown");
    }

}
package com.switchfully.maven.exchange.service;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.domain.StockCurrency;
import com.switchfully.maven.exchange.domain.StockPrice;
import com.switchfully.maven.exchange.domain.StockRepository;
import com.switchfully.maven.exchange.interfaces.ExternalStockInformationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class StockService {

    private final static Logger LOGGER = Logger.getLogger(StockService.class.getName());

    public Stock getStock(String stockId) {
        try {
            Stock stockWithoutPrice = StockRepository.getStockInformation(stockId);
            return enrichtStockWithPrice(stockWithoutPrice);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return new Stock(stockId, "Unknown stock");
        }
    }

    private Stock enrichtStockWithPrice(Stock stock) {
        BigDecimal priceInEuroForStock = ExternalStockInformationService
                .getPriceInEuroForStock(stock.getId());
        stock.setPrice(new StockPrice(priceInEuroForStock, StockCurrency.EUR));
        return stock;
    }
}

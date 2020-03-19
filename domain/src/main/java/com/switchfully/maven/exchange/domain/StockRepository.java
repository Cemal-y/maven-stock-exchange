package com.switchfully.maven.exchange.domain;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StockRepository {

    private static HashMap<String, Stock> stockDatabase =
            Maps.newHashMap(
                    new ImmutableMap.Builder<String, Stock>()
                            .put("AA", new Stock("AA", "Ambro AN"))
                            .put("BB", new Stock("BB", "Brumbo"))
                            .put("XND", new Stock("XND", "Xendo"))
                            .put("GL", new Stock("GL", "Golden Inc."))
                            .build()
            );

    public static Stock getStockInformation(String stockId) throws IllegalArgumentException{
        if(stockDatabase.containsKey(stockId)) {
            return stockDatabase.get(stockId);
        } else {
            throw new IllegalArgumentException(String.format("No stock found for id:%s", stockId));
        }
    }

}

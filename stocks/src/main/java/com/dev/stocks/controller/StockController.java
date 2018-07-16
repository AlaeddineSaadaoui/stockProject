package com.dev.stocks.controller;

import com.dev.stocks.dto.JsonDto;
import com.dev.stocks.entity.StockEntity;
import com.dev.stocks.entity.SymbolEntity;
import com.dev.stocks.model.StockStats;
import com.dev.stocks.service.StockService;
import com.dev.stocks.service.SymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private SymbolService symbolService;

    @PostMapping("/load")
    public String load() throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<JsonDto>> stockTypeReference = new TypeReference<List<JsonDto>>() {
        };
        Map<String, SymbolEntity> symbolMap = new HashMap<>();
        List<StockEntity> stockEntityList = new ArrayList<>();
        //InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stocks.json");
        try {
            URL jsonURL = new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json");
            InputStream inputStream = jsonURL.openStream();
            List<JsonDto> stockDtoList = mapper.readValue(inputStream, stockTypeReference);
            for (JsonDto stockDto : stockDtoList) {
                if (!symbolMap.containsKey(stockDto.getSymbol()))
                    symbolMap.put(stockDto.getSymbol(), new SymbolEntity(stockDto.getSymbol()));
                stockEntityList.add(new StockEntity(symbolMap.get(stockDto.getSymbol()), stockDto.getPrice(), stockDto.getVolume(), stockDto.getDate()));
            }
        } catch (IOException e) {
            System.out.println("Unable to save stocks: " + e.getMessage());
        }
        symbolService.saveAll(new ArrayList<SymbolEntity>(symbolMap.values()));
        stockService.saveAll(stockEntityList);
        return (symbolMap.values().size() + " symbols saved! and " + stockEntityList.size() + " stocks saved!");
    }
   @GetMapping("/{stockName}/{inputDate}")
    public String getDataByDate(@PathVariable("stockName") String stockName, @PathVariable("inputDate") String inputDate){

        StockStats stockStats=null;
        if(inputDate.length()==10)
        stockStats=stockService.getStockStatsByDate(stockName,inputDate);
        else
        if(inputDate.length()==7)
            stockStats=stockService.getStockStatsByMonth(stockName,inputDate);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        try {
            return mapper.writeValueAsString(stockStats);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package com.dev.stocks.controller;

import com.dev.stocks.entity.StockEntity;
import com.dev.stocks.model.StockStats;
import com.dev.stocks.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/load")
    public String load() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<StockEntity>> typeReference = new TypeReference<List<StockEntity>>(){};
        //InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stocks.json");
        URL jsonURL=new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json");
        InputStream inputStream=jsonURL.openStream();
        try {
            List<StockEntity> stocks = mapper.readValue(inputStream,typeReference);
            stockService.save(stocks);
            return(stocks.size()+" stocks Saved!");
        } catch (IOException e){
            return "Unable to save stocks: " + e.getMessage();
        }
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

package com.dev.stocks;


import com.dev.stocks.dto.JsonDto;
import com.dev.stocks.entity.StockEntity;
import com.dev.stocks.entity.SymbolEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration

public class StocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(StocksApplication.class, args);
    }
   /* @Bean
    CommandLineRunner runner(StockService stockService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<StockEntity>> typeReference = new TypeReference<List<StockEntity>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stocks.json");
            try {
                List<StockEntity> stocks = mapper.readValue(inputStream,typeReference);
                stockService.save(stocks);
                System.out.println("Stocks Saved!");
            } catch (IOException e){
                System.out.println("Unable to save stocks: " + e.getMessage());
            }
        };
    }*/
}

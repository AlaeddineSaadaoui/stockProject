package com.dev.stocks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;



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

package com.dev.stocks.service;

import com.dev.stocks.entity.StockEntity;
import com.dev.stocks.model.StockStats;
import com.dev.stocks.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService  {

    @Autowired
    private StockRepository stockRepository;


    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Iterable<StockEntity> list(){
        return stockRepository.findAll();
    }

    public Iterable<StockEntity> save(List<StockEntity> stockList ){
        return stockRepository.saveAll(stockList);
    }

    public StockStats getStockStatsByDate(String stockName, String inputDate){
        return stockRepository.getStockStatsByDate(stockName,inputDate);
    }

    public StockStats getStockStatsByMonth(String stockName, String inputMonth){
        return stockRepository.getStockStatsByMonth(stockName,inputMonth);
    }



}

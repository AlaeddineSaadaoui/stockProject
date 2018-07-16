package com.dev.stocks.service;

import com.dev.stocks.entity.StockEntity;
import com.dev.stocks.entity.SymbolEntity;
import com.dev.stocks.model.StockStats;
import com.dev.stocks.repository.StockRepository;
import com.dev.stocks.repository.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymbolService {

    @Autowired
    private SymbolRepository symbolRepository;


    public SymbolService(SymbolRepository symbolRepository) {
        this.symbolRepository=symbolRepository;
    }

    public Iterable<SymbolEntity> list(){
        return symbolRepository.findAll();
    }

    public Iterable<SymbolEntity> saveAll(List<SymbolEntity> symbolEntityList){
        return symbolRepository.saveAll(symbolEntityList);
    }

}

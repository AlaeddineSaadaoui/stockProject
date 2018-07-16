package com.dev.stocks.repository;

import com.dev.stocks.entity.StockEntity;
import com.dev.stocks.entity.SymbolEntity;
import com.dev.stocks.model.StockStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SymbolRepository extends CrudRepository<SymbolEntity,Integer> {


}
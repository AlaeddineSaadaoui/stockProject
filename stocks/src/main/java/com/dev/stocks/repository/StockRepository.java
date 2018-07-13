package com.dev.stocks.repository;

import com.dev.stocks.entity.StockEntity;
import com.dev.stocks.model.StockStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends CrudRepository<StockEntity,Integer> {

    //@Query(value = "SELECT new StockStats(MIN(CAST(s.price AS DECIMAL(5,2))), MAX(CAST(s.price AS DECIMAL(5,2))) , SUM(CAST(s.volume AS DECIMAL(5,2)))) FROM Stock s where s.symbol  like :stockName AND SUBSTRTRING(s.date,0,10) like :inputDate")

    @Query(value = "select new com.dev.stocks.model.StockStats(MIN(s.price), MAX(s.price) , SUM(s.volume), MAX(s.date)) from StockEntity s where s.symbol like :stockName and SUBSTRING(s.date,0,10) like :inputDate")
    public StockStats getStockStatsByDate(@Param("stockName") String stockName, @Param("inputDate")String inputDate);

    @Query(value = "select new com.dev.stocks.model.StockStats(MIN(s.price), MAX(s.price) , SUM(s.volume), MAX(s.date)) from StockEntity s where s.symbol like :stockName and SUBSTRING(s.date,0,7) like :inputMonth")
    public StockStats getStockStatsByMonth(@Param("stockName") String stockName, @Param("inputMonth")String inputMonth);
}
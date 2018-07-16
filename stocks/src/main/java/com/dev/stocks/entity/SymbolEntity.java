package com.dev.stocks.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SYMBOL")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SymbolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="symbol_id")
    private int symbol_id;

    @Column(name="symbol",unique = true)
    private String symbol;

    @OneToMany(mappedBy="symbolEntity",cascade=CascadeType.ALL)
    private List<StockEntity> stockEntityList;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getSymbol_id() {
        return symbol_id;
    }

    public void setSymbol_id(int symbol_id) {
        this.symbol_id = symbol_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SymbolEntity{");
        sb.append("symbol_id=").append(symbol_id);
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public List<StockEntity> getStockEntityList() {
        return stockEntityList;
    }

    public void setStockEntityList(List<StockEntity> stockEntityList) {
        this.stockEntityList = stockEntityList;
    }
    public SymbolEntity(String symbol) {
        this.symbol = symbol;
    }
    public SymbolEntity() { }
}

package com.dev.stocks.entity;


import javax.persistence.*;

@Entity
@Table(name="STOCK")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quote_id;

    @ManyToOne
    @JoinColumn(name="symbol_fk", referencedColumnName = "symbol_id")
    private SymbolEntity symbolEntity;

    @Column(name="price")
    private double price;

    @Column(name="volume")
    private int volume;


    @Column(name="date")
    private String date;


    public StockEntity() {
    }

    public int getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(int quote_id) {
        this.quote_id = quote_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public SymbolEntity getSymbolEntity() {
        return symbolEntity;
    }

    public void setSymbolEntity(SymbolEntity symbolEntity) { this.symbolEntity= symbolEntity; }

    public StockEntity(SymbolEntity symbolEntity, double price, int volume, String date) {
        this.symbolEntity=symbolEntity;
        this.price = price;
        this.volume = volume;
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockEntity{");
        sb.append("quote_id=").append(quote_id);
        sb.append(", symbol='").append(symbolEntity.getSymbol()).append('\'');
        sb.append(", price=").append(price);
        sb.append(", volume=").append(volume);
        sb.append(", date='").append(date).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

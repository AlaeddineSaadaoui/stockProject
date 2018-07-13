package com.dev.stocks.entity;


import javax.persistence.*;

@Entity
@Table(name="STOCK")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stock_id;

    @Column(name="symbol")
    private String symbol;

    @Column(name="price")
    private double price;

    @Column(name="volume")
    private int volume;

    @Column(name="date")
    private String date;

    public StockEntity() {
    }


    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
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


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public StockEntity(String symbol, double price, int volume, String date) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockEntity{");
        sb.append("stock_id=").append(stock_id);
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", price=").append(price);
        sb.append(", volume=").append(volume);
        sb.append(", date='").append(date).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

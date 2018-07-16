package com.dev.stocks.dto;

public class JsonDto {

    private double price;

    private int volume;

    private String date;

    private String symbol;

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

    public JsonDto(double price, int volume, String date, String symbol) {
        this.price = price;
        this.volume = volume;
        this.date = date;
        this.symbol = symbol;
    }

    public JsonDto() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JsonDto{");
        sb.append("price=").append(price);
        sb.append(", volume=").append(volume);
        sb.append(", date='").append(date).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

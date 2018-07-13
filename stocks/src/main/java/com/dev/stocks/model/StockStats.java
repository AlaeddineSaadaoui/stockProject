package com.dev.stocks.model;

import com.fasterxml.jackson.annotation.*;


@JsonPropertyOrder({ "lowest_price", "highest_price","closing_date","total_volume" })
@JsonRootName(value = "StockStats")
public class StockStats {

    @JsonProperty("lowest_price")
    private Double lowestPrice;

    @JsonProperty("highest_price")
    private Double highestPrice;

    @JsonProperty("total_volume")
    private Long totalVolume;



    @JsonProperty("closing_date")
    private String closingDate;

    @JsonGetter("lowest_price")
    public Double getLowestPrice() {
        return lowestPrice;
    }

    @JsonSetter("lowest_price")
    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    @JsonGetter("highest_price")
    public Double getHighestPrice() {
        return highestPrice;
    }

    @JsonSetter("highest_price")
    public void setHighestPrice(Double highestPrice) {
        this.highestPrice = highestPrice;
    }

    @JsonGetter("total_volume")
    public Long getTotalVolume() {
        return totalVolume;
    }

    @JsonSetter("total_volume")
    public void setTotalVolume(Long totalVolume) {
        this.totalVolume = totalVolume;
    }

    public StockStats(Double lowestPrice, Double highestPrice, Long totalVolume, String closingDate) {
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.totalVolume = totalVolume;
        this.closingDate=closingDate;
    }

    @JsonSetter("closing_date")
    public void setLowestPrice(Double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    @JsonGetter("closing_date")
    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockStats{");
        sb.append("lowestPrice=").append(lowestPrice);
        sb.append(", highestPrice=").append(highestPrice);
        sb.append(", totalVolume=").append(totalVolume);
        sb.append(", closingDate='").append(closingDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

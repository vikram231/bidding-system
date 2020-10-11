package com.cars24.bidding.models;

public class AuctionResponse {
    private String itemCode;
    private long highestBid;
    private long stepRate;


    public long getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(long highestBid) {
        this.highestBid = highestBid;
    }

    public long getStepRate() {
        return stepRate;
    }

    public void setStepRate(long stepRate) {
        this.stepRate = stepRate;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}

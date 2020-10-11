package com.cars24.bidding.models;

public class PostBid {
    private long bidAmount;
    private String userName;

    public long getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(long bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

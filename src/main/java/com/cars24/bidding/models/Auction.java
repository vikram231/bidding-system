package com.cars24.bidding.models;

import java.util.HashMap;

public class Auction {
    private String itemCode;
    private long basePrice;
    private long stepRate;
    private String status;
    private HashMap<String, Long> userBids;

    public HashMap<String, Long> getUserBids() {
        return userBids;
    }

    public void setUserBids(HashMap<String, Long> userBids) {
        this.userBids = userBids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getStepRate() {
        return stepRate;
    }

    public void setStepRate(long stepRate) {
        this.stepRate = stepRate;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "itemCode='" + itemCode + '\'' +
                ", basePrice=" + basePrice +
                ", stepRate=" + stepRate +
                ", status='" + status + '\'' +
                ", userBids=" + userBids +
                '}';
    }
}

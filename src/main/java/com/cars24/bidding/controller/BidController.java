package com.cars24.bidding.controller;

import com.cars24.bidding.models.Auction;
import com.cars24.bidding.models.AuctionResponse;
import com.cars24.bidding.models.PostBid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BidController {
    HashMap<String, Auction> auctions;

    BidController() {
        auctions = new HashMap<>();
        Auction olDiamond = new Auction();
        olDiamond.setItemCode("kohinoor234");
        olDiamond.setBasePrice(10000);
        olDiamond.setStatus("RUNNING");
        olDiamond.setStepRate(500);
        olDiamond.setUserBids(new HashMap<>());
        auctions.put("kohinoor234", olDiamond);

        Auction ipl = new Auction();
        ipl.setItemCode("ipl2020");
        ipl.setBasePrice(999);
        ipl.setStatus("RUNNING");
        ipl.setStepRate(100);
        ipl.setUserBids(new HashMap<>());
        auctions.put("ipl2020", ipl);

        Auction oldSword = new Auction();
        oldSword.setItemCode("sword23");
        oldSword.setBasePrice(1000);
        oldSword.setStatus("OVER");
        oldSword.setStepRate(200);
        oldSword.setUserBids(new HashMap<>());
        auctions.put("sword23", oldSword);
    }

    @RequestMapping("/auction")
    public List<AuctionResponse> getAuctions(@RequestParam(value = "status",
            defaultValue = "RUNNING") String status) {
        List<AuctionResponse> runningAuctions = new ArrayList<>();
        for (Map.Entry<String, Auction> auction : auctions.entrySet()) {
            if (auction.getValue().getStatus().equals(status)) {
                AuctionResponse auctionResponse = new AuctionResponse();
                auctionResponse.setHighestBid(auction.getValue().getBasePrice());
                auctionResponse.setStepRate(auction.getValue().getStepRate());
                auctionResponse.setItemCode(auction.getKey());
                runningAuctions.add(auctionResponse);
            }
        }
        return runningAuctions;
    }

    @RequestMapping(value = "/auction/{itemCode}/bid", method = RequestMethod.POST)
    public ResponseEntity postBid(@PathVariable(value = "itemCode") String itemCode,
                                  @RequestBody PostBid inputBid) {
        if (auctions.get(itemCode) == null ||
                auctions.get(itemCode).getStatus().equals("OVER"))
            return new ResponseEntity(HttpStatus.NOT_FOUND); //404

        Auction item = auctions.get(itemCode);
        System.out.println(item);
        item.getUserBids().put(inputBid.getUserName(), inputBid.getBidAmount());
        if (inputBid.getBidAmount() >= item.getBasePrice()) {
            item.setBasePrice(inputBid.getBidAmount()+item.getStepRate());
            return new ResponseEntity(HttpStatus.CREATED); // 201
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE); //406
    }
}


package com.example.geektrust.entities;

import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;

import java.util.HashMap;
import java.util.Map;

public class Station extends BaseEntity{
    private StationType stationType;
    private Long totalAmountCollected;
    private Long totalDiscountGiven;
    Map<PassengerType,Long> passengerSummary = new HashMap<>();

    public Station(StationType stationType, Long totalAmountCollected, Long totalDiscountGiven, Map<PassengerType, Long> passengerSummary) {
        this.stationType = stationType;
        this.totalAmountCollected = totalAmountCollected;
        this.totalDiscountGiven = totalDiscountGiven;
        this.passengerSummary = passengerSummary;
    }
    
    public StationType getStationType() {
        return stationType;
    }

    public Long getTotalAmountCollected() {
        return totalAmountCollected;
    }

    public Long getTotalDiscountGiven() {
        return totalDiscountGiven;
    }
    public Map<PassengerType, Long> getPassengerSummary() {
        return passengerSummary;
    }
}

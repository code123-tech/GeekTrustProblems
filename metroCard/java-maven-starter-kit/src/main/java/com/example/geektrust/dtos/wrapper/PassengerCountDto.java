package com.example.geektrust.dtos.wrapper;

public class PassengerCountDto {
    private String passengerType;
    private Long count;
    public PassengerCountDto(String passengerType, Long count) {
        this.passengerType = passengerType;
        this.count = count;
    }
    public String getPassengerType() {
        return passengerType;
    }
    public Long getCount() {
        return count;
    }
}

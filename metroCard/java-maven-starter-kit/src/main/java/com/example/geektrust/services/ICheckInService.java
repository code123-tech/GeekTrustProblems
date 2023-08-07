package com.example.geektrust.services;

import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;

import java.util.Map;

public interface ICheckInService  {

    void checkIn(String cardId, PassengerType passengerType, StationType stationType);
}

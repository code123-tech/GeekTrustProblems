package com.example.geektrust.repositories;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.entities.Station;
import com.example.geektrust.common.enums.StationType;

import java.util.Map;

public interface IStationRepository extends CRUDRepository<Station,String>{

//    void onboardPassenger(MetroCard card, PassengerType passengerType, StationType stationType);
    Map<StationType, Long> getStationTotalCollectionMap();
    Map<StationType, Long> getStationTotalDiscountMap();
    Map<StationType, Map<PassengerType, Long>> getStationTotalCountByPassengerTypeMap();
    Map<String,StationType> getCardCheckInMap();
}

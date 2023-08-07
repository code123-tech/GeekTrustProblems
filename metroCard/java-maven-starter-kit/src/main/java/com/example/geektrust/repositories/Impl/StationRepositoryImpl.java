package com.example.geektrust.repositories.Impl;

import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.entities.Station;
import com.example.geektrust.common.enums.StationType;
import com.example.geektrust.repositories.IStationRepository;

import java.util.*;

public class StationRepositoryImpl implements IStationRepository {
    private Map<StationType,Long> stationTotalCollectionMap = new HashMap<>();
    private Map<StationType,Long> stationTotalDiscountMap = new HashMap<>();
    private Map<StationType,Map<PassengerType,Long>> stationTotalCountByPassengerTypeMap = new HashMap<>();
    private Map<String,StationType> cardCheckInMap = new HashMap<>();

    private List<Station> savedEntities = new ArrayList<>();
    public StationRepositoryImpl(){
        stationTotalCollectionMap.put(StationType.CENTRAL, ServiceConstants.DEFAULT_VALUE_ZERO);
        stationTotalCollectionMap.put(StationType.AIRPORT, ServiceConstants.DEFAULT_VALUE_ZERO);
        stationTotalDiscountMap.put(StationType.CENTRAL, ServiceConstants.DEFAULT_VALUE_ZERO);
        stationTotalDiscountMap.put(StationType.AIRPORT, ServiceConstants.DEFAULT_VALUE_ZERO);
    }
    @Override
    public Station save(Station entity) {
        savedEntities.add(entity);
        return entity;
    }
    @Override
    public Map<StationType, Long> getStationTotalCollectionMap() {
        return stationTotalCollectionMap;
    }
    @Override
    public Map<StationType, Long> getStationTotalDiscountMap() {
        return stationTotalDiscountMap;
    }
    @Override
    public Map<StationType, Map<PassengerType, Long>> getStationTotalCountByPassengerTypeMap() {
        return stationTotalCountByPassengerTypeMap;
    }
    @Override
    public Map<String,StationType> getCardCheckInMap() {
        return cardCheckInMap;
    }
}

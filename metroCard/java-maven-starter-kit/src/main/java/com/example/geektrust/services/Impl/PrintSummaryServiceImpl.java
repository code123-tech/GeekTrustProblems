package com.example.geektrust.services.Impl;

import com.example.geektrust.common.Comparators.SortingComparators;
import com.example.geektrust.common.beans.ApplicationBeans;
import com.example.geektrust.common.constants.PrintCommandConstants;
import com.example.geektrust.dtos.wrapper.PassengerCountDto;
import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;
import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.IStationRepository;
import com.example.geektrust.services.IPrintSummaryService;

import java.util.*;
import java.util.stream.Collectors;

public class PrintSummaryServiceImpl implements IPrintSummaryService {
    private Map<StationType,Long> stationTotalCollectionMap;
    private Map<StationType,Long> stationTotalDiscountMap;
    private Map<StationType,Map<PassengerType,Long>> stationTotalCountByPassengerTypeMap;
    private final IStationRepository stationRepository;

    public PrintSummaryServiceImpl(IStationRepository stationRepository){
        this.stationRepository = stationRepository;
    }
    @Override
    public void printSummary() {
        stationTotalCollectionMap = stationRepository.getStationTotalCollectionMap();
        stationTotalDiscountMap = stationRepository.getStationTotalDiscountMap();
        stationTotalCountByPassengerTypeMap = stationRepository.getStationTotalCountByPassengerTypeMap();

        for(StationType station:StationType.values()){
            System.out.println(PrintCommandConstants.TOTAL_COLLECTION + " " + station.name()+"  " + stationTotalCollectionMap.get(station) +"  " +stationTotalDiscountMap.get(station));
            System.out.println(PrintCommandConstants.PASSENGER_TYPE_SUMMARY);
            /**
             * Get passengers type count at each station
             */
            Map<PassengerType, Long> central = stationTotalCountByPassengerTypeMap.get(station);
            List<PassengerCountDto> result = central.keySet().stream().map(key -> new PassengerCountDto(key.name(), central.get(key))).collect(Collectors.toList());
            Collections.sort(result, SortingComparators.getPassengerCountDtoComparator());
            for(PassengerCountDto passengerCountDto: result){
                System.out.println(passengerCountDto.getPassengerType() + " " + passengerCountDto.getCount());
            }
            stationRepository.save(new Station(station, stationTotalCollectionMap.get(station), stationTotalDiscountMap.get(station), central));
        }

    }
}

package com.example.geektrust.services.Impl;

import com.example.geektrust.common.beans.ApplicationBeans;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;
import com.example.geektrust.common.exceptions.CardNotFoundException;
import com.example.geektrust.repositories.IMetroCardRepository;
import com.example.geektrust.repositories.IStationRepository;
import com.example.geektrust.services.IBalanceService;
import com.example.geektrust.services.ICheckInService;

import java.util.HashMap;
import java.util.Map;

public class CheckInServiceImpl implements ICheckInService {
    private final IStationRepository stationRepository;
    private final IMetroCardRepository metroCardRepository;
    private final IBalanceService balanceService;

    public CheckInServiceImpl(IStationRepository stationRepository, IMetroCardRepository metroCardRepository, IBalanceService balanceService){
        this.stationRepository = stationRepository;
        this.metroCardRepository = metroCardRepository;
        this.balanceService = balanceService;
    }
    @Override
    public void checkIn(String cardId, PassengerType passengerType, StationType stationType) {
        MetroCard metroCard = metroCardRepository.findByCardId(cardId);
        if (metroCard==null){
            throw new CardNotFoundException(ServiceConstants.NO_SUCH_CARD_FOUND);
        }
        checkInPassenger(cardId,passengerType,stationType);
    }
    private void checkInPassenger(String cardId, PassengerType passengerType, StationType stationType){
        Long totalAmountAtStation = stationRepository.getStationTotalCollectionMap().getOrDefault(stationType, ServiceConstants.DEFAULT_VALUE_ZERO);
        Long passengerFare  = passengerType.getTicketPrice();

        if(stationRepository.getCardCheckInMap().containsKey(cardId)==false){
            totalAmountAtStation = balanceService.makeTransaction(cardId, totalAmountAtStation, passengerFare);
            stationRepository.getCardCheckInMap().put(cardId, stationType);
        }
        else{
            Long discount = passengerFare/ServiceConstants.DISCOUNT_FACTOR;
            passengerFare=passengerFare-discount;
            totalAmountAtStation = balanceService.makeTransaction(cardId, totalAmountAtStation, passengerFare);
            stationRepository.getCardCheckInMap().remove(cardId);
            stationRepository.getStationTotalDiscountMap().put(stationType,stationRepository.getStationTotalDiscountMap().getOrDefault(stationType, ServiceConstants.DEFAULT_VALUE_ZERO)+discount);
        }
        stationRepository.getStationTotalCollectionMap().put(stationType,totalAmountAtStation);
        Map<PassengerType,Long> countByPassengerType = stationRepository.getStationTotalCountByPassengerTypeMap().getOrDefault(stationType,new HashMap<>());
        countByPassengerType.put(passengerType,countByPassengerType.getOrDefault(passengerType, ServiceConstants.DEFAULT_VALUE_ZERO)+1);
        stationRepository.getStationTotalCountByPassengerTypeMap().put(stationType,countByPassengerType);
    }
}

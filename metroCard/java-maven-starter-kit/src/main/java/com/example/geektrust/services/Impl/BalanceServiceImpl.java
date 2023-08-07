package com.example.geektrust.services.Impl;

import com.example.geektrust.common.beans.ApplicationBeans;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.repositories.IMetroCardRepository;
import com.example.geektrust.services.IBalanceService;

public class BalanceServiceImpl implements IBalanceService {
    private final IMetroCardRepository metroCardRepository;

    public BalanceServiceImpl(IMetroCardRepository metroCardRepository){
        this.metroCardRepository = metroCardRepository;
    }

    @Override
    public MetroCard addCard(MetroCard metroCard) {
        return metroCardRepository.save(metroCard);
    }

    @Override
    public Long makeTransaction(String cardId, Long totalAmountAtStation, Long passengerFare) {
        MetroCard card = metroCardRepository.findByCardId(cardId);
        Long currentBalance = card.getBalance();
        if (currentBalance<passengerFare){
            Long remainingAmount =passengerFare-card.getBalance();
            totalAmountAtStation+= (long)(ServiceConstants.AUTO_RECHARGE_FEE*(remainingAmount)) + passengerFare;
            card.setBalance(ServiceConstants.DEFAULT_VALUE_ZERO);
        }
        else{
            totalAmountAtStation+= passengerFare;
            card.setBalance(currentBalance-passengerFare);
        }
        return totalAmountAtStation;
    }
}

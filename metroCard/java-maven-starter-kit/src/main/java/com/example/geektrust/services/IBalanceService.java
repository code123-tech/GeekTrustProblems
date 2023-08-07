package com.example.geektrust.services;

import com.example.geektrust.entities.MetroCard;

public interface IBalanceService {
    MetroCard addCard(MetroCard metroCard);
    Long makeTransaction(String cardId, Long totalAmountAtStation, Long passengerFare);
}

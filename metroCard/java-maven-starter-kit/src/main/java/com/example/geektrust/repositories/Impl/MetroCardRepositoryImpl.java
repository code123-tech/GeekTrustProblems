package com.example.geektrust.repositories.Impl;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.repositories.IMetroCardRepository;

import java.util.HashMap;
import java.util.Map;
public class MetroCardRepositoryImpl implements IMetroCardRepository {
    private final Map<String,MetroCard> metroCards;
    private Integer autoIncrement = 0;
    public MetroCardRepositoryImpl() {
        this.metroCards = new HashMap<>();
    }
    @Override
    public MetroCard save(MetroCard metroCard) {
        if( metroCard.getId() != null ){
            metroCards.put(metroCard.getCardId(),metroCard);
            return metroCard;
        }
        MetroCard c = new MetroCard(Integer.toString(++autoIncrement),metroCard.getBalance(),metroCard.getCardId());
        metroCards.put(c.getCardId(),c);
        return c;
    }

    @Override
    public MetroCard findByCardId(String cardId) {
        return metroCards.getOrDefault(cardId,null);
    }
}

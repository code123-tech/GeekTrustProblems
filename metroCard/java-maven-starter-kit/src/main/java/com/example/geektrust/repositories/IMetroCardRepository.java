package com.example.geektrust.repositories;

import com.example.geektrust.entities.MetroCard;

public interface IMetroCardRepository extends CRUDRepository<MetroCard,String>{
    MetroCard save(MetroCard metroCard);
    MetroCard findByCardId(String cardId);
}

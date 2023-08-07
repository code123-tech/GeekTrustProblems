package com.example.geektrust.services;

import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.repositories.IMetroCardRepository;
import com.example.geektrust.services.Impl.BalanceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("BalanceServiceImplTest")
@ExtendWith(MockitoExtension.class)
public class BalanceServiceImplTest {
    @Mock
    private IMetroCardRepository metroCardRepository;

    @InjectMocks
    private BalanceServiceImpl balanceService;

    @Test
    @DisplayName("Should add a new metro card")
    public void testAddCard(){
        // inputs
        String id = Integer.toString(1);
        Long balance = 120L;
        String cardId = "C-1";

        MetroCard metroCard = new MetroCard(id, balance, cardId);
        // Output
        Mockito.when(metroCardRepository.save(metroCard)).thenReturn(metroCard);
        MetroCard metroCardFromService = balanceService.addCard(metroCard);

        // Verify
        Assertions.assertNotNull(metroCardFromService);
        Assertions.assertEquals(metroCard.getId(), metroCardFromService.getId());
        Assertions.assertEquals(metroCard.getCardId(), metroCardFromService.getCardId());
        Assertions.assertEquals(metroCard.getBalance(), metroCardFromService.getBalance());
    }

    @Test
    @DisplayName("Make a card transaction when metro card balance is enough to pay")
    public void testWhenMetroCardBalanceIsEnoughToPay(){
        // inputs
        MetroCard metroCard = new MetroCard("1", 120L, "C-1");

        String cardId = metroCard.getCardId();
        Long totalAmountAtStation = 100L;
        Long passengerFare = 100L;
        Long remainingCardBalance = metroCard.getBalance() - passengerFare;

        // Output
        Mockito.when(metroCardRepository.findByCardId(cardId)).thenReturn(metroCard);
        Long totalAmountAfterCharge = totalAmountAtStation + passengerFare;

        Long totalAmountReceivedFromService = balanceService.makeTransaction(cardId, totalAmountAtStation, passengerFare);

        Assertions.assertNotNull(totalAmountReceivedFromService);
        Assertions.assertEquals(totalAmountAfterCharge, totalAmountReceivedFromService);
        Assertions.assertEquals(metroCard.getBalance(), remainingCardBalance);
    }

    @Test
    @DisplayName("Make a card transaction when metro card balance is not enough to pay")
    public void testWhenMetroCardBalanceIsNotEnoughToPay(){
        // inputs
        MetroCard metroCard = new MetroCard("1", 120L, "C-1");

        String cardId = metroCard.getCardId();
        Long totalAmountAtStation = 100L;
        Long passengerFare = 200L;
        Long remainingCardBalance = 0l;
        // Output
        Mockito.when(metroCardRepository.findByCardId(cardId)).thenReturn(metroCard);
        Long remainingFare = passengerFare - metroCard.getBalance();
        Long totalAmountAfterCharge = totalAmountAtStation + (long)(ServiceConstants.AUTO_RECHARGE_FEE*(remainingFare)) + passengerFare;
        Long totalAmountReceivedFromService = balanceService.makeTransaction(cardId, totalAmountAtStation, passengerFare);

        Assertions.assertNotNull(totalAmountReceivedFromService);
        Assertions.assertEquals(totalAmountAfterCharge, totalAmountReceivedFromService);
        Assertions.assertEquals(metroCard.getBalance(), remainingCardBalance);
    }
}

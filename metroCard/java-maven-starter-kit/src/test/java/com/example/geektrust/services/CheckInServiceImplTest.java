package com.example.geektrust.services;

import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;
import com.example.geektrust.common.exceptions.CardNotFoundException;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.repositories.IMetroCardRepository;
import com.example.geektrust.repositories.IStationRepository;
import com.example.geektrust.services.Impl.CheckInServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@DisplayName("CheckInServiceImplTest")
@ExtendWith(MockitoExtension.class)
public class CheckInServiceImplTest {
    @Mock
    private IStationRepository stationRepository;
    @Mock
    private IMetroCardRepository metroCardRepository;
    @Mock
    private IBalanceService balanceService;

    @InjectMocks
    private CheckInServiceImpl checkInService;

    @Test
    @DisplayName("Test checkIn")
    public void testCheckIn(){
        // inputs
        MetroCard metroCard = new MetroCard("1", 120L, "C-1");
        String cardId = metroCard.getCardId();
        PassengerType passengerType = PassengerType.SENIOR_CITIZEN;
        StationType stationType = StationType.CENTRAL;
        // Output
        Mockito.when(metroCardRepository.findByCardId(cardId)).thenReturn(metroCard);
        checkInService.checkIn(cardId, passengerType, stationType);
    }

    @Test
    @DisplayName("Test when card not found")
    public void testCheckInWhenCardNotFound(){
        // inputs
        MetroCard metroCard = new MetroCard("1", 120L, "C-1");
        String cardId = metroCard.getCardId();
        PassengerType passengerType = PassengerType.SENIOR_CITIZEN;
        StationType stationType = StationType.CENTRAL;
        // Output
        Mockito.when(metroCardRepository.findByCardId(cardId)).thenReturn(null);

        CardNotFoundException exception = Assertions.assertThrows(CardNotFoundException.class, ()->checkInService.checkIn(cardId, passengerType, stationType));
        Assertions.assertEquals(exception.getMessage(), ServiceConstants.NO_SUCH_CARD_FOUND);
    }

    @Test
    @DisplayName("Test when return journey happens")
    public void testCheckIfReturnJourneyHappens(){
        // inputs
        MetroCard metroCard = new MetroCard("1", 120L, "C-1");
        String cardId = metroCard.getCardId();
        PassengerType passengerType = PassengerType.SENIOR_CITIZEN;
        StationType stationType = StationType.CENTRAL;

        Map<String, StationType> cardCheckInMap = new HashMap<>();
        cardCheckInMap.put(cardId, StationType.AIRPORT);

         // Output
        Mockito.when(metroCardRepository.findByCardId(cardId)).thenReturn(metroCard);
        Mockito.when(stationRepository.getCardCheckInMap()).thenReturn(cardCheckInMap);

        checkInService.checkIn(cardId, passengerType, stationType);
    }
}

package com.example.geektrust.repository;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.repositories.Impl.MetroCardRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("MetroCardRepoImplTest")
@ExtendWith(MockitoExtension.class)
public class MetroCardRepositoryImplTest {
    @InjectMocks
    private MetroCardRepositoryImpl metroCardRepository;

    @Test
    @DisplayName("test save method - New card is created.")
    public void testSaveMethodWhenNewCardCreated(){
        // inputs
        String newId = "1";
        Long balance = 120L;
        String cardId = "C-1";

        MetroCard metroCard = new MetroCard(balance, cardId);
        // Output
        MetroCard metroCardFromService = metroCardRepository.save(metroCard);

        // Verify
        Assertions.assertNotNull(metroCardFromService);
        Assertions.assertEquals(newId, metroCardFromService.getId());
        Assertions.assertEquals(metroCard.getCardId(), metroCardFromService.getCardId());
        Assertions.assertEquals(metroCard.getBalance(), metroCardFromService.getBalance());
    }

    @Test
    @DisplayName("test save method - existing card.")
    public void testSaveMethodWhenExistingCard(){
        // inputs
        String newId = "1";
        Long balance = 120L;
        String cardId = "C-1";

        MetroCard metroCard = new MetroCard(newId, balance, cardId);
        // Output
        MetroCard metroCardFromService = metroCardRepository.save(metroCard);

        // Verify
        Assertions.assertNotNull(metroCardFromService);
        Assertions.assertEquals(newId, metroCardFromService.getId());
        Assertions.assertEquals(metroCard.getCardId(), metroCardFromService.getCardId());
        Assertions.assertEquals(metroCard.getBalance(), metroCardFromService.getBalance());
    }

    @Test
    @DisplayName("test find by card id.")
    public void testFindByCardId(){
        // inputs
        String newId = "1";
        Long balance = 120L;
        String cardId = "C-1";

        MetroCard metroCard = new MetroCard(newId, balance, cardId);
        // Output
        MetroCard metroCardFromService = metroCardRepository.save(metroCard);
        // Verify
        Assertions.assertNotNull(metroCardFromService);
        Assertions.assertEquals(newId, metroCardFromService.getId());
        Assertions.assertEquals(metroCard.getCardId(), metroCardFromService.getCardId());
        Assertions.assertEquals(metroCard.getBalance(), metroCardFromService.getBalance());
    }
}

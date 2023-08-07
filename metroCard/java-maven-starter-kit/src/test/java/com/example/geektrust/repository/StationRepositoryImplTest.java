package com.example.geektrust.repository;

import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.Impl.MetroCardRepositoryImpl;
import com.example.geektrust.repositories.Impl.StationRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@DisplayName("StationRepoImplTest")
@ExtendWith(MockitoExtension.class)
public class StationRepositoryImplTest {
    @InjectMocks
    private StationRepositoryImpl stationRepository;

    @Test
    @DisplayName("test save method")
    public void testSaveMethodWhenNewCardCreated(){
        // inputs
        Station station = new Station(StationType.CENTRAL, 100l, 100l, new HashMap<>());
        // Output
        Station stationFromService = stationRepository.save(station);

        // Verify
        Assertions.assertNotNull(stationFromService);
        Assertions.assertEquals(station.getStationType(), stationFromService.getStationType());
        Assertions.assertEquals(station.getTotalAmountCollected(), stationFromService.getTotalAmountCollected());
    }

    @Test
    @DisplayName("test get Station Total Collection Map")
    public void testGetStationTotalCollectionMap(){
        // inputs

        // Output
        Map<StationType,Long> stationTotalCollectionMap = stationRepository.getStationTotalCollectionMap();

        // Verify
        Assertions.assertNotNull(stationTotalCollectionMap);
    }

    @Test
    @DisplayName("test get Station Total Discount Map")
    public void testGetStationTotalDiscountMap(){
        // inputs

        // Output
        Map<StationType,Long> stationTotalDiscountMap = stationRepository.getStationTotalDiscountMap();

        // Verify
        Assertions.assertNotNull(stationTotalDiscountMap);
    }

    @Test
    @DisplayName("test get Station Total Count By PassengerType Map")
    public void testGetStationTotalCountByPassengerTypeMap(){
        // inputs

        // Output
        Map<StationType, Map<PassengerType, Long>> stationTotalCountByPassengerTypeMap = stationRepository.getStationTotalCountByPassengerTypeMap();

        // Verify
        Assertions.assertNotNull(stationTotalCountByPassengerTypeMap);
    }

    @Test
    @DisplayName("test get Card Check In Map")
    public void testGetCardCheckInMap(){
        // inputs

        // Output
        Map<String,StationType> stationCardCheckInMap = stationRepository.getCardCheckInMap();

        // Verify
        Assertions.assertNotNull(stationCardCheckInMap);
    }
}

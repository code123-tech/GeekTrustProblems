package com.example.geektrust.services;

import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;
import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.IStationRepository;
import com.example.geektrust.services.Impl.PrintSummaryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@DisplayName("PrintSummaryServiceImplTest")
@ExtendWith(MockitoExtension.class)
public class PrintSummaryServiceImplTest {
    @Mock
    private IStationRepository stationRepository;

    @InjectMocks
    private PrintSummaryServiceImpl printSummaryService;

    @Test
    @DisplayName("Test print summary")
    public void testPrintSummary(){
        // inputs
        Map<StationType,Long> stationTotalCollectionMap = new HashMap<>();
        stationTotalCollectionMap.put(StationType.CENTRAL, 100L);
        stationTotalCollectionMap.put(StationType.AIRPORT, 10L);
        Map<StationType,Long> stationTotalDiscountMap = new HashMap<>();
        stationTotalDiscountMap.put(StationType.CENTRAL, 0L);
        stationTotalDiscountMap.put(StationType.AIRPORT, 0L);
        Map<StationType,Map<PassengerType,Long>> stationTotalCountByPassengerTypeMap = new HashMap<>();
        Map<PassengerType, Long> passengerCount = new HashMap<>();
        passengerCount.put(PassengerType.ADULT, 1L);
        passengerCount.put(PassengerType.KID, 1L);
        passengerCount.put(PassengerType.SENIOR_CITIZEN, 1L);

        stationTotalCountByPassengerTypeMap.put(StationType.CENTRAL, passengerCount);
        stationTotalCountByPassengerTypeMap.put(StationType.AIRPORT, passengerCount);

        // output
        Mockito.when(stationRepository.getStationTotalCollectionMap()).thenReturn(stationTotalCollectionMap);
        Mockito.when(stationRepository.getStationTotalDiscountMap()).thenReturn(stationTotalDiscountMap);
        Mockito.when(stationRepository.getStationTotalCountByPassengerTypeMap()).thenReturn(stationTotalCountByPassengerTypeMap);

        printSummaryService.printSummary();
    }
}

package com.example.geektrust.common.Comparators;

import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.dtos.wrapper.PassengerCountDto;

import java.util.Comparator;

public class SortingComparators {
    public static Comparator<PassengerCountDto> getPassengerCountDtoComparator() {
        return (passengerCount1, passengerCount2) -> {
            if (passengerCount1.getCount() == passengerCount2.getCount()) {
                return passengerCount1.getPassengerType().charAt(ServiceConstants.ARRAY_INDEX_ZERO) - passengerCount2.getPassengerType().charAt(ServiceConstants.ARRAY_INDEX_ZERO);
            }
            return (int) (passengerCount2.getCount() - passengerCount1.getCount());
        };
    }
}

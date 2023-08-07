package com.example.geektrust.commands.CommandsImpl;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.PassengerType;
import com.example.geektrust.common.enums.StationType;
import com.example.geektrust.services.ICheckInService;

import java.util.List;

public class CheckInCommand implements ICommand {

    private final ICheckInService checkInService;

    public CheckInCommand(ICheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @Override
    public void execute(List<String> tokens) {
    String cardId = tokens.get(ServiceConstants.ARRAY_INDEX_ONE);
    PassengerType passengerType = PassengerType.valueOf(tokens.get(ServiceConstants.ARRAY_INDEX_TWO));
    StationType stationType = StationType.valueOf(tokens.get(ServiceConstants.ARRAY_INDEX_THREE));
    checkInService.checkIn(cardId,passengerType,stationType);

    }
}

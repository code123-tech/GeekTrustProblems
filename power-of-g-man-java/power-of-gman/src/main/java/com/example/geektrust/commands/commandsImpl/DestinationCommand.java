package com.example.geektrust.commands.commandsImpl;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.modal.Point;
import com.example.geektrust.service.IDestinationService;

import java.util.List;

public class DestinationCommand implements ICommand {
    private final IDestinationService destinationService;

    public DestinationCommand(IDestinationService destinationService){
        this.destinationService = destinationService;
    }
    @Override
    public void execute(List<String> tokens) {
        try {
            Integer dx = Integer.parseInt(tokens.get(ServiceConstants.ARRAY_INDEX_ONE));
            Integer dy = Integer.parseInt(tokens.get(ServiceConstants.ARRAY_INDEX_TWO));
            Integer gameId = ServiceConstants.GAME_ID;
            Point point = new Point(dx, dy);
            destinationService.addDestination(point, gameId);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

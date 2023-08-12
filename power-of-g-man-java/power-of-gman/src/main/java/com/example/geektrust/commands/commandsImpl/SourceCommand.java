package com.example.geektrust.commands.commandsImpl;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.modal.Point;
import com.example.geektrust.service.ISourceService;

import java.util.List;

public class SourceCommand implements ICommand {
    private final ISourceService sourceService;

    public SourceCommand(ISourceService sourceService){
        this.sourceService = sourceService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            Integer sx = Integer.parseInt(tokens.get(ServiceConstants.ARRAY_INDEX_ONE));
            Integer sy = Integer.parseInt(tokens.get(ServiceConstants.ARRAY_INDEX_TWO));
            String direction = tokens.get(ServiceConstants.ARRAY_INDEX_THREE);
            Point point = new Point(sx, sy);
            sourceService.addPoint(point, direction, ServiceConstants.INITIAL_POWER);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

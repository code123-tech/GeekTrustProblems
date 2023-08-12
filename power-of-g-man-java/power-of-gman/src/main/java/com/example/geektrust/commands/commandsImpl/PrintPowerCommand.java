package com.example.geektrust.commands.commandsImpl;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.service.IPrintPowerService;

import java.util.List;

public class PrintPowerCommand implements ICommand {
    private final IPrintPowerService printPowerService;

    public PrintPowerCommand(IPrintPowerService printPowerService){
        this.printPowerService = printPowerService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            Integer remainingPower = printPowerService.calculateGamePower(ServiceConstants.GAME_ID);
            System.out.println(ServiceConstants.POWER_STRING + " " + remainingPower);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.example.geektrust.commands.CommandsImpl;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.services.IBalanceService;

import java.util.List;

public class BalanceCommand implements ICommand {

    private final IBalanceService balanceService;

    public BalanceCommand(IBalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @Override
    public void execute(List<String> tokens) {
        String cardId = tokens.get(ServiceConstants.ARRAY_INDEX_ONE);
        try {
            Long balance = Long.parseLong(tokens.get(ServiceConstants.ARRAY_INDEX_TWO));
            MetroCard metroCard = new MetroCard(balance, cardId);
            balanceService.addCard(metroCard);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

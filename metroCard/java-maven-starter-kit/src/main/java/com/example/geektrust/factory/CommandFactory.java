package com.example.geektrust.factory;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.beans.ApplicationBeans;
import com.example.geektrust.common.constants.CommandsConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.exceptions.NoSuchCommandException;

public class CommandFactory {

    private final ICommand balanceCommand;
    private final ICommand checkInCommand;
    private final ICommand printSummaryCommand;

    public CommandFactory(ICommand balanceCommand, ICommand checkInCommand, ICommand printSummaryCommand){
        this.balanceCommand = balanceCommand;
        this.checkInCommand = checkInCommand;
        this.printSummaryCommand = printSummaryCommand;
    }
    public ICommand getCommandImplementationByCommandName(String command){
        ICommand iCommand = null;
        switch(command){
            case CommandsConstants.BALANCE_COMMAND:
                iCommand = this.balanceCommand;
                break;
            case CommandsConstants.CHECKIN_COMMAND:
                iCommand = this.checkInCommand;
                break;
            case CommandsConstants.PRINT_SUMMARY_COMMAND:
                iCommand = this.printSummaryCommand;
                break;
            default:
                System.out.println(ServiceConstants.NO_SUCH_COMMAND_FOUND);
                throw new NoSuchCommandException();
        }
        return iCommand;
    }
}

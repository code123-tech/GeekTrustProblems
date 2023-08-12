package com.example.geektrust.factory;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.CommandsConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.exceptions.NoSuchCommandException;

public class CommandFactory {

    private final ICommand sourceCommand;
    private final ICommand destinationCommand;
    private final ICommand printPowerCommand;

    public CommandFactory(ICommand sourceCommand, ICommand destinationCommand, ICommand printPowerCommand){
        this.sourceCommand = sourceCommand;
        this.destinationCommand = destinationCommand;
        this.printPowerCommand = printPowerCommand;
    }
    public ICommand getCommandImplementationByCommandName(String command){
        ICommand iCommand = null;
        switch(command){
            case CommandsConstants.SOURCE_COMMAND:
                iCommand = this.sourceCommand;
                break;
            case CommandsConstants.DESTINATION_COMMAND:
                iCommand = this.destinationCommand;
                break;
            case CommandsConstants.PRINT_POWER_COMMAND:
                iCommand = this.printPowerCommand;
                break;
            default:
                System.out.println(ServiceConstants.NO_SUCH_COMMAND_FOUND + ": " + command);
                throw new NoSuchCommandException(ServiceConstants.NO_SUCH_COMMAND_FOUND);
        }
        return iCommand;
    }
}

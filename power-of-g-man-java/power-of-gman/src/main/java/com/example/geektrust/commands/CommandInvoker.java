package com.example.geektrust.commands;

import com.example.geektrust.common.exceptions.NoSuchCommandException;
import com.example.geektrust.factory.CommandFactory;

import java.util.List;

public class CommandInvoker {
    private final CommandFactory commandFactory;
    public CommandInvoker(CommandFactory commandFactory){
        this.commandFactory = commandFactory;
    }
    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = commandFactory.getCommandImplementationByCommandName(commandName);
        command.execute(tokens);
    }
}

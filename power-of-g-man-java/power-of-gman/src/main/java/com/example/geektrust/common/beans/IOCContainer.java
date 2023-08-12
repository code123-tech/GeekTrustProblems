package com.example.geektrust.common.beans;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.commandsImpl.DestinationCommand;
import com.example.geektrust.commands.commandsImpl.PrintPowerCommand;
import com.example.geektrust.commands.commandsImpl.SourceCommand;
import com.example.geektrust.factory.CommandFactory;
import com.example.geektrust.repository.IGameRepository;
import com.example.geektrust.repository.IGridRepository;
import com.example.geektrust.repository.IPointRepository;
import com.example.geektrust.repository.Impl.GameRepositoryImpl;
import com.example.geektrust.repository.Impl.GridRepositoryImpl;
import com.example.geektrust.repository.Impl.PointRepositoryImpl;
import com.example.geektrust.service.IDestinationService;
import com.example.geektrust.service.IPrintPowerService;
import com.example.geektrust.service.ISourceService;
import com.example.geektrust.service.Impl.DestinationServiceImpl;
import com.example.geektrust.service.Impl.PrintPowerServiceImpl;
import com.example.geektrust.service.Impl.SourceServiceImpl;

public class IOCContainer {
    /**
     * Repository layer beans
     */
    private static final IPointRepository pointRepository = new PointRepositoryImpl();
    private static final IGridRepository gridRepository = new GridRepositoryImpl();
    private static final IGameRepository gameRepository = new GameRepositoryImpl();
    /**
     * Service layer beans
     */
    private static final ISourceService sourceService = new SourceServiceImpl(pointRepository, gameRepository);
    private static final IDestinationService destinationService = new DestinationServiceImpl(gameRepository, pointRepository);
    private static final IPrintPowerService printPowerService = new PrintPowerServiceImpl(gameRepository);
    /**
     * Other Helper Service Beans
     */
    private static final SourceCommand sourceCommand = new SourceCommand(sourceService);
    private static final DestinationCommand destinationCommand = new DestinationCommand(destinationService);
    private static final PrintPowerCommand printPowerCommand = new PrintPowerCommand(printPowerService);
    private static final CommandFactory commandFactory = new CommandFactory(sourceCommand, destinationCommand, printPowerCommand);
    private static final CommandInvoker commandInvoker = new CommandInvoker(commandFactory);
    public CommandInvoker getCommandInvoker() {
        return commandInvoker;
    }
}

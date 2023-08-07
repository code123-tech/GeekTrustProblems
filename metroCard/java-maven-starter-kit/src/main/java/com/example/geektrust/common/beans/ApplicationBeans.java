package com.example.geektrust.common.beans;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.CommandsImpl.BalanceCommand;
import com.example.geektrust.commands.CommandsImpl.CheckInCommand;
import com.example.geektrust.commands.CommandsImpl.PrintSummaryCommand;
import com.example.geektrust.factory.CommandFactory;
import com.example.geektrust.repositories.IMetroCardRepository;
import com.example.geektrust.repositories.IStationRepository;
import com.example.geektrust.repositories.Impl.MetroCardRepositoryImpl;
import com.example.geektrust.repositories.Impl.StationRepositoryImpl;
import com.example.geektrust.services.IBalanceService;
import com.example.geektrust.services.ICheckInService;
import com.example.geektrust.services.IPrintSummaryService;
import com.example.geektrust.services.Impl.BalanceServiceImpl;
import com.example.geektrust.services.Impl.CheckInServiceImpl;
import com.example.geektrust.services.Impl.PrintSummaryServiceImpl;

public class ApplicationBeans {
    /**
     * Repository layer beans
     */
    private static final IMetroCardRepository metroCardRepository = new MetroCardRepositoryImpl();
    private static final IStationRepository stationRepository = new StationRepositoryImpl();
    /**
     * Service layer beans
     */
    private static final IBalanceService balanceService = new BalanceServiceImpl(metroCardRepository);
    private static final ICheckInService checkInService = new CheckInServiceImpl(stationRepository, metroCardRepository, balanceService);
    private static final IPrintSummaryService printSummaryService = new PrintSummaryServiceImpl(stationRepository);
    /**
     * Other Helper Service Beans
     */
    private static final BalanceCommand balanceCommand = new BalanceCommand(balanceService);
    private static final CheckInCommand checkInCommand = new CheckInCommand(checkInService);
    private static final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(printSummaryService);
    private static final CommandFactory commandFactory = new CommandFactory(balanceCommand, checkInCommand, printSummaryCommand);
    private static final CommandInvoker commandInvoker = new CommandInvoker(commandFactory);
    public CommandInvoker getCommandInvoker() {
        return commandInvoker;
    }
}

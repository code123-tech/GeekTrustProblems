package com.example.geektrust.commands.CommandsImpl;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.services.IPrintSummaryService;

import java.util.List;

public class PrintSummaryCommand implements ICommand {

    private final IPrintSummaryService printSummaryService;

    public PrintSummaryCommand(IPrintSummaryService printSummaryService) {
        this.printSummaryService = printSummaryService;
    }

    @Override
    public void execute(List<String> tokens) {
        printSummaryService.printSummary();
    }
}

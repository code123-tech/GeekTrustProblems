package com.example.geektrust.factory;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.CommandsConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.exceptions.CardNotFoundException;
import com.example.geektrust.common.exceptions.NoSuchCommandException;
import com.example.geektrust.entities.MetroCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("CommandFactoryTest")
@ExtendWith(MockitoExtension.class)
public class CommandFactoryTest {
    @Mock
    private ICommand balanceCommand;
    @Mock
    private ICommand checkInCommand;
    @Mock
    private ICommand printSummaryCommand;

    @InjectMocks
    private CommandFactory commandFactory;

    @Test
    @DisplayName("test balance command object from factory.")
    public void testBalanceCommand(){
        // inputs
        String command = CommandsConstants.BALANCE_COMMAND;

        // Verify
        Assertions.assertNotNull(commandFactory.getCommandImplementationByCommandName(command));
    }
    @Test
    @DisplayName("test checkIn command object from factory.")
    public void testCheckInCommand(){
        // inputs
        String command = CommandsConstants.CHECKIN_COMMAND;

        // Verify
        Assertions.assertNotNull(commandFactory.getCommandImplementationByCommandName(command));
    }
    @Test
    @DisplayName("test print summary command object from factory.")
    public void testPrintSummaryCommand(){
        // inputs
        String command = CommandsConstants.PRINT_SUMMARY_COMMAND;

        // Verify
        Assertions.assertNotNull(commandFactory.getCommandImplementationByCommandName(command));
    }
    @Test
    @DisplayName("test no command exception.")
    public void testNoSuchCommandException(){
        // inputs
        String command = "no command";

        // verify
        NoSuchCommandException exception = Assertions.assertThrows(NoSuchCommandException.class, ()->commandFactory.getCommandImplementationByCommandName(command));
        Assertions.assertNotNull(exception);
    }
}

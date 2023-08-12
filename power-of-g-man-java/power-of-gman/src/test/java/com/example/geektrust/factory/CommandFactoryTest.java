package com.example.geektrust.factory;

import com.example.geektrust.commands.ICommand;
import com.example.geektrust.common.constants.CommandsConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.exceptions.NoSuchCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("CommandFactoryTest")
@ExtendWith(MockitoExtension.class)
public class CommandFactoryTest {
    @Mock
    private ICommand sourceCommand;
    @Mock
    private ICommand destinationCommand;
    @Mock
    private ICommand printPowerCommand;

    @InjectMocks
    private CommandFactory commandFactory;

    @Test
    @DisplayName("test source command object from factory.")
    public void testSourceCommand(){
        // inputs
        String command = CommandsConstants.SOURCE_COMMAND;

        // Verify
        Assertions.assertNotNull(commandFactory.getCommandImplementationByCommandName(command));
    }
    @Test
    @DisplayName("test destination command object from factory.")
    public void testDestinationCommand(){
        // inputs
        String command = CommandsConstants.DESTINATION_COMMAND;

        // Verify
        Assertions.assertNotNull(commandFactory.getCommandImplementationByCommandName(command));
    }
    @Test
    @DisplayName("test print power command object from factory.")
    public void testPrintPowerCommand(){
        // inputs
        String command = CommandsConstants.PRINT_POWER_COMMAND;

        // Verify
        Assertions.assertNotNull(commandFactory.getCommandImplementationByCommandName(command));
    }
    @Test
    @DisplayName("test no command exception.")
    public void testNoSuchCommandException(){
        // inputs
        String command = ServiceConstants.NO_SUCH_COMMAND_FOUND;

        // verify
        NoSuchCommandException exception = Assertions.assertThrows(NoSuchCommandException.class, ()->commandFactory.getCommandImplementationByCommandName(command));
        Assertions.assertNotNull(exception);
    }
}

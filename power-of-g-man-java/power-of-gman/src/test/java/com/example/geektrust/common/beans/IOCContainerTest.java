package com.example.geektrust.common.beans;

import com.example.geektrust.commands.CommandInvoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("ApplicationBeansTest")
@ExtendWith(MockitoExtension.class)
public class IOCContainerTest {
    @InjectMocks
    private IOCContainer iocContainer;

    @Test
    @DisplayName("Test Get Command Invoker")
    public void testGetCommandInvoker(){
        // inputs

        // Output
        CommandInvoker commandInvoker = iocContainer.getCommandInvoker();

        // Verify
        Assertions.assertNotNull(commandInvoker);
    }
}

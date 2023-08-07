package com.example.geektrust.common.beans;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.common.enums.StationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@DisplayName("ApplicationBeansTest")
@ExtendWith(MockitoExtension.class)
public class ApplicationBeansTest {
    @InjectMocks
    private ApplicationBeans applicationBeans;

    @Test
    @DisplayName("Test Get Command Invoker")
    public void testGetCommandInvoker(){
        // inputs

        // Output
        CommandInvoker commandInvoker = applicationBeans.getCommandInvoker();

        // Verify
        Assertions.assertNotNull(commandInvoker);
    }
}

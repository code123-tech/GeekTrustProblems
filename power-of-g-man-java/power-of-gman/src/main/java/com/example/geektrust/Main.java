package com.example.geektrust;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.common.beans.IOCContainer;
import com.example.geektrust.common.exceptions.NoSuchCommandException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IOCContainer iocContainer = new IOCContainer();
        CommandInvoker commandInvoker = iocContainer.getCommandInvoker();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | NoSuchCommandException e) {
            e.printStackTrace();
        }
    }
}

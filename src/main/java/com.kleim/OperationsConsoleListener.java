package com.kleim;


import com.kleim.operations.ConsoleOperationType;
import com.kleim.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class OperationsConsoleListener {

    private final Scanner scanner;
    private final Map<ConsoleOperationType, OperationCommandProcessor> processorMap;


    public OperationsConsoleListener(Scanner scanner, List<OperationCommandProcessor> commandProcessorList) {
        this.scanner = scanner;
        this.processorMap =
                commandProcessorList
                        .stream()
                        .collect(
                                Collectors.toMap(
                                        OperationCommandProcessor::operationType,
                                        processor -> processor
                                )
                        );
    }


    public void consoleListener() {
        System.out.println("Type operations");
        while (!Thread.currentThread().isInterrupted()) {
            var operationType = listenNextOperation();
            if (operationType == null) {
                return;
            }
            processNextOperation(operationType);
        }
    }

    private ConsoleOperationType listenNextOperation() {

        System.out.println("Type next operations");
        printAllAvailableOperations();
        while (!Thread.currentThread().isInterrupted()) {
            var nextOperation = scanner.nextLine();
            try {
                var message = ConsoleOperationType.valueOf(nextOperation);
                return message;
            } catch (IllegalArgumentException e) {
                System.out.println("No such command found");
                e.getStackTrace();
            }
        }
        return null;
    }



    public void processNextOperation(ConsoleOperationType operation) {
       try {
           var processor = processorMap.get(operation);
           processor.processOperation();
       } catch (Exception e) {
           System.out.printf("Next operation not complete=%s\n", operation);
       }

    }



    private void printAllAvailableOperations() {
        processorMap.keySet().forEach(System.out::println);
    }

    public void startListen() {
        System.out.println("Console listener started;");
    }

    public void endListen() {
        System.out.println("Console listener ending;");

    }
}

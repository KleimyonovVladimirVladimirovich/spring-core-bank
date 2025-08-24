package com.kleim;


import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;
import java.util.Map;
import java.util.Scanner;

public class OperationsConsoleListener {

    private final Scanner scanner;
    private final Map<ConsoleOperationType, OperationCommandProcessor> processorMap;


    public OperationsConsoleListener(Scanner scanner, Map<ConsoleOperationType, OperationCommandProcessor> processorMap) {
        this.scanner = scanner;
        this.processorMap = processorMap;
    }


    public void consoleListener() {
        System.out.println("Type operations");
        while (true) {
             var operationType = listenNextOperation();
              processNextOperation(operationType);
        }
    }

    private ConsoleOperationType listenNextOperation() {

      System.out.println("Type next operations");
      printAllAvailableOperations();
      while (true) {
      var nextOperation = scanner.nextLine();
      try {
          var message = ConsoleOperationType.valueOf(nextOperation); // TODO: check later
          return message;
      } catch (IllegalArgumentException e) {
          System.out.println("No such command found");
          e.getStackTrace();
      }
      return null;
      }
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
        processorMap.keySet().forEach(it -> System.out.println(it));
    }

    public void startListen() {
        System.out.println("Console listener started;");
    }

    public void endListen() {
        System.out.println("Console listener ending;");

    }
}

package com.kleim.operations;


public interface OperationCommandProcessor {

    void processOperation();

    ConsoleOperationType operationType();

}

package operations.processors;

import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;

public class TransferAccountProcessor implements OperationCommandProcessor {
    @Override
    public void processOperation() {

    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.ACCOUNT_TRANSFER;
    }
}

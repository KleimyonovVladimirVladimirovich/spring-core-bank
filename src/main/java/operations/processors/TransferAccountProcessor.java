package operations.processors;

import com.kleim.service.AccountService;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;

import java.util.Scanner;

public class TransferAccountProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final AccountService accountService;

    public TransferAccountProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter sender id: \n");
        int accountFrom = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter receiver id: \n");
        int accountTo = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to transfer: \n");
        int amountToTransfer = Integer.parseInt(scanner.nextLine());
        accountService.transfer(accountFrom, accountTo, amountToTransfer);
        System.out.println("Successfully transfer FROM %s TO %s. Amount to transfer: %s%n".formatted(accountFrom,accountTo,amountToTransfer));
    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.ACCOUNT_TRANSFER;
    }
}

package com.kleim.operations.processors;

import com.kleim.service.AccountService;
import com.kleim.operations.ConsoleOperationType;
import com.kleim.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class DepositAccountProcessor implements OperationCommandProcessor {

    private final AccountService accountService;
    private final Scanner scanner;

    public DepositAccountProcessor(AccountService accountService, Scanner scanner) {
        this.accountService = accountService;

        this.scanner = scanner;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter your account id: \n");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to deposit: ");
        int amountToDeposit = Integer.parseInt(scanner.nextLine());
        accountService.depositAccount(accountId, amountToDeposit);
        System.out.println("Successful deposit to account id: %s, money to account: %s%n".formatted(accountId, amountToDeposit));
    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.ACCOUNT_DEPOSIT;
    }
}

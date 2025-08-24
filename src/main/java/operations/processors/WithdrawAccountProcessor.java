package operations.processors;

import com.kleim.service.AccountService;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;

import java.util.Scanner;

public class WithdrawAccountProcessor implements OperationCommandProcessor {
    private final AccountService accountService;
    private final Scanner scanner;

    public WithdrawAccountProcessor(AccountService accountService, Scanner scanner) {
        this.accountService = accountService;

        this.scanner = scanner;
    }
    @Override
    public void processOperation() {
        System.out.println("Enter your account id: \n");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to deposit: ");
        int amountToWithdraw = Integer.parseInt(scanner.nextLine());
        accountService.withdrawToAccount(accountId, amountToWithdraw);
        System.out.println("Successful withdraw to account id: %s, money to account: %s%n".formatted(accountId, amountToWithdraw));
    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.ACCOUNT_WITHDRAW;
    }
}

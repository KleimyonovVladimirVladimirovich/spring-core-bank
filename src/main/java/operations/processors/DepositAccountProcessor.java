package operations.processors;

import com.kleim.entity.Account;
import com.kleim.service.AccountService;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

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

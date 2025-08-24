package operations.processors;

import com.kleim.entity.Account;
import com.kleim.entity.User;
import com.kleim.service.AccountService;
import com.kleim.service.UserService;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class CloseAccountProcessor implements OperationCommandProcessor {

    private final AccountService accountService;
    private final UserService userService;
    private final Scanner scanner;

    public CloseAccountProcessor(AccountService accountService, UserService userService, Scanner scanner) {
        this.accountService= accountService;
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter account id to close: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        Account account = accountService.closeAccount(accountId);
        User user = userService.findUserById(account.getUserId()).orElseThrow(() ->
                new IllegalArgumentException("No such user with id: %s".formatted(account.getUserId())));

        user.getAccountList().remove(account);




    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.ACCOUNT_CLOSE;
    }
}

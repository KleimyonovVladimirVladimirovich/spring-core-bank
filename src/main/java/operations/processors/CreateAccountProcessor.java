package operations.processors;

import com.kleim.entity.Account;
import com.kleim.entity.User;
import com.kleim.service.AccountService;
import com.kleim.service.UserService;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;

import java.util.Scanner;

public class CreateAccountProcessor implements OperationCommandProcessor {

    private final Scanner scanner;
    private final AccountService accountService;
    private final UserService userService;

    public CreateAccountProcessor(Scanner scanner, AccountService accountService, UserService userService) {
        this.scanner = scanner;
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter user id: ");

        int userId = Integer.parseInt(scanner.nextLine());
        User user = userService.findUserById(userId).orElseThrow(() ->
                new IllegalArgumentException("No such user with this id:%s".formatted(userId)));

        Account account = accountService.createAccount(user);
        user.getAccountList().add(account);

        System.out.printf("Account was created successful with id: %s for user: %s%n", account.getId(), user.getLogin());
    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.ACCOUNT_CREATE;
    }

}

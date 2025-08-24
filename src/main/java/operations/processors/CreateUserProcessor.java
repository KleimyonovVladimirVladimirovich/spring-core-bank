package operations.processors;

import com.kleim.entity.User;
import com.kleim.service.UserService;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;

import java.util.Scanner;

public class CreateUserProcessor implements OperationCommandProcessor {

    private final Scanner scanner;
    private final UserService userService;

    public CreateUserProcessor(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter login for create new user: ");

        String login = scanner.nextLine();
        User user = userService.createUser(login);

        System.out.println("User created: " + user.toString());
    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.USER_CREATE;
    }

}

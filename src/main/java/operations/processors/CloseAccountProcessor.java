package operations.processors;

import com.kleim.entity.User;
import com.kleim.service.UserService;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class CloseAccountProcessor implements OperationCommandProcessor {

    private final   UserService userService;
    private final Scanner scanner;

    public CloseAccountProcessor(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void processOperation() {
        System.out.println("Please, type id user, which need to  delete: ");
        int userId = Integer.parseInt(scanner.nextLine());
        User user = userService.findUserById(userId).orElseThrow(() ->
                new IllegalArgumentException("No such user with id= %s".formatted(userId)));




    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.ACCOUNT_CLOSE;
    }
}

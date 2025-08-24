package com.kleim.operations.processors;

import com.kleim.entity.User;
import com.kleim.service.UserService;
import com.kleim.operations.ConsoleOperationType;
import com.kleim.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class ShowAllUserProcessors implements OperationCommandProcessor {

    private final UserService userService;

    public ShowAllUserProcessors(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        List<User> userList = userService.getAllUsers();

        if (!userList.isEmpty()) {
            System.out.println("List of all users: ");
            userList.forEach(user -> System.out.println(userList));  // TODO: CHECH LATER
        } else {
            System.out.println("Now, user list is empty.");
        }
    }

    @Override
    public ConsoleOperationType operationType() {
        return ConsoleOperationType.SHOW_ALL_USERS;
    }
}

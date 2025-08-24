package com.kleim.configuration;

import com.kleim.OperationsConsoleListener;
import operations.ConsoleOperationType;
import operations.OperationCommandProcessor;
import operations.processors.CreateAccountProcessor;
import operations.processors.CreateUserProcessor;
import operations.processors.DepositAccountProcessor;
import operations.processors.ShowAllUserProcessors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kleim.service.AccountService;
import com.kleim.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public Scanner scanner() {
      return new Scanner(System.in);
    }


    @Bean
    public OperationsConsoleListener operationsConsoleListener (
            Scanner scanner,
            List<OperationCommandProcessor> commandProcessorList
    ) {
        Map<ConsoleOperationType, OperationCommandProcessor> map =
                commandProcessorList
                        .stream()
                        .collect(
                                Collectors.toMap(
                                        OperationCommandProcessor::operationType,
                                        processor -> processor
                                )
        );
        return new OperationsConsoleListener(scanner, map);
    }


    @Bean
    public UserService userService() {
        return new UserService();
    }


    @Bean
    public AccountService accountService() {
        return new AccountService();
    }


    @Bean
    public CreateUserProcessor createUserProcessor(Scanner scanner, UserService userService) {
        return new CreateUserProcessor(scanner,userService);
    }


    @Bean
    public CreateAccountProcessor createAccountProcessor(Scanner scanner, AccountService accountService, UserService userService) {
        return new CreateAccountProcessor(scanner,accountService,userService);
    }


    @Bean
    public ShowAllUserProcessors showAllUserProcessors(UserService userService) {
        return new ShowAllUserProcessors(userService);
    }

    @Bean
    public DepositAccountProcessor depositAccountProcessor(AccountService accountService, Scanner scanner) {
        return new DepositAccountProcessor(accountService, scanner);
    }

}

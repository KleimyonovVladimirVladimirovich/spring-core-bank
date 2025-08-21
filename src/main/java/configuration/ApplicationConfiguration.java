package configuration;

import com.kleim.OperationsConsoleListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.AccountService;
import service.UserService;

import java.util.Scanner;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Scanner scanner() {
      return new Scanner(System.in);
    }

    @Bean
    public OperationsConsoleListener operationsConsoleListener (
            Scanner scanner
    ) {
        return new OperationsConsoleListener(scanner);
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public AccountService accountService() {
        return new AccountService();
    }
}

package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class UserService {

    private final Map<Integer, User> userMap;
    private final Set<String> takingLogins;
    private int idCounter;
    private final AccountService accountService;

    @Autowired
    public UserService(AccountService accountService) {
        this.accountService = accountService;
        this.takingLogins = new HashSet<>();
;        this.userMap = new HashMap<>();
        this.idCounter = 0;
    }


    public User createUser(String login) {
        if (takingLogins.contains(login)) {
            throw new IllegalArgumentException("User already exist with this login=%s".formatted(login));
        }
        takingLogins.add(login);
        idCounter++;
        var newUser = new User(idCounter, login, new ArrayList<>());

        var newAccount = accountService.createAccount(newUser);
        newUser.getAccountList().add(newAccount);
        userMap.put(newUser.getId(), newUser);
        return newUser;
    }

    public Optional<User> findUserById(int id) {
        return Optional.ofNullable(userMap.get(id));
    }

    public List<User> getAllUsers() {
        return userMap.values().stream().toList();
    }

}
























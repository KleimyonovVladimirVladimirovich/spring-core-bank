package com.kleim.service;

import com.kleim.entity.Account;
import com.kleim.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class UserService {

    private final Map<Integer, User> userMap;
    private final Set<String> takingLogins;
    private int idCounter;
    @Autowired
    private AccountService accountService;



    public UserService() {
        this.takingLogins = new HashSet<>();
;       this.userMap = new HashMap<>();
        this.idCounter = 0;
    }



    public User createUser(String login) {
        if (takingLogins.contains(login)) {
            throw new IllegalArgumentException("User already exist with this login=%s".formatted(login));
        }
        takingLogins.add(login);
        idCounter++;
        User user = new User(idCounter, login, new ArrayList<>());
        Account account = accountService.createAccount(user);
        user.getAccountList().add(account);
        userMap.put(user.getId(), user);
        return user;
    }



    public Optional<User> findUserById(int id) {
        return Optional.ofNullable(userMap.get(id));
    }



    public List<User> getAllUsers() {
        return userMap
                .values()
                .stream()
                .toList();
    }

}
























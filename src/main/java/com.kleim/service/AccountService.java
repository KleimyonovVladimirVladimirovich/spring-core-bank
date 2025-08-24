package com.kleim.service;

import com.kleim.entity.Account;
import com.kleim.entity.User;

import java.util.*;

public class AccountService {

    private final Map<Integer, Account> accountMap;
    private int idCounter;
//    private final User user;


    public AccountService() {
        this.accountMap = new HashMap<>();
        this.idCounter = 0;

    }

    public Account createAccount(User user) {
      idCounter++;
      Account account = new Account(idCounter,user.getId(), 0);
      accountMap.put(account.getId(), account);
      return account;
    }


    public Optional<Account> findAccountById(int id) {
       return Optional.ofNullable(accountMap.get(id));
    }


    public List<Account> getAllUsersAccounts(int userId) {
       return accountMap.values().stream()
               .filter(account -> account.getUserId() == userId)
               .toList();
    }


    public void depositAccount(int accountId, int moneyToDeposit) {
        Account account = findAccountById(accountId)
                .orElseThrow(() ->
                        new IllegalArgumentException("No such account with id=%s".formatted(accountId)));
        if (moneyToDeposit <= 0) {
            throw new IllegalArgumentException("No money");
        }
        account.setMoneyAmount(account.getMoneyAmount() + moneyToDeposit);
    }

    public void withdrawToAccount(int accountId, int amountToWithdraw) {
        Account account = findAccountById(accountId)
                .orElseThrow(() ->
                        new IllegalArgumentException("No such account with id=%s".formatted(accountId)));
        if (amountToWithdraw <= 0) {
            throw new IllegalArgumentException("No access to operation, your account do not will have negative amount");
        }
        if (account.getMoneyAmount() < amountToWithdraw) {
            throw new IllegalArgumentException("Cannot withdraw from account id %s, money to account: %s%n".formatted(accountId, account.getMoneyAmount()));
        }
    }
}





















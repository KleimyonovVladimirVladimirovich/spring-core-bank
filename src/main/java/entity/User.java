package entity;

import java.util.List;


public class User {

    private Long id;

    private String login;

    List<String> accountList;

    public User(Long id, String login, List<String> accountList) {
        this.id = id;
        this.login = login;
        this.accountList = accountList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }
}

package entity;


public class Account {

    private Long id;
    private Long userId;
    private Long moneyAmount;

    public Account(Long id, Long userId, Long moneyAmount) {
        this.id = id;
        this.userId = userId;
        this.moneyAmount = moneyAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Long moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}

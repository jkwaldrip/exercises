package bank.account;

import bank.exceptions.WithdrawalLimitException;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public static final String SAVINGS = "Savings";
    public static final String CHECKING = "Checking";

    private String type;
    private String owner;
    private Integer withdrawalLimit;
    private Integer balance;

    public Integer deposit(Integer amount) {
        this.balance += amount;
        return this.balance;
    }

    public Integer withdraw(Integer amount) throws WithdrawalLimitException {
        if (this.withdrawalLimit == null || amount < this.withdrawalLimit) {
            this.balance -= amount;
            return this.balance;
        } else {
            throw new WithdrawalLimitException(
                    amount,
                    this.withdrawalLimit
            );
        }
    }

    public <T extends Account> List<Integer> transfer(Integer amount, T toAccount) {
        List<Integer> balancesList = new ArrayList<>();
        balancesList.add(withdraw(amount));
        balancesList.add(toAccount.deposit(amount));
        return balancesList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public <T extends Account> T withOwner(String owner) {
        setOwner(owner);
        return (T) this;
    }

    public Integer getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(Integer withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public <T extends Account> T withBalance(Integer balance) {
        setBalance(balance);
        return (T) this;
    }

}

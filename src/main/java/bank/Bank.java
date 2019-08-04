package bank;

import bank.account.Account;

import java.util.List;

public class Bank {

    private String name;
    private List<Account> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank withName(String name) {
        setName(name);
        return this;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank withAccounts(List<Account> accounts) {
        setAccounts(accounts);
        return this;
    }
}

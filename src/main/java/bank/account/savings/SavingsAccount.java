package bank.account.savings;

import bank.account.Account;

public class SavingsAccount extends Account {

    public SavingsAccount() {
        super();
        setType(SAVINGS);
    }
}

package bank.account.checking;

import bank.account.Account;

public class CheckingAccount extends Account {

    public static final String INDIVIDUAL = "Individual";
    public static final String MONEY_MARKET = "Money Market";

    private String checkingType;

    public CheckingAccount() {
        super();
        setType(Account.CHECKING);
    }

    public String getCheckingType() {
        return checkingType;
    }

    public void setCheckingType(String checkingType) {
        this.checkingType = checkingType;
    }
}

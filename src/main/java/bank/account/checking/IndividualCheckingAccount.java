package bank.account.checking;

public class IndividualCheckingAccount extends CheckingAccount {

    public IndividualCheckingAccount() {
        super();
        setCheckingType(INDIVIDUAL);
        setWithdrawalLimit(1000);
    }
}

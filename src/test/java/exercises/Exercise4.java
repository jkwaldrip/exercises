package exercises;

import bank.account.Account;
import bank.Bank;
import bank.account.checking.IndividualCheckingAccount;
import bank.account.checking.MoneyMarketCheckingAccount;
import bank.account.savings.SavingsAccount;
import bank.exceptions.WithdrawalLimitException;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static bank.account.Account.CHECKING;
import static bank.account.Account.SAVINGS;
import static bank.account.checking.CheckingAccount.INDIVIDUAL;
import static bank.account.checking.CheckingAccount.MONEY_MARKET;
import static org.assertj.core.api.Assertions.assertThat;

public class Exercise4 {

    private Bank bank;
    private IndividualCheckingAccount individualCheckingAccount;
    private MoneyMarketCheckingAccount moneyMarketCheckingAccount;
    private SavingsAccount savingsAccount;
    private List<Account> accountsList;

    @Before
    public void setup() {
        Faker faker = new Faker();

        this.individualCheckingAccount = new IndividualCheckingAccount()
                .withOwner(faker.name().fullName())
                .withBalance(2000);
        this.moneyMarketCheckingAccount = new MoneyMarketCheckingAccount()
                .withOwner(faker.name().fullName())
                .withBalance(2000);
        this.savingsAccount = new SavingsAccount()
                .withOwner(faker.name().fullName())
                .withBalance(2000);

        this.accountsList = Arrays.asList(
                this.individualCheckingAccount,
                this.moneyMarketCheckingAccount,
                this.savingsAccount
        );

        this.bank = new Bank()
                .withName(faker.commerce().productName() + " Bank")
                .withAccounts(this.accountsList);
    }

    @Test
    public void bankHasName() {
        assertThat(this.bank.getName())
                .isNotBlank();
    }

    @Test
    public void bankHasAccounts() {
        assertThat(this.bank.getAccounts())
                .isNotEmpty()
                .isEqualTo(this.accountsList);
    }

    @Test
    public void savingsAccountHasOwner() {
        assertThat(this.savingsAccount.getOwner())
                .isNotBlank();
    }

    @Test
    public void individualCheckingAccountHasOwner() {
        assertThat(this.individualCheckingAccount.getOwner())
                .isNotBlank();
    }

    @Test
    public void moneyMarketCheckingAccountHasOwner() {
        assertThat(this.moneyMarketCheckingAccount.getOwner())
                .isNotBlank();
    }

    @Test
    public void individualCheckingAccountHasCheckingType() {
        assertThat(this.individualCheckingAccount.getType())
                .isEqualTo(CHECKING);
    }

    @Test
    public void moneyMarketCheckingAccountHasCheckingType() {
        assertThat(this.moneyMarketCheckingAccount.getType())
                .isEqualTo(CHECKING);
    }

    @Test
    public void savingsAccountHasSavingsType() {
        assertThat(this.savingsAccount.getType())
                .isEqualTo(SAVINGS);
    }

    @Test
    public void checkingAccountHasIndividualType() {
        assertThat(this.individualCheckingAccount.getCheckingType())
                .isEqualTo(INDIVIDUAL);
    }

    @Test
    public void checkingAccountHasMoneyMarketType() {
        assertThat(this.moneyMarketCheckingAccount.getCheckingType())
                .isEqualTo(MONEY_MARKET);
    }

    @Test
    public void individualAccountHasWithdrawalLimit() {
        assertThat(this.individualCheckingAccount.getWithdrawalLimit())
                .isEqualTo(1000);
    }

    @Test
    public void savingsAccountAcceptsDeposit() {
        assertThat(this.savingsAccount.deposit(100))
                .isEqualTo(2100);
    }

    @Test
    public void individualCheckingAccountAcceptsDeposit() {
        assertThat(this.individualCheckingAccount.deposit(200))
                .isEqualTo(2200);
    }

    @Test
    public void moneyMarketCheckingAccountAcceptsDeposit() {
        assertThat(this.moneyMarketCheckingAccount.deposit(300))
                .isEqualTo(2300);
    }

    @Test
    public void savingsAccountAcceptsWithdrawal() throws WithdrawalLimitException {
        assertThat(this.savingsAccount.withdraw(1500))
                .isEqualTo(500);
    }

    @Test
    public void individualCheckingAccountAcceptsWithdrawal() throws WithdrawalLimitException {
        assertThat(this.individualCheckingAccount.withdraw(100))
                .isEqualTo(1900);
    }

    @Test
    public void moneyMarketCheckingAccountAcceptsWithdrawal() throws WithdrawalLimitException {
        assertThat(this.moneyMarketCheckingAccount.withdraw(1600))
                .isEqualTo(400);
    }

    @Test
    public void accountAcceptsTransfer() {
        List<Integer> balancesList = this.savingsAccount.transfer(
                500,
                this.individualCheckingAccount
        );

        assertThat(balancesList)
                .contains(1500, 2500);

        assertThat(this.savingsAccount.getBalance())
                .isEqualTo(1500);

        assertThat(this.individualCheckingAccount.getBalance())
                .isEqualTo(2500);
    }

    @Test(expected = WithdrawalLimitException.class)
    public void withdrawalDoesNotExceedLimit() {
        this.individualCheckingAccount.withdraw(1001);
    }

    @Test(expected = WithdrawalLimitException.class)
    public void transferDoesNotExceedLimit() {
        this.individualCheckingAccount.transfer(
                1001,
                this.savingsAccount
        );
    }
}

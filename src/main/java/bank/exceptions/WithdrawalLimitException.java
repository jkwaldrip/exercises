package bank.exceptions;

public class WithdrawalLimitException extends RuntimeException {

    public WithdrawalLimitException(Integer amount, Integer limit) {
        super(
                "Request withdraw amount exceeds limit\n" +
                        "  Amount: " + amount + "\n" +
                        "  Limit:  " + limit + "\n"
        );
    }
}

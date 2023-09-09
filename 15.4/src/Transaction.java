public class Transaction {
    private int accountNumber;
    private double amount;

    public Transaction(int acc,double a)
    {
        this.accountNumber=acc;
        this.amount=a;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

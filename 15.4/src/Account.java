import java.io.Serializable;

public class Account implements Serializable {
    private int account;
    private String fname;
    private String lname;
    private double balance;

    public Account()
    {
        this (0,"","",0.0);
    }

    public Account(int i, String s, String s1, double v) {
        this.account=i;
        this.fname=s;
        this.lname=s1;
        this.balance=v;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double combine(Transaction transaction)
    {
        return transaction.getAmount() + getBalance();
    }
}

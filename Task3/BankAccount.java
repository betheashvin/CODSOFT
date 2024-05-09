package Task3;


public class BankAccount {
    private double bal;
    public BankAccount(double amount)
    {
        this.bal = amount;
    }

    public double getBalance()
    {
        return this.bal;
    }

    public void setBalance(double amount)
    {
        this.bal = amount;
    }
}

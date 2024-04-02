package banking_application;

public class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
    }

    public boolean withdraw(double amount) 
    {
        if (balance >= amount) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() 
    {
        return balance;
    }
}

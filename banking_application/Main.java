package banking_application;

public class Main 
{
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(0);
        BankSystem bankingSystem = new BankSystem(account);
        bankingSystem.start();
    }
}
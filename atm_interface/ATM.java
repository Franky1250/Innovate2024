package atm_interface;

import java.util.List;
import java.util.Map;

public class ATM 
{

    private Map<String, User> users;

    public ATM(Map<String, User> users) 
    {
        this.users = users;
    }

    public boolean authenticateUser(String id, String pin) 
    {
        if (users.containsKey(id)) 
        {
            User user = users.get(id);
            if (user.getPin().equals(pin)) 
            {
                return true;
            } 
            else 
            {
                return false;
            }
        }
        return false;
    }

    public void showTransactionHistory(String id) 
    {
        if (users.containsKey(id)) 
        {
            User user = users.get(id);
            List<Transaction> transactions = user.getTransactionHistory();
            if (transactions.isEmpty()) 
            {
                System.out.println("No transactions yet.");
            } 
            else 
            {
                System.out.println("Transaction History:");
                for (Transaction transaction : transactions) 
                {
                    System.out.println(transaction.getType() + ": $" + transaction.getAmount() + " at "
                            + transaction.getTimestamp());
                }
            }
        }
    }

    public void deposit(String id, double amount) 
    {
        if (users.containsKey(id)) 
        {
            User user = users.get(id);
            user.addToBalance(amount);
            user.addTransaction(new Transaction("Deposit", amount));
            System.out.println("Deposit successful. Current balance: " + user.getBalance());
        } 
    }

    public void withdraw(String id, double amount) 
    {
        if (users.containsKey(id)) 
        {
            User user = users.get(id);
            if (user.getBalance() >= amount) 
            {
                user.deductFromBalance(amount);
                user.addTransaction(new Transaction("Withdrawal", amount));
                System.out.println("Withdrawal successful. Current balance: Rupees" + user.getBalance());
            } 
            else 
            {
                System.out.println("Insufficient funds.");
            }
        } 
    }

    public void transfer(String senderId, String receiverId, double amount) 
    {
        if (users.containsKey(senderId) && users.containsKey(receiverId)) 
        {
            User sender = users.get(senderId);
            User receiver = users.get(receiverId);
            if (sender.getBalance() >= amount) 
            {
                sender.deductFromBalance(amount);
                receiver.addToBalance(amount);
                sender.addTransaction(new Transaction("Transfer to " + receiverId, amount));
                receiver.addTransaction(new Transaction("Transfer from " + senderId, amount));
                System.out.println("Transfer successful. Current balance: Rupees" + sender.getBalance());
            } 
            else 
            {
                System.out.println("Insufficient funds.");
            }
        }
    }
}

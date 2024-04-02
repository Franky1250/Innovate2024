package atm_interface;

import java.util.Scanner;

public class Menu 
{
	public static void displayMainMenu(ATM atm) 
	{
	    Scanner scanner = new Scanner(System.in);
	    boolean quit = false;
	    boolean isAuthenticated = false;
	    String id = "";
	    String pin = "";

	    while (!quit) 
	    {
	        if (!isAuthenticated) 
	        {
	            System.out.println("Please Enter Your ATM ID And PIN:");
	            System.out.print("Enter your ID: ");
	            id = scanner.nextLine();
	            System.out.print("Enter your PIN: ");
	            pin = scanner.nextLine();

	            if (atm.authenticateUser(id, pin)) 
	            {
	                isAuthenticated = true;
	                System.out.println("Login successful...");
	            } 
	            else 
	            {
	                System.out.println("Invalid ATM ID or PIN. Please try Again...");
	                continue;
	            }
	        }

	        System.out.println("\n"+"Main Menu:");
	        System.out.println("1. Show Transaction History");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw");
	        System.out.println("4. Transfer");
	        System.out.println("5. Quit");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); 

	        switch (choice) 
	        {
	            case 1:
	                atm.showTransactionHistory(id);
	                break;
	            case 2:
	                System.out.print("Enter amount to deposit: Rupees");
	                double depositAmount = scanner.nextDouble();
	                atm.deposit(id, depositAmount);
	                break;
	            case 3:
	                System.out.print("Enter amount to withdraw: Rupees");
	                double withdrawAmount = scanner.nextDouble();
	                atm.withdraw(id, withdrawAmount);
	                break;
	            case 4:
	                System.out.print("Enter receiver ID: ");
	                String receiverId = scanner.nextLine();
	                System.out.print("Enter amount to transfer: Rupees");
	                double transferAmount = scanner.nextDouble();
	                atm.transfer(id, receiverId, transferAmount);
	                break;
	            case 5:
	                quit = true;
	                System.out.println("Thank you for using our ATM system!");
	                break;
	            default:
	                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	        }
	    }
	    scanner.close();
	}
}

package banking_application;

import java.util.Scanner;

public class BankSystem 
{
	private BankAccount account;

	public BankSystem(BankAccount account) 
	{
		this.account = account;
	}

	public void start() 
	{
		Scanner sc = new Scanner(System.in);
		int choice;

		do 
		{
			System.out.println("Simple Banking System");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) 
			{
			case 1:
				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
				System.out.printf("Deposited %.2f successfully.\n", depositAmount);
				break;
			case 2:
				System.out.print("Enter withdrawal amount: ");
				double withdrawalAmount = sc.nextDouble();
				if (account.withdraw(withdrawalAmount)) 
				{
					System.out.printf("Withdrew %.2f successfully.\n", withdrawalAmount);
				} 
				else 
				{
					System.out.println("Insufficient balance.");
				}
				break;
			case 3:
				System.out.printf("Your current balance is: %.2f\n", account.getBalance());
				break;
			case 4:
				System.out.println("Thank you for using our banking system.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} 
		while (choice != 4);

		sc.close();
	}
}
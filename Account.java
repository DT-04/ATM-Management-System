import java.text.*;
import java.util.*;

public class Account 
{
	// variables
	int customerNumber;
	int pinNumber;
	double checkingBalance = 0;
	double savingBalance = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00"); //output money format 

// constructor:
	public Account(int customerNumber, int pinNumber) 
	{
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}

	//parameterized constructor
	public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) 
	{
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}

	//getter and setter method 
	public int setCustomerNumber(int customerNumber) 
	{
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() 
	{
		return customerNumber;
	}

	public int setPinNumber(int pinNumber) 
	{
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() 
	{
		return pinNumber;
	}

	public double getCheckingBalance() 
	{
		return checkingBalance;
	}

	public double getSavingBalance() 
	{
		return savingBalance;
	}

	//method for withdrawing money and counting balance after it
	public double calcCheckingWithdraw(double amount) 
	{
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	//method calculating savingbalance after savingwithdraw
	public double calcSavingWithdraw(double amount) 
	{
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	//method for calculating balance after deposit
	public double calcCheckingDeposit(double amount) 
	{
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	//calculating saving after depositsaving
	public double calcSavingDeposit(double amount) 
	{
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}

	//method for transfering money from account
	public void calcCheckTransfer(double amount) 
	{
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}

	//transfering money from saving account
	public void calcSavingTransfer(double amount) 
	{
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
	}

	//displaying and checking the input format and balance(withdraw)	
	public void getCheckingWithdrawInput() 
	{
		boolean end = false;
		while (!end) 
		{
			try 
			{
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
				System.out.print("\nAmount you want to withdraw from Checkings Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance - amount) >= 0 && amount >= 0) 
				{
					calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
					end = true;
				} else 
				{
					System.out.println("\nBalance Cannot be Negative.");
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	//displaying and checking the input format and balance(saving)
	public void getsavingWithdrawInput() 
	{
		boolean end = false;
		while (!end) 
		{
			try 
			{
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((savingBalance - amount) >= 0 && amount >= 0) 
				{
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
					end = true;
				} 
				else 
				{
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	//displaying and checking the input format and balance(deposit)
	public void getCheckingDepositInput() 
	{
		boolean end = false;
		while (!end) 
		{
			try 
			{
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
				System.out.print("\nAmount you want to deposit from Checkings Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance + amount) >= 0 && amount >= 0) 
				{
					calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
					end = true;
				} 
				else 
				{
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() 
	{
		boolean end = false;
		while (!end) 
		{
			try 
			{
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();

				if ((savingBalance + amount) >= 0 && amount >= 0) 
				{
					calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
					end = true;
				} 
				else 
				{
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getTransferInput(String accType) 
	{
		boolean end = false;
		while (!end) 
		{
			try 
			{
				if (accType.equals("Checkings")) 
				{
					System.out.println("\nSelect an account you wish to tranfers funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) 
					{
					case 1:
						System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
						System.out.print("\nAmount you want to deposit into your Savings Account: ");
						double amount = input.nextDouble();
						if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) 
						{
							calcCheckTransfer(amount);
							System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
							System.out.println(
									"\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
							end = true;
						} 
						else 
						{
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				} 
				else if (accType.equals("Savings")) 
				{
					System.out.println("\nSelect an account you wish to tranfers funds to: ");
					System.out.println("1. Checkings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) 
					{
					case 1:
						System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
						System.out.print("\nAmount you want to deposit into your savings account: ");
						double amount = input.nextDouble();
						if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) 
						{
							calcSavingTransfer(amount);
							System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(checkingBalance));
							System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
							end = true;
						} 
						else 
						{
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}
}

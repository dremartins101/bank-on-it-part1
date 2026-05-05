import java.util.*;
import java.io.*;

public class Customer extends User {
	private CheckingAccount checking;
	private SavingsAccount savings;
	private transient Scanner input = new Scanner(System.in);

	public Customer() {
		this.userName = "Alice";
		this.PIN = "0000";
		this.checking = new CheckingAccount();
		this.savings = new SavingsAccount();
	}

	public Customer(String name, String pin) {
		this.userName = name;
		this.PIN = pin;
		this.checking = new CheckingAccount();
		this.savings = new SavingsAccount();
	}

	public String menu() {
		System.out.println("\nCustomer Menu");
		System.out.println("0) Exit");
		System.out.println("1) Manage Checking Account");
		System.out.println("2) Manage Savings Account");
		System.out.println("3) Change PIN");
		System.out.print("\nAction (0-3): ");
		return input.nextLine();
	}

	public void start() {
		String choice = "";
		while (!choice.equals("0")) {
			choice = menu();
			if (choice.equals("1")) {
				System.out.println("Checking Account");
				checking.start();
			} else if (choice.equals("2")){
					System.out.println("Savings Account");
					savings.start();
			} else if (choice.equals("3")) {
				changePin();
			}
		}
	}

	public void changePin(){
		System.out.print("Enter new PIN: ");
		this.PIN = input.nextLine();
		System.out.println("PIN updated successfully");
	}

	@Override
	public String getReport(){
		return String.format("Customer: %s\nChecking: %s\nSavings: %s",
		userName, checking.getBalanceString(), savings.getBalanceString());
	}

	public static void main(String[] args){
		Customer c = new Customer("Alice", "0000");
		c.start();
	}
} // end Customer

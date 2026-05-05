import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable {
	double balance;

	public static void main(String[] args){
		CheckingAccount ca = new CheckingAccount();
		ca.start();
	} // end main
	
	public CheckingAccount(){
		this.balance = 0d;
	} // end constructor
	
	public CheckingAccount(double balance){
		this.balance = balance;
	} // end constructor
	
	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("0) quit");
		System.out.println("1) check balance");
		System.out.println("2) make a deposit");
		System.out.println("3) make a withdrawal");
		System.out.println();
		System.out.print("Please enter 0-3: ");
		String response = input.nextLine();
		return response;
	} // end menu
	
	public void start(){
		boolean keepGoing = true;
		String response;
		while(keepGoing){
			response = menu();
			if (response.equals("0")){
				keepGoing = false;
			} else if (response.equals("1")){
				System.out.println(" Checking balance... ");
				checkBalance();
			} else if (response.equals("2")){
				System.out.println(" Making a deposit... ");
				makeDeposit();
			} else if (response.equals("3")){
				System.out.println(" Making a withdrawal... ");
				makeWithdrawal();
			} else {
				System.out.println("Please enter 0, 1, 2, or 3");
			} // end if
		} // end while
	} // end start
	

	public String getBalanceString(){
        return String.format("$%.2f", this.balance);
    }

    public void checkBalance(){
        System.out.println("Current balance: " + this.getBalanceString()); // added parens
    }

    private double getDouble(){
        Scanner input = new Scanner(System.in);
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e){
            System.out.println("Not a legal input. Changing to 0");
            return 0.0;
        }
    }

    public void makeDeposit(){
        System.out.print("How much to deposit? ");
        double deposit = getDouble();
        this.balance += deposit; // removed "this." from local var
        System.out.println("New balance: " + getBalanceString());
    }

    public void makeWithdrawal(){
        System.out.print("How much to withdraw? ");
        double withdrawal = getDouble();
        if (withdrawal > this.balance){
            System.out.println("Insufficient funds");
        } else {
            this.balance -= withdrawal; // removed "this."
        }
        System.out.println("New balance: " + getBalanceString());
    }

        public double getBalance() {
	       	return balance;
       	}
    public void setBalance(double b) {
	    this.balance = b;
    }
	
} // end class def


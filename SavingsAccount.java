import java.util.*;
import java.io.*;

public class SavingsAccount extends CheckingAccount implements Serializable{
	private double interestRate = 0.05;

	public SavingsAccount(){
		super(); // calls checkingaccount
	}

	public void calcInterest() {
		double interest = getBalance() * interestRate;
		setBalance(getBalance() + interest);
	}

	public void setInterestRate(double rate) {
		this.interestRate = rate; 
	}
	public double getInterestRate() {
		return this.interestRate;
	}

} // end SavingsAccount

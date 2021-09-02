import java.util.*; 
public class ATM {
	public static HashMap <String, Double> accounts = new HashMap(); 
	
	public static void deposit (String bankAccountID, double amount)
	{
		accounts.putIfAbsent(bankAccountID, 0.0);
		accounts.replace(bankAccountID, accounts.get(bankAccountID)+amount);
	}
	public static double checkBalance(String bankAccountID)
	{
		if(accounts.get(bankAccountID) == null)
		{
			throw new NullPointerException("Account not found");
		}
		double balance = accounts.get(bankAccountID);
		return balance;
	}
	public static void withdraw(String bankAccountID, double amount)
	{
		if(amount > checkBalance(bankAccountID))
		{
			throw new ArithmeticException("Overwithdrawal found, the amount that you withdraw must be less than or equal to your balance");
		}
		else
		{
			accounts.replace(bankAccountID, checkBalance(bankAccountID) - amount);
		}
	}
	public static void main (String [] args)
	{
		ATM atm = new ATM();
		atm.deposit("Winfrey", 25159684372.43);
		atm.deposit("Bezos", 193495330293.43);
		atm.deposit("Bezos", 20394353.35);
		atm.withdraw("Bezos", 3593293.66);
		atm.deposit("MrTheiss",64033.55);
		atm.withdraw("MrTheiss", 443964.46);
		atm.checkBalance("Bezos");
		atm.checkBalance("Winfrey");
		atm.checkBalance("YoMama");
		atm.checkBalance("MrTheiss");
	}
}

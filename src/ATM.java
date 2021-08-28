import java.util.*; 
public class ATM {
	public HashMap <String, Integer> accounts = new HashMap <String, Integer> (); 
	
	private void deposit (String bankAccountID, int amount)
	{
		if(accounts.putIfAbsent(bankAccountID, amount) != null)
		{
		accounts.replace(bankAccountID, accounts.get(bankAccountID)+amount); 
	}
}
}

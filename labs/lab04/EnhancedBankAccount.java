class EnhancedBankAccount extends BankAccount
{
	private final java.util.ArrayList<Transaction> successfulTransactions;
	private final java.util.ArrayList<Transaction> failedTransactions;
	
	EnhancedBankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		super(ownerLastName, ownerFirstName, checkingBalance, savingsBalance);
		
		successfulTransactions = new java.util.ArrayList<>();
		failedTransactions = new java.util.ArrayList<>();
		
		java.util.Date date = new java.util.Date();
		successfulTransactions.add(new Transaction("new EnhancedBankAccount", date, 0.0));
		if( checkingBalance > 0.0 )
		{
			successfulTransactions.add(new Transaction("depositToChecking", date, checkingBalance));
		}
		
		if( savingsBalance > 0.0 )
		{
			successfulTransactions.add(new Transaction("depositToSavings", date, savingsBalance));
		}
	}
	
	EnhancedBankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	public boolean withdrawFromChecking(double amount)
	{
		boolean returnValue = false;
		java.util.Date date = new java.util.Date(); 
		if( super.withdrawFromChecking(amount) )
		{
			successfulTransactions.add(new Transaction("withdrawFromChecking", date, amount));
			returnValue = true;
		}
		else
		{
			failedTransactions.add(new Transaction("withdrawFromChecking", date, amount));
		}
		return returnValue;
	}
	
	public boolean withdrawFromSavings(double amount)
	{
		boolean returnValue = false;
		java.util.Date date = new java.util.Date(); 
		if( super.withdrawFromSavings(amount) )
		{
			successfulTransactions.add(new Transaction("withdrawFromSavings", date, amount));
			returnValue = true;
		}
		else
		{
			failedTransactions.add(new Transaction("withdrawFromSavings", date, amount));
		}
		return returnValue;
	}
	
	public boolean transferFromSavingsToChecking(double amount)
	{
		boolean returnValue = false;
		java.util.Date date = new java.util.Date(); 
		if( super.transferFromSavingsToChecking(amount) )
		{
			successfulTransactions.add(new Transaction("transferFromSavingsToChecking", date, amount));
			returnValue = true;
		}
		else
		{
			failedTransactions.add(new Transaction("transferFromSavingsToChecking", date, amount));
		}
		return returnValue;
	}
	
	public boolean transferFromCheckingToSavings(double amount)
	{
		boolean returnValue = false;
		java.util.Date date = new java.util.Date(); 
		if( super.transferFromCheckingToSavings(amount) )
		{
			successfulTransactions.add(new Transaction("transferFromCheckingToSavings", date, amount));
			returnValue = true;
		}
		else
		{
			failedTransactions.add(new Transaction("transferFromCheckingToSavings", date, amount));
		}
		return returnValue;
	}
	
	public void depositToSavings(double amount)
	{
		java.util.Date date = new java.util.Date();
		super.depositToSavings(amount);
		successfulTransactions.add(new Transaction("depositToSavings", date, amount));
	}
	
	public void depositToChecking(double amount)
	{
		java.util.Date date = new java.util.Date();
		super.depositToChecking(amount);
		successfulTransactions.add(new Transaction("depositToChecking", date, amount));
	}
	
	public java.util.ArrayList<Transaction> getAllSuccessfulTransactions()
	{
		return successfulTransactions;
	}
	
	public java.util.ArrayList<Transaction> getAllFailedTransactions()
	{
		return failedTransactions;
	}
	
	public java.util.ArrayList<Transaction> getSavingsDepositTransactions()
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for( Transaction t : successfulTransactions )
		{
			if( t.type().equals("depositToSavings") )
			{
				results.add(t);
			}
		}
		return results;
	}
	
	public java.util.ArrayList<Transaction> getCheckingDepositTransactions()
	{
		return null;
	}
	
	public java.util.ArrayList<Transaction> getSavingsWithdrawalTransactions()
	{
		return null;
	}
	
	public java.util.ArrayList<Transaction> getCheckingWithdrawalTransactions()
	{
		return null;
	}
	
	public java.util.ArrayList<Transaction> getSavingsToCheckingTransferTransactions()
	{
		return null;
	}
	
	public java.util.ArrayList<Transaction> getCheckingToSavingsTransferTransactions()
	{
		return null;
	}
	
	public java.util.ArrayList<Transaction> getFailedTransactions(java.util.Date startDate, java.util.Date endDate)
	{
		return null;
	}
	
	public java.util.ArrayList<Transaction> getSuccessfulTransactions(java.util.Date startDate, java.util.Date endDate)
	{
		return null;
	}
}

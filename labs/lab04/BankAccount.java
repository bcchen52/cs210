class BankAccount
{
	private final String ownerLastName;
	private final String ownerFirstName;
	private final String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int bankAccountCount = 0;
	
	BankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		this.ownerLastName = ownerLastName;
		this.ownerFirstName = ownerFirstName;
		this.accountNumber = makeAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		
		bankAccountCount = bankAccountCount+1;
	}
	
	BankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	public boolean withdrawFromChecking(double amount)
	{
		boolean y = getCheckingBalance() >= amount;
		if( y )
		{
			checkingBalance = checkingBalance - amount;
		}
		return y;
	}
	
	public boolean withdrawFromSavings(double amount)
	{
		boolean y = getSavingsBalance() >= amount;
		if( y )
		{
			savingsBalance = savingsBalance - amount;
		}
		return y;
	}
	
	public boolean transferFromSavingsToChecking(double amount)
	{
		boolean y = getSavingsBalance() >= amount;
		if( y )
		{
			savingsBalance = savingsBalance - amount; 
			checkingBalance = checkingBalance + amount;
		}
		return y;
	}
	
	public boolean transferFromCheckingToSavings(double amount)
	{
		boolean y = getCheckingBalance() >= amount;
		if( y )
		{
			checkingBalance = checkingBalance - amount;
			savingsBalance = savingsBalance + amount; 
		}
		return y;
	}
	
	public void depositToSavings(double amount)
	{
		savingsBalance = savingsBalance + amount;
	}
	
	public void depositToChecking(double amount)
	{
		checkingBalance = checkingBalance + amount;
	}
	
	public String toString()
	{
		String c = "" + getCheckingBalance();
		String s = "" + getSavingsBalance();
		return getOwnerLastName() + ", " + getOwnerFirstName() + ", " + accountNumber + "\n" + c + "\n" + s;
	}
	
	public String getOwnerLastName()
	{
		return ownerLastName;
	}
	
	public String getOwnerFirstName()
	{
		return ownerFirstName;
	}
	
	public String getAccountNumber()
	{
		return makeAccountNumber();
	}
	
	public double getCheckingBalance()
	{
		return checkingBalance;
	}
	
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
	
	private String makeAccountNumber()
	{
		String aNumber = "" + bankAccountCount;
		
		while( aNumber.length() < 6 )
		{
			aNumber = "0" + aNumber;
		}
		return aNumber;
	}
	
	public static int getBankAccountCount()
	{
		return bankAccountCount;
	}
}

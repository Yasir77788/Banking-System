package bank_program;

public abstract class AbstractBankAccount implements BankAccountInterface
{
    // protected variables and constructor to be 
    // directly accessed by the subclasses.
    protected int accountNum;
    protected int balance = 0;
    protected boolean isforeign = false;
    
    protected AbstractBankAccount (int accountNum)
    {
        this.accountNum = accountNum;
    }
    
    // abstract mehtods that will be implemented by sub classes
    public abstract boolean hasEnoughCollateral(int loanAmount);
    public abstract String toString();
    public abstract void addInterest();
    
    @Override
    public int getAccountNum()
    {
        return accountNum;
    }
    
    @Override
    public int getBalance()
    {
        return balance;
    }
    @Override
    public boolean isForeign()
    {
        return isforeign;
    }
    
    @Override
    public void setForeign(boolean b)
    {
        isforeign = b;
    }
    
    @Override
    public void deposit(int amount)
    {
        balance += amount;
    }
    
    @Override
    public int compareTo(BankAccountInterface ba)
    {
        int bal1 = getBalance();
        int bal2 = ba.getBalance();
        if(bal1 == bal2)
            return getAccountNum() - ba.getAccountNum();
        else
            return bal1 - bal2;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(! (obj instanceof BankAccountInterface))
            return false;
        BankAccountInterface ba = (BankAccountInterface) obj;
        return getAccountNum() == ba.getAccountNum();
        
    }
    
}
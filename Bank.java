/*
    The class Bank is responsible for the banking information
*/
package bank_program;
import java.util.*;

public class Bank
{
    private Map<Integer, BankAccountInterface> accounts;
    private int nextAccount;
    
    public Bank(Map<Integer, BankAccountInterface> accounts, int n)
    {
        this.accounts = accounts;
        nextAccount = n;
        
    }
    
    
    /*
       newAccount() creates an object of the specified class
       and stores a reference to it in the variable ba.
    */
    public int newAccount(int type, boolean isforeign)
    {
        int accountNum = nextAccount++;
        BankAccountInterface ba;
        if (type == 1)
            ba = new SavingsAccount(accountNum);
        else if(type == 2)
            ba = new RegularCheckingAccount(accountNum);
        else
            ba = new InterestChecking(accountNum);
        ba.setForeign(isforeign);
        accounts.put(accountNum, ba);
        return accountNum;
        
    }   
    
    /*
        getBalance() calls ba.getBalance, which will execute
        the code of whichever object ba refers to
    */
    
    public int getBalance(int accountNum) 
    {
      BankAccountInterface ba = accounts.get(accountNum);
      return ba.getBalance();
    }
    
    public void setForeign(int accountNum, boolean isforeign)
    {
        BankAccountInterface ba = accounts.get(accountNum);
        ba.setForeign(isforeign);
    }
    
    public void deposit(int accountNum, int amount)
    {
        BankAccountInterface ba = accounts.get(accountNum);
        ba.deposit(amount);
    }
    
    public boolean authorizeLoan(int accountNum, int loanAmount)
    {
       BankAccountInterface ba = accounts.get(accountNum);
       return ba.hasEnoughCollateral(loanAmount);
    }
    
    public String toString() 
    {
      String result = "The bank has " + accounts.size() + " accounts.";
      for (BankAccountInterface ba : accounts.values())
         result += "\n\t" + ba.toString();
      return result;
   }
    
   /*
        addInterest() method iterates through all the accounts.
    */
    
   public void addInterest() 
   {
      for (BankAccountInterface ba : accounts.values())
         ba.addInterest();
   }

   public int nextAcctNum() 
   {
      return nextAccount;
   } 
    
}

package bank_program;

public class SavingsAccount extends AbstractBankAccount
{
    private double rate = 0.01;
    
    public SavingsAccount(int accountNum)
    {
        super(accountNum);
    }
    
    public boolean hasEnoughCollateral(int loanAmount)
    {
        return balance >= loanAmount/2;
    }
    
    public String toString()
    {
        return "Saving account " + accountNum + ": balance = " +
               balance + ", is " + (isforeign ? "foreign" : "domestic");
     
    }
    
    public void addInterest()
    {
        balance += (int)(balance * rate);
    }
}
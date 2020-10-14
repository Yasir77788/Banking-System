/*
 
 */
package bank_program;

public class InterestChecking extends AbstractCheckingAccount
{
    private double rate = 0.01;
    
    public InterestChecking (int accountNum)
    {
        super(accountNum);
    }
    
    @Override
    public String toString()
    {
        return "Interest checking acount " + accountNum + ": balance =" +
                balance + ", is " + (isforeign ? "foreign" : "domestic");
    }
    
    @Override
    public void addInterest()
    {
        balance += (int) (balance * rate);
    }
    
}
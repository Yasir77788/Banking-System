
package bank_program;

public class RegularCheckingAccount extends AbstractCheckingAccount
{
    public RegularCheckingAccount(int accountNum)
    {
        super(accountNum);
    }
    
    public String toString()
    {
        return "Regular checking account " + accountNum + ": balance =" +
                balance + ", is " + (isforeign ? "foreign" : "domestic");
    }
    
    public void addInterest()
    {
        // do nothing
    }
}
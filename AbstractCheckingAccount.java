/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_program;

public abstract class AbstractCheckingAccount extends AbstractBankAccount
{
    protected AbstractCheckingAccount(int accountNum)
    {
        super(accountNum);
    }
    
    @Override
    public boolean hasEnoughCollateral(int loanAmount)
    {
        return balance >= 2 * (loanAmount/3);
    }
    
    public abstract String toString();
    public abstract void addInterest();
    
}
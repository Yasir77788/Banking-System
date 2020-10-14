/*
    BankAccountInterface to implement polymorphism
    It specifies behavoirs of classes implementing it.
    BankAccountInterface is an interface, whose objects can be from
    either SavingsAccount or RegularCheckingAccount classes.
    this relation is implemented polymorphically.
    It can hold references to objects from different classes.
 */
package bank_program;   

public interface BankAccountInterface extends Comparable<BankAccountInterface>
{
    // public static mothodes headers
    int getAccountNum();
    int getBalance();
    void deposit(int amount);
    boolean isForeign();
    void setForeign(boolean isforeign);
    boolean hasEnoughCollateral(int loanAmount);
    String toString();
    void addInterest();
    
    // using static and default method 
    // added in java 8
    static BankAccountInterface createSavingsWithDeposit(int accountNum, int n)
    {
        BankAccountInterface ba = new SavingsAccount(accountNum);
        ba.deposit(n);
        return ba;
    }
    default boolean isEmpty()
    {
        return getBalance() == 0;
    }
    
    
}
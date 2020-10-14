/*
    BankProgram  reads the bank's initial
    account information from a file when the program begins,
    and writes the account information to the file when the program ends. 
    It uses the class SavedBankInfo to interact with the file.
*/

package bank_program;

import java.util.*;

public class BankProgram 
{
   public static void main(String[] args) 
   {
      SavedBankInfo info = new SavedBankInfo("bank.info");
      Map<Integer,BankAccountInterface> accounts = info.getAccounts();
      int nextAccount = info.nextAcctNum();
      Bank bank = new Bank(accounts, nextAccount);
      Scanner scanner = new Scanner(System.in);
      BankClient client = new BankClient(scanner, bank);
      client.run();
      info.saveMap(accounts, bank.nextAcctNum());
   }
}

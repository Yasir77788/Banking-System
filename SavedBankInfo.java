
package bank_program;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

public class SavedBankInfo 
{
   private String fname;
   private Map<Integer,BankAccountInterface> accounts = new HashMap<>();
   private int nextaccount = 0;
   private ByteBuffer bb = ByteBuffer.allocate(16);

   public SavedBankInfo(String fname) 
   {
      this.fname = fname;
      if (!new File(fname).exists()) 
         return;
      try (InputStream is = new FileInputStream(fname)) {
         readMap(is);
      }
      catch (IOException ex) {
         throw new RuntimeException("bank file read exception");
      }
   }

   public Map<Integer,BankAccountInterface> getAccounts() 
   {
      return accounts;
   }

   public int nextAcctNum() 
   {
      return nextaccount;
   }

   public void saveMap(Map<Integer,BankAccountInterface> map, int nextaccount) 
   {
      try (OutputStream os = new FileOutputStream(fname)) 
      {
         writeMap(os, map, nextaccount);
      }
      catch (IOException ex) 
      {
         throw new RuntimeException("bank file write exception");
      }
   }

   private void readMap(InputStream is) throws IOException 
   {
      nextaccount = readInt(is);
      BankAccountInterface ba = readAccount(is);
      while (ba != null)
      {
         accounts.put(ba.getAccountNum(), ba);
         ba = readAccount(is);
      }
   }

   private int readInt(InputStream is) throws IOException 
   {
      is.read(bb.array(), 0, 4);
      return bb.getInt(0);
   }

   private BankAccountInterface readAccount(InputStream is) throws IOException 
   {
      int n = is.read(bb.array());
      if (n < 0)
         return null;
      int num       = bb.getInt(0);
      int type      = bb.getInt(4);
      int balance   = bb.getInt(8);
      int isforeign = bb.getInt(12);

      BankAccountInterface ba;
      if (type == 1) 
         ba = new SavingsAccount(num);
      if (type == 2)  
         ba = new RegularCheckingAccount(num);
      else
         ba = new InterestChecking(num);
      ba.deposit(balance);
      ba.setForeign(isforeign == 1);
      return ba;
   }

   private void writeMap(OutputStream os, Map<Integer,BankAccountInterface> map, int nextacct) 
         throws IOException {
      writeInt(os, nextacct);
      for (BankAccountInterface ba : map.values())
         writeAccount(os, ba);
   }

   private void writeInt(OutputStream os, int n) throws IOException {
      bb.putInt(0, n);
      os.write(bb.array(), 0, 4);
   }

   private void writeAccount(OutputStream os, BankAccountInterface ba) throws IOException {
      int type = (ba instanceof SavingsAccount)  ? 1 
            : (ba instanceof RegularCheckingAccount) ? 2 : 3;
      bb.putInt(0, ba.getAccountNum());
      bb.putInt(4, type);
      bb.putInt(8, ba.getBalance());
      bb.putInt(12, ba.isForeign() ? 1 : 2);
      os.write(bb.array());
   }
}

package bankAccount;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {
    @Test
    public void  constructorWork(){
        BankAccount bankAccount=new BankAccount("asd",new  BigDecimal(100));
        Assert.assertEquals("asd",bankAccount.getName());
        Assert.assertEquals(new BigDecimal(100),bankAccount.getBalance());
    }

  @Test(expected = UnsupportedOperationException.class)
    public void depositException(){
      BankAccount bankAccount=new BankAccount("asd",new  BigDecimal(100));
      bankAccount.deposit(BigDecimal.ZERO);
  }
    @Test(expected = UnsupportedOperationException.class)
    public void depositExceptiona(){
        BankAccount bankAccount=new BankAccount("asd",new  BigDecimal(100));
        bankAccount.deposit(new BigDecimal(-1000));
    }
  @Test
    public void deposit(){
      BankAccount bankAccount=new BankAccount("asd",new  BigDecimal(200));
bankAccount.deposit(new BigDecimal(100));
Assert.assertEquals(new BigDecimal(300),bankAccount.getBalance());
  }
  @Test(expected = UnsupportedOperationException.class)
    public void withdrawWithException(){
      BankAccount bankAccount=new BankAccount("asd",new  BigDecimal(200));
bankAccount.withdraw(new BigDecimal(-4));
  }

    @Test
    public void withdrawCorrect(){
        BankAccount bankAccount=new BankAccount("asd",new  BigDecimal(200));
        BigDecimal withdraw = bankAccount.withdraw(new BigDecimal(200));
        Assert.assertEquals(new BigDecimal(200), withdraw);
        Assert.assertEquals(BigDecimal.ZERO, bankAccount.getBalance());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void withdrawWithExceptionSecond(){
        BankAccount bankAccount=new BankAccount("asd",new  BigDecimal(200));
        bankAccount.withdraw(new BigDecimal(300));
    }
    @Test(expected = IllegalArgumentException.class)
public void nameThree(){
        BankAccount bankAccount=new BankAccount("a",new  BigDecimal(200));
    }
    @Test(expected = IllegalArgumentException.class)
    public void nameThreeAgain(){
        BankAccount bankAccount=new BankAccount("skdaslohfodifuhgwoefnowenfowenfoweofnwoef",new  BigDecimal(200));
    }
    @Test(expected = IllegalArgumentException.class)
    public void value(){
        BankAccount bankAccount=new BankAccount("andnfdssd",new  BigDecimal(-200));
    }
}